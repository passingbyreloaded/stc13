package ru.innopolis.stc13.generics.mathbox;

import java.util.*;

public class MathBox {

    public Set<Integer> set;

    public MathBox(Integer[] array) throws MathBoxException {
        Set<Integer> set = new TreeSet<>(Arrays.asList(array));
        if (array.length != set.size()) {
            throw new MathBoxException("duplicates in array");
        }
        this.set = set;
    }

    public int summator() {
        int result = 0;
        for (int i : set) {
            result += i;
        }
        return result;
    }

    public Set<Double> splitter(int divider) throws MathBoxException {
        if (divider == 0) {
            throw new MathBoxException("division by zero");
        }
        Set<Double> result = new LinkedHashSet<>();
        for (int i : set) {
            result.add(i / (double) divider);
        }
        return result;
    }

    public void delete(Integer integer) {
        if (set.contains(integer)) {
            set.remove(integer);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(set, mathBox.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "set=" + set +
                '}';
    }
}
