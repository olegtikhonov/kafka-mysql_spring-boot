package com.intuit.home.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class PayeeTest {
    public static final String LAST_NAME = "Griffin";
    private static final String FIRST_NAME = "Stewie";
    public static final String EMAIL = "Stewie.Griffin@mail.com";
    private Payee payee;

    @Before
    public void setUp() {

        payee = new Payee().setPayeeId(UUID.randomUUID()).
                            setFirstName(FIRST_NAME).
                            setLastName(LAST_NAME).
                            setEmail(EMAIL);
    }

    @Test
    public void getPayeeId() {
        assertNotNull(payee.getPayeeId());
    }

    @Test
    public void getFirstName() {
        assertEquals(FIRST_NAME, payee.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals(LAST_NAME, payee.getLastName());
    }

    @Test
    public void getEmail() {
        assertEquals(EMAIL, payee.getEmail());
    }
}
