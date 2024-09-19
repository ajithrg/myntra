package com.myntra.ecommerce.fraudcheck;

import com.myntra.ecommerce.SuccessResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        path = "api/v1/fraud-check",
        value = "fraudcheck-application"
)
public interface FraudCheckClient {

    @GetMapping(path = "")
    public SuccessResponse checkIfFraudulent(
            @RequestParam(name = "customer_id") String customerId,
            @RequestParam(name = "email") String email);
}
