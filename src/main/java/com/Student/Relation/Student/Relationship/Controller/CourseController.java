package com.Student.Relation.Student.Relationship.Controller;


import com.Student.Relation.Student.Relationship.DTO.CourseStudentDTO;
import com.Student.Relation.Student.Relationship.Entity.Course;
import com.Student.Relation.Student.Relationship.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseStudentDTO> getCourseWithStudents(@PathVariable String courseId) {
        CourseStudentDTO courseStudentDTO = courseService.getCourseWithStudentEnrollmentIds(courseId);
        return ResponseEntity.ok(courseStudentDTO);
    }
}