package ru.ishoev.NauJava2024.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ishoev.NauJava2024.dao.RegionRepository;
import ru.ishoev.NauJava2024.entity.Region;

@Service
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;
    private Long uniqID = 0L;

    @Autowired
    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public Long createRegion(String name, Short phoneCode) {
        regionRepository.create(new Region(uniqID, name, phoneCode));
        return uniqID++;
    }

    @Override
    public Region findById(Long id) {
        return regionRepository.read(id);
    }

    @Override
    public void deleteById(Long id) {
        regionRepository.delete(id);
    }

    @Override
    public boolean updatePhoneCode(Long id, Short newPhoneCode) {
        var region = regionRepository.read(id);
        if (region == null) return false;
        region.setPhoneCode(newPhoneCode);
        regionRepository.update(region);
        return true;
    }
}

