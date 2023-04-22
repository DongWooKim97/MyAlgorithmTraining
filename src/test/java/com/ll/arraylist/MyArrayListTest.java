package com.ll.arraylist;

import com.ll.TestUt;
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

        String[] data = TestUt.getFieldValue(list, "data", null);
        assertThat(data.length).isEqualTo(2);

        list.add("사과");
        list.add("포도");

        data = TestUt.getFieldValue(list, "data", null);
        assertThat(data.length).isEqualTo(2);

        list.add("당근");

        data = TestUt.getFieldValue(list, "data", null);
        assertThat(data.length).isEqualTo(4);

        assertThat(list.size()).isEqualTo(3);
    }
}