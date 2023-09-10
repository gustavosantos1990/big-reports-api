package org.gdas.bigreportsapi.service;

import org.gdas.bigreportsapi.model.entity.Employee;
import org.gdas.bigreportsapi.model.json.EmployeeJSON;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.stream.IntStream;

@Service
public class MockService {

    @Value("${data.maker.base.path}")
    private String dataMakerBasePath;

    private final RestTemplate restTemplate;
    private final EmployeeService employeeService;

    public MockService(RestTemplate restTemplate, EmployeeService employeeService) {
        this.restTemplate = restTemplate;
        this.employeeService = employeeService;
    }

    public void saveN(int amount) {
        String url = mountURL();
        IntStream.rangeClosed(1, amount)
                .parallel()
                .forEach(n -> {
                    EmployeeJSON mock = restTemplate.getForObject(url, EmployeeJSON.class);
                    Employee newEmployee = new Employee();
                    BeanUtils.copyProperties(mock, newEmployee);
                    employeeService.save(newEmployee);
                });
    }

    private String mountURL() {
        return UriComponentsBuilder.fromHttpUrl(dataMakerBasePath)
                .pathSegment("v1", "mock")
                .toUriString();
    }

}
