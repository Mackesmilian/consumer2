package com.wolf.consumer2.controller;

import com.wolf.consumer2.entity.Customer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CustomerController {

    private final RestTemplate restTemplate;

    public CustomerController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @RequestMapping("/customerBalance")
    List<Customer> getCustomerIndo() {
        ResponseEntity<List<Customer>> customerResponseEntity = restTemplate.exchange(
                "http://localhost:8080/customers/balance", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Customer>>(){});
        return customerResponseEntity.getBody();
    }
}
