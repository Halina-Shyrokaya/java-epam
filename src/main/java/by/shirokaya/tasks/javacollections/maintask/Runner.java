package by.shirokaya.tasks.javacollections.maintask;

import by.shirokaya.tasks.javacollections.maintask.entity.Confectionery;
import by.shirokaya.tasks.javacollections.maintask.entity.Gift;
import by.shirokaya.tasks.javacollections.maintask.entity.NonValidQuantityOfPositionsException;
import by.shirokaya.tasks.javacollections.maintask.entity.Portion;
import by.shirokaya.tasks.javacollections.maintask.repo.Catalog;
import by.shirokaya.tasks.javacollections.maintask.service.GiftManager;
import by.shirokaya.tasks.javacollections.maintask.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.shirokaya.tasks.javacollections.maintask.util.GiftComparator.*;

public class Runner {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        try {
            catalog = new JsonReader().readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GiftManager giftManager = new GiftManager();
        List<Confectionery> list = new ArrayList<>();
        try {
            list = giftManager.chooseRandomPositionsFromCatalog(catalog, 10);
        } catch (NonValidQuantityOfPositionsException e) {
            e.printStackTrace();
        }
        Gift gift = giftManager.buildGiftWithRandomQuantityOfEachItem(list);
        System.out.println("Подарок создан (случайным образом): ");
        System.out.println(gift);

        System.out.println("Общий вес подарка, г: ");
        System.out.println(gift.getTotalWeight());

        System.out.println("Сортировка по названию сладости: ");
        gift.sort(NAME_OF_ITEM_COMPARATOR);
        System.out.println(gift);

        System.out.println("Фильтр по содержанию сахара в указанном диапазоне: ");
        List<Portion> filtered = gift.filterBySugarContent(0.0, 0.54);
        System.out.println(filtered);
    }
}
