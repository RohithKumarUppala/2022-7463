package transaction;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Transaction implements Atm {
	Scanner s = new Scanner(System.in);
	
	public void withdraw(Map<Integer,Customer> data,Transaction a,int key) throws KeyMismatch,WithdrawException 
	{
		Iterator details=data.entrySet().iterator();
		while(details.hasNext()) {
			Map.Entry<Integer, Customer> record = (Map.Entry<Integer, Customer>) details.next();
			Customer c = (Customer)record.getValue();
			System.out.println("Enter the Key Again");
			Integer k = s.nextInt();
				if(k!=key) {
						throw new KeyMismatch("Key is Missmatched");
				}else
					{
					System.out.println("Enter Amount to be Withdraw");
					int w=s.nextInt();
					if(w>0&&w>100) {
						System.out.println(c.getName());
						int setbalance=c.getBalance()-w;
						c.setBalance(setbalance);
						System.out.println(w+ " Amount Withdrawn Sussfully"+"\n Balance Amount is  "
						+c.getBalance());
						return;
					}
					else{
						throw new WithdrawException("Enter the Minimum Account");
				}
			}
		}
		return;	
	}
	
	public void deposit(Map<Integer,Customer> data,int key)throws KeyMismatch,DepositException {
		Iterator details=data.entrySet().iterator();
		while(details.hasNext()) {
			Map.Entry<Integer, Customer> record = (Map.Entry<Integer, Customer>) details.next();
			Customer c = (Customer)record.getValue();
			System.out.println("Enter the Key Again");
			Integer k = s.nextInt();
			if(k!=key) {
					throw new KeyMismatch("Key is Missmatched");
				}
			else {
					System.out.println("Enter Amount to be Deposit");
					int d=s.nextInt();
					if(d>0&&d>100) {
						System.out.println(c.getName());
						int setbalance=c.getBalance()+d;
						c.setBalance(setbalance);
						System.out.print("  Amount Depoisted Successfully\n");
						return;
					}
					else
						throw new DepositException("Minimum Amount to Deposit");
				}
			}
		
		return;
	}
	public void checkBalance(Map<Integer,Customer> data) throws KeyMismatch{
		Iterator details=data.entrySet().iterator();
		while(details.hasNext()) {
			Map.Entry<Integer, Customer> record = (Map.Entry<Integer, Customer>) details.next();
			Customer c = (Customer)record.getValue();
			System.out.println("Enter the Key Again");
			int key=s.nextInt();
			if(data.containsKey(key)) {
				System.out.println(c.getName()+" Balance i Keys "+c.getBalance());
				return;
			}
			else {
				throw new KeyMismatch("Key is Missmatched");
			}
		}
		return;
	}

	public static void main(String arg[]) throws KeyMismatch,DepositException,WithdrawException,InvalidKey{
		
		Scanner s = new Scanner(System.in);
		int key,ch,che;
		Map<Integer,Customer> data =new HashMap<>();
		Customer c1 = new Customer("Rohith","Hyderbad",9949495015l,20000);
		Customer c2 = new Customer("Sandeep","Hyderbad",7702951214l,10000);
		Customer c3 = new Customer("Aravind","Hyderbad",9949495015l,15000);
		data.put(1015, c1);
		data.put(7032, c2);
		data.put(7799, c3);
		
		Transaction a = new Transaction();
		 do{
			try {
			System.out.println("Enter the Key of Account");
			key = s.nextInt();
			if(data.containsKey(key)) {
				do{
					System.out.println("Enter the Choice\n1.Withdraw\n2.deposit\n3.balancecheck\nEnter zero to Exit Account");
					ch=s.nextInt();
					switch(ch) {
					case 1: try{
								a.withdraw(data, a, key);
							break;
							}catch(WithdrawException e) {
								System.out.println(e);
							}
					case 2:try{
							a.deposit(data, key);
							break;
						}catch(DepositException e) {
								System.out.println(e);
						}
					case 3: a.checkBalance(data);
							break;
					case 0: System.out.println("Exit From Account");
							break;
					}
				}while(ch!=0);
			}
			else
				throw new InvalidKey("Entered Invalid Key"
						+ " Check And ");
			}catch(KeyMismatch e) {
				System.out.println(e);
			}catch(InvalidKey e) {
				System.out.println();
			}
			System.out.println("Enter '1' to Strat again AND '0' to Exit");
			che=s.nextInt();
		}while(che!=0);
		System.out.println("Thank You Visit Again");
		s.close();
	}
}