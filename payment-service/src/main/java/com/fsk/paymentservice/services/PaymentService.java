package com.fsk.paymentservice.services;

import com.fsk.paymentservice.entities.Payment;
import com.fsk.paymentservice.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {


    private final PaymentRepository paymentRepository;


    public Payment doPayment(Payment payment) {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentId(UUID.randomUUID().toString());
        return paymentRepository.insert(payment);
    }

    public String paymentProcessing() {
        //3rd payment gateway (paypal)
        return new Random().nextBoolean() ? "success" : "false";
    }

    public Payment findPaymentHistoryByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
