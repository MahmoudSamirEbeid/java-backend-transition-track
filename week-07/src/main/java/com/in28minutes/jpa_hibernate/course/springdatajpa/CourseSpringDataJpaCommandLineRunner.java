package com.in28minutes.jpa_hibernate.course.springdatajpa;

import com.in28minutes.jpa_hibernate.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CourseSpringDataJpaCommandLineRunner implements CommandLineRunner {

    private final CourseSpringDataJpaRepository courseSpringDataJpaRepository;

    public CourseSpringDataJpaCommandLineRunner(CourseSpringDataJpaRepository courseSpringDataJpaRepository) {
        this.courseSpringDataJpaRepository = courseSpringDataJpaRepository;
    }

    @Override
    public void run(String... args) {
        List<Course> courses = Arrays.asList(
                new Course(1, "Java Core", "James Gosling"),
                new Course(2, "Spring Boot", "Rod Johnson"),
                new Course(3, "Typescript", "Anders Hejlsberg"),
                new Course(4, "Javascript", "Brendan Eich")
        );

        courseSpringDataJpaRepository.saveAll(courses);
        System.out.println("======================");
        System.out.println(courseSpringDataJpaRepository.findByAuthor("Anders Hejlsberg"));
        System.out.println("======================");
        courseSpringDataJpaRepository.findAll().forEach(System.out::println);
    }
}
