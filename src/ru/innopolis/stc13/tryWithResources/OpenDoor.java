package ru.innopolis.stc13.tryWithResources;

public class OpenDoor implements AutoCloseable {

    public OpenDoor() {
        System.out.println("The door is open");
    }

    public void swing() throws Exception {
        System.out.println("The door is closing");
        throw new SwingException("Some problem");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Door is closed");
    }
}
