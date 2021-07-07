package com.example.java6.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Students")
public class Student {
    @Id
    String email;
    String fullname;
    String country;
    Boolean gender;
    Double marks;
}
