package com.intuit.home.common;

import com.intuit.home.entity.Payment;
import com.intuit.home.money.Moneta;
import com.intuit.home.request.PaymentRequest;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class RequestConverterTest {

    @Test
    public void toString1() {
    }

    @Test
    public void fromString() {
    }

    @Test
    public void toPayment() {
        PaymentRequest paymentRequest = createPaymentRequest();
        Payment payment = RequestConverter.toPayment(paymentRequest);
        assertEquals(Integer.valueOf(Moneta.BRL.ordinal() + 1), payment.getCurrencyId());
    }

    private PaymentRequest createPaymentRequest() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount(78.9);
        paymentRequest.setCurrency(Moneta.BRL);
        paymentRequest.setUserId(UUID.randomUUID());
        paymentRequest.setPayeeId(UUID.randomUUID());
        paymentRequest.setPaymentMethodId(UUID.randomUUID());
        return paymentRequest;
    }
}
