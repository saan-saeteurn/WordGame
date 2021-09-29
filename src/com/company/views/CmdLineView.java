package com.company.views;

import java.util.Scanner;
import java.util.Arrays;

public class CmdLineView {

    private String[] letters;
    private String theGuess;

    public CmdLineView(String[] letters) {
        this.letters = letters;
    }

    public void startGame() {
        System.out.println("Guess the word \n");
        for(int i = 0; i < letters.length; i++){
            System.out.print("_ ");
        }
        System.out.print("\n");
    }

    public String makeAGuess(){
        System.out.print("Guess a letter: ");
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public void displayHints(String[] hints, int guessCounter, int maxGuessCount){
        for(String hint: hints){
            System.out.print(hint);
        }

        System.out.print("\n");
        if(guessCounter <= maxGuessCount)
            System.out.println("Number of incorrect guesses: " + guessCounter + " (out of " + maxGuessCount + ")");
    }

    public void cheat(String theWord){
        System.out.println("The word is " + theWord + ".");
    }

    public Boolean isWinner(String[] guessWord, String[] targetWord) {
        if(Arrays.equals(guessWord, targetWord)) {
            System.out.println("You have correctly guess all the letters!");
            return true;
        } else
            return false;
    }

    public String[] getLetters() {
        return letters;
    }

    public void setLetters(String[] letters) {
        this.letters = letters;
    }

    public String getTheGuess() {
        return theGuess;
    }

    public void setTheGuess(String theGuess) {
        this.theGuess = theGuess;
    }
}
