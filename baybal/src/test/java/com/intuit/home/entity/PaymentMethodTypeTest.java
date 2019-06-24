package com.intuit.home.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentMethodTypeTest {
    public static final String TYPE = "E-WALLET";
    public static final Integer METHOD_TYPE_ID = 11;
    private PaymentMethodType paymentMethodType;

    @Before
    public void setUp() {
        paymentMethodType = new PaymentMethodType().setType(TYPE).
                                                    setPaymentMethodTypeId(METHOD_TYPE_ID);
    }

    @Test
    public void getPaymentMethodTypeId() {
        assertEquals(METHOD_TYPE_ID, paymentMethodType.getPaymentMethodTypeId());
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
