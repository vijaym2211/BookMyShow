package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Entity
public class Payment extends BaseModel{
    private String transactionId;
    private double transactionAmount;
    @Enumerated(value = EnumType.ORDINAL)
    private PaymentStatus status;

}
