package com.attornatus.techtest.repository;

import com.attornatus.techtest.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
