package com.fps.repos;

import com.fps.entities.Payee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;
import java.util.List;

public interface PayeeRepo extends PagingAndSortingRepository<Payee, BigInteger> {

    Page<Payee> findAllByCustId (BigInteger custId, Pageable pageable);
}
