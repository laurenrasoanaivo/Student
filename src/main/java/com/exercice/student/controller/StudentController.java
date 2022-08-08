package com.exercice.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercice.student.modele.Student;
import com.exercice.student.repository.StudentSimpleRepository;

@RestController
public class StudentController {
    @GetMapping("/students")
    public static List<Student> getAllStudent(){
        return StudentSimpleRepository.findAll();
    }
    @GetMapping("/students/{id_student}")
    public static Optional<Student> getAllStudent(@PathVariable(required = true) String id_student){
        return StudentSimpleRepository.findById(id_student);
    }
    @PostMapping("/students")
    public static Student save(@RequestBody(required = true) Student s){
        return StudentSimpleRepository.save(s);
    }
    @DeleteMapping("/students/{id_student}")
    public void deleteById(@PathVariable(required = true) String id_student){
        StudentSimpleRepository.deleteById(id_student);
    }
    @GetMapping("/students/{name}")
    public static List<Student> findWhereNameLike(@PathVariable(required = true) String name){
        return StudentSimpleRepository.findWhereNameLike(name);
    }
}
