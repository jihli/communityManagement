package com.laioffer.communitymanagement.payment;

import com.laioffer.communitymanagement.db.entity.PaymentEntity;
import com.laioffer.communitymanagement.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * Process a payment using PayPal API.
     *
     * @param paymentMethodNonce The nonce obtained from the client side.
     * @param amount             The amount for the transaction.
     * @param userId             The user making the payment.
     * @param description        A description of the transaction.
     * @return The saved payment record.
     */
    @PostMapping("/process")
    public ResponseEntity<PaymentEntity> processPayment(
            @RequestParam String paymentMethodNonce,
            @RequestParam BigDecimal amount,
            @RequestParam Long userId,
            @RequestParam String description) {

        PaymentEntity payment = paymentService.processPayment(paymentMethodNonce, amount, userId, description);
        return ResponseEntity.ok(payment);
    }

    /**
     * Retrieve payment details by payment ID.
     *
     * @param id The payment ID.
     * @return The payment record.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentEntity> getPaymentById(@PathVariable String id) {
        PaymentEntity payment = paymentService.getPaymentById(id);
        return ResponseEntity.ok(payment);
    }

    /**
     * Get all payment records.
     *
     * @return A list of all payment records.
     */
    @GetMapping
    public ResponseEntity<List<PaymentEntity>> getAllPayments() {
        List<PaymentEntity> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    /**
     * Retrieve all payments made by a specific user.
     *
     * @param userId The user ID.
     * @return A list of payment records for the user.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PaymentEntity>> getPaymentsByUserId(@PathVariable Long userId) {
        List<PaymentEntity> payments = paymentService.getPaymentsByUserId(userId);
        return ResponseEntity.ok(payments);
    }
}

