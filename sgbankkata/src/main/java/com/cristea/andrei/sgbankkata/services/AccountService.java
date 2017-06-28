package com.cristea.andrei.sgbankkata.services;

import com.cristea.andrei.sgbankkata.entities.AccountStatement;

/**
 * Account Service Interface.
 * 
 * @author andrei-cristea
 */
public interface AccountService {

    /**
     * Deposit of an amount on the account.
     * 
     * @param pAmount
     *            (> 0).
     * @return A reference of the {@link AccountStatement} created.
     */
    AccountStatement deposit(final double pAmount);
}
