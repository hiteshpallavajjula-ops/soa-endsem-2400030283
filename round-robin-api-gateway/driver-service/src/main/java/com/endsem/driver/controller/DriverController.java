package com.endsem.driver.controller;

import com.endsem.driver.dto.DriverDTO;
import com.endsem.driver.service.DriverService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    private final DriverService service;

    @Value("${server.port}")
    private String port;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping
    public List<DriverDTO> getAllDrivers() {
        return service.getAllDrivers();
    }

    @GetMapping("/{id}")
    public DriverDTO getDriverById(@PathVariable int id) {
        return service.getDriverById(id);
    }

    @PostMapping
    public DriverDTO saveDriver(@RequestBody DriverDTO driverDTO) {
        return service.saveDriver(driverDTO);
    }

    // Shows which Driver Service instance handled the request.
    @GetMapping("/instance")
    public String getInstancePort() {
        return "Driver Service instance responding on port: " + port;
    }
}
