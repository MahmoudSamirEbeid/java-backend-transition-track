package com.bm.dataaccess.course.springdatajpa;

import com.bm.dataaccess.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);
    List<Course> findByNameContaining(String name);
    Course findByAuthor(String author);
    List<Course> findAllByAuthor(String author);
}
