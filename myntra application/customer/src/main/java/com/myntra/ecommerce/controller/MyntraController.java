package com.myntra.ecommerce.controller;

import com.myntra.ecommerce.SuccessResponse;
import com.myntra.ecommerce.request.CustomerRegistrationReqeust;
import com.myntra.ecommerce.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping(path = "api/v1/customer")
@RestController
@RequiredArgsConstructor
public class MyntraController {


    private final CustomerService customerService;

    @PostMapping(path = "/regCus")
    public SuccessResponse customerRegister (@RequestBody CustomerRegistrationReqeust reqeust){

        Integer id = customerService.customerRegister(reqeust);

        return SuccessResponse.builder()
                .data(id)
                .httpStatus(HttpStatus.CREATED)
                .message("Data Has Been Stored")
                .timestamp(LocalDateTime.now())
                .token("DHABHdbj.fkjwbife.DHWhy.faiuefbiuaehfi")

                .build();
    }

}
