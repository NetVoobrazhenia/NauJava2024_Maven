package ru.ishoev.NauJava2024.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import ru.ishoev.NauJava2024.entity.Street;
import ru.ishoev.NauJava2024.repository.CityRepository;
import ru.ishoev.NauJava2024.repository.StreetRepository;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final StreetRepository streetRepository;
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, StreetRepository streetRepository,
                           PlatformTransactionManager transactionManager) {
        this.cityRepository = cityRepository;
        this.streetRepository = streetRepository;
        this.transactionManager = transactionManager;
    }

    @Override
    public void deleteCity(String cityName) {
        TransactionStatus status = transactionManager.getTransaction(new
                DefaultTransactionDefinition());
        try {
            List<Street> streets = streetRepository.findByCityName(cityName);
            streetRepository.deleteAll(streets);
            cityRepository.deleteByName(cityName);
            transactionManager.commit(status);
        } catch (DataAccessException ex) {
            transactionManager.rollback(status);
            throw ex;
        }
    }
}
