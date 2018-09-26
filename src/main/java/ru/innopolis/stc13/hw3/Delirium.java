package ru.innopolis.stc13.hw3;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Delirium {

    private static String letters = "abcdefghijklmnopqrstuvwxyz";
    private static String marks = ".!?";
    private static Random random = new Random();

    public static void main(String[] args) {
//        genFiles("files", 20, 10000, 40000, 1, new String[]{"tttttttttttt", "aaaaaaaaaaaa", "lllllllllll", "uuuuuuuuuuu", "ddddddddddd", "mmmmmmmmmm"}, 3);
        System.out.println(genWord(0));
    }

    public static void genFiles(String path, int n, int size1, int size2, int diff, String[] words, int probability) {
        File directory = new File(path);
        if (!directory.isDirectory()) {
            return;
        }
        List<Integer> sentencesNumber = getListOfSizes(n, size1, size2, diff);
        int paragraphSize = 0;
        for (int i = 0; i < n; i++) {
            paragraphSize = random.nextInt(20) + 1;
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 1; j <= sentencesNumber.get(i); j++) {
                stringBuilder.append(genSentence(random.nextInt(15) + 1, words, probability));
                if (j % paragraphSize == 0) {
                    stringBuilder.append('\n');
                }
            }
            writeToFile(stringBuilder, path, i);
        }
    }

    private static void writeToFile(StringBuilder stringBuilder, String path, int i) {
        File file = new File(path + "//file" + i);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(stringBuilder.toString().getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Integer> getListOfSizes(int n, int size1, int size2, int diff) {
        List<Integer> list = new ArrayList<>(n);
        switch (diff) {
            case 1:
                for (int i = 0; i < n; i++) {
                    list.add(random.nextInt(size2 - size1) + size1);
                }
                break;
            case 2:
                int delta = (int) ((size2 - size1) * 0.40);
                int min = size1 + delta;
                int max = size2 - delta;
                for (int i = 0; i < n; i++) {
                    if (random.nextInt(3) != 0) {
                        list.add(random.nextInt(max - min) + min);
                    } else {
                        list.add(random.nextInt(size2 - size1) + size1);
                    }
                }
                break;
            case 3:
                int delta2 = (int) ((size2 - size1) * 0.2);
                int min2 = size1 + delta2;
                int max2 = size2 - delta2;
                for (int i = 0; i < n; i++) {
                    int r = random.nextInt(5);
                    if (r == 0) {
                        list.add(random.nextInt(size2 - size1) + size1);
                    } else if (r < 3) {
                        list.add(random.nextInt(min2 - size1) + size1);
                    } else {
                        list.add(random.nextInt(size2 - max2) + max2);
                    }
                }
                break;
            default:
                return null;
        }
//        Collections.sort(list);
//        System.out.println(list);
        return list;
    }

    public static String genSentence(int n, String[] words, int probability) {
        if (n == 0 || words.length == 0 || probability == 0) {
            return "";
        }
        String arrayWord = null;
        int arrayWordIndex = 0;
        if (random.nextInt(probability) == 0) {
            arrayWord = words[random.nextInt(words.length)];
            arrayWordIndex = random.nextInt(n);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (arrayWord != null && i == arrayWordIndex) {
                stringBuilder.append(arrayWord);
            } else {
                stringBuilder.append(genWord(random.nextInt(15) + 1));
            }
            if (i != 0 && i != n - 1) {
                stringBuilder.append(random.nextInt(10) == 5 ? "," : "");
            }
            if (i != n - 1) {
                stringBuilder.append(" ");
            }
        }
        stringBuilder.setCharAt(0, stringBuilder.substring(0, 1).toUpperCase().charAt(0));
        stringBuilder.append(marks.charAt(random.nextInt(marks.length())));
        stringBuilder.append(" ");
        return stringBuilder.toString();
    }

    public static String genWord(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(letters.charAt(random.nextInt(letters.length())));
        }
        return stringBuilder.toString();
    }
}
