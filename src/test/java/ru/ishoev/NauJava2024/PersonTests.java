package ru.ishoev.NauJava2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.ishoev.NauJava2024.dao.PersonRepositoryCustom;
import ru.ishoev.NauJava2024.entity.Country;
import ru.ishoev.NauJava2024.entity.Person;
import ru.ishoev.NauJava2024.repository.CountryRepository;
import ru.ishoev.NauJava2024.repository.PersonRepository;

import java.util.UUID;

@SpringBootTest
public class PersonTests {
    private final PersonRepository personRepository;
    private final PersonRepositoryCustom personRepositoryCustom;
    private final CountryRepository countryRepository;


    @Autowired
    PersonTests(PersonRepository personRepository, PersonRepositoryCustom personRepositoryCustom, CountryRepository countryRepository) {
        this.personRepository = personRepository;
        this.personRepositoryCustom = personRepositoryCustom;
        this.countryRepository = countryRepository;
    }

    /**
     * Тестирование поиск человека по его имени
     */
    @Test
    void testFindPersonByName() {
        var personName = UUID.randomUUID().toString();
        var person = new Person(personName);
        personRepository.save(person);

        var foundPerson = personRepositoryCustom.findByName(personName).getFirst();

        Assertions.assertNotNull(foundPerson);
        Assertions.assertEquals(person.getId(), foundPerson.getId());
        Assertions.assertEquals(personName, foundPerson.getName());
    }

    /**
     * Тестирование поиск человека по названию города
     */
    @Test
    void testFindPersonByCountryName() {
        var countryName = UUID.randomUUID().toString();
        var country = new Country(countryName);
        countryRepository.save(country);

        var personName = UUID.randomUUID().toString();
        var person = new Person(personName);
        person.setCountry(country);
        personRepository.save(person);

        var foundPerson = personRepositoryCustom.findByCountryName(countryName).getFirst();

        Assertions.assertNotNull(foundPerson);
        Assertions.assertEquals(person.getId(), foundPerson.getId());
        Assertions.assertEquals(countryName, foundPerson.getCountry().getName());
    }
}