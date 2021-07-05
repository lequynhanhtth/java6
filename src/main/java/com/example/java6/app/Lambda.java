package com.example.java6.app;

import com.example.java6.modal.student;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        demo4();
    }
    private static void demo1() {
        List<Integer> list = Arrays.asList(1, 5, 7, 4);
        list.forEach(n -> System.out.println(n));
    }

    private static void demo2() {
        List<student> list = Arrays.asList(new student("Nguyễn Văn Tèo", true, 8.4), new student("Lê Quý Nhẫn", true, 10.0));
        list.forEach(student -> {
            System.out.println(">>Name : " + student.getFullname());
            System.out.println(">>Marks : " + student.getMarks());
        });

    }

    private static void demo3() {
        List<student> list = Arrays.asList(new student("Nguyễn Văn Tèo", true, 8.4), new student("Lê Quý Nhẫn", true, 10.0));
        Collections.sort(list, (sv1, sv2) -> sv1.getMarks() < sv2.getMarks() ? 1 : -1);
        list.forEach(student -> {
            System.out.println(">>Name : " + student.getFullname());
            System.out.println(">>Marks : " + student.getMarks());
        });
    }

    public static void demo4() {
        Demo4Inter o  = (x) ->{
            System.out.println(x);
        };
        o.m1(2021);
    }

    @FunctionalInterface
    interface Demo4Inter {
        void m1(int x);

        default void m2() {
        }

        public static void m3() {
        }
    }
}
