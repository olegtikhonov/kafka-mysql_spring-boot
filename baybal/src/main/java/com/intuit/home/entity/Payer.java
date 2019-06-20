package com.intuit.home.entity;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;


/**
 * +------------+--------------+------+-----+---------+-------+
 * | Field      | Type         | Null | Key | Default | Extra |
 * +------------+--------------+------+-----+---------+-------+
 * | payer_id   | binary(16)   | NO   | PRI | NULL    |       |
 * | first_name | varchar(100) | NO   |     | NULL    |       |
 * | last_name  | varchar(100) | YES  |     | NULL    |       |
 * | email      | varchar(100) | YES  |     | NULL    |       |
 * +------------+--------------+------+-----+---------+-------+
 */
public class Payer {
    @Id
    @Type(type="uuid-char")
    private UUID payerId;

    @Column
    private String firstName;

    @Column
    private String lastName;


    @Column
    private String email;


    public UUID getPayerId() {
        return payerId;
    }

    public Payer setPayerId(UUID payerId) {
        this.payerId = payerId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Payer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Payer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Payer setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{payerId=").append(payerId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
