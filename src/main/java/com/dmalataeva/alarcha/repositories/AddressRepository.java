package com.dmalataeva.alarcha.repositories;

import com.dmalataeva.alarcha.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
}
