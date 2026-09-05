package com.bm.jpa_hibernate.course.jpa;

import com.bm.jpa_hibernate.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {

    private final CourseJpaRepository courseJpaRepository;

    public CourseJpaCommandLineRunner(CourseJpaRepository courseJpaRepository) {
        this.courseJpaRepository = courseJpaRepository;
    }

    @Override
    public void run(String... args) {
        courseJpaRepository.insert(new Course(201, "JPA with EntityManager", "Mahmoud Samir"));
        courseJpaRepository.insert(new Course(202, "JPQL Basics", "Mahmoud Samir"));

        System.out.println("===== JPA EntityManager: findById =====");
        System.out.println(courseJpaRepository.findById(201));

        courseJpaRepository.deleteById(202);

        System.out.println("===== JPA EntityManager: findAll after deleting id 202 =====");
        courseJpaRepository.findAll().forEach(System.out::println);
    }
}
