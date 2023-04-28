package com.ll.sort.selection;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{22, 50, 17, 25, 18, 32, 33, 44, 29, 8};

        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }

    }
}

// 출력 >> 8 17 18 22 25 29 32 33 44 50


