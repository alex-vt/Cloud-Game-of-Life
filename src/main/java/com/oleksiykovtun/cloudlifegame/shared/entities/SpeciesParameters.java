package com.oleksiykovtun.cloudlifegame.shared.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.io.Serializable;

/**
 * The parameters of a species in the Game of Life
 */
@Entity
public class SpeciesParameters implements Serializable {

    private static int counter = 0;

    @Id
    private String number;
    private String name;
    private String speed;
    private String visionDistance;
    private String isIntelligent;
    private String interactionWith1;
    private String interactionWith2;
    private String interactionWith3;
    private String interactionWith4;
    private String interactionWith5;
    private String isMobile;
    private String breedingDistance;
    private String breedingPeriodStart1;
    private String breedingPeriodEnd1;
    private String deathPeriodStart1;
    private String deathPeriodEnd1;
    private String deathPeriodProbability1;
    private String breedingPeriodStart2;
    private String breedingPeriodEnd2;
    private String deathPeriodStart2;
    private String deathPeriodEnd2;
    private String deathPeriodProbability2;
    private String breedingPeriodStart3;
    private String breedingPeriodEnd3;
    private String deathPeriodStart3;
    private String deathPeriodEnd3;
    private String deathPeriodProbability3;
    private String breedingPeriodStart4;
    private String breedingPeriodEnd4;
    private String deathPeriodStart4;
    private String deathPeriodEnd4;
    private String deathPeriodProbability4;
    private String breedingPeriodStart5;
    private String breedingPeriodEnd5;
    private String deathPeriodStart5;
    private String deathPeriodEnd5;
    private String deathPeriodProbability5;
    private String breedingPeriodStart6;
    private String breedingPeriodEnd6;
    private String deathPeriodStart6;
    private String deathPeriodEnd6;
    private String deathPeriodProbability6;
    private String breedingPeriodStart7;
    private String breedingPeriodEnd7;
    private String deathPeriodStart7;
    private String deathPeriodEnd7;
    private String deathPeriodProbability7;
    private String initialQuantity;
    private String initialFieldX;
    private String initialFieldY;
    private String childrenQuantityPerPeriod;
    private String isPairRequired;
    private String isBreedingSynchronous;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getVisionDistance() {
        return visionDistance;
    }

    public void setVisionDistance(String visionDistance) {
        this.visionDistance = visionDistance;
    }

    public String getIsIntelligent() {
        return isIntelligent;
    }

    public void setIsIntelligent(String isIntelligent) {
        this.isIntelligent = isIntelligent;
    }

    public String getInteractionWith1() {
        return interactionWith1;
    }

    public void setInteractionWith1(String interactionWith1) {
        this.interactionWith1 = interactionWith1;
    }

    public String getInteractionWith3() {
        return interactionWith3;
    }

    public void setInteractionWith3(String interactionWith3) {
        this.interactionWith3 = interactionWith3;
    }

    public String getInteractionWith4() {
        return interactionWith4;
    }

    public void setInteractionWith4(String interactionWith4) {
        this.interactionWith4 = interactionWith4;
    }

    public String getInteractionWith5() {
        return interactionWith5;
    }

    public void setInteractionWith5(String interactionWith5) {
        this.interactionWith5 = interactionWith5;
    }

    public String getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(String isMobile) {
        this.isMobile = isMobile;
    }

    public String getBreedingPeriodStart1() {
        return breedingPeriodStart1;
    }

    public void setBreedingPeriodStart1(String breedingPeriodStart1) {
        this.breedingPeriodStart1 = breedingPeriodStart1;
    }

    public String getBreedingDistance() {
        return breedingDistance;
    }

    public void setBreedingDistance(String breedingDistance) {
        this.breedingDistance = breedingDistance;
    }

    public String getBreedingPeriodEnd1() {
        return breedingPeriodEnd1;
    }

    public void setBreedingPeriodEnd1(String breedingPeriodEnd1) {
        this.breedingPeriodEnd1 = breedingPeriodEnd1;
    }

    public String getDeathPeriodStart1() {
        return deathPeriodStart1;
    }

    public void setDeathPeriodStart1(String deathPeriodStart1) {
        this.deathPeriodStart1 = deathPeriodStart1;
    }

    public String getDeathPeriodEnd1() {
        return deathPeriodEnd1;
    }

    public void setDeathPeriodEnd1(String deathPeriodEnd1) {
        this.deathPeriodEnd1 = deathPeriodEnd1;
    }

    public String getDeathPeriodProbability1() {
        return deathPeriodProbability1;
    }

