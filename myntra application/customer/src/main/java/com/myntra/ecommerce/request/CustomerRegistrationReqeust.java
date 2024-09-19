package com.myntra.ecommerce.request;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

public class CustomerRegistrationReqeust {
    private String firstname;
    private String lastname;
    private String email;
}
