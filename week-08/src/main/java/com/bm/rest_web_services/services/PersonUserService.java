package com.bm.rest_web_services.services;

import com.bm.rest_web_services.dto.Name;
import com.bm.rest_web_services.dto.PersonV1;
import com.bm.rest_web_services.dto.PersonV2;
import com.bm.rest_web_services.repository.PersonRepository;
import com.bm.rest_web_services.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonUserService {
    private final PersonRepository personRepository;

    public PersonUserService(UserRepository userRepository, PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<PersonV1> personListV1() {
        return personRepository.findAll().stream().map(person -> new PersonV1(person.getId(), person.getFirstName() + " " + person.getLastName())).toList();
    }
    public PersonV1 personV1(int id) {
        return personRepository.findById(id).map((person -> new PersonV1(person.getId(), person.getFirstName() + " " + person.getLastName()))).orElse(null);
    }

    public List<PersonV2> personListV2() {
        return personRepository.findAll().stream().map(person -> new PersonV2(person.getId(), new Name(person.getFirstName(), person.getLastName()))).toList();
    }
}
