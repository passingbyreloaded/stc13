package ru.innopolis.stc13.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class WordFinderUserTest {

    private static final String EMPTY_STRING = "";
    private static final String FIRST_SENTENCE = "first sentence";
    private static final String SECOND_SENTENCE = "second sentence";
    private static final String RESOURCE = "file://any";
    private static final String BAD_URL = "222";
    private WordFinderUser wordFinderUser;
    private WordFinder wordFinder = Mockito.mock(WordFinder.class);

    @BeforeEach
    void beforeEach() {
        wordFinderUser = new WordFinderUser(wordFinder);
    }

    @Test
    void doWorkNull() {
        when(wordFinder.getSentences(any())).thenReturn(null);
        assertDoesNotThrow(() -> wordFinderUser.doWord(RESOURCE, EMPTY_STRING));
    }

    @Test
    void doWorkEmpty() {
        when(wordFinder.getSentences(any())).thenReturn(Collections.emptySet());
        try {
            wordFinderUser.doWord(RESOURCE, EMPTY_STRING);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        verify(wordFinder, times(0)).checkIfWordInSentences(any(), any());
        verify(wordFinder, times(0)).writeSentenceToResult(any());
    }

    @Test
    void doWorkIfTrue() {
        Set<String> set = new HashSet<>();
        set.add(FIRST_SENTENCE);
        set.add(SECOND_SENTENCE);
        when(wordFinder.getSentences(any())).thenReturn(set);
        when(wordFinder.checkIfWordInSentences(FIRST_SENTENCE, EMPTY_STRING)).thenReturn(true);
        when(wordFinder.checkIfWordInSentences(SECOND_SENTENCE, EMPTY_STRING)).thenReturn(false);
        try {
            wordFinderUser.doWord(RESOURCE, EMPTY_STRING);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        verify(wordFinder, times(1)).writeSentenceToResult(FIRST_SENTENCE);
        verify(wordFinder, times(0)).writeSentenceToResult(SECOND_SENTENCE);
    }

    @Test
    void doWorkURL() {
        final ArgumentCaptor<URL> captor = ArgumentCaptor.forClass(URL.class);
        try {
            wordFinderUser.doWord(RESOURCE, EMPTY_STRING);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        verify(wordFinder).getSentences(captor.capture());
        URL argument = captor.getValue();
        assertEquals(RESOURCE, argument.toString());
    }

    @Test
    void doWorkBadURL() {
        assertThrows(MalformedURLException.class, () -> this.wordFinderUser.doWord(BAD_URL, EMPTY_STRING));
    }
}
