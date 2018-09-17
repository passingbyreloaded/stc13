package ru.innopolis.stc13.proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Trainer mikhail = new JavaTrainer();
        TrainingCenter trainingCenter = new TrainingCenter(mikhail);
        Trainer stc = (Trainer) Proxy.newProxyInstance(TrainingCenter.class.getClassLoader(), new Class[]{Trainer.class}, trainingCenter);
        System.out.println("without proxy:");
        mikhail.eat();
        mikhail.teach();
        System.out.println("with proxy:");
        stc.teach();
        stc.eat();
        stc.talk();

        Trainer fake = (Trainer) Proxy.newProxyInstance(TrainingCenter.class.getClassLoader(), new Class[]{Trainer.class}, new FakeTrainingTrainer());
        fake.teach();
        fake.eat();
        fake.talk();
    }
}
