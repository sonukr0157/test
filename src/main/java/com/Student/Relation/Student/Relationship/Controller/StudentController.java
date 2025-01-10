package com.Student.Relation.Student.Relationship.Controller;

import com.Student.Relation.Student.Relationship.Entity.Student;
import com.Student.Relation.Student.Relationship.Repository.StudentRepository;
import com.Student.Relation.Student.Relationship.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            Student savedStudent = studentService.createStudent(student);
            return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Handle error and return a proper response
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Get student by enrollmentId
    @GetMapping("/{enrollmentId}")
    public ResponseEntity<Student> getStudent(@PathVariable String enrollmentId) {
        Optional<Student> student = studentService.getStudentByEnrollmentId(enrollmentId);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<String>> getEnrollmentIdsByCourse(@PathVariable String courseId) {
        List<String> enrollmentIds = studentService.getEnrollmentIdsByCourseId(courseId);
        return ResponseEntity.ok(enrollmentIds);
    }


}