    public void setDeathPeriodProbability1(String deathPeriodProbability1) {
        this.deathPeriodProbability1 = deathPeriodProbability1;
    }

    public String getBreedingPeriodEnd2() {
        return breedingPeriodEnd2;
    }

    public void setBreedingPeriodEnd2(String breedingPeriodEnd2) {
        this.breedingPeriodEnd2 = breedingPeriodEnd2;
    }

    public String getBreedingPeriodStart2() {
        return breedingPeriodStart2;
    }

    public void setBreedingPeriodStart2(String breedingPeriodStart2) {
        this.breedingPeriodStart2 = breedingPeriodStart2;
    }

    public String getDeathPeriodStart2() {
        return deathPeriodStart2;
    }

    public void setDeathPeriodStart2(String deathPeriodStart2) {
        this.deathPeriodStart2 = deathPeriodStart2;
    }

    public String getDeathPeriodEnd2() {
        return deathPeriodEnd2;
    }

    public void setDeathPeriodEnd2(String deathPeriodEnd2) {
        this.deathPeriodEnd2 = deathPeriodEnd2;
    }

    public String getDeathPeriodProbability2() {
        return deathPeriodProbability2;
    }

    public void setDeathPeriodProbability2(String deathPeriodProbability2) {
        this.deathPeriodProbability2 = deathPeriodProbability2;
    }

    public String getBreedingPeriodStart3() {
        return breedingPeriodStart3;
    }

    public void setBreedingPeriodStart3(String breedingPeriodStart3) {
        this.breedingPeriodStart3 = breedingPeriodStart3;
    }

    public String getBreedingPeriodEnd3() {
        return breedingPeriodEnd3;
    }

    public void setBreedingPeriodEnd3(String breedingPeriodEnd3) {
        this.breedingPeriodEnd3 = breedingPeriodEnd3;
    }

    public String getDeathPeriodStart3() {
        return deathPeriodStart3;
    }

    public void setDeathPeriodStart3(String deathPeriodStart3) {
        this.deathPeriodStart3 = deathPeriodStart3;
    }

    public String getDeathPeriodEnd3() {
        return deathPeriodEnd3;
    }

    public void setDeathPeriodEnd3(String deathPeriodEnd3) {
        this.deathPeriodEnd3 = deathPeriodEnd3;
    }

    public String getDeathPeriodProbability3() {
        return deathPeriodProbability3;
    }

    public void setDeathPeriodProbability3(String deathPeriodProbability3) {
        this.deathPeriodProbability3 = deathPeriodProbability3;
    }

    public String getBreedingPeriodStart4() {
        return breedingPeriodStart4;
    }

    public void setBreedingPeriodStart4(String breedingPeriodStart4) {
        this.breedingPeriodStart4 = breedingPeriodStart4;
    }

    public String getBreedingPeriodEnd4() {
        return breedingPeriodEnd4;
    }

    public void setBreedingPeriodEnd4(String breedingPeriodEnd4) {
        this.breedingPeriodEnd4 = breedingPeriodEnd4;
    }

    public String getDeathPeriodStart4() {
        return deathPeriodStart4;
    }

    public void setDeathPeriodStart4(String deathPeriodStart4) {
        this.deathPeriodStart4 = deathPeriodStart4;
    }

    public String getDeathPeriodEnd4() {
        return deathPeriodEnd4;
    }

    public void setDeathPeriodEnd4(String deathPeriodEnd4) {
        this.deathPeriodEnd4 = deathPeriodEnd4;
    }

    public String getDeathPeriodProbability4() {
        return deathPeriodProbability4;
    }

    public void setDeathPeriodProbability4(String deathPeriodProbability4) {
        this.deathPeriodProbability4 = deathPeriodProbability4;
    }

    public String getBreedingPeriodStart5() {
        return breedingPeriodStart5;
    }

    public void setBreedingPeriodStart5(String breedingPeriodStart5) {
        this.breedingPeriodStart5 = breedingPeriodStart5;
    }

    public String getBreedingPeriodEnd5() {
        return breedingPeriodEnd5;
    }

    public void setBreedingPeriodEnd5(String breedingPeriodEnd5) {
        this.breedingPeriodEnd5 = breedingPeriodEnd5;
    }

    public String getDeathPeriodStart5() {
        return deathPeriodStart5;
    }

    public void setDeathPeriodStart5(String deathPeriodStart5) {
        this.deathPeriodStart5 = deathPeriodStart5;
    }

