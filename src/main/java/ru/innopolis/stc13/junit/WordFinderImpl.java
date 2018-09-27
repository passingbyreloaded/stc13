package ru.innopolis.stc13.junit;

import java.net.URL;
import java.util.Set;

public class WordFinderImpl implements WordFinder {

    @Override
    public Set<String> getSentences(URL resource) {
        return null;
    }

    @Override
    public boolean checkIfWordInSentences(String sentence, String word) {
        return false;
    }

    @Override
    public void writeSentenceToResult(String sentence) {

    }
}
