package com.example.java6.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.security.auth.Subject;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class student2 {
    String name;
    Boolean gender = false;
    Double marks = 0.0;
    Contact contact ;
    List<String> subjects;
}
