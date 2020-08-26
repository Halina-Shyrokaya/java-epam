package by.shirokaya.tasks.javacollections.maintask.repo;

import by.shirokaya.tasks.javacollections.maintask.entity.Confectionery;

import java.util.List;

public class Catalog {

    private List<Confectionery> list;

    public Catalog(List<Confectionery> list) {
        this.list = list;
    }

    public Catalog() {
    }

    public List<Confectionery> getList() {
        return list;
    }

    public void setList(List<Confectionery> list) {
        this.list = list;
    }
}
