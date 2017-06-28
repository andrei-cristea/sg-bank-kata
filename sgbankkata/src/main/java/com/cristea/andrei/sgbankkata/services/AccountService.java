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
     * @throws IllegalArgumentException
     *             if pAmount is less or equal to zero.
     */
    AccountStatement deposit(final double pAmount);

    /**
     * Withdrawal of an amount of the account.
     * 
     * @param pAmount
     *            (> 0).
     * @return A reference of the {@link AccountStatement} created.
     * @throws IllegalArgumentException
     *             if pAmount is less or equal to zero.
     */
    AccountStatement withdrawal(final double pAmount);
}
