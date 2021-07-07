package com.example.java6.DAO;

import com.example.java6.MAP.StudentMap;
import com.example.java6.modal.Student;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class StudentDAO {
    RestTemplate rest = new RestTemplate();
    String url = "https://java6-b97f0-default-rtdb.firebaseio.com/students.json";

    private String getUrl(String key) {
        return url.replace(".json", "/" + key + ".json");
    }

    public StudentMap findAll() {
        return rest.getForObject(url, StudentMap.class);
    }

    public Student findByKey(String key) {
        return rest.getForObject(getUrl(key), Student.class);
    }

    public String create(Student data) {
        HttpEntity<Student> entity = new HttpEntity<>(data);
        JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
        return resp.get("name").asText();
    }

    public Student update(String key, Student data) {
        HttpEntity<Student> entity = new HttpEntity<>(data);
        rest.put(getUrl(key), entity);
        return data;
    }
    public void delete(String key){
        rest.delete(getUrl(key));
    }
}
