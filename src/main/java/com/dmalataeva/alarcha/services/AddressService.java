package com.dmalataeva.alarcha.services;

import com.dmalataeva.alarcha.entities.AddressEntity;
import com.dmalataeva.alarcha.models.Address;
import com.dmalataeva.alarcha.repositories.AddressRepository;
import com.dmalataeva.alarcha.util.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address getAddressById(int addressId) throws Exception {
        return new Address(addressRepository.findById(addressId).orElseThrow(RecordNotFoundException::new));
    }

    public Address saveAddress(Address address) {
        AddressEntity saveResult = addressRepository.save(address.convertToEntity());
        return new Address(saveResult);
    }

    public void deleteAddressById(int addressId) {
        addressRepository.deleteById(addressId);
    }
}
