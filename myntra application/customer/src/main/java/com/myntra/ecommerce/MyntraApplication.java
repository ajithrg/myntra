package com.myntra.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(
        basePackages ={"com.myntra.ecommerce.fraudcheck"}
)
@EnableEurekaClient
@SpringBootApplication
public class MyntraApplication {
    public static void main(String[] args) {

        SpringApplication.run(MyntraApplication.class,args);
    }
}
