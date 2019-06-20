package com.intuit.home.entity;

import com.intuit.home.money.Moneta;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurrencyTest {
    private Currency currency;


    @Before
    public void setUp() {
        currency = new Currency().setIsoName(Moneta.AUD.name()).setDescription(Moneta.AUD.to());
    }

    @Test
    public void getIsoName() {
        assertEquals(currency.getIsoName(), Moneta.AUD.name());
    }

    @Test
    public void getDescription() {
        assertEquals(currency.getDescription(), Moneta.AUD.to());
    }

    @Test
    public void toString1() {
        assertTrue(currency.toString().contains(Currency.class.getSimpleName()));
    }
}
