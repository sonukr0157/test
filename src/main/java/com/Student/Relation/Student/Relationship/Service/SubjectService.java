package com.Student.Relation.Student.Relationship.Service;

import com.Student.Relation.Student.Relationship.DTO.SubjectCourseDTO;
import com.Student.Relation.Student.Relationship.Entity.Course;
import com.Student.Relation.Student.Relationship.Entity.Subject;
import com.Student.Relation.Student.Relationship.Repository.CourseRepository;
import com.Student.Relation.Student.Relationship.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;


    @Autowired
    private CourseRepository courseRepository;


    // Get all subjects
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    // Get subject by id
    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    // Save a new subject with associated courses
    public Subject saveSubject(Subject subject) {
        // Ensure that each course is fetched from the database by its id
        if (subject.getCourses() != null) {
            Set<Course> courses = new HashSet<>();
            for (Course course : subject.getCourses()) {
                if (course.getId() != null) {
                    Optional<Course> courseFromDb = courseRepository.findById(course.getId());
                    if (courseFromDb.isPresent()) {
                        courses.add(courseFromDb.get());
                    } else {
                        throw new RuntimeException("Course with id " + course.getId() + " not found");
                    }
                }
            }
            subject.setCourses(courses);
        }
        // Save the subject and its associated courses
        return subjectRepository.save(subject);
    }


    // Method to get all course names for a given subjectId
    public List<String> getCourseNamesBySubjectId(String subjectId) {
        Optional<Subject> subject = subjectRepository.findBySubjectId(subjectId);
        if (subject.isPresent()) {
            // Return the list of course names associated with the subject
            return subject.get().getCourses().stream()
                    .map(Course::getCourseName)
                    .collect(Collectors.toList());
        }
        return null;  // Return null or empty list if no subject is found
    }



    // Update an existing subject
    public Subject updateSubject(Long id, Subject subjectDetails) {
        Optional<Subject> subject = subjectRepository.findById(id);
        if (subject.isPresent()) {
            Subject existingSubject = subject.get();
            existingSubject.setSubjectName(subjectDetails.getSubjectName());
            existingSubject.setSubjectId(subjectDetails.getSubjectId());
            return subjectRepository.save(existingSubject);
        }
        return null;
    }

    // Method to get subject details and course names by subjectId
    public SubjectCourseDTO getSubjectDetailsAndCourses(String subjectId) {
        Optional<Subject> subject = subjectRepository.findBySubjectId(subjectId);
        if (subject.isPresent()) {
            // Get the subject and associated course names
            Subject subjectData = subject.get();
            List<String> courseNames = subjectData.getCourses().stream()
                    .map(course -> course.getCourseName())
                    .collect(Collectors.toList());

            // Return the data in the SubjectCourseDTO format
            return new SubjectCourseDTO(subjectData.getSubjectId(), subjectData.getSubjectName(), courseNames);
        }
        return null;  // Return null if subject is not found
    }

    // Delete a subject by id
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
