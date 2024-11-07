package ru.ishoev.NauJava2024.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ishoev.NauJava2024.entity.Region;

public interface RegionRepository extends CrudRepository<Region, Long> {
}