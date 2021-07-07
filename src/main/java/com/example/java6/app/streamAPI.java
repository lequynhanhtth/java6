//package com.example.java6.app;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class streamAPI {
//    public static void main(String[] args) {
//        demo4();
//    }
//    private static void demo1() {
//        Stream<Integer> stream1 = Stream.of(1,9,4,2);
//        stream1.forEach(n -> System.out.println(n));
//    }
//
//    private static void demo2() {
//        List<Integer> list = Arrays.asList(1,9,4,6);
//        List<Double>  result =list.stream().filter(n -> n%2 ==0).map(n-> Math.sqrt(n)).peek(d -> System.out.println(d)).collect(Collectors.toList());
//
//    }
//
//    private static void demo3() {
//        List<student> list = Arrays.asList(new student("Nguyễn Văn Tèo", true, 8.4), new student("Lê Quý Nhẫn", true, 10.0));
//        List<student> result = list.stream().filter(sv -> sv.getMarks() >=7).peek(sv -> sv.setFullname(sv.getFullname().toUpperCase())).collect(Collectors.toList());
//        result.forEach(sv -> {
//            System.out.println(">>Fullname "+sv.getFullname());
//            System.out.println(">>Mark "+sv.getMarks());
//        });
//    }
//
//    public static void demo4() {
//        List<student> list = Arrays.asList(new student("Nguyễn Văn Tèo", true, 8.4), new student("Lê Quý Nhẫn", true, 10.0), new student("Lam",true,4));
//        double average = list.stream().mapToDouble(sv -> sv.getMarks()).average().getAsDouble();
//        System.out.println("average: "+average);
//        double sum = list.stream().mapToDouble(sv -> sv.getMarks()).sum();
//        System.out.println("sum: " +sum);
//        double minmark = list.stream().mapToDouble(sv -> sv.getMarks()).min().getAsDouble();
//        System.out.println("Min: "+minmark);
//        boolean All_passed = list.stream().allMatch(sv -> sv.getMarks() >=5);
//        System.out.println("all Passed : "+All_passed);
//        student minsv =list.stream().reduce(list.get(0),(min,sv) ->sv.getMarks() < min.getMarks() ? sv:min);
//        System.out.println("min_sv : "+minsv.getFullname());
//    }
//
//    @FunctionalInterface
//    interface Demo4Inter {
//        void m1(int x);
//
//        default void m2() {
//        }
//
//        public static void m3() {
//        }
//    }
//}
