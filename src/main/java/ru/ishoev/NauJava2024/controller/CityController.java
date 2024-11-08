package ru.ishoev.NauJava2024.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ishoev.NauJava2024.entity.City;
import ru.ishoev.NauJava2024.repository.CityRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityRepository cityRepository;

    @GetMapping("/findBy/name")
    public List<City> findByName(@RequestParam String name) {
        return cityRepository.findByName(name);
    }
}