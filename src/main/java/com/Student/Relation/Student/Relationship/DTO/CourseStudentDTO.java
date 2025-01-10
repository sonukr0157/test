package com.Student.Relation.Student.Relationship.DTO;

import java.util.List;

public class CourseStudentDTO {
    private String courseId;
    private String courseName;
    private List<String> studentEnrollmentIds;

    // Constructor
    public CourseStudentDTO(String courseId, String courseName, List<String> studentEnrollmentIds) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.studentEnrollmentIds = studentEnrollmentIds;
    }

    // Getters and Setters
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<String> getStudentEnrollmentIds() {
        return studentEnrollmentIds;
    }

    public void setStudentEnrollmentIds(List<String> studentEnrollmentIds) {
        this.studentEnrollmentIds = studentEnrollmentIds;
    }
}