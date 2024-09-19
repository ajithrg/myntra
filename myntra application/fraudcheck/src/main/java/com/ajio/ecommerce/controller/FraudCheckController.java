package com.ajio.ecommerce.controller;

import com.ajio.ecommerce.service.FraudCheckService;
import com.myntra.ecommerce.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudCheckController {
    private final FraudCheckService fraudCheckService;


    @GetMapping(path = "")
    public SuccessResponse checkFradulant(@RequestParam(name = "customer_id") String customerId,

                                          @RequestParam(name = "email") String email) {

        Boolean isFraudulant = fraudCheckService.checkIfFraudulent(customerId, email);

        return SuccessResponse
                .builder()
                .message("customer is not fraudualnt")
                .httpStatus(HttpStatus.OK)
                .data(isFraudulant)
                .timestamp(LocalDateTime.now())
                .build();
    }


}
