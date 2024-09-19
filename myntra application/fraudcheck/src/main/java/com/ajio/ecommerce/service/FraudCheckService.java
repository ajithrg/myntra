package com.ajio.ecommerce.service;

import com.ajio.ecommerce.entity.FraudCheckHistory;
import com.ajio.ecommerce.repository.FraudCheckRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public record FraudCheckService(FraudCheckRepository fraudCheckRepository) {

    public Boolean checkIfFraudulent(String customerId, String email) {
        log.info("checking if the customer is fraudulent");
        fraudCheckRepository.save(FraudCheckHistory.builder()
                        .customerId(Integer.parseInt(customerId))
                        .email(email)
                        .isFraudulent(false)
                        .timestamp(LocalDateTime.now())
                        .build());
        log.info("customer is not fraudulant");
        return false;
    }
}
