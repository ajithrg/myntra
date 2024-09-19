package com.myntra.ecommerce;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode
public class SuccessResponse {

    private String message;
    private String token;
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;
    private Object data;
}
