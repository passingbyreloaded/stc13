package ru.innopolis.stc13.hw2;

public class Main {
    public static void main(String[] args) throws BoxException {
//        Integer[] array = new Integer[]{50, 25, 1, 87, 69, 34};
        Float[] array = new Float[]{2.2f, 1.5f, 5.6f};
//        Object[] objects = new Object[]{"12",new Object(),new Integer(0)};
        MathBox mathBox = new MathBox(array);
        System.out.println(mathBox.dump());
        System.out.println(mathBox.summator());
        System.out.println(mathBox.splitter(2));
//        System.out.println(mathBox.splitter(0));
//        mathBox.addObject(new Integer(2));
        mathBox.addObject(2.2f);
        System.out.println(mathBox.dump());
        mathBox.deleteObject(25.3f);
        System.out.println(mathBox.dump());
    }
}
