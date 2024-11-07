package ru.ishoev.NauJava2024.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ishoev.NauJava2024.entity.PhoneNumber;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Long> {
}