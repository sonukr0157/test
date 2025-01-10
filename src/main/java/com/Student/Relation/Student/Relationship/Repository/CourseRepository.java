package com.Student.Relation.Student.Relationship.Repository;


import com.Student.Relation.Student.Relationship.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c FROM Course c JOIN FETCH c.students WHERE c.courseId = :courseId")
    Course findCourseWithStudentsByCourseId(String courseId);
}