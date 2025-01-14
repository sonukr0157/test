package com.Student.Relation.Student.Relationship.Controller;

import com.Student.Relation.Student.Relationship.DTO.ResultDTO;
import com.Student.Relation.Student.Relationship.Entity.Result;
import com.Student.Relation.Student.Relationship.Repository.ResultRepository;
import com.Student.Relation.Student.Relationship.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping
    public ResultDTO saveResult(@RequestBody ResultDTO resultDTO) {
        return resultService.saveResult(resultDTO);
    }

    @GetMapping
    public List<ResultDTO> getAllResults() {
        return resultService.getAllResults();
    }

    @GetMapping("/student/{enrollmentId}")
    public List<ResultDTO> getResultsByStudentId(@PathVariable String enrollmentId) {
        return resultService.getResultsByStudentEnrollmentId(enrollmentId);
    }
}
