package com.fps.services;

import com.fps.dto.FavouritePayeeDto;
import com.fps.dto.ResponseDto;
import com.fps.exception.PayeeException;

import java.math.BigInteger;
import java.util.List;

public interface PayeeService {

   ResponseDto getListOfFavouritePayee (BigInteger custId, Integer pageNo) throws PayeeException;
}
