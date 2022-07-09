package com.fps.services;

import com.fps.dto.FavouritePayeeDto;
import com.fps.dto.ResponseDto;
import com.fps.entities.Customer;
import com.fps.entities.Payee;
import com.fps.exception.PayeeException;
import com.fps.repos.CustomerRepo;
import com.fps.repos.PayeeRepo;
import com.fps.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.fps.constants.Constants.*;
import static com.fps.utils.Validator.isNull;

@Service
public class PayeeServiceImpl implements PayeeService{

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private PayeeRepo payeeRepo;

    @Override
    public ResponseDto getListOfFavouritePayee(BigInteger custId, Integer pageNo) throws PayeeException {
        Optional<Customer> customerOptional =customerRepo.findByCustId(custId);

        isNull(customerOptional,CUSTOMER_NOT_FOUND,CUSTOMER_NOT_FOUND);
        Pageable paging = PageRequest.of(pageNo, 5, Sort.by("lastModifiedDt").ascending());

        Page<Payee> payees =  payeeRepo.findAllByCustId(custId,paging);
        List<FavouritePayeeDto> favouritePayeeDtoList = payees.get().map(payee -> new FavouritePayeeDto(payee.getPayeeName(), payee.getIban(), payee.getBankName())).collect(Collectors.toList());
      //  isNull(favouritePayeeDtoList,"NO_DATA_FOUND","NO DATA FOUND FOR CUSTOMER ID : "+custId+ " AND PAGE NO: "+pageNo);
        return new ResponseDto(STATUS_SUCCESS,SUCCESS_CODE,"Data Fetched Succefully",favouritePayeeDtoList,null);
    }
}
