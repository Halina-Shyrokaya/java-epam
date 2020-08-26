package by.shirokaya.tasks.javacollections.maintask.util;

import by.shirokaya.tasks.javacollections.maintask.entity.Portion;

import java.util.Comparator;

public class GiftComparator {

    public final static Comparator<Portion> NAME_OF_ITEM_COMPARATOR = Comparator.comparing(p -> p.getConfectionery().getName());
    public final static Comparator<Portion> WEIGHT_OF_ITEM_COMPARATOR = Comparator.comparingDouble(p -> p.getConfectionery().getWeight());
    public final static Comparator<Portion> WEIGHT_OF_PORTION_COMPARATOR = Comparator.comparingDouble(p -> p.getConfectionery().getWeight() * p.getPieces());
    public final static Comparator<Portion> SUGAR_CONTENT_COMPARATOR = Comparator.comparingDouble(p -> p.getConfectionery().getSugarContent());
    public final static Comparator<Portion> SHELF_LIFE_COMPARATOR = Comparator.comparingInt(p -> p.getConfectionery().getShelfLife());
    public final static Comparator<Portion> FILLING_COMPARATOR = Comparator.comparing(p -> p.getConfectionery().getFilling());
    public final static Comparator<Portion> QUANTITY_OF_PIECES_COMPARATOR = Comparator.comparingInt(Portion::getPieces);

}

