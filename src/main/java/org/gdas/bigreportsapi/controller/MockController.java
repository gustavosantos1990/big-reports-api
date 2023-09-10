package org.gdas.bigreportsapi.controller;

import org.gdas.bigreportsapi.service.MockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/mock")
public class MockController {

    private final MockService mockService;

    public MockController(MockService mockService) {
        this.mockService = mockService;
    }

    @GetMapping("/{amount}")
    public ResponseEntity<Void> get(@PathVariable Integer amount) {
        mockService.saveN(amount);
        return ResponseEntity.noContent().build();
    }

}
