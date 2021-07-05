package com.example.java6.app;

import com.example.java6.modal.Contact;
import com.example.java6.modal.student2;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jackson2 {
    public static void main(String[] args) throws Exception {
        demo2();
    }

    private static void demo2() throws Exception {
        String path = "E:\\java6\\src\\main\\resources\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> student = mapper.readValue(new File(path), List.class);
        student.forEach(students -> {
            System.out.println(">>Name " + students.get("name"));
        });
    }

    private static void demo3() throws Exception {
        String path = "E:\\java6\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        student2 student = mapper.readValue(new File(path), student2.class);
        System.out.println(">> Name : " + student.getName());
        System.out.println(">> Marks : " + student.getMarks());
        System.out.println(">> Gender : " + student.getGender());
        Contact contact = student.getContact();
        System.out.println(">>Email : " + contact.getEmail());
        System.out.println(">> Phone " + contact.getPhone());
        List<String> subjects = student.getSubjects();
        subjects.forEach(subject -> {
            System.out.println(">> Subject : " + subject);
        });
    }

    private static void demo4() throws Exception {
        String path = "E:\\java6\\src\\main\\resources\\students.json";
        TypeReference<List<student2>> type = new TypeReference<List<student2>>() {
        };
        ObjectMapper mapper = new ObjectMapper();
        List<student2> students = mapper.readValue(new File(path), type);
        students.forEach(student -> {
            System.out.println(">> Name : " + student.getName());
        });
    }

    private static void demo5() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Nguyen  Teo");
        student.put("marks", 5.2);
        student.put("gender", true);
        ObjectNode contact = mapper.createObjectNode();
        contact.put("email", "teonv@gmail.com");
        ArrayNode subjects = student.putArray("subjects");
        subjects.add("WEB");
        subjects.add("COM");
        String json = mapper.writeValueAsString(student);
        mapper.writeValue(System.out, student);
        mapper.writeValue(new File("E:\\java6\\src\\main\\resources\\student.json"), student);
    }
    private static void demo6() throws Exception{
        Map<String , Object> contact = new HashMap<>();
        contact.put("email" , "tennv@gmail.com");
        contact.put("phone","0977329121");
        List<String> subjects = Arrays.asList("WEB","COM");
        Map<String , Object> student = new HashMap<>();
        student.put("name", "Nguyen Van Teo");
        student.put("marks", 5.2);
        student.put("gender", true);
        student.put("contact",contact);
        student.put("subjects",subjects);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(student);
        System.out.println(json);
        mapper.writeValue(System.out,student);
        mapper.writeValue(new File("E:\\java6\\src\\main\\resources\\students.json"), student);
    }
    public static void demo7()throws Exception{
        Contact contact = new Contact("Nhan@Gmail.com","09230290",null);
        List<String> subjects =Arrays.asList("WWEB","COM");
        student2 student = new student2("Bibi",true,6.4,contact,subjects);
        ObjectMapper  mapper = new ObjectMapper();
        mapper.writeValue(System.out,student);
        mapper.writeValue(new File("E:\\java6\\src\\main\\resources\\students.json"), student);
    }
}

