package by.shirokaya.tasks.javacollections.maintask.entity;

import java.util.*;
import java.util.stream.Collectors;

public class Gift {

    private List<Portion> composition;

    public Gift(List<Portion> composition) {
        this.composition = composition;
    }

    public Gift() {
    }

    public List<Portion> getComposition() {
        return composition;
    }

    public void setComposition(List<Portion> composition) {
        this.composition = composition;
    }

    public double getTotalWeight() {
        double totalWeight = 0.0;
        for (Portion portion : composition) {
            totalWeight += portion.getConfectionery().getWeight() * portion.getPieces();
        }
        return totalWeight;
    }

    public void sort(Comparator<Portion> comparator) {
        composition.sort(comparator);
    }

    public List<Portion> filterBySugarContent(double minContent, double maxContent) {
        return composition.stream()
                .filter(p -> p.getConfectionery().getSugarContent() <= maxContent)
                .filter(p -> p.getConfectionery().getSugarContent() >= minContent)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return Objects.equals(composition, gift.composition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(composition);
    }

    @Override
    public String toString() {
        return "Gift composition=" + composition;
    }
}
