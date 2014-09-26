package com.oleksiykovtun.cloudlifegame.server.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Operations with field cells
 */
class CellsManager {

    private final SettingsManager settingsManager;
    private final Random random = new Random();
    public double timeDelta = 0.125;

    public CellsManager(SettingsManager settingsManager) {
        this.settingsManager = settingsManager;
    }

    public Cell createCell(int x, int y, String type_, double birthTime) {
        Cell cell = new Cell(new Coordinates(x, y), type_, birthTime);
        cell.setBreedingPeriodsQuotas(settingsManager.getBreedingPeriodsQuotas(type_));
        cell.setDeathTime(getDeathTime(type_, birthTime));
        if (!settingsManager.getIsMobile(type_)) {
            cell.setBreedingTimes(getBreedingTimes(type_, birthTime));
        }
        return cell;
    }

    private List<Double> getBreedingTimes(String type_, double birthTime) {
        List<Double> breedingPeriodsStarts = settingsManager.getBreedingPeriodsStarts(type_);
        List<Double> breedingPeriodsEnds = settingsManager.getBreedingPeriodsEnds(type_);
        List<Double> breedingTimes = new ArrayList<Double>();
        int breedingTimesPerPeriod = settingsManager.getIsBreedingSynchronous(type_)
                ? 1 : settingsManager.getChildrenQuantityPerPeriod(type_);
        for (int i = 0; i < breedingPeriodsStarts.size(); ++i) {
            for (int j = 0; j < breedingTimesPerPeriod; ++j) {
                double breedingTimeRaw = birthTime + breedingPeriodsStarts.get(i)
                        + random.nextDouble() * (breedingPeriodsEnds.get(i) - breedingPeriodsStarts.get(i));
                double breedingTime = Math.floor(breedingTimeRaw / timeDelta) * timeDelta;
                breedingTimes.add(breedingTime);
            }
        }
        return breedingTimes;
    }

    private double getDeathTime(String type_, double birthTime) {
        double cumulativeDeathProbability = random.nextDouble();
        List<Double> deathPeriodsStarts = settingsManager.getDeathPeriodsStarts(type_);
        List<Double> deathPeriodsEnds = settingsManager.getDeathPeriodsEnds(type_);
        List<Double> cumulativeDeathProbabilities = settingsManager.getCumulativeDeathProbabilities(type_);
        int deathPeriod = 0;
        for (int i = 0; i < cumulativeDeathProbabilities.size(); ++i) {
            deathPeriod = i;
            if (cumulativeDeathProbabilities.get(i) > cumulativeDeathProbability) {
                break;
            }
        }
        if (cumulativeDeathProbability > cumulativeDeathProbabilities.get(cumulativeDeathProbabilities.size() - 1)) {
            return deathPeriodsEnds.get(deathPeriodsEnds.size() - 1);
        }
        double deathTimeRaw = birthTime + deathPeriodsStarts.get(deathPeriod)
                + random.nextDouble() * (deathPeriodsEnds.get(deathPeriod) - deathPeriodsStarts.get(deathPeriod));
        double deathTime = Math.floor(deathTimeRaw / timeDelta) * timeDelta;
        return deathTime;
    }

    public boolean isCellKilled(List<Cell> cells, Cell cell) {
        List<Cell> overlapCells = getOverlapCells(cell.getCoordinates(), cells);
        if (overlapCells.size() == 2) {
            String interaction = settingsManager.getInteraction(
                    overlapCells.get(0).getType_(), overlapCells.get(1).getType_());
            if (interaction.equals("Dies") && overlapCells.get(0).getType_().equals(cell.getType_())) {
                return true;
            }
            if (interaction.equals("Kills") && overlapCells.get(1).getType_().equals(cell.getType_())) {
                return true;
            }
        }
        return false;
    }

    public boolean isCellCoupling(List<Cell> cells, Cell cell) {
        List<Cell> overlapCells = getOverlapCells(cell.getCoordinates(), cells);
        if (overlapCells.size() == 2) {
            String interaction = settingsManager.getInteraction(
                    overlapCells.get(0).getType_(), overlapCells.get(1).getType_());
            if (interaction.equals("Breeds")) {
                return true;
            }
        }
        return false;
    }

