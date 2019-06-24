package com.intuit.home.money;

import org.junit.Test;

import static org.junit.Assert.*;

public class MonetaTest {
    private static final String description = "Swiss franc";

    @Test
    public void to() {
        assertEquals(description, Moneta.CHF.to());
    }
}
