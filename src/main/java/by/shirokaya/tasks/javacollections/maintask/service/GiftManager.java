package by.shirokaya.tasks.javacollections.maintask.service;

import by.shirokaya.tasks.javacollections.maintask.entity.Confectionery;
import by.shirokaya.tasks.javacollections.maintask.entity.Gift;
import by.shirokaya.tasks.javacollections.maintask.entity.NonValidQuantityOfPositionsException;
import by.shirokaya.tasks.javacollections.maintask.repo.Catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GiftManager {

    public List<Confectionery> chooseRandomPositionsFromCatalog(Catalog catalog, int quantityOfPositions) throws NonValidQuantityOfPositionsException {
        List<Confectionery> list = catalog.getList();
        if (quantityOfPositions > list.size()) {
            throw new NonValidQuantityOfPositionsException("The maximal quantity is " + list.size());
        } else if (quantityOfPositions <= 0) {
            throw new NonValidQuantityOfPositionsException("The minimal quantity is 1");
        }
        Collections.shuffle(list);
        return list.subList(0, quantityOfPositions);
    }

    public Gift buildGiftWithRandomQuantityOfEachItem(List<Confectionery> list) {
        Gift gift = new Gift(new ArrayList<>());
        for (Confectionery item : list) {
            item
                    .createPortion(new Random().nextInt(10) + 1)
                    .addToComposition(gift);
        }
        return gift;
    }

}