    public String getDeathPeriodEnd5() {
        return deathPeriodEnd5;
    }

    public void setDeathPeriodEnd5(String deathPeriodEnd5) {
        this.deathPeriodEnd5 = deathPeriodEnd5;
    }

    public String getDeathPeriodProbability5() {
        return deathPeriodProbability5;
    }

    public void setDeathPeriodProbability5(String deathPeriodProbability5) {
        this.deathPeriodProbability5 = deathPeriodProbability5;
    }

    public String getBreedingPeriodStart6() {
        return breedingPeriodStart6;
    }

    public void setBreedingPeriodStart6(String breedingPeriodStart6) {
        this.breedingPeriodStart6 = breedingPeriodStart6;
    }

    public String getBreedingPeriodEnd6() {
        return breedingPeriodEnd6;
    }

    public void setBreedingPeriodEnd6(String breedingPeriodEnd6) {
        this.breedingPeriodEnd6 = breedingPeriodEnd6;
    }

    public String getDeathPeriodStart6() {
        return deathPeriodStart6;
    }

    public void setDeathPeriodStart6(String deathPeriodStart6) {
        this.deathPeriodStart6 = deathPeriodStart6;
    }

    public String getDeathPeriodEnd6() {
        return deathPeriodEnd6;
    }

    public void setDeathPeriodEnd6(String deathPeriodEnd6) {
        this.deathPeriodEnd6 = deathPeriodEnd6;
    }

    public String getDeathPeriodProbability6() {
        return deathPeriodProbability6;
    }

    public void setDeathPeriodProbability6(String deathPeriodProbability6) {
        this.deathPeriodProbability6 = deathPeriodProbability6;
    }

    public String getBreedingPeriodStart7() {
        return breedingPeriodStart7;
    }

    public void setBreedingPeriodStart7(String breedingPeriodStart7) {
        this.breedingPeriodStart7 = breedingPeriodStart7;
    }

    public String getBreedingPeriodEnd7() {
        return breedingPeriodEnd7;
    }

    public void setBreedingPeriodEnd7(String breedingPeriodEnd7) {
        this.breedingPeriodEnd7 = breedingPeriodEnd7;
    }

    public String getDeathPeriodStart7() {
        return deathPeriodStart7;
    }

    public void setDeathPeriodStart7(String deathPeriodStart7) {
        this.deathPeriodStart7 = deathPeriodStart7;
    }

    public String getDeathPeriodEnd7() {
        return deathPeriodEnd7;
    }

    public void setDeathPeriodEnd7(String deathPeriodEnd7) {
        this.deathPeriodEnd7 = deathPeriodEnd7;
    }

    public String getDeathPeriodProbability7() {
        return deathPeriodProbability7;
    }

    public void setDeathPeriodProbability7(String deathPeriodProbability7) {
        this.deathPeriodProbability7 = deathPeriodProbability7;
    }

    public String getInteractionWith2() {
        return interactionWith2;
    }

    public void setInteractionWith2(String interactionWith2) {
        this.interactionWith2 = interactionWith2;
    }

