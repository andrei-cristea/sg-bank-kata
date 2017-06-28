package com.cristea.andrei.sgbankkata;

import com.cristea.andrei.sgbankkata.services.AccountService;
import com.cristea.andrei.sgbankkata.services.impl.AccountServiceImpl;

/**
 * Account Factory (singleton).
 * 
 * @author andrei-cristea
 */
public final class AccountFactory {

    /** Private constructor */
    private AccountFactory() {
	// NOP
    }

    /** Singleton */
    private static AccountFactory instance;

    /**
     * @return the unique instance of {@link AccountFactory}
     */
    public static AccountFactory getInstance() {
	if (instance == null) {
	    instance = new AccountFactory();
	}
	return instance;
    }

    /**
     * Build an account service.
     * 
     * @return a new {@link AccountService}
     */
    public AccountService buildAccountService() {
	return new AccountServiceImpl();
    }
}
