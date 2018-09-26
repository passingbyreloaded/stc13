package ru.innopolis.stc13.start;

public class Animal {

    private String name;
    private Integer nLegs;

    public Animal(String name, Integer nLegs) {
        this.name = name;
        this.nLegs = nLegs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getnLegs() {
        return nLegs;
    }

    public void setnLegs(Integer nLegs) {
        this.nLegs = nLegs;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", nLegs=" + nLegs +
                '}';
    }
}
