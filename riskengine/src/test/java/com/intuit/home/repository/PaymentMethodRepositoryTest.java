package com.intuit.home.repository;

import com.intuit.home.entity.PaymentMethod;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AUTO_CONFIGURED)
public class PaymentMethodRepositoryTest {
    @Autowired private PaymentMethodRepository paymentMethodRepository;

    @Test
    public void findByPayerId() {
        PaymentMethod paymentMethod = createPaymentMethod();
        paymentMethodRepository.save(paymentMethod);
        assertEquals(1, paymentMethodRepository.count());
    }

    private PaymentMethod createPaymentMethod() {
        return new PaymentMethod().setPayerId(UUID.randomUUID()).
                                                              setBankAccount("0123456789012").
                                                              setPaymentMethodId(UUID.randomUUID()).
                                                              setPaymentMethodTypeId(12);
    }
}
