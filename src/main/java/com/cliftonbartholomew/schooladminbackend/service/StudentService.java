package com.cliftonbartholomew.schooladminbackend.service;

import java.util.List;

import com.cliftonbartholomew.schooladminbackend.model.Student;
import com.cliftonbartholomew.schooladminbackend.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    // Create
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Read
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    // Update
    public Student updateStudent(long studentID, Student studentDetails) {
        Student s = studentRepository.findById(studentID).get();
        s.setName(studentDetails.getName());
        s.setSurname(studentDetails.getSurname());
        s.setRegisterClassID(studentDetails.getRegisterClassID());

        return studentRepository.save(s);
    }

    // Delete
    public void deleteStudent(long studentID) {
        studentRepository.deleteById(studentID);
    }
}
