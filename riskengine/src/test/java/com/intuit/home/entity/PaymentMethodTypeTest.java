package com.intuit.home.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentMethodTypeTest {
    public static final Integer PAYMENT_METHOD_TYPE_ID = 12;
    public static final String TYPE = "E_WALLET";
    private PaymentMethodType paymentMethodType;


    @Before
    public void setUp() {
        paymentMethodType = new PaymentMethodType().setPaymentMethodTypeId(PAYMENT_METHOD_TYPE_ID).setType(TYPE);
    }

    @Test
    public void getPaymentMethodTypeId() {
        assertEquals(PAYMENT_METHOD_TYPE_ID, paymentMethodType.getPaymentMethodTypeId());
    }

    @Test
    public void getType() {
        assertEquals(TYPE, paymentMethodType.getType());
    }

    @Test
    public void toString1() {
        assertTrue(paymentMethodType.toString().contains(PaymentMethodType.class.getSimpleName()));
    }
}
