package com.Student.Relation.Student.Relationship.Service;


import com.Student.Relation.Student.Relationship.DTO.CourseStudentDTO;
import com.Student.Relation.Student.Relationship.Entity.Course;
import com.Student.Relation.Student.Relationship.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public CourseStudentDTO getCourseWithStudentEnrollmentIds(String courseId) {
        Course course = courseRepository.findCourseWithStudentsByCourseId(courseId);

        // Map data to DTO
        List<String> enrollmentIds = course.getStudents()
                .stream()
                .map(student -> student.getEnrollmentId())
                .collect(Collectors.toList());

        return new CourseStudentDTO(course.getCourseId(), course.getCourseName(), enrollmentIds);
    }
}