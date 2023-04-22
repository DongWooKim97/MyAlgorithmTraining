package com.ll.arraylist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyArrayListTest {

    @Test
    @DisplayName("사이즈 테스트")
    void t1() {
        MyArrayList<String> list = new MyArrayList<>();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("add(\"사과\")")
    void t2() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("사과"); // data[0]
        list.add("포도"); // data[1];

        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("get(1)")
    void t3() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("사과"); // data[0]
        list.add("포도"); // data[1];

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(1)).isEqualTo("포도");
    }

    @Test
    @DisplayName("data(배열)의 크기가 자동으로 늘어나야 한다.")
    void t4() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("사과");
        list.add("포도");
        list.add("당근");

        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("배열 크기를 한계에 계속 늘림")
    void t5() {
        MyArrayList<String> list = new MyArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }

        assertThat(list.size()).isEqualTo(100);
    }

}