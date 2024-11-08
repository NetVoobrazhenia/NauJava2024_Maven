package ru.ishoev.NauJava2024.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.ishoev.NauJava2024.entity.Street;

import java.util.List;

@RepositoryRestResource(path="streets")
public interface StreetRepository extends CrudRepository<Street, Long> {
    /**
     * Находит все улицы относящиеся к заданному городу
     *
     * @param cityName название города
     */
    @Query("FROM Street WHERE city.name = :cityName")
    List<Street> findByCityName(String cityName);
}