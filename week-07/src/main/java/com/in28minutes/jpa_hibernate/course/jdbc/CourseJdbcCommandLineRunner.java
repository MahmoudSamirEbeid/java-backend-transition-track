package com.in28minutes.jpa_hibernate.course.jdbc;

import com.in28minutes.jpa_hibernate.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    private final CourseJdbcRepository courseJdbcRepository;

    public CourseJdbcCommandLineRunner(CourseJdbcRepository courseJdbcRepository) {
        this.courseJdbcRepository = courseJdbcRepository;
    }

    @Override
    public void run(String... args) {
        courseJdbcRepository.insert(new Course(101, "Java Core with JDBC", "Nanna Saeed"));
        courseJdbcRepository.insert(new Course(102, "Spring JDBC", "Mahmoud Samir"));
        courseJdbcRepository.insert(new Course(103, "Spring Boot JDBC", "Hany Badr"));

        System.out.println("===== Spring JDBC: findById =====");
        System.out.println(courseJdbcRepository.findById(101));

        courseJdbcRepository.deleteById(102);

        System.out.println("===== Spring JDBC: findAll after deleting id 102 =====");
        courseJdbcRepository.findAll().forEach(System.out::println);
    }
}
