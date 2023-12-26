package Game.ui;
import Game.logic.GameControl;

import java.util.Random;
import java.util.Scanner;

public class UserInterface {
    private GameControl gameControl;
    private Scanner scanner;

    public UserInterface(GameControl gameControl, Scanner scanner) {
        this.gameControl = gameControl;
        this.scanner = scanner;
    }

    public void start() {
        actionMenu();
    }

    public void addCharacter() {
        System.out.println("Welcome to character creation");
        System.out.println("Are you a boy or a girl?");
        System.out.println("[1] Boy");
        System.out.println("[2] Girl");
        System.out.print("> Enter a number: ");
        String answer = scanner.nextLine();

        System.out.print("What is your characters name: ");
        String name = scanner.nextLine();
        if (name.isBlank()) {
            System.out.println("We get it you hate following instructions, the game will now assign you the name Red");
            name = "Red";
        }
        System.out.println("Right! So you're " + name + "! Welcome!!!!");

        gameControl.addCharacter(name);
    }

    public void actionMenu() {

        label:
        while (true) {
            if (gameControl.gameOver()) {
                break;
            }
            System.out.println();
            System.out.println("Action Menu");
            System.out.println("--------------------");
            System.out.println();
            System.out.println("[1] Fight");
            System.out.println("[2] Shop for Supplies");
            System.out.println("[3] Check XP");
            System.out.println("[4] Check Player Stats");
            System.out.println("[5] Quit");
            System.out.print("> Enter a number: ");

            String answer = scanner.nextLine();
            System.out.println();

            switch (answer) {
                case "1":
                    fight();
                    break;
                case "2":
                    shop();
                    break;
                case "3":
                    gameControl.getPlayerXP();
                    break;
                case "4":
                    gameControl.getPlayerStats();
                    break;
                case "5":
                    System.out.println("Thank you for playing");
                    break label;
                default:
                    System.out.println("Not a valid input");
                    break;
            }
        }
    }

    public void fight() {
        int npcID = new Random().nextInt(5); //picks a random number which will associate with an enemy
        gameControl.generateNPC(npcID);
        boolean fightStatus = false; //Is the fight over

        while (!fightStatus) {
            System.out.println();
            System.out.println("Action Menu");
            System.out.println("--------------------");
            System.out.println();
            System.out.println("[1] Weapon Attack");
            System.out.println("[2] Fireball");
            System.out.println("[3] Heal Spell");
            System.out.println("[4] Use Potion");
            System.out.print("> Enter a command[1-4]: ");

            String command = scanner.nextLine();
            System.out.println();

            if (command.equals("1") || command.equals("2") || command.equals("3") || command.equals("4")) {
                fightStatus = gameControl.fight(Integer.valueOf(command));
            } else {
                System.out.println("Not a valid input");
            }
        }

    }

    public void shop() {

    }

}
