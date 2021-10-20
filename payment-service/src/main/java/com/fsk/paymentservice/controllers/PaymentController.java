package com.fsk.paymentservice.controllers;

import com.fsk.paymentservice.entities.Payment;
import com.fsk.paymentservice.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;


    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) {
        return paymentService.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable Long orderId) {
        return paymentService.findPaymentHistoryByOrderId(orderId);
    }


}
