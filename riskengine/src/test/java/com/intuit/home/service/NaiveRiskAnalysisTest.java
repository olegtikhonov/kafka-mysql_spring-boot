package com.intuit.home.service;

import com.intuit.home.repository.PaymentRepository;
import com.intuit.home.request.PaymentRequest;
import com.intuit.home.response.PaymentResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AUTO_CONFIGURED)
public class NaiveRiskAnalysisTest {
    private NaiveRiskAnalysis naiveRiskAnalysis;
    @Mock private PaymentRequest paymentRequest;
    @Autowired PaymentRepository paymentRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        naiveRiskAnalysis = new NaiveRiskAnalysis();
        Field paymentRepositoryFiled = naiveRiskAnalysis.getClass().getDeclaredField("paymentRepository");
        paymentRepositoryFiled.setAccessible(true);
        paymentRepositoryFiled.set(naiveRiskAnalysis, paymentRepository);
    }

    @Test
    public void performAnalysys() {
        PaymentResponse paymentResponse = naiveRiskAnalysis.performAnalysys(Optional.of(paymentRequest));
        assertNotNull(paymentResponse);
    }
}
