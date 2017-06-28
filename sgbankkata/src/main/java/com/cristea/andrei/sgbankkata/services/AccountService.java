package com.cristea.andrei.sgbankkata.services;

import java.util.List;

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
     *            The amount (greater than zero).
     * @return A clone of the {@link AccountStatement} created.
     * @throws IllegalArgumentException
     *             if pAmount is less or equal to zero.
     */
    AccountStatement deposit(final double pAmount);

    /**
     * Withdrawal of an amount of the account.
     * 
     * @param pAmount
     *            The amount (greater than zero).
     * @return A clone of the {@link AccountStatement} created.
     * @throws IllegalArgumentException
     *             if pAmount is less or equal to zero.
     */
    AccountStatement withdrawal(final double pAmount);

    /**
     * Get the history or an empty list if there's no history.
     * 
     * @return a list of clones not null.
     */
    List<AccountStatement> history();
}
