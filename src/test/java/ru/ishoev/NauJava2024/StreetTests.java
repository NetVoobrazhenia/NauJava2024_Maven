package ru.ishoev.NauJava2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.ishoev.NauJava2024.entity.City;
import ru.ishoev.NauJava2024.entity.Street;
import ru.ishoev.NauJava2024.repository.CityRepository;
import ru.ishoev.NauJava2024.repository.StreetRepository;

import java.util.UUID;

@SpringBootTest
class StreetTests {
    private final StreetRepository streetRepository;
    private final CityRepository cityRepository;

    @Autowired
    StreetTests(StreetRepository streetRepository, CityRepository cityRepository) {
        this.streetRepository = streetRepository;
        this.cityRepository = cityRepository;
    }

    /**
     * Тестирование поиска улиц по названию города
     */
    @Test
    void testFindStreetByCityName() {
        var cityName = UUID.randomUUID().toString();
        var city = new City(cityName);
        cityRepository.save(city);

        var streetName = UUID.randomUUID().toString();
        var street = new Street(streetName, city);
        streetRepository.save(street);

        var foundStreet = streetRepository.findByCityName(cityName).getFirst();

        Assertions.assertNotNull(foundStreet);
        Assertions.assertEquals(street.getId(), foundStreet.getId());
        Assertions.assertEquals(streetName, foundStreet.getName());
    }
}