package ru.innopolis.stc13.hw3;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeliriumTest {

    @Test
    void writeToFileNull() {
        assertDoesNotThrow(() -> Delirium.writeToFile(null, "files", 111));
    }

    @Test
    void writeToFileBadPath() {
        assertThrows(IOException.class, () -> Delirium.writeToFile(new StringBuilder(), "22", 111));
    }

    @Test
    void getListOfSizes() {
        int result = Delirium.getListOfSizes(15, 20, 40, 1).size();
        assertEquals(15, result);
    }

    @Test
    void getListOfSizesNull() {
        List<Integer> result = Delirium.getListOfSizes(15, 20, 40, 4);
        assertNull(result);
    }

    @Test
    void genSentence() {
        int result = Delirium.genSentence(10, new String[]{"test"}, 1).split(" ").length;
        assertEquals(10, result);
    }

    @Test
    void genSentenceEmpty() {
        String result = Delirium.genSentence(0, new String[]{"test"}, 1);
        assertEquals("", result);
    }

    @Test
    void genSentenceWithProbability() {
        String result = Delirium.genSentence(10, new String[]{"test"}, 1);
        assertTrue(result.contains("test"));
    }

    @Test
    void genWord() {
        int result = Delirium.genWord(5).length();
        assertEquals(5, result);
    }

    @Test
    void genWordEmpty() {
        int result = Delirium.genWord(0).length();
        assertEquals(0, result);
    }
}
