package transaction;

class Customer {
	
	private String name;
	private String Address;
	private long mobileno;
	private int balance;
	public Customer(String name, String address, long mobileno, int balance) {
		super();
		this.name = name;
		Address = address;
		this.mobileno = mobileno;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}	
	
	
}
