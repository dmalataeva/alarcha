package com.dmalataeva.alarcha.services;

import com.dmalataeva.alarcha.entities.ShippingEntity;
import com.dmalataeva.alarcha.models.Shipping;
import com.dmalataeva.alarcha.repositories.ShippingRepository;
import com.dmalataeva.alarcha.util.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    @Autowired
    private ShippingRepository shippingRepository;

    public Shipping getShippingById(int shippingId) throws Exception {
        return new Shipping(shippingRepository.findById(shippingId).orElseThrow(RecordNotFoundException::new));
    }

    public Shipping saveShipping(Shipping shipping) {
        ShippingEntity saveResult = shippingRepository.save(shipping.convertToEntity());
        return new Shipping(saveResult);
    }
}
