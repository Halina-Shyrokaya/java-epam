package by.shirokaya.tasks.javacollections.maintask.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Chocolate extends Confectionery {
    private double cacaoContent;
    private double milkContent;

    @JsonCreator
    public Chocolate(@JsonProperty("name") String name,
                     @JsonProperty("filling") String filling,
                     @JsonProperty("weight") double weight,
                     @JsonProperty("sugarContent") double sugarContent,
                     @JsonProperty("shelfLife") int shelfLife,
                     @JsonProperty("cacaoContent") double cacaoContent,
                     @JsonProperty("milkContent") double milkContent) {
        super(name, filling, weight, sugarContent, shelfLife);
        this.cacaoContent = cacaoContent;
        this.milkContent = milkContent;
    }

    public Chocolate() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chocolate chocolate = (Chocolate) o;
        return Double.compare(chocolate.cacaoContent, cacaoContent) == 0 &&
                Double.compare(chocolate.milkContent, milkContent) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cacaoContent, milkContent);
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "name='" + getName() + '\'' +
                ", filling='" + getFilling() + '\'' +
                ", weight=" + getWeight() +
                ", sugarContent=" + getSugarContent() +
                ", shelfLife=" + getShelfLife() +
                ", cacaoContent=" + cacaoContent +
                ", milkContent=" + milkContent +
                '}';
    }

    public double getCacaoContent() {
        return cacaoContent;
    }

    public void setCacaoContent(double cacaoContent) {
        this.cacaoContent = cacaoContent;
    }

    public double getMilkContent() {
        return milkContent;
    }

    public void setMilkContent(double milkContent) {
        this.milkContent = milkContent;
    }
}
