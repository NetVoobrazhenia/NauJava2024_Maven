package ru.ishoev.NauJava2024.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ishoev.NauJava2024.entity.Region;

import java.util.List;

@Component
public class RegionRepository implements CrudRepository<Region, Long> {
    private final List<Region> regionContainer;

    @Autowired
    public RegionRepository(List<Region> regionContainer) {
        this.regionContainer = regionContainer;
    }

    @Override
    public void create(Region region) {
        regionContainer.add(region);
    }

    @Override
    public Region read(Long id) {
        return regionContainer.stream()
                .filter(r -> id.equals(r.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Region region) {
        var foundRegion = regionContainer.stream().filter(r -> region.getId().equals(r.getId())).findFirst()
                .orElse(null);
        var regionIdx = regionContainer.indexOf(foundRegion);
        regionContainer.set(regionIdx, region);
    }

    @Override
    public void delete(Long id) {
        regionContainer.removeIf(r -> id.equals(r.getId()));
    }
}
