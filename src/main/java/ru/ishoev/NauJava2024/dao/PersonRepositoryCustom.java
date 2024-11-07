package ru.ishoev.NauJava2024.dao;

import ru.ishoev.NauJava2024.entity.Person;

import java.util.List;

public interface PersonRepositoryCustom {
    /**
     * Находит всех людей с заданным именем
     *
     * @param name имя человека
     */
    List<Person> findByName(String name);

    /**
     * Находит всех людей из заданного города
     *
     * @param countryName название города
     */
    List<Person> findByCountryName(String countryName);
}

