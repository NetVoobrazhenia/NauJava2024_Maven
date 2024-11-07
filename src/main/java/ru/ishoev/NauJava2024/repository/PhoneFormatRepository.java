package ru.ishoev.NauJava2024.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ishoev.NauJava2024.entity.PhoneFormat;

public interface PhoneFormatRepository extends CrudRepository<PhoneFormat, Long> {
}