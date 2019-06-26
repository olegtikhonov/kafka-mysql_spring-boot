package com.intuit.home.controller;

import com.intuit.home.common.RequestConverter;
import com.intuit.home.money.Moneta;
import com.intuit.home.request.PaymentRequest;
import com.intuit.home.service.NaiveRiskAnalysis;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.Assert.*;

public class PaymentRequestListenerTest {
    public static final String MESSAGE = "My story is a lot like yours, only more interesting ‘cause it involves robots.";
    @InjectMocks PaymentRequestListener paymentRequestListener;
    @Mock NaiveRiskAnalysis riskAnalysis;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listen() {
        // case not a PaymentRequest
        paymentRequestListener.listen(MESSAGE);
        assertTrue(true);
        // case a PaymentRequest
        paymentRequestListener.listen(RequestConverter.toString(createPaymentRequest()));
        assertTrue(true);
    }

    private PaymentRequest createPaymentRequest() {
        return new PaymentRequest().setPaymentMethodId(UUID.randomUUID()).
                                    setAmount(12.45d).
                                    setCurrency(Moneta.HKD).
                                    setPayeeId(UUID.randomUUID()).
                                    setUserId(UUID.randomUUID());
    }
}
