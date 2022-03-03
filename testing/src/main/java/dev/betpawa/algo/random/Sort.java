package dev.betpawa.algo.random;

import java.util.Arrays;

public class Sort {
    public static void mergeSort(int[] input) {
        int[] buff = new int[input.length];
        mergeSort(input, buff, 0, input.length - 1);
    }

    private static void mergeSort(int[] input, int[] buff, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(input, buff, low, mid);
            mergeSort(input, buff, mid + 1, high);
            merge(input, buff, low, mid + 1, high);
        }
    }

    private static void merge(int[] input, int[] buff, int left, int right, int end) {
        int start = right - 1;
        int k = left;
        int num = end - left + 1;

        while (left <= start && right <= end) {
            if (input[left] < input[right]) {
                buff[k++] = input[left++];
            } else {
                buff[k++] = input[right++];
            }
        }

        while (left <= start) {
            buff[k++] = input[left++];
        }

        while (right <= end) {
            buff[k++] = input[right++];
        }

        for (int i = 0; i < num; i++, end--) {
            input[end] = buff[end];
        }
    }

    public static void main(String[] args) {
        int[] a = {15,8,7,3,9,2,1,6,8,12,5,8,6,22,31,1,0,3};
        int[] b = {15,8,7,3,9,2,1,6,8,12,5,8,6,22,31,1,0,3};
        mergeSort(a);
        bubbleSort(b);
        System.out.println("Test merge sort " + Arrays.toString(a));
        System.out.println("Test bubble sort " + Arrays.toString(b));
    }

    private static void bubbleSort(int[] original) {
        int temp;
        int n = original.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (original[j] > original[j + 1]) {
                    temp = original[j];
                    original[j] = original[j + 1];
                    original[j + 1] = temp;
                }
            }
        }
    }
}
