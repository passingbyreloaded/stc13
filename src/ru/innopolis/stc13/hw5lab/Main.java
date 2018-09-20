package ru.innopolis.stc13.hw5lab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Collectors;

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

                try {
                    result.append(Files.lines(file.toPath())
                            .flatMap(line -> Arrays.stream(line.split("\\? |! |\\. |… "))
                                    .map(s -> s + line.charAt(line.indexOf(s) + s.length())))
                            .filter(s -> Arrays.stream(words)
                                    .anyMatch(w -> s.toUpperCase().contains(w.toUpperCase())))
                            .collect(Collectors.joining("\n", "", "\n")));
                } catch (IOException e) {
                    e.printStackTrace();
                }

//                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//                        String[] sentences = line.split("\\? |! |\\. |… ");
//                        System.out.println(sentences.length);
//                        int i=0;
//                        for (String sentence : sentences) {
//                            sentence += line.charAt(line.indexOf(sentence) + sentence.length());
//                            for (String word : words) {
//                                if (sentence.toUpperCase().contains(word.toUpperCase())) {
//                                    result.append(sentence).append("\n");
//                                    System.out.println(sentence);
//                                    i++;
//                                    break;
//                                }
//                            }
//                        }
//                        System.out.println(i);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            });
        }
        while (true) {
            if (pool.allTasksTaken()) {
                pool.shutDown();
                while (true) {
                    if (pool.allTasksDone()) {
                        break;
                    }
                }
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
