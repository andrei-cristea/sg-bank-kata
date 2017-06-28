package com.cristea.andrei.sgbankkata.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cristea.andrei.sgbankkata.entities.AccountStatement;
import com.cristea.andrei.sgbankkata.entities.impl.AccountStatementImpl;
import com.cristea.andrei.sgbankkata.enums.OperationTypeEnum;
import com.cristea.andrei.sgbankkata.services.AccountService;

/**
 * Account Service Implementation.
 * 
 * @author andrei-cristea
 */
public class AccountServiceImpl implements AccountService {

    /** List of account statements */
    private List<AccountStatement> accountStatements = new ArrayList<>();

    public AccountStatement deposit(final double pAmount) {

	checkAmount(pAmount);
	return addStatement(pAmount, OperationTypeEnum.DEPOSIT);
    }

    public AccountStatement withdrawal(final double pAmount) {

	checkAmount(pAmount);
	return addStatement(-pAmount, OperationTypeEnum.WITHDRAWAL);
    }

    public List<AccountStatement> history() {

	return accountStatements.stream().map(e -> e.clone()).collect(Collectors.toList());
    }

    /**
     * Check if amount is greater than zero.
     * 
     * @param pAmount
     *            The amount to check.
     * @throws IllegalArgumentException
     *             if pAmount is less or equal to zero.
     */
    private void checkAmount(final double pAmount) {

	if (pAmount <= 0) {
	    throw new IllegalArgumentException("The amount must be greater than zero");
	}
    }

    /**
     * Add the positive or negative amount on the account.
     * 
     * @param pAmount
     *            The amount.
     * @param pOperationType
     *            The operation type.
     * @return A reference of the {@link AccountStatement} created.
     */
    private AccountStatement addStatement(final double pAmount, final OperationTypeEnum pOperationType) {

	// Compute the balance
	double balance = pAmount;
	if (!accountStatements.isEmpty()) {
	    balance = accountStatements.get(accountStatements.size() - 1).getBalance() + pAmount;
	}

	// Build a new account statement
	AccountStatementImpl result = new AccountStatementImpl();
	result.setOperationType(pOperationType);
	result.setDate(LocalDateTime.now());
	result.setAmount(Math.abs(pAmount));
	result.setBalance(balance);

	accountStatements.add(result);

	return result.clone();
    }
}
