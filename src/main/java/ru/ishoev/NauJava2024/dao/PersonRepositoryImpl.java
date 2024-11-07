package ru.ishoev.NauJava2024.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ishoev.NauJava2024.entity.Country;
import ru.ishoev.NauJava2024.entity.Person;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepositoryCustom {
    private final EntityManager entityManager;

    @Autowired
    public PersonRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Person> findByName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> personRoot = criteriaQuery.from(Person.class);
        Predicate namePredicate = criteriaBuilder.equal(personRoot.get("name"), name);
        criteriaQuery.select(personRoot).where(namePredicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Person> findByCountryName(String countryName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> personRoot = criteriaQuery.from(Person.class);
        Join<Person, Country> country = personRoot.join("country", JoinType.INNER);
        Predicate namePredicate = criteriaBuilder.equal(country.get("name"), countryName);
        criteriaQuery.select(personRoot).where(namePredicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}

