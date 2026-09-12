package com.bm.rest_web_services.repository;

import com.bm.rest_web_services.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
