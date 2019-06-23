package com.intuit.home.service;

import com.intuit.home.common.RequestConverter;
import com.intuit.home.entity.Payment;
import com.intuit.home.repository.PaymentRepository;
import com.intuit.home.request.PaymentRequest;
import com.intuit.home.response.PaymentResponse;
import com.intuit.home.strategy.RiskAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * This risk analysis works as follows:
 * Calculate number of Payment rows mod 7
 * if it != 0, it accepts it, otherwise rejects.
 */
@Service
public class NaiveRiskAnalysis implements RiskAnalysis<PaymentResponse, Optional<PaymentRequest>> {
    @Autowired PaymentRepository paymentRepository;


    @Override
    public PaymentResponse performAnalysys(Optional<PaymentRequest> dataToBEAnalyzed) {
        if(dataToBEAnalyzed.isPresent()) {
            Payment payment = RequestConverter.toPayment(dataToBEAnalyzed.get());
            payment.setSucceeded(true);
            if((paymentRepository.count() % 7) != 0) {
                // accepts the payments
                payment.setSucceeded(true);

            } else {
                payment.setSucceeded(false);
            }

            paymentRepository.save(payment);
         }

        return new PaymentResponse();
    }
}