    public List<Coordinates> getAllCoordinates() {
        List<Coordinates> coordinatesRange = new ArrayList<Coordinates>();
        for (int i = 0; i < settingsManager.getFieldX(); ++i) {
            for (int j = 0; j < settingsManager.getFieldY(); ++j) {
                coordinatesRange.add(new Coordinates(i, j));
            }
        }
        return coordinatesRange;
    }

    public List<Coordinates> getCoordinatesInRange(Cell cell, int range) {
        int xLeft = cell.getCoordinates().getX() - range;
        int yTop = cell.getCoordinates().getY() - range;
        int xRight = cell.getCoordinates().getX() + 1 + range;
        int yBottom = cell.getCoordinates().getY() + 1 + range;
        List<Coordinates> coordinatesRange = new ArrayList<Coordinates>();
        for (int i = xLeft; i < xRight; ++i) {
            for (int j = yTop; j < yBottom; ++j) {
                Coordinates localCoordinates = new Coordinates(i, j);
                if (areCoordinatesInField(localCoordinates)) {
                    coordinatesRange.add(localCoordinates);
                }
            }
        }
        return coordinatesRange;
    }

    public List<Coordinates> getNoOverlapCoordinates(List<Coordinates> coordinates, List<Cell> cells) {
        for (int i = 0; i < coordinates.size(); ++i) {
            while (i < coordinates.size() && getOverlapCells(coordinates.get(i), cells).size() != 0) {
                coordinates.remove(i);
            }
        }
        return coordinates;
    }

    public List<Coordinates> getValidOverlapCoordinates(List<Coordinates> coordinates, Cell cell,
                                                        List<Cell> cells, double currentTime) {
        for (int i = coordinates.size() - 1; i >= 0; --i) {
            List<Cell> overlapCells = getOverlapCells(coordinates.get(i), cells);
            if (overlapCells.size() > 1) {
                coordinates.remove(i);
            } else if (overlapCells.size() == 1) {
                String interaction = settingsManager.getInteraction(cell.getType_(),
                        overlapCells.get(0).getType_());
                if (interaction.equals("-")) {
                    coordinates.remove(i);
                } else if (interaction.equals("Breeds")) {
                    if (!checkBreedingQuota(cell, currentTime)
                            || !checkBreedingQuota(overlapCells.get(0), currentTime)) {
                        coordinates.remove(i);
                    }
                }
            }
        }
        return coordinates;
    }

    private boolean checkBreedingQuota(Cell cell, double currentTime) {
        List<Double> breedingPeriodsStarts = settingsManager.getBreedingPeriodsStarts(cell.getType_());
        List<Double> breedingPeriodsEnds = settingsManager.getBreedingPeriodsEnds(cell.getType_());
        for (int i = 0; i < breedingPeriodsStarts.size(); ++i) {
            if (currentTime >= cell.getBirthTime() + breedingPeriodsStarts.get(i)
                    && currentTime < cell.getBirthTime() + breedingPeriodsEnds.get(i)) {
                return (cell.getBreedingQuota(i) > 0);
            }
        }
        return false;
    }

    private List<Cell> getOverlapCells(Coordinates coordinates, List<Cell> cells) {
        List<Cell> overlapCells = new ArrayList<Cell>();
        for (Cell cell : cells) {
            if (cell.getCoordinates().getX() == coordinates.getX()
                    && cell.getCoordinates().getY() == coordinates.getY()) {
                overlapCells.add(cell);
            }
        }
        return overlapCells;
    }

    private boolean areCoordinatesInField(Coordinates coordinates) {
        return !(coordinates.getX() < 0
                || coordinates.getY() < 0
                || coordinates.getX() >= settingsManager.getFieldX()
                || coordinates.getY() >= settingsManager.getFieldY());
    }

