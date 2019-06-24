package com.intuit.home.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurrencyTest {
    public static final String DESCRIPTION = "States bucks";
    public static final String ISO_NAME = "USD";
    private Currency currency;

    @Before
    public void setUp() {
        currency = new Currency().setDescription(DESCRIPTION).setIsoName(ISO_NAME);
    }

    @Test
    public void getIsoName() {
        assertEquals(ISO_NAME, currency.getIsoName());
    }

    @Test
    public void getDescription() {
        assertEquals(DESCRIPTION, currency.getDescription());
    }

    @Test
    public void testToString() {
        assertTrue(currency.toString().contains(Currency.class.getSimpleName()));
    }
}
