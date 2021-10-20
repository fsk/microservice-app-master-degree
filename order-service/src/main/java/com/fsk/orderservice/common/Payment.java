package com.fsk.orderservice.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private String paymentId;
    private String paymentStatus;
    private String transactionId;
    private Long orderId;
    private Long amount;
}
