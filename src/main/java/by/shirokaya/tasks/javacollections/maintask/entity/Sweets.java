package by.shirokaya.tasks.javacollections.maintask.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Sweets extends Confectionery {

    private SweetsType sweetsType;

    @JsonCreator()
    public Sweets(@JsonProperty("name") String name,
                  @JsonProperty("filling") String filling,
                  @JsonProperty("weight") double weight,
                  @JsonProperty("sugarContent") double sugarContent,
                  @JsonProperty("shelfLife") int shelfLife,
                  @JsonProperty("sweetsType") SweetsType sweetsType) {
        super(name, filling, weight, sugarContent, shelfLife);
        this.sweetsType = sweetsType;
    }

    public Sweets() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sweets sweets = (Sweets) o;
        return sweetsType == sweets.sweetsType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sweetsType);
    }

    @Override
    public String toString() {
        return "Sweets{" +
                "name='" + getName() + '\'' +
                ", filling='" + getFilling() + '\'' +
                ", weight=" + getWeight() +
                ", sugarContent=" + getSugarContent() +
                ", shelfLife=" + getShelfLife() +
                ", sweetsType=" + sweetsType +
                '}';
    }

    public SweetsType getSweetsType() {
        return sweetsType;
    }

    public void setSweetsType(SweetsType sweetsType) {
        this.sweetsType = sweetsType;
    }
}
