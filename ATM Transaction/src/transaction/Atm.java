package transaction;

import java.util.Map;

public interface Atm {
	
	public void withdraw(Map<Integer,Customer> data,Transaction a,int key) throws KeyMismatch,WithdrawException;
	public void deposit(Map<Integer,Customer> data,int key) throws KeyMismatch, DepositException;
	public void checkBalance(Map<Integer,Customer> data) throws KeyMismatch;
}
