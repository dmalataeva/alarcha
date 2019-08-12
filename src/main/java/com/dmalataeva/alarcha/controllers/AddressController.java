package com.dmalataeva.alarcha.controllers;

import com.dmalataeva.alarcha.models.Address;
import com.dmalataeva.alarcha.repositories.AddressRepository;
import com.dmalataeva.alarcha.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    //private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private AddressService addressService;

    @RequestMapping("/")
    public String defaultAddress() {
        //logger.info("You've hit the default endpoint");
        //logger.debug("This is a debugging message for the default endpoint");
        return "Default address endpoint";
    }

    @RequestMapping(method = RequestMethod.GET)
    public Address getAddress(@RequestParam("id") int id) { return addressService.getAddressById(id); }

    @RequestMapping(method = RequestMethod.PUT)
    public void putAddress(@RequestBody Address address) {
        addressService.saveAddress(address);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Address postAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAddress(@PathVariable int id) {
        addressService.deleteAddressById(id);
    }
}
