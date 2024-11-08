package ru.ishoev.NauJava2024.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.ishoev.NauJava2024.entity.Region;

@RepositoryRestResource(path="regions")
public interface RegionRepository extends CrudRepository<Region, Long> {
}