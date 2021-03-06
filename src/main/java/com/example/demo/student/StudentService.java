package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public void postStudent(Student student){
        System.out.println(new Student());
        System.out.println(student);
    }

    public void addNewStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.getStudentByEmail(student.getEmail());
        if(optionalStudent.isPresent())
            throw new IllegalStateException("Student already present");
        studentRepository.save(student);
    }
}
