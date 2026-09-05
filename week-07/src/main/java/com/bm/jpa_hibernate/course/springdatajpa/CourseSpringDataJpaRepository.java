package com.bm.jpa_hibernate.course.springdatajpa;

import com.bm.jpa_hibernate.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);
    List<Course> findByNameContaining(String name);
    Course findByAuthor(String author);
    List<Course> findAllByAuthor(String author);
}
