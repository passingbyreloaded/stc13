package ru.innopolis.stc13.hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MathBox extends ObjectBox<Number> {

    public MathBox(Number[] array) throws BoxException {
        super(array);
    }

    public Double summator() {
        Double result = 0.0;
        for (Number num : set) {
            result += num.doubleValue();
        }
        return result;
    }

    public List<Double> splitter(int divider) throws BoxException {
        if (divider == 0) {
            throw new BoxException("division by zero");
        }
        List<Double> result = new ArrayList<>();
        for (Number number : set) {
            result.add(number.doubleValue() / divider);
        }
        return result;
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

