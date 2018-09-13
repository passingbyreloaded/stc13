package ru.innopolis.stc13.hw2;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ObjectBox<T> implements Serializable {

    protected Set<T> set = new HashSet<>();

    public ObjectBox() {
    }

    public ObjectBox(Set<T> set) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox<?> objectBox = (ObjectBox<?>) o;
        return Objects.equals(set, objectBox.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }
}
