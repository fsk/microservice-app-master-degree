package com.fsk.orderservice.controllers;

import com.fsk.orderservice.common.Payment;
import com.fsk.orderservice.common.TransactionRequest;
import com.fsk.orderservice.common.TransactionResponse;
import com.fsk.orderservice.entities.Order;
import com.fsk.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {

        return orderService.saveOrder(request);
    }
}
