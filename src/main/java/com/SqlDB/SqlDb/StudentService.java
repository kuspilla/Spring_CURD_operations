package com.SqlDB.SqlDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void add_student(Student student) {
        studentRepository.save(student);
    }

    public Student getById(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent() == false) {
            return null;
        }
        Student student = optionalStudent.get();
        return student;
    }

    public void update_name(Integer id, String name) throws Exception {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent() == false)
            throw new Exception("student not found");

        Student student = optionalStudent.get();
        student.setName(name);
        studentRepository.save(student);
    }
    public void delete(Integer id) throws Exception{
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent() == false) {
            throw new Exception("student not found");
        }
        studentRepository.deleteById(id);

    }
}

