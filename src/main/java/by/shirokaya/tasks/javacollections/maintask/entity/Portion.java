package by.shirokaya.tasks.javacollections.maintask.entity;

import java.util.Objects;

public class Portion {
    private Confectionery confectionery;
    private int pieces;

    public Portion(Confectionery confectionery, int pieces) {
        this.confectionery = confectionery;
        this.pieces = pieces;
    }

    public Confectionery getConfectionery() {
        return confectionery;
    }

    public void setConfectionery(Confectionery confectionery) {
        this.confectionery = confectionery;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portion portion = (Portion) o;
        return pieces == portion.pieces &&
                Objects.equals(confectionery, portion.confectionery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(confectionery, pieces);
    }

    @Override
    public String toString() {
        return "\nPortion{" +
                "confectionery=" + confectionery +
                ", pieces=" + pieces +
                '}';
    }

    public void addToComposition(Gift gift) {
        gift.getComposition().add(this);
    }


}
