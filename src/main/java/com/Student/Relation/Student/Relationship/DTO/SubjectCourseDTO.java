package com.Student.Relation.Student.Relationship.DTO;

import java.util.List;

public class SubjectCourseDTO {
    private String subjectId;
    private String subjectName;
    private List<String> courseNames;

    public SubjectCourseDTO(String subjectId, String subjectName, List<String> courseNames) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.courseNames = courseNames;
    }

    // Getters and Setters

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<String> getCourseNames() {
        return courseNames;
    }

    public void setCourseNames(List<String> courseNames) {
        this.courseNames = courseNames;
    }
}
