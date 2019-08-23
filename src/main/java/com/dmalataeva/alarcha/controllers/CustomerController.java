package com.dmalataeva.alarcha.controllers;

import com.dmalataeva.alarcha.models.Customer;
import com.dmalataeva.alarcha.repositories.CustomerRepository;
import com.dmalataeva.alarcha.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    //private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    public String defaultCustomer() {
        //logger.info("You've hit the default endpoint");
        //logger.debug("This is a debugging message for the default endpoint");
        return "Default customer endpoint";
    }

    @RequestMapping(method = RequestMethod.GET)
    public Customer getCustomer(@RequestParam("id") int id) throws Exception {
        return customerService.getCustomerById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void putCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomerById(id);
    }
}
