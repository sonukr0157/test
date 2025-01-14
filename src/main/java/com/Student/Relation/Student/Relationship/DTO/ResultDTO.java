package com.Student.Relation.Student.Relationship.DTO;

import java.util.List;

public class ResultDTO {
    private Long id;
    private String studentId; // Enrollment ID
    private String courseId;
    private Integer totalMaxMarks;
    private Integer totalObtainedMarks;
    private String finalGrade;
    private Double percentage;
    private List<ResultItemDTO> resultItems;

    public ResultDTO() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getTotalMaxMarks() {
        return totalMaxMarks;
    }

    public void setTotalMaxMarks(Integer totalMaxMarks) {
        this.totalMaxMarks = totalMaxMarks;
    }

    public Integer getTotalObtainedMarks() {
        return totalObtainedMarks;
    }

    public void setTotalObtainedMarks(Integer totalObtainedMarks) {
        this.totalObtainedMarks = totalObtainedMarks;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public List<ResultItemDTO> getResultItems() {
        return resultItems;
    }

    public void setResultItems(List<ResultItemDTO> resultItems) {
        this.resultItems = resultItems;
    }
}
