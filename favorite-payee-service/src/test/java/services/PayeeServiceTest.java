package services;

import com.fps.dto.ResponseDto;
import com.fps.entities.Customer;
import com.fps.entities.Payee;
import com.fps.exception.PayeeException;
import com.fps.repos.CustomerRepo;
import com.fps.repos.PayeeRepo;
import com.fps.services.PayeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.math.BigInteger;
import java.util.Optional;

import static com.fps.constants.Constants.CUSTOMER_NOT_FOUND;
import static com.fps.constants.Constants.STATUS_FAILURE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PayeeServiceTest {

    @InjectMocks
    @Spy
    private PayeeServiceImpl payeeService;

    @Mock
    private CustomerRepo customerRepo;

    @Mock
    private PayeeRepo payeeRepo;

    @Spy
    private Customer customer;

    @Test
    public void getListOfFavourite() throws PayeeException {
        customer.setCustId(BigInteger.valueOf(1));
        customer.setCustName("MOCK");
        Page<Payee> pages = Mockito.mock(Page.class);
        when(customerRepo.findByCustId(Mockito.any())).thenReturn(Optional.of(customer));
        when(payeeRepo.findAllByCustId(Mockito.any(),Mockito.any())).thenReturn(pages);
        ResponseDto responseDto = payeeService.getListOfFavouritePayee(Mockito.any(),Mockito.anyInt());
        assertEquals("SUCCESS",responseDto.getStatus());
    }

    @Test
    public void customerNotFound() throws PayeeException {
        Page<Payee> pages = Mockito.mock(Page.class);
        when(customerRepo.findByCustId(Mockito.any())).thenReturn(Optional.empty());
        PayeeException payeeException = assertThrows(PayeeException.class, () -> payeeService.getListOfFavouritePayee(Mockito.any(),Mockito.anyInt()));
        assertEquals(CUSTOMER_NOT_FOUND, payeeException.getStatusCode());
    }
}


