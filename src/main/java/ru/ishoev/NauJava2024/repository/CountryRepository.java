package ru.ishoev.NauJava2024.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ishoev.NauJava2024.entity.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
}