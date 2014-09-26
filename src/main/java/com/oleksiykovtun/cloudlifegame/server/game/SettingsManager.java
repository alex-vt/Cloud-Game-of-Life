package com.oleksiykovtun.cloudlifegame.server.game;

import com.oleksiykovtun.cloudlifegame.shared.entities.SpeciesParameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Data retrieval from settings
 */
class SettingsManager {

    private final List<SpeciesParameters> speciesParameters;

    public SettingsManager(List<SpeciesParameters> speciesParameters) {
        this.speciesParameters = speciesParameters;
    }


    public int getInitialQuantity(int id) {
        return getInt(speciesParameters.get(id).getInitialQuantity());
    }

    public int getFieldX() {
        int maxValue = 0;
        for (SpeciesParameters speciesParametersItem : speciesParameters) {
            if (getInt(speciesParametersItem.getInitialFieldX()) > maxValue) {
                maxValue = getInt(speciesParametersItem.getInitialFieldX());
            }
        }
        return maxValue;
    }

    public int getFieldY() {
        int maxValue = 0;
        for (SpeciesParameters speciesParametersItem : speciesParameters) {
            if (getInt(speciesParametersItem.getInitialFieldY()) > maxValue) {
                maxValue = getInt(speciesParametersItem.getInitialFieldY());
            }
        }
        return maxValue;
    }

    public int getSpeciesCount() {
        return speciesParameters.size();
    }

    public int getChildrenQuantityNow(String type_) {
        if (getIsBreedingSynchronous(type_)) {
            return getChildrenQuantityPerPeriod(type_);
        }
        return 1;
    }

    public boolean getIsMobile(String type_) {
        return getBoolean(getSpecies(type_).getIsMobile());
    }

    public boolean getIsBreedingSynchronous(String type_) {
        return getBoolean(getSpecies(type_).getIsBreedingSynchronous());
    }

    public int getChildrenQuantityPerPeriod(String type_) {
        return getInt(getSpecies(type_).getChildrenQuantityPerPeriod());
    }

    public int getBreedingDistance(String type_) {
        return getInt(getSpecies(type_).getBreedingDistance());
    }


    public String getType(int i) {
        return speciesParameters.get(i).getNumber();
    }

    private SpeciesParameters getSpecies(String type_) {
        for (SpeciesParameters speciesParametersItem : speciesParameters) {
            if (speciesParametersItem.getNumber().equals(type_)) {
                return speciesParametersItem;
            }
        }
        return null;
    }

    private int getInt(String value) {
        return (int) getDouble(value);
    }

