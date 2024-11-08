package ru.ishoev.NauJava2024.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.ishoev.NauJava2024.entity.City;

import java.util.List;

@RepositoryRestResource(path="cities")
public interface CityRepository extends CrudRepository<City, Long> {
    /**
     * Находит все города с заданным названием
     *
     * @param name названием города
     */
    List<City> findByName(String name);

    /**
     * Удаляет город с заданным названием
     *
     * @param name название города
     */
    void deleteByName(String name);
}