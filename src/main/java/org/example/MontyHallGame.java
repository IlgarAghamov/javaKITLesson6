package org.example;

import org.apache.commons.math3.random.RandomDataGenerator;

public class MontyHallGame {
    private final Door[] doors;
    private final RandomDataGenerator randomDataGenerator;
    private int chosenDoorIndex;

    public MontyHallGame(int numDoors) {
        doors = new Door[numDoors];
        randomDataGenerator = new RandomDataGenerator();
        initializeDoors();
    }

    private void initializeDoors() {
        int prizeDoorIndex = randomDataGenerator.nextInt(0, doors.length - 1);
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new Door(i == prizeDoorIndex);
        }
    }

    public void chooseDoor(int doorIndex) {
        chosenDoorIndex = doorIndex;
    }

    public int revealEmptyDoor() {
        int revealIndex;
        do {
            revealIndex = randomDataGenerator.nextInt(0, doors.length - 1);
        } while (revealIndex == chosenDoorIndex || doors[revealIndex].isHasPrize());
        return revealIndex;
    }

    public boolean switchDoor() {
        for (int i = 0; i < doors.length; i++) {
            if (i != chosenDoorIndex) {
                chosenDoorIndex = i;
                return doors[i].isHasPrize();
            }
        }
        return false;
    }

    public boolean isWinner() {
        return doors[chosenDoorIndex].isHasPrize();
    }
}
