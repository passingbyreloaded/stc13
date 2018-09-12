package ru.innopolis.stc13.generics.mathbox;

public class Main {

    public static void main(String[] args) throws MathBoxException {
        Integer[] array = new Integer[]{50, 25, 1, 87, 69, 34};
//        Integer[] array = new Integer[]{50,25,1,87,69,34,25};;
        MathBox mathBox = new MathBox(array);
        System.out.println(mathBox.set);
        System.out.println(mathBox.summator());
        System.out.println(mathBox.splitter(2));
//        System.out.println(mathBox.splitter(0));
        mathBox.delete(3);
        System.out.println(mathBox.set);
        mathBox.delete(25);
        System.out.println(mathBox.set);
    }
}
