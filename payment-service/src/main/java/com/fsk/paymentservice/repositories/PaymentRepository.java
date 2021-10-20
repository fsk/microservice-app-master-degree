package com.fsk.paymentservice.repositories;

import com.fsk.paymentservice.entities.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PaymentRepository extends MongoRepository<Payment, String> {

    Payment findByOrderId(Long orderId);


}
