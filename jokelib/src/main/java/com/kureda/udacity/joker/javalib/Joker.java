package com.kureda.udacity.joker.javalib;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Joker {

    private static Random generator = new Random();
    private static final List<String> jokes = Arrays.asList(
            "Enter any 11-digit prime number to continue.",
            "Error: Keyboard not attached.\nPress F1 to continue.",
            "Press any key to continue\nor any other key to quit.",
            "Printer not ready.\nDo you have a pen?",
            "SYSTEM HALTED!\nPress any key to do nothing.",
            "Press any key...\nOh no!\nNOT THAT ONE!",
            "God is rebooting the universe, please wait.",
            "Missing mouse driver.\nSpank the cat? (Y/N)",
            "User Error.\nReplace user.",
            "OS/Windows found: Remove it? (Y/Y)",
            "Backup not found:\n(A)bort (R)etry (P)anic"
    );

    public static String getJoke() {
        int i = generator.nextInt(jokes.size());
        return jokes.get(i);
    }
}
