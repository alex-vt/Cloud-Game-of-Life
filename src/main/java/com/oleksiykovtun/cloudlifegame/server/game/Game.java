package com.oleksiykovtun.cloudlifegame.server.game;

import com.oleksiykovtun.cloudlifegame.shared.entities.FieldState;
import com.oleksiykovtun.cloudlifegame.shared.entities.SpeciesParameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Game of Life
 */
public class Game {

    private final double maxGameTime = 200;
    private final int maxCpuTimeMillis = 20000;

    private final SettingsManager settingsManager;
    private final CellsManager cellsManager;

    public Game(List<SpeciesParameters> speciesParameters) {
        settingsManager = new SettingsManager(speciesParameters);
        cellsManager = new CellsManager(settingsManager);
    }

    /**
     * Computes a game with parameters given in constructor
     * @return list of field layouts through game time
     */
    public List<FieldState> computeGameplay() {
        List<FieldState> fieldChanges = new ArrayList<FieldState>();
        List<Cell> cells = getInitialCells();
        fieldChanges.add(getFieldState(cells, 0));
        long startCpuTime = System.currentTimeMillis();
        for (double currentTime = 0; currentTime < maxGameTime; currentTime += cellsManager.timeDelta) {
            cells = applyMoving(cells, currentTime);
            cells = applyDying(cells, currentTime);
            fieldChanges.add(getFieldState(cells, currentTime));
            cells = applyBreeding(cells, currentTime);
            fieldChanges.add(getFieldState(cells, currentTime));
            System.out.println("Written time " + currentTime);
            if (System.currentTimeMillis() - startCpuTime > maxCpuTimeMillis) {
                break;
            }
        }
        return fieldChanges;
    }

    private List<Cell> getInitialCells() {
        List<Cell> cells = new ArrayList<Cell>();
        for (int i = 0; i < settingsManager.getSpeciesCount(); ++i) {
            List<Coordinates> newCellsCoordinates = cellsManager.getAllCoordinates();
            newCellsCoordinates = cellsManager.getNoOverlapCoordinates(newCellsCoordinates, cells);
            for (int j = 0; j < settingsManager.getInitialQuantity(i); ++j) {
                if (newCellsCoordinates.size() > 0) {
                    Coordinates coordinates = cellsManager.getRandomCoordinates(newCellsCoordinates);
                    cells.add(cellsManager.createCell(coordinates.getX(), coordinates.getY(),
                            settingsManager.getType(i), 0));
                }
            }
        }
        return cells;
    }

    private List<Cell> applyBreeding(List<Cell> cells, double currentTime) {
        int initialCellsSize = cells.size();
        for (int i = 0; i < initialCellsSize; ++i) {
            int childrenQuantityNow = 0;
            while (cells.get(i).isBreeding(currentTime)) {
                ++childrenQuantityNow;
            }
            if (cellsManager.isCellCoupling(cells, cells.get(i))) {
                childrenQuantityNow = settingsManager.getChildrenQuantityNow(cells.get(i).getType_());
            }
            int range = settingsManager.getBreedingDistance(cells.get(i).getType_());
            List<Coordinates> breedingCoordinates = cellsManager.getCoordinatesInRange(cells.get(i), range);
            breedingCoordinates = cellsManager.getNoOverlapCoordinates(breedingCoordinates, cells);
            while (breedingCoordinates.size() > 0 && childrenQuantityNow > 0) {
                Coordinates coordinates = cellsManager.getRandomCoordinates(breedingCoordinates);
                cells.add(cellsManager.createCell(coordinates.getX(), coordinates.getY(),
                        cells.get(i).getType_(), currentTime));
                cellsManager.decrementCellBreedingQuota(cells.get(i), currentTime);
                --childrenQuantityNow;
            }
        }
        return cells;
    }

    private List<Cell> applyDying(List<Cell> cells, double currentTime) {
        for (int i = cells.size() - 1; i >= 0; --i) {
            if (cells.get(i).isDying(currentTime)
                    || cellsManager.isCellKilled(cells, cells.get(i))) {
                cells.remove(i);
            }
        }
        return cells;
    }

    private List<Cell> applyMoving(List<Cell> cells, double currentTime) {
        for (Cell cell : cells) {
            if (settingsManager.getIsMobile(cell.getType_())) {
                double speed = settingsManager.getSpeed(cell.getType_());
                if (speed != 0 && currentTime * speed == (int) (currentTime * speed)) {
                    List<Coordinates> movingCoordinates = cellsManager.getCoordinatesInRange(cell, 1);
                    movingCoordinates = cellsManager.getValidOverlapCoordinates(movingCoordinates,
                            cell, cells, currentTime);
                    if (movingCoordinates.size() > 0) {
                        Coordinates nextCoordinates;
                        if (settingsManager.getIsIntelligent(cell.getType_())) {
                            nextCoordinates = cellsManager.getOptimalCoordinates(movingCoordinates, cell, cells);
                        } else {
                            nextCoordinates = cellsManager.getRandomCoordinates(movingCoordinates);
                        }
                        cell.moveTo(nextCoordinates);
                    }
                }
            }
        }
        return cells;
    }

    private FieldState getFieldState(List<Cell> cells, double time) {
        FieldState fieldState = new FieldState(time, settingsManager.getFieldX(), settingsManager.getFieldY());
        for (Cell cell : cells) {
            fieldState.setCell(cell.getCoordinates().getX(),
                    cell.getCoordinates().getY(), Byte.parseByte(cell.getType_()));
        }
        return fieldState;
    }

}
