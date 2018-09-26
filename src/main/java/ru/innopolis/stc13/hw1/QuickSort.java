package ru.innopolis.stc13.hw1;

public class QuickSort {

    public static void main(String[] args) throws Exception {

        int[] array = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static void quickSort(int[] array, int lowestIndex, int highestIndex) throws Exception {
        if (array.length == 0) {
            throw new Exception("empty array!");
        }

        if (lowestIndex >= highestIndex) {
            return;
        }

        int pivotIndex = lowestIndex + (highestIndex - lowestIndex) / 2;
        int pivot = array[pivotIndex];

        int i = lowestIndex, j = highestIndex;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            //swap
            if (i <= j) {
                int value = array[i];
                array[i] = array[j];
                array[j] = value;
                i++;
                j--;
            }
        }

        if (lowestIndex < j)
            quickSort(array, lowestIndex, j);

        if (highestIndex > i)
            quickSort(array, i, highestIndex);
    }
}
