package by.shirokaya.tasks.javacollections.maintask.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Caramel extends Confectionery {

    private boolean isCoveredWithChocolate;

    @JsonCreator()
    public Caramel(@JsonProperty("name") String name,
                   @JsonProperty("filling") String filling,
                   @JsonProperty("weight") double weight,
                   @JsonProperty("sugarContent") double sugarContent,
                   @JsonProperty("shelfLife") int shelfLife,
                   @JsonProperty("isCoveredWithChocolate") boolean isCoveredWithChocolate) {
        super(name, filling, weight, sugarContent, shelfLife);
        this.isCoveredWithChocolate = isCoveredWithChocolate;
    }

    public Caramel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Caramel caramel = (Caramel) o;
        return isCoveredWithChocolate == caramel.isCoveredWithChocolate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isCoveredWithChocolate);
    }

    @Override
    public String toString() {
        return "Caramel{" +
                "name='" + getName() + '\'' +
                ", filling='" + getFilling() + '\'' +
                ", weight=" + getWeight() +
                ", sugarContent=" + getSugarContent() +
                ", shelfLife=" + getShelfLife() +
                ", isCoveredWithChocolate=" + isCoveredWithChocolate +
                '}';
    }

    public boolean isCoveredWithChocolate() {
        return isCoveredWithChocolate;
    }

    public void setCoveredWithChocolate(boolean coveredWithChocolate) {
        isCoveredWithChocolate = coveredWithChocolate;
    }
}
