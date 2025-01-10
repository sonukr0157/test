package com.Student.Relation.Student.Relationship.Controller;

import com.Student.Relation.Student.Relationship.DTO.SubjectCourseDTO;
import com.Student.Relation.Student.Relationship.Entity.Subject;
import com.Student.Relation.Student.Relationship.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
dfghjkkl
    @Autowired
    private SubjectService subjectService;

    // Get all subjects
    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    // Get subject by ID
    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
        Optional<Subject> subject = subjectService.getSubjectById(id);
        return subject.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Endpoint to get subject details and all course names for a specific subjectId
    @GetMapping("/{subjectId}/courses")
    public ResponseEntity<SubjectCourseDTO> getSubjectDetailsAndCourses(@PathVariable String subjectId) {
        SubjectCourseDTO subjectCourseDTO = subjectService.getSubjectDetailsAndCourses(subjectId);
        if (subjectCourseDTO != null) {
            return ResponseEntity.ok(subjectCourseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject savedSubject = subjectService.saveSubject(subject);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSubject);
    }


    // Update an existing subject
    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject subjectDetails) {
        Subject updatedSubject = subjectService.updateSubject(id, subjectDetails);
        return updatedSubject != null ? ResponseEntity.ok(updatedSubject) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete a subject
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
