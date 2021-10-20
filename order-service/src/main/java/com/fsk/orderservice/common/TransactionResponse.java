package com.fsk.orderservice.common;

import com.fsk.orderservice.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private Order order;
    private Long amount;
    private String transactionId;
    private String message;

}
