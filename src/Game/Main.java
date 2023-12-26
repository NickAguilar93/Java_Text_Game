package Game;

import Game.domain.NPC;
import Game.logic.GameControl;
import Game.ui.UserInterface;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        GameControl gameControl = new GameControl();
        UserInterface ui = new UserInterface(gameControl, scanner);

        System.out.println("Hello there! Welcome to the world of POKEMON! My name is OAK!");
        System.out.println("People call me the POKEMON PROF! This world is inhabited by creatures called POKEMON!");
        System.out.println("For some people, POKEMON are pets. Others use them for fights.");
        System.out.println("Myself...I study POKEMON as a profession.");
        System.out.println("First, lets figure out what you are");

        ui.addCharacter();
        ui.start();
    }
}
