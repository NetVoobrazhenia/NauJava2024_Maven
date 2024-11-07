package ru.ishoev.NauJava2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.ishoev.NauJava2024.entity.City;
import ru.ishoev.NauJava2024.entity.Street;
import ru.ishoev.NauJava2024.repository.CityRepository;
import ru.ishoev.NauJava2024.repository.StreetRepository;
import ru.ishoev.NauJava2024.service.CityService;

import java.util.UUID;

@SpringBootTest
class CityTests {
    private final CityService cityService;
    private final StreetRepository streetRepository;
    private final CityRepository cityRepository;

    @Autowired
    CityTests(CityService cityService, StreetRepository streetRepository, CityRepository cityRepository) {
        this.cityService = cityService;
        this.streetRepository = streetRepository;
        this.cityRepository = cityRepository;
    }

    /**
     * Тестирование поиск города по его названию
     */
    @Test
    void testFindCityByName() {
        var cityName = UUID.randomUUID().toString();
        var city = new City(cityName);
        cityRepository.save(city);

        var foundCity = cityRepository.findByName(cityName).getFirst();

        Assertions.assertNotNull(foundCity);
        Assertions.assertEquals(city.getId(), foundCity.getId());
        Assertions.assertEquals(cityName, foundCity.getName());
    }


    /**
     * Тестирование удаления города
     */
    @Test
    void testDeleteCityInTx() {
        var adminCity = new City(UUID.randomUUID().toString());
        cityRepository.save(adminCity);

        var street1 = new Street(UUID.randomUUID().toString(), adminCity);
        streetRepository.save(street1);

        var street2 = new Street(UUID.randomUUID().toString(), adminCity);
        streetRepository.save(street2);

        cityService.deleteCity(adminCity.getName());

        var foundCity = cityRepository.findById(adminCity.getId());
        Assertions.assertTrue(foundCity.isEmpty());

        var foundStreet1 = streetRepository.findById(street1.getId());
        Assertions.assertTrue(foundStreet1.isEmpty());

        var foundStreet2 = streetRepository.findById(street2.getId());
        Assertions.assertTrue(foundStreet2.isEmpty());
    }
}
