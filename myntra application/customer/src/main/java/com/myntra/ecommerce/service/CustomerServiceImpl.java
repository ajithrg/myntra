package com.myntra.ecommerce.service;

import com.myntra.ecommerce.SuccessResponse;
import com.myntra.ecommerce.entity.Customer;
import com.myntra.ecommerce.fraudcheck.FraudCheckClient;
import com.myntra.ecommerce.repository.CustomerRepository;
import com.myntra.ecommerce.request.CustomerRegistrationReqeust;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final RestTemplate restTemplate;
    private final FraudCheckClient fraudCheckClient;

    private final CustomerRepository customerRepository;


    @Override
    public Integer customerRegister(CustomerRegistrationReqeust reqeust) {
    log.info("try");
       String email= reqeust.getEmail();
       String customerId = 1 +"";

      /*  SuccessResponse successResponse = restTemplate.getForObject("http://localhost:8082/api/v1/fraud-check?customer_id=1&email=ds",
                SuccessResponse.class);*/
        SuccessResponse successResponse = fraudCheckClient.checkIfFraudulent(customerId,email);

        log.info("not working");

        if ((Boolean)successResponse.getData()){

            throw new  RuntimeException("Customer is fraud");
        }
        Customer customer = Customer.builder()
                .firstname(reqeust.getFirstname())
                .lastname(reqeust.getLastname())
                .email(reqeust.getEmail())
                .build();
      return customerRepository.save(customer).getCustomerId();


    }
}
