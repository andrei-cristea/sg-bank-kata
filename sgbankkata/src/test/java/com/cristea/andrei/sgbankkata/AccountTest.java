package com.cristea.andrei.sgbankkata;

import org.junit.Test;

import com.cristea.andrei.sgbankkata.entities.AccountStatement;
import com.cristea.andrei.sgbankkata.enums.OperationTypeEnum;
import com.cristea.andrei.sgbankkata.services.AccountService;

import junit.framework.Assert;

public class AccountTest {

    @Test(expected = IllegalArgumentException.class)
    public void testDepositAmountZero() {
	AccountService service = AccountFactory.getInstance().buildAccountService();
	service.deposit(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositAmountNegative() {
	AccountService service = AccountFactory.getInstance().buildAccountService();
	service.deposit(-0.1);
    }

    @Test
    public void testDeposit1Amount() {
	AccountService service = AccountFactory.getInstance().buildAccountService();
	AccountStatement statement = service.deposit(0.1);
	Assert.assertNotNull(statement);
	Assert.assertEquals(OperationTypeEnum.DEPOSIT, statement.getOperationType());
	Assert.assertNotNull(statement.getDate());
	Assert.assertEquals(0.1, statement.getAmount());
	Assert.assertEquals(0.1, statement.getBalance());
    }

    @Test
    public void testDeposit2Amounts() {
	AccountService service = AccountFactory.getInstance().buildAccountService();
	AccountStatement statement = service.deposit(0.1);
	Assert.assertEquals(0.1, statement.getAmount());
	Assert.assertEquals(0.1, statement.getBalance());
	statement = service.deposit(1.2);
	Assert.assertEquals(1.2, statement.getAmount());
	Assert.assertEquals(1.3, statement.getBalance());
    }
}
