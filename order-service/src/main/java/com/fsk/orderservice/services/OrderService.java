package com.fsk.orderservice.services;

import com.fsk.orderservice.common.Payment;
import com.fsk.orderservice.common.TransactionRequest;
import com.fsk.orderservice.common.TransactionResponse;
import com.fsk.orderservice.entities.Order;
import com.fsk.orderservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request) {
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call
        Payment paymentResponse = restTemplate.postForObject("http://payment-service/payment/doPayment", payment, Payment.class);

        response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successfull and order placed" : "There is a failure in payment api," +
                "order added to card";
        orderRepository.save(order);
        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }
}
