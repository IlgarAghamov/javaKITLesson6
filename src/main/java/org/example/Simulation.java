package org.example;

import java.util.HashMap;
import java.util.Map;

public class Simulation {
    public static void main(String[] args) {
        int numSimulations = 1000;
        int numDoors = 3;
        Map<String, Integer> stats = new HashMap<>();
        stats.put("Wins", 0);
        stats.put("Losses", 0);

        for (int i = 0; i < numSimulations; i++) {
            MontyHallGame game = new MontyHallGame(numDoors);
            int chosenDoor = (int) (Math.random() * numDoors);
            game.chooseDoor(chosenDoor);
            int revealedDoor = game.revealEmptyDoor();
            boolean switchDoor = Math.random() < 0.5; // Randomly decide whether to switch door
            if (switchDoor) {
                game.chooseDoor(game.switchDoor() ? revealedDoor : chosenDoor);
            }
            if (game.isWinner()) {
                stats.put("Wins", stats.get("Wins") + 1);
            } else {
                stats.put("Losses", stats.get("Losses") + 1);
            }
        }

        System.out.println("Wins: " + stats.get("Wins"));
        System.out.println("Losses: " + stats.get("Losses"));
    }
}
