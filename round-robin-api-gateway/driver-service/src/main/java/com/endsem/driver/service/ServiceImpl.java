package com.endsem.driver.service;

import com.endsem.driver.dto.DriverDTO;
import com.endsem.driver.entity.Driver;
import com.endsem.driver.repository.DriverRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServiceImpl implements DriverService {
    private final DriverRepository repository;

    public ServiceImpl(DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public DriverDTO getDriverById(int id) {
        Driver driver = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Driver not found"));
        return toDTO(driver);
    }

    @Override
    public DriverDTO saveDriver(DriverDTO driverDTO) {
        Driver driver = new Driver(
                driverDTO.getId(),
                driverDTO.getName(),
                driverDTO.getLocation());
        return toDTO(repository.save(driver));
    }

    private DriverDTO toDTO(Driver driver) {
        return new DriverDTO(driver.getId(), driver.getName(), driver.getLocation());
    }
}
