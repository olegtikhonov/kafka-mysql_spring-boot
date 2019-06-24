package com.intuit.home.controller;

import com.intuit.home.money.Moneta;
import com.intuit.home.request.PaymentRequest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static com.intuit.home.TestConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@TestPropertySource("classpath:test.properties")
public class PaymentServiceControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }


    @Test
    public void getPaymentMethodByUserID() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(String.format(GET_PAYMENT_METHODS, UUID.randomUUID().toString())).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.toLowerCase().contains("[]"));
    }

    @Test
    public void makePayment() throws Exception {
        PaymentRequest paymentRequest = createPaymentRequest();

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(MAKE_PAYMENT).content(mapToJson(paymentRequest)).contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.ACCEPTED.value(), status);
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.toLowerCase().contains("sss"));
    }


    @Test
    public void getPayees() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(GET_PAYEES).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.toLowerCase().contains("[]"));
    }


    /**
     * Creates a {@link PaymentRequest}
     *
     * @return a {@link PaymentRequest}
     */
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
