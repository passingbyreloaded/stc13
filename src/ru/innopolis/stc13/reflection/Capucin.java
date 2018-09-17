package ru.innopolis.stc13.reflection;

public class Capucin extends Monkey {
    private final int tailLenght = 40;
    public int charming;
    protected int harmful;
    private int footsize;

    public Capucin(int charming, int harmful, int footsize) {
        this.charming = charming;
        this.harmful = harmful;
        this.footsize = footsize;
    }

    public Capucin(int charming) {
        this(charming, 1, 38);
    }

    protected void washFace() {
        System.out.println("Face is clean");
    }

    private void washEars() {
        System.out.println("Ears are clean");
    }

    public void eatBananas(int count) {
        System.out.println("Ate " + count + " bananas");
    }
}
