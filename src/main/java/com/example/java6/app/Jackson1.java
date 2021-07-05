package com.example.java6.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Jackson1 {
    public static void main(String[] args) throws Exception {
        demo2();
    }
    private static void demo1() throws Exception{
        String json = "{\r\n"+
                "\"name\":\"Nguyên Văn Tòe\",\r\n\"gender\":true,\r\n" +
                "\"marks\":6.4,\r\n" +
                "\"contact\":{\r\n" +
                "\"email\" : \"nhanlqod0@gmail.com\" ,\r\n " +
                "\"phone\":\"0977429912\"\r\n" +
                "},\r\n" +
                "\"subjects\":[\"WEB205\",\"COM196\"]\r\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode sutdent = mapper.readTree(json);
        System.out.println(">>Name : " +sutdent.get("name").asText());
        System.out.println(">>Marks : " +sutdent.get("marks").asText());
        System.out.println(">>Gender : " +sutdent.get("gender").asBoolean());
        System.out.println(">>Email : " +sutdent.get("contact").get("email").asText());
        System.out.println(">>Phone : " +sutdent.get("contact").get("phone").asText());
        sutdent.get("subjects").iterator().forEachRemaining(subject -> {
            System.out.println(">>Subject : "+subject.asText());
        });
    }
    private static void demo2() throws Exception{
        String json = "E:\\java6\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode sutdent = mapper.readTree(new File(json));
        System.out.println(">>Name : " +sutdent.get("name").asText());
        System.out.println(">>Marks : " +sutdent.get("marks").asText());
        System.out.println(">>Gender : " +sutdent.get("gender").asBoolean());
        System.out.println(">>Email : " +sutdent.get("contact").get("email").asText());
        System.out.println(">>Phone : " +sutdent.get("contact").get("phone").asText());
        sutdent.get("subjects").iterator().forEachRemaining(subject -> {
            System.out.println(">>Subject : "+subject.asText());
        });
    }
}
