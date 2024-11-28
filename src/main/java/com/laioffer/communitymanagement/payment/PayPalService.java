package com.laioffer.communitymanagement.service;

import com.braintreegateway.*;
import com.laioffer.communitymanagement.db.entity.PaymentEntity;
import com.laioffer.communitymanagement.db.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private BraintreeGateway gateway;

    @Autowired
    private PaymentRepository paymentRepository;

    // Process a payment using PayPal API and store it in the database
    public PaymentEntity processPayment(String paymentMethodNonce, BigDecimal amount, Long userId, String description) {
        TransactionRequest request = new TransactionRequest()
                .amount(amount)
                .paymentMethodNonce(paymentMethodNonce)
                .options()
                .submitForSettlement(true)
                .done();

        Result<Transaction> result = gateway.transaction().sale(request);

        PaymentEntity payment;
        if (result.isSuccess()) {
            Transaction transaction = result.getTarget();
            payment = new PaymentEntity(
                    transaction.getId(),
                    userId,
                    Long.valueOf(transaction.getId()),
                    amount.longValue(),
                    transaction.getCurrencyIsoCode(),
                    "SUCCESS",
                    description,
                    Instant.now(),
                    Instant.now()
            );
        } else {
            String errorMessage = result.getMessage();
            payment = new PaymentEntity(
                    null,
                    userId,
                    null,
                    amount.longValue(),
                    "USD",
                    "FAILED",
                    errorMessage,
                    Instant.now(),
                    Instant.now()
            );
        }

        // Save payment to the database
        return paymentRepository.save(payment);
    }

    // Retrieve payment by ID
    public PaymentEntity getPaymentById(String id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + id));
    }

    // Get all payments
    public List<PaymentEntity> getAllPayments() {
        return paymentRepository.findAll();
    }
}
