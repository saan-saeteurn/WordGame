package com.company.controllers;
import com.company.views.CmdLineView;
import com.company.models.WordList;
import java.util.Arrays;


public class Main {

    public static String[] letters;
    public static int numLetters = 0;
    public static int numGuesses;
    public static int maxGuesses;
    public static String theGuess;
    public static String[] hints;
    public static  CmdLineView view;

    public static void main(String[] args) {

        numGuesses = 6;

        GetWord getWord = new GetWord();
        String theWord = getWord.getTheWord();

        WordList word = new WordList(theWord);

        letters = calculateLetters(word.getTheWord());

        view = new CmdLineView(letters);
        view.startGame();
        view.cheat(word.getTheWord());

        while(numGuesses > 0){
            hints = guess();
            view.displayHints(hints);
            //display
            String currentGuess = view.getTheGuess();
            if(currentGuess != null)
                System.out.println("You guessed " + currentGuess);
        }
    }

    private static String[] calculateLetters(String theWord){
        /*
        Set number of letters equals the size of our placeholder
        for hints.  Set the guess maximum size to dynamically
        scale or double the length of each randomly selected word.
        Lastly, set our hints array to "_" to avoid having to
        initialize it elsewhere.
         */
        String[] letters = theWord.split("");
        numLetters = letters.length;
        hints = new String[letters.length];
        maxGuesses = letters.length * 2;
        Arrays.setAll(hints, i -> "_");
        return letters;
    }

    private static String[] guess(){
        theGuess = view.makeAGuess();

        for(int i = 0; i < letters.length; i++) {
            if(letters[i].equals(theGuess)) {
                if(Arrays.stream(hints).toList().contains(theGuess))
                    continue;
                else
                    hints[i] = theGuess;
            }
        }
        return hints;
    }
}