    public Coordinates getOptimalCoordinates(List<Coordinates> coordinatesAvailable, Cell cell, List<Cell> cells) {
        int visionRange = settingsManager.getVisionDistance(cell.getType_());
        List<Coordinates> enemiesCoordinates = getCoordinatesInRange(cell, cells, visionRange, "Dies");
        if (enemiesCoordinates.size() > 0) {
            Coordinates closestEnemyCoordinates = getClosestCoordinates(cell.getCoordinates(),
                    enemiesCoordinates);
            int optimalMovementDirection
                    = (getDirectionTo(cell.getCoordinates(), closestEnemyCoordinates) + 180) % 360;
            return getCoordinatesClosestToDirection(coordinatesAvailable,
                    cell.getCoordinates(), optimalMovementDirection);
        } else {
            List<Coordinates> preysCoordinates = getCoordinatesInRange(cell, cells, visionRange, "Kills");
            if (preysCoordinates.size() > 0) {
                Coordinates closestPreyCoordinates = getClosestCoordinates(cell.getCoordinates(),
                        preysCoordinates);
                int optimalMovementDirection
                        = getDirectionTo(cell.getCoordinates(), closestPreyCoordinates);
                return getCoordinatesClosestToDirection(coordinatesAvailable,
                        cell.getCoordinates(), optimalMovementDirection);
            }
        }
        return getRandomCoordinates(coordinatesAvailable);
    }

    private List<Coordinates> getCoordinatesInRange(Cell cell, List<Cell> cells, int visionRange, String interaction) {
        List<Coordinates> foundCoordinates = new ArrayList<Coordinates>();
        for (Cell currentCell : cells) {
            if (isInRange(currentCell.getCoordinates(), cell.getCoordinates(), visionRange)) {
                if (settingsManager.getInteraction(cell.getType_(), currentCell.getType_()).equals(interaction)) {
                    foundCoordinates.add(currentCell.getCoordinates());
                }
            }
        }
        return foundCoordinates;
    }

    private boolean isInRange(Coordinates these, Coordinates others, int range) {
        return Math.abs(these.getX() - others.getX()) <= range
                && Math.abs(these.getY() - others.getY()) <= range;
    }

    private Coordinates getClosestCoordinates(Coordinates these, List<Coordinates> others) {
        double leastDistance = Integer.MAX_VALUE;
        int leastDistanceIndex = 0;
        for (int i = 0; i < others.size(); ++i) {
            double currentDistance = Math.sqrt(Math.pow(others.get(i).getX() - these.getX(), 2)
                    + Math.pow(others.get(i).getY() - these.getY(), 2));
            if (currentDistance < leastDistance) {
                leastDistance = currentDistance;
                leastDistanceIndex = i;
            }
        }
        return others.get(leastDistanceIndex);
    }

    private Coordinates getCoordinatesClosestToDirection(List<Coordinates> others,
                                                         Coordinates these, int optimalDirection) {
        int leastAngleDifference = 180;
        int leastAngleDifferenceIndex = 0;
        for (int i = 0; i < others.size(); ++i) {
            int currentDirection = getDirectionTo(these, others.get(i));
            int currentDirectionsDifference = Math.abs(currentDirection - optimalDirection);
            if (currentDirectionsDifference > 180) {
                currentDirectionsDifference = 360 - currentDirectionsDifference;
            }
            if (currentDirectionsDifference < leastAngleDifference) {
                leastAngleDifference = currentDirectionsDifference;
                leastAngleDifferenceIndex = i;
            }
        }
        return others.get(leastAngleDifferenceIndex);
    }

    private int getDirectionTo(Coordinates these, Coordinates others) {
        return (int) (180 * Math.atan2(others.getY() - these.getY(), others.getX() - these.getX()) / Math.PI + 360)
                % 360;
    }

    public Coordinates getRandomCoordinates(List<Coordinates> coordinatesAvailable) {
        int position = random.nextInt(coordinatesAvailable.size());
        return coordinatesAvailable.remove(position);
    }

    public void decrementCellBreedingQuota(Cell cell, double currentTime) {
        List<Double> breedingPeriodsStarts = settingsManager.getBreedingPeriodsStarts(cell.getType_());
        List<Double> breedingPeriodsEnds = settingsManager.getBreedingPeriodsEnds(cell.getType_());
        for (int i = 0; i < breedingPeriodsStarts.size(); ++i) {
            if (currentTime >= cell.getBirthTime() + breedingPeriodsStarts.get(i)
                    && currentTime < cell.getBirthTime() + breedingPeriodsEnds.get(i)) {
                cell.decrementBreedingQuota(i);
                break;
            }
        }
    }

}
