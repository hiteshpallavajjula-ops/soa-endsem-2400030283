package com.endsem.driver.service;

import com.endsem.driver.dto.DriverDTO;
import java.util.List;

public interface DriverService {
    List<DriverDTO> getAllDrivers();
    DriverDTO getDriverById(int id);
    DriverDTO saveDriver(DriverDTO driverDTO);
}
