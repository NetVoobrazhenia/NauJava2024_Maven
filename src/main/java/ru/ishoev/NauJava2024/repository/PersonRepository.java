package ru.ishoev.NauJava2024.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.ishoev.NauJava2024.entity.Person;

@RepositoryRestResource(path="persons")
public interface PersonRepository extends CrudRepository<Person, Long> {
}