/*
Class WordList doesn't actually creates nor maintains
a word list.  All it does is takes a string of a single
word and set it during instantiation.  The word itself can
be retrieve via a getter called "getTheWord()".
 */

package com.company.models;

public class WordList {

    private String theWord;

    public WordList(String theWord) {
        this.theWord = theWord;
    }

    public String getTheWord() {
        theWord = theWord.toLowerCase();
        return theWord;
    }

    // TODO: not in use
    public void setTheWord(String theWord) {
        this.theWord = theWord;
    }
}
