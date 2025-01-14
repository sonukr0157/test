package com.Student.Relation.Student.Relationship.Service;

import com.Student.Relation.Student.Relationship.DTO.ResultDTO;
import com.Student.Relation.Student.Relationship.DTO.ResultItemDTO;
import com.Student.Relation.Student.Relationship.Entity.*;
import com.Student.Relation.Student.Relationship.Repository.CourseRepository;
import com.Student.Relation.Student.Relationship.Repository.ResultRepository;
import com.Student.Relation.Student.Relationship.Repository.StudentRepository;
import com.Student.Relation.Student.Relationship.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;


//    public ResultDTO saveResult(ResultDTO resultDTO) {
//        // Fetch the Student entity using enrollmentId
//        Student student = studentRepository.findByEnrollmentId(resultDTO.getStudentId())
//                .orElseThrow(() -> new IllegalArgumentException("Student with enrollment ID " + resultDTO.getStudentId() + " not found"));
//
//        // Fetch the Course entity using courseId
//        Course course = courseRepository.findByCourseId(resultDTO.getCourseId())
//                .orElseThrow(() -> new IllegalArgumentException("Course with ID " + resultDTO.getCourseId() + " not found"));
//
//        // Create a new Result
//        Result result = new Result();
//        result.setStudent(student);
//        result.setCourse(course);
//        result.setTotalMaxMarks(resultDTO.getTotalMaxMarks());
//        result.setTotalObtainedMarks(resultDTO.getTotalObtainedMarks());
//        result.setFinalGrade(resultDTO.getFinalGrade());
//        result.setPercentage(resultDTO.getPercentage());
//
//        // Map ResultItemDTO list to ResultItem entities
//        List<ResultItem> resultItems = resultDTO.getResultItems().stream().map(itemDTO -> {
//            // Fetch the Subject entity using subjectId
//            Subject subject = subjectRepository.findBySubjectId(itemDTO.getSubjectId())
//                    .orElseThrow(() -> new IllegalArgumentException("Subject with ID " + itemDTO.getSubjectId() + " not found"));
//
//            ResultItem item = new ResultItem();
//            item.setSubject(subject);
//            item.setMaxMarks(itemDTO.getMaxMarks());
//            item.setObtainedMarks(itemDTO.getObtainedMarks());
//            item.setGrade(itemDTO.getGrade());
//            item.setResult(result); // Associate ResultItem with the parent Result
//            return item;
//        }).collect(Collectors.toList());
//
//        // Associate ResultItems with the Result
//        result.setResultItems(resultItems);
//
//        // Save and return the Result
//        Result savedResult = resultRepository.save(result);
//        return mapToDTO(savedResult);
//    }


    public ResultDTO saveResult(ResultDTO resultDTO) {
        // Fetch the Student entity using enrollmentId
        Student student = studentRepository.findByEnrollmentId(resultDTO.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Student with enrollment ID " + resultDTO.getStudentId() + " not found"));

        // Fetch the Course entity using courseId
        Course course = courseRepository.findByCourseId(resultDTO.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Course with ID " + resultDTO.getCourseId() + " not found"));

        // Create a new Result
        Result result = new Result();
        result.setStudent(student);
        result.setCourse(course);
        result.setTotalMaxMarks(resultDTO.getTotalMaxMarks());
        result.setTotalObtainedMarks(resultDTO.getTotalObtainedMarks());
        result.setFinalGrade(resultDTO.getFinalGrade());
        result.setPercentage(resultDTO.getPercentage());

        // Map ResultItemDTO list to ResultItem entities
        List<ResultItem> resultItems = resultDTO.getResultItems().stream().map(itemDTO -> {
            // Fetch the Subject entity using subjectId
            Subject subject = subjectRepository.findBySubjectId(itemDTO.getSubjectId())
                    .orElseThrow(() -> new IllegalArgumentException("Subject with ID " + itemDTO.getSubjectId() + " not found"));

            ResultItem item = new ResultItem();
            item.setSubject(subject);
            item.setMaxMarks(itemDTO.getMaxMarks());
            item.setObtainedMarks(itemDTO.getObtainedMarks());
            item.setGrade(itemDTO.getGrade());
            item.setResult(result); // Associate ResultItem with the parent Result
            return item;
        }).collect(Collectors.toList());


        // Associate ResultItems with the Result
        result.setResultItems(resultItems);

        // Save and return the Result
        Result savedResult = resultRepository.save(result);
        return mapToDTO(savedResult);
    }








    // Retrieve all Results
    public List<ResultDTO> getAllResults() {
        return resultRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<ResultDTO> getResultsByStudentEnrollmentId(String enrollmentId) {
        // Fetch the Student using enrollmentId
        Student student = studentRepository.findByEnrollmentId(enrollmentId)
                .orElseThrow(() -> new IllegalArgumentException("Student with enrollment ID " + enrollmentId + " not found"));

        // Fetch Results associated with the student
        List<Result> results = resultRepository.findByStudent(student);

        // Map the Results to DTOs and return
        return results.stream().map(this::mapToDTO).collect(Collectors.toList());
    }


    public List<ResultDTO> getResultsByCourseId(String courseId) {
        // Fetch the Course using courseId
        Course course = courseRepository.findByCourseId(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course with ID " + courseId + " not found"));

        // Fetch Results associated with the course
        List<Result> results = resultRepository.findByCourse(course);

        // Map the Results to DTOs and return
        return results.stream().map(this::mapToDTO).collect(Collectors.toList());
    }



    // Helper Method: Map Result Entity to DTO
    private ResultDTO mapToDTO(Result result) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setId(result.getId());
        resultDTO.setStudentId(result.getStudent().getEnrollmentId()); // Retrieve student ID as string
        resultDTO.setCourseId(result.getCourse().getCourseId());       // Retrieve course ID as string
        resultDTO.setTotalMaxMarks(result.getTotalMaxMarks());
        resultDTO.setTotalObtainedMarks(result.getTotalObtainedMarks());
        resultDTO.setFinalGrade(result.getFinalGrade());
        resultDTO.setPercentage(result.getPercentage());

        // Map ResultItems to ResultItemDTO
        List<ResultItemDTO> resultItems = result.getResultItems().stream().map(item -> {
            ResultItemDTO itemDTO = new ResultItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setSubjectId(item.getSubject().getSubjectId()); // Retrieve subject ID as string
            itemDTO.setMaxMarks(item.getMaxMarks());
            itemDTO.setObtainedMarks(item.getObtainedMarks());
            itemDTO.setGrade(item.getGrade());
            return itemDTO;
        }).collect(Collectors.toList());

        resultDTO.setResultItems(resultItems);
        return resultDTO;
    }
}
