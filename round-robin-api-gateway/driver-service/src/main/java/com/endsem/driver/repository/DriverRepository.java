package com.endsem.driver.repository;

import com.endsem.driver.entity.Driver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DriverRepository {
    private final List<Driver> drivers = new ArrayList<>();

    public DriverRepository() {
        drivers.add(new Driver(1, "hitesh", "vijayawada"));
        drivers.add(new Driver(2, "jsk", "hyderabad"));
        drivers.add(new Driver(3, "ali", "bihar"));
    }

    public List<Driver> findAll() {
        return new ArrayList<>(drivers);
    }

    public Optional<Driver> findById(int id) {
        return drivers.stream().filter(driver -> driver.getId() == id).findFirst();
    }

    public Driver save(Driver driver) {
        drivers.removeIf(existing -> existing.getId() == driver.getId());
        drivers.add(driver);
        return driver;
    }
}
