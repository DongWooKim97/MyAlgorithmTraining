package com.ll.array;

public class Array {
    static int idx = 3;
    static int num = 6;
    static int[] arr = new int[10];

    public static void main(String[] args) {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i;
        }

        check(); // 초기화 상태
        //0 1 2 3 4 5 6 7 8 0

        insert();
        check(); // 임의의 위치 추가 상태
        //0 1 2 6 3 4 5 6 7 8

        delete();
        check(); // 임의의 위치 삭제 상태
        //0 1 2 3 4 5 6 7 8 0
    }

    static void check() {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static void insert() {
        for (int i = arr.length - 1; i >= idx; i--) {
            int tmp = arr[i - 1];
            arr[i] = tmp;
        }
        arr[idx] = num;
    }

    static void delete() {
        for (int i = idx; i < arr.length - 1; i++) {
            int tmp = arr[i + 1];
            arr[i] = tmp;
        }
        arr[arr.length - 1] = 0;
    }
}