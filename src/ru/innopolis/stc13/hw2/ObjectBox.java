package ru.innopolis.stc13.hw2;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ObjectBox<T> {

    protected Set<T> set = new TreeSet<>();

    public ObjectBox() {
    }

    public ObjectBox(Set<T> set) {
        this.set = set;
    }

    public ObjectBox(T[] array) throws BoxException {
        Set<T> set = new TreeSet<>(Arrays.asList(array));
        if (array.length != set.size()) {
            throw new BoxException("duplicates in array");
        }
        this.set = set;
    }

    public Set<T> getSet() {
        return set;
    }

    public void setSet(Set<T> set) {
        this.set = set;
    }

    public void addObject(T object) {
        set.add(object);
    }

    public void deleteObject(T object) {
        if (set.contains(object)) {
            set.remove(object);
        }
    }

    public String dump() {
        return set.toString();
    }
}
