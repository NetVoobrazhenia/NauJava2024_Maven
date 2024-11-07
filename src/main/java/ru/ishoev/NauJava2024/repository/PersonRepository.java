package ru.ishoev.NauJava2024.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ishoev.NauJava2024.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}