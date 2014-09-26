package com.oleksiykovtun.cloudlifegame.server.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Game field cell
 */
class Cell {

    private Coordinates currentCoordinates;
    private String type_;
    private double birthTime;
    private double deathTime = Integer.MAX_VALUE;
    private List<Double> breedingTimes = new ArrayList<Double>();
    private List<Integer> breedingPeriodsQuotas = new ArrayList<Integer>();

    public static int id = 0;

    public Cell(Coordinates coordinates, String type_, double birthTime) {
        currentCoordinates = coordinates;
        this.type_ = type_;
        this.birthTime = birthTime;
        ++id;
    }

    public double getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(double birthTime) {
        this.birthTime = birthTime;
    }

    public void moveTo(Coordinates newCoordinates) {
        currentCoordinates.setX(newCoordinates.getX());
        currentCoordinates.setY(newCoordinates.getY());
    }

    public void setDeathTime(double deathTime) {
        this.deathTime = deathTime;
    }

    public void setBreedingTimes(List<Double> breedingTimes) {
        this.breedingTimes = breedingTimes;
    }

    public void setBreedingPeriodsQuotas(List<Integer> breedingPeriodsQuotas) {
        this.breedingPeriodsQuotas = breedingPeriodsQuotas;
    }

    public Coordinates getCoordinates() {
        return currentCoordinates;
    }

    public void setCurrentCoordinates(Coordinates currentCoordinates) {
        this.currentCoordinates = currentCoordinates;
    }

    public String getType_() {
        return type_;
    }

    public void setType_(String type_) {
        this.type_ = type_;
    }

    public boolean isDying(double currentTime) {
        return (currentTime == deathTime);
    }

    public boolean isBreeding(double currentTime) {
        return breedingTimes.remove(currentTime);
    }

    public void decrementBreedingQuota(int periodNumber) {
        breedingPeriodsQuotas.set(periodNumber,
                Math.max(breedingPeriodsQuotas.get(periodNumber) - 1, 0));
    }

    public int getBreedingQuota(int periodNumber) {
        return breedingPeriodsQuotas.get(periodNumber);
    }
}
