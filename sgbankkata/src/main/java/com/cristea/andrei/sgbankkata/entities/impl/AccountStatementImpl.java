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

    @Override
    public AccountStatementImpl clone() {
	try {
	    return (AccountStatementImpl) super.clone();
	} catch (CloneNotSupportedException e) {
	    return null;
	}
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(amount);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(balance);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + ((operationType == null) ? 0 : operationType.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	AccountStatementImpl other = (AccountStatementImpl) obj;
	if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
	    return false;
	if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
	    return false;
	if (date == null) {
	    if (other.date != null)
		return false;
	} else if (!date.equals(other.date))
	    return false;
	if (operationType != other.operationType)
	    return false;
	return true;
    }

}
