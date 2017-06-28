package com.cristea.andrei.sgbankkata.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private List<AccountStatement> accountStatements = new ArrayList<AccountStatement>();

    public AccountStatement deposit(final double pAmount) {

	if (pAmount <= 0) {
	    throw new IllegalArgumentException("The amount must be greater than zero");
	}

	// Compute the balance
	double balance = pAmount;
	if (!accountStatements.isEmpty()) {
	    balance = accountStatements.get(accountStatements.size() - 1).getBalance() + pAmount;
	}

	// Build a new account statement
	AccountStatementImpl result = new AccountStatementImpl();
	result.setOperationType(OperationTypeEnum.DEPOSIT);
	result.setDate(LocalDateTime.now());
	result.setAmount(pAmount);
	result.setBalance(balance);

	accountStatements.add(result);

	return result;
    }
}
