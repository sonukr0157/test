package com.Student.Relation.Student.Relationship.Entity;

import jakarta.persistence.*;

@Entity
public class ResultItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "result_id", nullable = false)
    private Result result;


    private Integer maxMarks;

    private Integer obtainedMarks;

    private String grade;

    public ResultItem() {
    }

    public Long getId() {
        return id;
    }

    public ResultItem setId(Long id) {
        this.id = id;
        return this;
    }

    public Subject getSubject() {
        return subject;
    }

    public ResultItem setSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public Result getResult() {
        return result;
    }

    public ResultItem setResult(Result result) {
        this.result = result;
        return this;
    }

    public Integer getMaxMarks() {
        return maxMarks;
    }

    public ResultItem setMaxMarks(Integer maxMarks) {
        this.maxMarks = maxMarks;
        return this;
    }

    public Integer getObtainedMarks() {
        return obtainedMarks;
    }

    public ResultItem setObtainedMarks(Integer obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public ResultItem setGrade(String grade) {
        this.grade = grade;
        return this;
    }
}