    public String getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(String initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public String getInitialFieldX() {
        return initialFieldX;
    }

    public void setInitialFieldX(String initialFieldX) {
        this.initialFieldX = initialFieldX;
    }

    public String getInitialFieldY() {
        return initialFieldY;
    }

    public void setInitialFieldY(String initialFieldY) {
        this.initialFieldY = initialFieldY;
    }

    public String getChildrenQuantityPerPeriod() {
        return childrenQuantityPerPeriod;
    }

    public void setChildrenQuantityPerPeriod(String childrenQuantityPerPeriod) {
        this.childrenQuantityPerPeriod = childrenQuantityPerPeriod;
    }

    public String getIsPairRequired() {
        return isPairRequired;
    }

    public void setIsPairRequired(String isPairRequired) {
        this.isPairRequired = isPairRequired;
    }

    public String getIsBreedingSynchronous() {
        return isBreedingSynchronous;
    }

    public void setIsBreedingSynchronous(String isBreedingSynchronous) {
        this.isBreedingSynchronous = isBreedingSynchronous;
    }

    public SpeciesParameters() {
        this.number = "" + ++counter;
    }

    public SpeciesParameters(String number, String name, String speed,
                             String breedingDistance, String visionDistance,
                             String isIntelligent, String isMobile,
                             String interactionWith1, String interactionWith2, String interactionWith3,
                             String interactionWith4, String interactionWith5,
                             String breedingPeriodStart1, String breedingPeriodEnd1,
                             String deathPeriodStart1, String deathPeriodEnd1,
                             String deathPeriodProbability1,
                             String breedingPeriodStart2, String breedingPeriodEnd2,
                             String deathPeriodStart2, String deathPeriodEnd2,
                             String deathPeriodProbability2,
                             String breedingPeriodStart3, String breedingPeriodEnd3,
                             String deathPeriodStart3, String deathPeriodEnd3,
                             String deathPeriodProbability3,
                             String breedingPeriodStart4, String breedingPeriodEnd4,
                             String deathPeriodStart4, String deathPeriodEnd4,
                             String deathPeriodProbability4,
                             String breedingPeriodStart5, String breedingPeriodEnd5,
                             String deathPeriodStart5, String deathPeriodEnd5,
                             String deathPeriodProbability5,
                             String breedingPeriodStart6, String breedingPeriodEnd6,
                             String deathPeriodStart6, String deathPeriodEnd6,
                             String deathPeriodProbability6,
                             String breedingPeriodStart7, String breedingPeriodEnd7,
                             String deathPeriodStart7, String deathPeriodEnd7,
                             String deathPeriodProbability7,
                             String isPairRequired, String childrenQuantityPerPeriod,
                             String isBreedingSynchronous,
                             String initialQuantity, String initialFieldX, String initialFieldY) {
        ++counter;
        this.number = number;
        this.name = name;
        this.speed = speed;
        this.visionDistance = visionDistance;
        this.isIntelligent = isIntelligent;
        this.interactionWith1 = interactionWith1;
        this.interactionWith2 = interactionWith2;
        this.interactionWith3 = interactionWith3;
        this.interactionWith4 = interactionWith4;
        this.interactionWith5 = interactionWith5;
        this.isMobile = isMobile;
        this.breedingDistance = breedingDistance;
        this.breedingPeriodStart1 = breedingPeriodStart1;
        this.breedingPeriodEnd1 = breedingPeriodEnd1;
        this.deathPeriodStart1 = deathPeriodStart1;
        this.deathPeriodEnd1 = deathPeriodEnd1;
        this.deathPeriodProbability1 = deathPeriodProbability1;
        this.breedingPeriodStart2 = breedingPeriodStart2;
        this.breedingPeriodEnd2 = breedingPeriodEnd2;
        this.deathPeriodStart2 = deathPeriodStart2;
        this.deathPeriodEnd2 = deathPeriodEnd2;
        this.deathPeriodProbability2 = deathPeriodProbability2;
        this.breedingPeriodStart3 = breedingPeriodStart3;
        this.breedingPeriodEnd3 = breedingPeriodEnd3;
        this.deathPeriodStart3 = deathPeriodStart3;
        this.deathPeriodEnd3 = deathPeriodEnd3;
        this.deathPeriodProbability3 = deathPeriodProbability3;
        this.breedingPeriodStart4 = breedingPeriodStart4;
        this.breedingPeriodEnd4 = breedingPeriodEnd4;
        this.deathPeriodStart4 = deathPeriodStart4;
        this.deathPeriodEnd4 = deathPeriodEnd4;
        this.deathPeriodProbability4 = deathPeriodProbability4;
        this.breedingPeriodStart5 = breedingPeriodStart5;
        this.breedingPeriodEnd5 = breedingPeriodEnd5;
        this.deathPeriodStart5 = deathPeriodStart5;
        this.deathPeriodEnd5 = deathPeriodEnd5;
        this.deathPeriodProbability5 = deathPeriodProbability5;
        this.breedingPeriodStart6 = breedingPeriodStart6;
        this.breedingPeriodEnd6 = breedingPeriodEnd6;
        this.deathPeriodStart6 = deathPeriodStart6;
        this.deathPeriodEnd6 = deathPeriodEnd6;
        this.deathPeriodProbability6 = deathPeriodProbability6;
        this.breedingPeriodStart7 = breedingPeriodStart7;
        this.breedingPeriodEnd7 = breedingPeriodEnd7;
        this.deathPeriodStart7 = deathPeriodStart7;
        this.deathPeriodEnd7 = deathPeriodEnd7;
        this.deathPeriodProbability7 = deathPeriodProbability7;
        this.initialQuantity = initialQuantity;
        this.initialFieldX = initialFieldX;
        this.initialFieldY = initialFieldY;
        this.isPairRequired = isPairRequired;
        this.childrenQuantityPerPeriod = childrenQuantityPerPeriod;
        this.isBreedingSynchronous = isBreedingSynchronous;
    }

}
