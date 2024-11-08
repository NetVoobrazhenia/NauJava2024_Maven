package ru.ishoev.NauJava2024.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.ishoev.NauJava2024.entity.PhoneFormat;

@RepositoryRestResource(path="phoneFormats")
public interface PhoneFormatRepository extends CrudRepository<PhoneFormat, Long> {
}