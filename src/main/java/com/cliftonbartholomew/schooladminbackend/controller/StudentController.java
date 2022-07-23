package com.cliftonbartholomew.schooladminbackend.controller;

import java.util.List;

import com.cliftonbartholomew.schooladminbackend.model.Student;
import com.cliftonbartholomew.schooladminbackend.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> readStudents() {
        return studentService.getStudents();
    }

    @RequestMapping(value = "/students/{studentID}", method = RequestMethod.PUT)
    public Student updateStudent(@PathVariable(value = "studentID") long studentID,
            @RequestBody Student studentDetails) {
        return studentService.updateStudent(studentID, studentDetails);
    }

    @RequestMapping(value = "/students/{studentID}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable(value = "studentID") long studentID) {
        studentService.deleteStudent(studentID);
    }
}
