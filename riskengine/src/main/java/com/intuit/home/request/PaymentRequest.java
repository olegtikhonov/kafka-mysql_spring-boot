package com.intuit.home.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intuit.home.money.Moneta;

import java.util.UUID;

/**
 * Represents a payment request
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentRequest extends BaseRequest {
    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("currency")
    private Moneta currency;

    @JsonProperty("userId")
    private UUID userId;

    @JsonProperty("payeeId")
    private UUID payeeId;

    @JsonProperty("paymentMethodId")
    private UUID paymentMethodId;


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Moneta getCurrency() {
        return currency;
    }

    public void setCurrency(Moneta currency) {
        this.currency = currency;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
    }

    public UUID getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(UUID paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{ amount=").append(amount);
        sb.append(", currency=").append(currency);
        sb.append(", userId=").append(userId);
        sb.append(", payeeId=").append(payeeId);
        sb.append(", paymentMethodId=").append(paymentMethodId);
        sb.append('}');
        return sb.toString();
    }
}