    private double getDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return 0;
        }
    }

    private boolean getBoolean(String value) {
        return value.equals("Yes");
    }

    public List<Integer> getBreedingPeriodsQuotas(String type_) {
        int quota = getIsBreedingSynchronous(type_) ? 1
                : getInt(getSpecies(type_).getChildrenQuantityPerPeriod());
        List<Integer> breedingPeriodsQuotas = new ArrayList<Integer>();
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd1()) != 0) {
            breedingPeriodsQuotas.add(quota);
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd2()) != 0) {
            breedingPeriodsQuotas.add(quota);
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd3()) != 0) {
            breedingPeriodsQuotas.add(quota);
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd4()) != 0) {
            breedingPeriodsQuotas.add(quota);
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd5()) != 0) {
            breedingPeriodsQuotas.add(quota);
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd6()) != 0) {
            breedingPeriodsQuotas.add(quota);
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd7()) != 0) {
            breedingPeriodsQuotas.add(quota);
        }
        return breedingPeriodsQuotas;
    }

    public List<Double> getBreedingPeriodsEnds(String type_) {
        List<Double> breedingPeriodsEnds = new ArrayList<Double>();
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd1()) != 0) {
            breedingPeriodsEnds.add(getDouble(getSpecies(type_).getBreedingPeriodEnd1()));
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd2()) != 0) {
            breedingPeriodsEnds.add(getDouble(getSpecies(type_).getBreedingPeriodEnd2()));
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd3()) != 0) {
            breedingPeriodsEnds.add(getDouble(getSpecies(type_).getBreedingPeriodEnd3()));
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd4()) != 0) {
            breedingPeriodsEnds.add(getDouble(getSpecies(type_).getBreedingPeriodEnd4()));
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd5()) != 0) {
            breedingPeriodsEnds.add(getDouble(getSpecies(type_).getBreedingPeriodEnd5()));
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd6()) != 0) {
            breedingPeriodsEnds.add(getDouble(getSpecies(type_).getBreedingPeriodEnd6()));
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd7()) != 0) {
            breedingPeriodsEnds.add(getDouble(getSpecies(type_).getBreedingPeriodEnd7()));
        }
        return breedingPeriodsEnds;
    }

    public List<Double> getBreedingPeriodsStarts(String type_) {
        List<Double> breedingPeriodsStarts = new ArrayList<Double>();
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd1()) != 0) {
            breedingPeriodsStarts.add(getDouble(getSpecies(type_).getBreedingPeriodStart1()));
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd2()) != 0) {
            breedingPeriodsStarts.add(getDouble(getSpecies(type_).getBreedingPeriodStart2()));
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd3()) != 0) {
            breedingPeriodsStarts.add(getDouble(getSpecies(type_).getBreedingPeriodStart3()));
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd4()) != 0) {
            breedingPeriodsStarts.add(getDouble(getSpecies(type_).getBreedingPeriodStart4()));
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd5()) != 0) {
            breedingPeriodsStarts.add(getDouble(getSpecies(type_).getBreedingPeriodStart5()));
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd6()) != 0) {
            breedingPeriodsStarts.add(getDouble(getSpecies(type_).getBreedingPeriodStart6()));
        }
        if (getDouble(getSpecies(type_).getBreedingPeriodEnd7()) != 0) {
            breedingPeriodsStarts.add(getDouble(getSpecies(type_).getBreedingPeriodStart7()));
        }
        return breedingPeriodsStarts;
    }

    public List<Double> getDeathPeriodsEnds(String type_) {
        List<Double> deathPeriodsEnds = new ArrayList<Double>();
        if (getDouble(getSpecies(type_).getDeathPeriodEnd1()) != 0) {
            deathPeriodsEnds.add(getDouble(getSpecies(type_).getDeathPeriodEnd1()));
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd2()) != 0) {
            deathPeriodsEnds.add(getDouble(getSpecies(type_).getDeathPeriodEnd2()));
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd3()) != 0) {
            deathPeriodsEnds.add(getDouble(getSpecies(type_).getDeathPeriodEnd3()));
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd4()) != 0) {
            deathPeriodsEnds.add(getDouble(getSpecies(type_).getDeathPeriodEnd4()));
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd5()) != 0) {
            deathPeriodsEnds.add(getDouble(getSpecies(type_).getDeathPeriodEnd5()));
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd6()) != 0) {
            deathPeriodsEnds.add(getDouble(getSpecies(type_).getDeathPeriodEnd6()));
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd7()) != 0) {
            deathPeriodsEnds.add(getDouble(getSpecies(type_).getDeathPeriodEnd7()));
        }
        return deathPeriodsEnds;
    }

    public List<Double> getDeathPeriodsStarts(String type_) {
        List<Double> deathPeriodsStarts = new ArrayList<Double>();
        if (getDouble(getSpecies(type_).getDeathPeriodEnd1()) != 0) {
            deathPeriodsStarts.add(getDouble(getSpecies(type_).getDeathPeriodStart1()));
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd2()) != 0) {
            deathPeriodsStarts.add(getDouble(getSpecies(type_).getDeathPeriodStart2()));
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd3()) != 0) {
            deathPeriodsStarts.add(getDouble(getSpecies(type_).getDeathPeriodStart3()));
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd4()) != 0) {
            deathPeriodsStarts.add(getDouble(getSpecies(type_).getDeathPeriodStart4()));
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd5()) != 0) {
            deathPeriodsStarts.add(getDouble(getSpecies(type_).getDeathPeriodStart5()));
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd6()) != 0) {
            deathPeriodsStarts.add(getDouble(getSpecies(type_).getDeathPeriodStart6()));
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd7()) != 0) {
            deathPeriodsStarts.add(getDouble(getSpecies(type_).getDeathPeriodStart7()));
        }
        return deathPeriodsStarts;
    }

    public List<Double> getCumulativeDeathProbabilities(String type_) {
        List<Double> cumulativeDeathProbabilities = new ArrayList<Double>();
        double cumulativeDeathProbability = 0;
        if (getDouble(getSpecies(type_).getDeathPeriodEnd1()) != 0) {
            cumulativeDeathProbability += getDouble(getSpecies(type_).getDeathPeriodProbability1());
            cumulativeDeathProbabilities.add(cumulativeDeathProbability);
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd2()) != 0) {
            cumulativeDeathProbability += getDouble(getSpecies(type_).getDeathPeriodProbability2());
            cumulativeDeathProbabilities.add(cumulativeDeathProbability);
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd3()) != 0) {
            cumulativeDeathProbability += getDouble(getSpecies(type_).getDeathPeriodProbability3());
            cumulativeDeathProbabilities.add(cumulativeDeathProbability);
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd4()) != 0) {
            cumulativeDeathProbability += getDouble(getSpecies(type_).getDeathPeriodProbability4());
            cumulativeDeathProbabilities.add(cumulativeDeathProbability);
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd5()) != 0) {
            cumulativeDeathProbability += getDouble(getSpecies(type_).getDeathPeriodProbability5());
            cumulativeDeathProbabilities.add(cumulativeDeathProbability);
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd6()) != 0) {
            cumulativeDeathProbability += getDouble(getSpecies(type_).getDeathPeriodProbability6());
            cumulativeDeathProbabilities.add(cumulativeDeathProbability);
        }
        if (getDouble(getSpecies(type_).getDeathPeriodEnd7()) != 0) {
            cumulativeDeathProbability += getDouble(getSpecies(type_).getDeathPeriodProbability7());
            cumulativeDeathProbabilities.add(cumulativeDeathProbability);
        }
        return cumulativeDeathProbabilities;
    }

    public String getInteraction(String typeThis, String typeOther) {
        SpeciesParameters thisSpeciesParameters = getSpecies(typeThis);
        String interaction = "";
        switch (getInt(typeOther)) {
            case 1:
                interaction = thisSpeciesParameters.getInteractionWith1();
                break;
            case 2:
                interaction = thisSpeciesParameters.getInteractionWith2();
                break;
            case 3:
                interaction = thisSpeciesParameters.getInteractionWith3();
                break;
            case 4:
                interaction = thisSpeciesParameters.getInteractionWith4();
                break;
            case 5:
                interaction = thisSpeciesParameters.getInteractionWith5();
                break;
        }
        return interaction;
    }

    public boolean getIsIntelligent(String type_) {
        return getBoolean(getSpecies(type_).getIsIntelligent());
    }

    public int getVisionDistance(String type_) {
        return getInt(getSpecies(type_).getVisionDistance());
    }

    public int getSpeed(String type_) {
        return getInt(getSpecies(type_).getSpeed());
    }

}
