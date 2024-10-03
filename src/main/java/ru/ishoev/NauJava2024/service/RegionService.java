package ru.ishoev.NauJava2024.service;

import ru.ishoev.NauJava2024.entity.Region;

public interface RegionService {
    Long createRegion(String name, Short phoneCode);

    Region findById(Long id);

    void deleteById(Long id);

    boolean updatePhoneCode(Long id, Short newPhoneCode);
}
