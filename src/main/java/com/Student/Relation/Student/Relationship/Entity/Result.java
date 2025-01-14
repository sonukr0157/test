package com.Student.Relation.Student.Relationship.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "result", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ResultItem> resultItems;


    private Integer totalMaxMarks;

    private Integer totalObtainedMarks;

    private String finalGrade;

    private Double percentage;

    public Result() {
    }

    public Long getId() {
        return id;
    }

    public Result setId(Long id) {
        this.id = id;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public Result setStudent(Student student) {
        this.student = student;
        return this;
    }

    public Course getCourse() {
        return course;
    }

    public Result setCourse(Course course) {
        this.course = course;
        return this;
    }

    public List<ResultItem> getResultItems() {
        return resultItems;
    }

    public Result setResultItems(List<ResultItem> resultItems) {
        this.resultItems = resultItems;
        return this;
    }

    public Integer getTotalMaxMarks() {
        return totalMaxMarks;
    }

    public Result setTotalMaxMarks(Integer totalMaxMarks) {
        this.totalMaxMarks = totalMaxMarks;
        return this;
    }

    public Integer getTotalObtainedMarks() {
        return totalObtainedMarks;
    }

    public Result setTotalObtainedMarks(Integer totalObtainedMarks) {
        this.totalObtainedMarks = totalObtainedMarks;
        return this;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public Result setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
        return this;
    }

    public Double getPercentage() {
        return percentage;
    }

    public Result setPercentage(Double percentage) {
        this.percentage = percentage;
        return this;
    }
}
