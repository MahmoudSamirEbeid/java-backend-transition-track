package com.in28minutes.jpa_hibernate.course.jpa;

import com.in28minutes.jpa_hibernate.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public List<Course> findAll() {
        return entityManager
                .createQuery("select course from Course course order by course.id", Course.class)
                .getResultList();
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        if (course != null) {
            entityManager.remove(course);
        }
    }
}
