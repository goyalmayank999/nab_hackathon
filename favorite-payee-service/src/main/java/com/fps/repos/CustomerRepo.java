package com.fps.repos;

import com.fps.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,BigInteger> {

    Optional<Customer> findByCustId (BigInteger custId);
}
