package com.cristea.andrei.sgbankkata;

import java.util.ArrayList;
import java.util.List;

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

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawalAmountZero() {
	AccountService service = AccountFactory.getInstance().buildAccountService();
	service.withdrawal(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawalAmountNegative() {
	AccountService service = AccountFactory.getInstance().buildAccountService();
	service.withdrawal(-0.1);
    }

    @Test
    public void testWithdrawal1Amount() {
	AccountService service = AccountFactory.getInstance().buildAccountService();
	AccountStatement statement = service.withdrawal(0.1);
	Assert.assertNotNull(statement);
	Assert.assertEquals(OperationTypeEnum.WITHDRAWAL, statement.getOperationType());
	Assert.assertNotNull(statement.getDate());
	Assert.assertEquals(0.1, statement.getAmount());
	Assert.assertEquals(-0.1, statement.getBalance());
    }

    @Test
    public void testWithdrawal2Amounts() {
	AccountService service = AccountFactory.getInstance().buildAccountService();
	AccountStatement statement = service.withdrawal(0.1);
	Assert.assertEquals(0.1, statement.getAmount());
	Assert.assertEquals(-0.1, statement.getBalance());
	statement = service.withdrawal(1.2);
	Assert.assertEquals(1.2, statement.getAmount());
	Assert.assertEquals(-1.3, statement.getBalance());
    }

    @Test
    public void testHistoryEmpty() {
	AccountService service = AccountFactory.getInstance().buildAccountService();
	List<AccountStatement> statements = service.history();
	Assert.assertEquals(0, statements.size());
    }

    @Test
    public void testHistoryNotEmpty() {
	AccountService service = AccountFactory.getInstance().buildAccountService();
	List<AccountStatement> expectedStatements = new ArrayList<>();
	expectedStatements.add(service.deposit(0.1));
	expectedStatements.add(service.withdrawal(2));
	expectedStatements.add(service.deposit(3));
	expectedStatements.add(service.deposit(5.7));
	expectedStatements.add(service.withdrawal(6.6));
	List<AccountStatement> statements = service.history();
	Assert.assertEquals(expectedStatements, statements);
    }
}
