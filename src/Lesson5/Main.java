package Lesson5;

import java.util.Random;

public class Main {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Cat cat = new Cat("Cat1", RANDOM.nextInt(100, 300), 2.0, 0);
        Dog dog = new Dog("Dog1", RANDOM.nextInt(400, 600), 0.5, 10);
        Horse horse = new Horse("Horse1", RANDOM.nextInt(1300, 1800), 3.0, 0);
        Bird bird = new Bird("Bird1", RANDOM.nextInt(4, 7), 0.2, 100);

        Animal[] animals = {cat, dog, bird, horse};
        animalRun(50, animals);
        System.out.println();
        animalSwim(7, animals);
        System.out.println();
        animalJump(1.2, animals);


    }

    public static void animalRun(int magnitudeRun, Animal[] animals) {
        System.out.println("Задача: пробежать " + magnitudeRun + "м");
        for (Animal animal : animals) {
            if (animal.run(magnitudeRun)) {
                System.out.println(animal.getName() + "(maxRun = " + animal.getMaxRun() + "м), пробежал!!!");
            } else {
                System.out.println(animal.getName() + "(maxRun = " + animal.getMaxRun() + "м), не смог пробежать(((");
            }
        }
    }

    public static void animalSwim(int magnitudeSwim, Animal[] animals) {
        System.out.println("Задача: проплыть " + magnitudeSwim + "м");
        for (Animal animal : animals) {
            if (animal.swim(magnitudeSwim)) {
                System.out.println(animal.getName() + "(maxSwim = " + animal.getMaxSwim() + "м), проплыл!!!");
            } else {
                System.out.println(animal.getName() + "(maxSwim = " + animal.getMaxSwim() + "м), не смог проплыть(((");
            }
        }
    }

    public static void animalJump(double magnitudeJump, Animal[] animals) {
        System.out.println("Задача: прыгнуть на " + magnitudeJump + "м");
        for (Animal animal : animals) {
            if (animal.jump(magnitudeJump)) {
                System.out.println(animal.getName() + "(maxJump = " + animal.getMaxJump() + "м), прыгнул!!!");
            } else {
                System.out.println(animal.getName() + "(maxJump = " + animal.getMaxJump() + "м), не смог прыгнуть(((");
            }
        }
    }
}
