package ru.innopolis.stc13.hw5lab;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        String[] sources = Arrays.stream(new File("files").listFiles()).map(File::getAbsolutePath).toArray(String[]::new);
        String[] words = new String[]{"tttttttttttt", "aaaaaaaaaaaa", "lllllllllll", "uuuuuuuuuuu", "ddddddddddd", "mmmmmmmmmm"};
        getOccurrences(sources, words, "result");
    }

    public static void getOccurrences(String[] sources, String[] words, String res) throws IOException {
        StringBuffer result = new StringBuffer();
        File resultFile = new File(res);
        if (!isFileOk(resultFile)) {
            return;
        }
        ThreadPool pool = new ThreadPool(5);
        for (String string : sources) {
            pool.startTask(() -> {
                File file = new File(string);
                if (!isFileOk(file)) {
                    return;
                }
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] sentences = line.split("\\? |! |\\. |… ");
                        for (String sentence : sentences) {
                            sentence += line.charAt(line.indexOf(sentence) + sentence.length());
                            for (String word : words) {
                                if (sentence.toUpperCase().contains(word.toUpperCase())) {
                                    result.append(sentence).append("\n");
                                    break;
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        while (true) {
            if (pool.allTasksDone()) {
                pool.shutDown();
                break;
            }
        }

        try (FileWriter writer = new FileWriter(resultFile, false)) {
            writer.write(result.toString());
        }
    }

    private static boolean isFileOk(File file) {
        if (file.isDirectory() || !file.exists()) {
            System.out.println("File " + file.getAbsolutePath() + " is a directory or doesnt exist");
            return false;
        }
        return true;
    }
}
