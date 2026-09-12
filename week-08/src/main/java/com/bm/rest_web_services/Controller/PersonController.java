package com.bm.rest_web_services.Controller;

import com.bm.rest_web_services.DTO.Name;
import com.bm.rest_web_services.DTO.PersonV1;
import com.bm.rest_web_services.DTO.PersonV2;
import com.bm.rest_web_services.repository.PersonRepository;
import com.bm.rest_web_services.repository.UserRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController()
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(UserRepository userRepository, PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonV1> personV1() {
        return personRepository.findAll().stream().map(person -> new PersonV1(person.getId(), person.getFirstName() + " " + person.getLastName())).toList();
    }

    public List<PersonV2> personV2() {
        return personRepository.findAll().stream().map(person -> new PersonV2(person.getId(), new Name(person.getFirstName(), person.getLastName()))).toList();
    }
    // Java Manual Versioning

    @GetMapping("/{version}/persons")
    public List<?> personPV(@PathVariable("version") String version) {
        if (version.equals("1"))
            return personV1();
        return personV2();
    }

    @GetMapping(value = "/persons", params = "version")
    public List<?> personQuery(@RequestParam String version) {
        if (version.equals("1"))
            return personV1();
        return personV2();
    }

    @GetMapping(value = "/persons", headers = "X-API-VERSION")
    public List<?> personCH(@RequestHeader("X-API-VERSION") String version) {
        if (version.equals("1"))
            return personV1();
        return personV2();
    }

    @GetMapping(value = "/persons", produces = {
            "application/vnd.bm.api.v1+json",
            "application/vnd.bm.api.v2+json"
    })
    public List<?> personMT(@RequestHeader("Accept") String accept) {
        if (accept.equals("application/vnd.bm.api.v1+json"))
            return personV1();
        return personV2();
    }

    @GetMapping(value = "/{version}/person/{id}", version = "v1")
    public EntityModel<PersonV1> personPVBIV1(@PathVariable Integer id) {
        PersonV1 p = personRepository.findById(id).map((person -> new PersonV1(person.getId(), person.getFirstName() + " " + person.getLastName()))).orElse(null);

        EntityModel<PersonV1> entity = EntityModel.of(p);
        Link allPersonsLink = linkTo(
                methodOn(PersonController.class).personsPVBIV1()
        ).withRel("all-persons");
        Link selfLink = linkTo(
                methodOn(PersonController.class).personPVBIV1(id)
        ).withRel("self");
        entity.add(allPersonsLink, selfLink);
        return entity;
    }


    // Java Built-in Versioning

    @GetMapping(value = "/{version}/persons", version = "v1")
    public List<PersonV1> personsPVBIV1() {
        return personRepository.findAll().stream().map(person -> new PersonV1(person.getId(), person.getFirstName() + " " + person.getLastName())).toList();
    }
//
//    @GetMapping(value = "/{version}/persons", version = "2.0.0")
//    public List<PersonV2> personsPVBIV2() {
//        return personRepository.findAll().stream().map(person -> new PersonV2(person.getId(), new Name(person.getFirstName(), person.getLastName()))).toList();
//    }
//
//    @GetMapping(value = "/persons", version = "1.0.0")
//    public List<PersonV1> personsBIV1() {
//        return personV1();
//    }
//    @GetMapping(value = "/persons", version = "2.0.0")
//    public List<PersonV2> personsBIV2() {
//        return personV2();
//    }
}
