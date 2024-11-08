package ru.ishoev.NauJava2024.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ishoev.NauJava2024.repository.CityRepository;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cities/view")
public class CityControllerView {
    private final CityRepository cityRepository;

    @GetMapping("/list")
    public String cityListView(Model model) {
        var cities = cityRepository.findAll();
        model.addAttribute("cities", cities);
        return "cityList";
    }
}
