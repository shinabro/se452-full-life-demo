package edu.depaul.cdm.se452.herokudemoapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se452.herokudemoapp.student.Student;
import edu.depaul.cdm.se452.herokudemoapp.student.StudentRepository;
import edu.depaul.cdm.se452.herokudemoapp.student.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;
    
    @GetMapping("/")
    public List<Student> getAllStudents() {
        List<Student> students = service.findAll();
        return students;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> read(@PathVariable("id") Long id) {
        Optional<Student> foundStudent = service.find(id);
        
        if (foundStudent.isPresent()) {
            System.out.println(foundStudent.get());
            return ResponseEntity.ok(foundStudent.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
