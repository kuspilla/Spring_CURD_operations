package com.SqlDB.SqlDb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping ("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity add_stundet(@RequestBody Student student){
        try{
            studentService.add_student(student);
             return new ResponseEntity(student.getName()+" added successfully", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get")
    public Student getById(@RequestParam("id") Integer id) {
        try{
            Student student = studentService.getById(id);
            return student;
        }catch (Exception e){
            log.error("Student not found");
            return null;
        }

    }
    @PutMapping("/update_name")
    public String update_name(@RequestParam("id") Integer id, @RequestParam("name") String name){
        try{
            studentService.update_name(id, name);
            return "updated successfully";
        }catch (Exception e){
            return e.toString();
        }

    }
    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        try{
            studentService.delete(id);
            return "deleted successfully";
        }catch (Exception e){
            return e.toString();
        }
    }
}
