package com.cristea.andrei.sgbankkata.entities.impl;

import java.time.LocalDateTime;

import com.cristea.andrei.sgbankkata.entities.AccountStatement;
import com.cristea.andrei.sgbankkata.enums.OperationTypeEnum;

/**
 * Account Statement Implementation.
 * 
 * @author andrei-cristea
 */
public class AccountStatementImpl implements AccountStatement {

    private static final long serialVersionUID = -3719118962371756651L;

    private OperationTypeEnum operationType;
    private LocalDateTime date;
    private double amount;
    private double balance;

    public OperationTypeEnum getOperationType() {
	return operationType;
    }

    public void setOperationType(OperationTypeEnum operationType) {
	this.operationType = operationType;
    }

    public LocalDateTime getDate() {
	return date;
    }

    public void setDate(LocalDateTime date) {
	this.date = date;
    }

    public double getAmount() {
	return amount;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

    public double getBalance() {
	return balance;
    }

    public void setBalance(double balance) {
	this.balance = balance;
    }
}
