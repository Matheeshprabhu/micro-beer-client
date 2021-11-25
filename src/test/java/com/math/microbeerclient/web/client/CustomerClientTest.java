package com.math.microbeerclient.web.client;

import com.math.microbeerclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerById() {
        CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
        System.out.println(customerDto);
    }

    @Test
    void saveNewCustomer() {

        CustomerDto customerDto = CustomerDto.builder().name("Matheesh").id(UUID.randomUUID()).build();
        URI uri = customerClient.saveNewCustomer(customerDto);

        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void updateCustomer() {

        CustomerDto customerDto = CustomerDto.builder().name("Math").build();
        customerClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {

        customerClient.deleteCustomer(UUID.randomUUID());
    }
}