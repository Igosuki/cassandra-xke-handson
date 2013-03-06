package com.gepsens.xebia.crawler.local;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class LocalDataSet<T> {

    Set<T> items;

    public LocalDataSet() {

    }

    public LocalDataSet(Collection<T> items) {
        this.items = new HashSet<>(items);
    }

    public Set<T> getItems() {
        return items;
    }

    public void setItems(Set<T> items) {
        this.items = items;
    }

    public void addItem(T item) {
        if(this.items == null) {
            this.items = new HashSet<>();
        }
        this.items.add(item);
    }
}
