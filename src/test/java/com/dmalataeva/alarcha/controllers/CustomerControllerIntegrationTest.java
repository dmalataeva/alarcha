package com.dmalataeva.alarcha.controllers;

import com.dmalataeva.alarcha.entities.CustomerEntity;
import com.dmalataeva.alarcha.models.Customer;
import com.dmalataeva.alarcha.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = com.dmalataeva.alarcha.Alarcha.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase*/
public class CustomerControllerIntegrationTest {

    /*@Autowired
    private MockMvc mvc;

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void whenGetCustomerById_thenReturnCustomer() throws Exception {
        Customer customer = new Customer(1,1,1,"Octocat","octocat@github.com","xyz");

        CustomerEntity res = customerRepository.save(customer.convertToEntity());

        mvc.perform(MockMvcRequestBuilders.get("/customer").param("id", customer.getCustomerId() + "")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerId").value(customer.getCustomerId()));
    }*/
}
