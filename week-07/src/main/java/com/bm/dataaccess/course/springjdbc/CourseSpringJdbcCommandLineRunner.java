package com.bm.dataaccess.course.springjdbc;

import com.bm.dataaccess.course.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSpringJdbcCommandLineRunner implements CommandLineRunner {

    private final CourseSpringJdbcRepository courseSpringJdbcRepository;

    public CourseSpringJdbcCommandLineRunner(CourseSpringJdbcRepository courseSpringJdbcRepository) {
        this.courseSpringJdbcRepository = courseSpringJdbcRepository;
    }

    @Override
    public void run(String... args) {
        courseSpringJdbcRepository.insert(new Course(101, "Java Core with JDBC", "Nanna Saeed"));
        courseSpringJdbcRepository.insert(new Course(102, "Spring JDBC", "Mahmoud Samir"));
        courseSpringJdbcRepository.insert(new Course(103, "Spring Boot JDBC", "Hany Badr"));

        System.out.println("===== Spring JDBC: findById =====");
        System.out.println(courseSpringJdbcRepository.findById(101));

        courseSpringJdbcRepository.deleteById(102);

        System.out.println("===== Spring JDBC: findAll after deleting id 102 =====");
        courseSpringJdbcRepository.findAll().forEach(System.out::println);
    }
}
