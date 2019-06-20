package com.intuit.home.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.home.request.PaymentRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Optional;

/**
 * Utility which converts {@link com.intuit.home.request.PaymentRequest}
 */
public final class RequestConverter {
    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static Logger logger = LogManager.getLogger(RequestConverter.class);


    /**
     * Converts an {@link Object} to JSON as String
     *
     * @param toBeConverted
     *
     * @return json as payment request.
     */
    public static String toString(Object toBeConverted) {
        try {
            return (toBeConverted != null) ? objectMapper.writeValueAsString(toBeConverted) : "";
        } catch (JsonProcessingException e) {
            logger.error("error {}", e);
        }

        return "";
    }

    /**
     * Create a pojo from {@link String}.
     *
     * @param anObject to be converted.
     *
     * @return a paymentRequest as an optional or empty.
     */
    public static Optional<PaymentRequest> fromString(String anObject) {
        try {
            return (anObject != null) ? Optional.of(objectMapper.readValue(anObject, PaymentRequest.class)) : Optional.empty();
        } catch (IOException e) {
            logger.error("error {}", e);
        }
        return Optional.empty();
    }
}
