package com.attornatus.techtest.controller;

import com.attornatus.techtest.domain.Person;
import com.attornatus.techtest.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> findAllPersons() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable long id) {
        return ResponseEntity.ok(personService.findPersonByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody @Valid Person person) {
        return ResponseEntity.ok(personService.savePerson(person));
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Person person) {
        personService.replacePerson(person);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
