package jolaexpress.africa.service;

import jolaexpress.africa.data.dto.request.CustomerRegistrationRequest;
import jolaexpress.africa.data.dto.response.CustomerRegistrationResponse;
import jolaexpress.africa.exception.CustomerAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;

    private CustomerRegistrationRequest request;
    private CustomerRegistrationResponse response;

    @BeforeEach
    void setUp() throws CustomerAlreadyExistException {
        request = CustomerRegistrationRequest
                .builder()
                .email("wiz@email.com")
                .firstName("wiz")
                .lastName("james")
                .phoneNumber("08174697745")
                .password("2222")
                .build();

        response = customerService.register(request);

    }


    @Test
    void registerCustomer() {
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isNotNull();
       // assertThat(response.getId()).isGreaterThan(0);
    }

    @Test
    void getCustomer() {
        assertThat(request).isNotNull();
        log.info(" registered customer email -> {}", request.getEmail());
       assertEquals("wiz@email.com", request.getEmail());

        ;
    }

    @Test
    void updateProfile() {
        request.setFirstName("james");
        assertThat(request.getFirstName()).isEqualTo("james");
    }



    @Test
    void deleteCustomer() {
        customerService.deleteCustomer(1L);
      assertThat(customerService.getAllCustomers().isEmpty());
      log.info("customer removed successfully");

    }
}