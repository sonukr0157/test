package com.Student.Relation.Student.Relationship.Service;

import com.Student.Relation.Student.Relationship.Entity.Student;
import com.Student.Relation.Student.Relationship.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        // Check if enrollmentId already exists
        Optional<Student> existingStudent = studentRepository.findByEnrollmentId(student.getEnrollmentId());
        if (existingStudent.isPresent()) {
            throw new IllegalArgumentException("Enrollment ID already exists");
        }

        return studentRepository.save(student); // Save and return the saved student
    }

    public Optional<Student> getStudentByEnrollmentId(String enrollmentId) {
        return studentRepository.findByEnrollmentId(enrollmentId); // Find student by enrollmentId
    }


    // Fetch all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll(); // Retrieve all students
    }

    public List<String> getEnrollmentIdsByCourseId(String courseId) {
        List<Student> students = studentRepository.findByCourse_CourseId(courseId);
        return students.stream()
                .map(Student::getEnrollmentId)
                .toList();
    }
}