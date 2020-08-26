package by.shirokaya.tasks.javacollections.maintask.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Caramel.class),
        @JsonSubTypes.Type(value = Chocolate.class),
        @JsonSubTypes.Type(value = Sweets.class),
})
public abstract class Confectionery {

    private String name;
    private String filling;
    private double weight;
    private double sugarContent;
    private int shelfLife;

    public Confectionery() {
    }

    public Confectionery(String name, String filling, double weight, double sugarContent, int shelfLife) {
        this.name = name;
        this.filling = filling;
        this.weight = weight;
        this.sugarContent = sugarContent;
        this.shelfLife = shelfLife;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    public void setSugarContent(double sugarContent) {
        this.sugarContent = sugarContent;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Confectionery that = (Confectionery) o;
        return Double.compare(that.weight, weight) == 0 &&
                Double.compare(that.sugarContent, sugarContent) == 0 &&
                shelfLife == that.shelfLife &&
                Objects.equals(name, that.name) &&
                Objects.equals(filling, that.filling);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, filling, weight, sugarContent, shelfLife);
    }

    @Override
    public String toString() {
        return "Confectionery{" +
                "name='" + name + '\'' +
                ", filling='" + filling + '\'' +
                ", weight=" + weight +
                ", sugarContent=" + sugarContent +
                ", shelfLife=" + shelfLife +
                '}';
    }

    public Portion createPortion(int pieces) {
        return new Portion(this, pieces);
    }
}
