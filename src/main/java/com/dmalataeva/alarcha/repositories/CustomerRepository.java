package com.dmalataeva.alarcha.repositories;

import com.dmalataeva.alarcha.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
