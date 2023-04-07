package com.attornatus.techtest.service;

import com.attornatus.techtest.domain.Person;
import com.attornatus.techtest.exception.BadRequestException;
import com.attornatus.techtest.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findPersonByIdOrThrowBadRequestException(long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Person not found"));
    }

    @Transactional
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void replacePerson(Person person) {
        Person savedPerson = findPersonByIdOrThrowBadRequestException(person.getId());
        person.setId(savedPerson.getId());
        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
