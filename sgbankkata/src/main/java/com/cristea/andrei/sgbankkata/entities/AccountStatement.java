package com.cristea.andrei.sgbankkata.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.cristea.andrei.sgbankkata.enums.OperationTypeEnum;

/**
 * Account Statement Interface.
 * 
 * @author andrei-cristea
 */
public interface AccountStatement extends Serializable, Cloneable {

    /**
     * Get the operation type.
     * 
     * @return {@link OperationTypeEnum}
     */
    OperationTypeEnum getOperationType();

    /**
     * Get the local datetime of the operation.
     * 
     * @return {@link LocalDateTime}
     */
    LocalDateTime getDate();

    /**
     * Get the amount of the operation (greater than zero).
     * 
     * @return a {@link double} positive value.
     */
    double getAmount();

    /**
     * Get the balance after the operation.
     * 
     * @return a {@link double} value.
     */
    double getBalance();

    /**
     * Clone the object.
     * 
     * @return a new {@link AccountStatement}.
     */
    AccountStatement clone();

}
