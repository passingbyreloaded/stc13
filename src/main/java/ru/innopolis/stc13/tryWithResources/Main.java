package ru.innopolis.stc13.tryWithResources;

public class Main {
    public static void main(String[] args) {
        try (OpenDoor door = new OpenDoor()) {

        } catch (Exception e) {
            System.out.println();
        }
    }
}
