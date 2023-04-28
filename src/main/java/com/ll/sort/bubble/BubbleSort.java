package com.ll.sort.bubble;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 6, 88, 2, 5, 9, 312, 99}; // 길이가 9인 배열 arr

        // 버블정렬 1 -> 정순
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        // 출력용
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 버블정렬 2 -> 역순
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        // 출력용
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
