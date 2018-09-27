package ru.innopolis.stc13.junit;

import java.net.URL;
import java.util.Set;

public interface WordFinder {

    Set<String> getSentences(URL resource);

    boolean checkIfWordInSentences(String sentence, String word);

    void writeSentenceToResult(String sentence);
}
