package transaction;

public class KeyMismatch extends Exception {
	KeyMismatch(String str){
		super(str);
	}
}
class DepositException extends IllegalArgumentException {
	DepositException(String str){
		super(str);
	}
}
class WithdrawException extends IllegalArgumentException {
	WithdrawException(String str){
		 super(str);	
	}
}
class InvalidKey extends Exception{
	InvalidKey(String str){
		System.out.println(str);
	}
	
}
