package ru.ishoev.NauJava2024.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.ishoev.NauJava2024.entity.Region;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ContainerConfig {
    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public List<Region> reginContainer() {
        return new ArrayList<>();
    }
}

