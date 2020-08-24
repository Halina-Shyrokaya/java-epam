package planes;

import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;

import java.util.Objects;

public abstract class Plane {

    private String model;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;
    private ClassificationLevel classificationLevel;
    private ExperimentalType experimentalType;
    private MilitaryType militaryType;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                 ClassificationLevel classificationLevel, ExperimentalType experimentalType, MilitaryType militaryType) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
        this.classificationLevel = classificationLevel;
        this.experimentalType = experimentalType;
        this.militaryType = militaryType;
    }

    public Plane() {
    }


    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public ExperimentalType getExperimentalType() {
        return experimentalType;
    }

    public MilitaryType getMilitaryType() {
        return militaryType;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setMaxFlightDistance(int maxFlightDistance) {
        this.maxFlightDistance = maxFlightDistance;
    }

    public void setMaxLoadCapacity(int maxLoadCapacity) {
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    public void setExperimentalType(ExperimentalType experimentalType) {
        this.experimentalType = experimentalType;
    }

    public void setMilitaryType(MilitaryType militaryType) {
        this.militaryType = militaryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return maxSpeed == plane.maxSpeed &&
                maxFlightDistance == plane.maxFlightDistance &&
                maxLoadCapacity == plane.maxLoadCapacity &&
                Objects.equals(model, plane.model) &&
                classificationLevel == plane.classificationLevel &&
                experimentalType == plane.experimentalType &&
                militaryType == plane.militaryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity, classificationLevel, experimentalType, militaryType);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                ", classification level=" + classificationLevel +
                ", experimentalType=" + experimentalType +
                ", type=" + militaryType +
                '}';
    }

}

