package com.stackroute.designpattern;
import java.util.ArrayList;
import java.util.List;

// Component interface
interface Account {
    void calcuInterest( );
    double getBalance();
}

class SavingsAccount implements Account {
    private String accountNumber;
    private double balance;
    SavingsAccount(String acno,double bal)
    {
    	this.accountNumber=acno;
    	this.balance=bal;
    }
    
	public void calcuInterest( ) {
		balance=balance + (balance*8/100);
		
	}
	public double getBalance() {
	 
		return balance;
	}
}

class RecurringAccount implements Account
{

	 private String accountNumber;
	    private double balance;
	    
	    RecurringAccount(String acno,double bal)
	    {
	    	this.accountNumber=acno;
	    	this.balance=bal;
	    }
		public void calcuInterest( ) {
			balance=balance + (balance*6/100);
			
		}
		public double getBalance() {
		 
			return balance;
		}
	
}

class CompositeAccount implements Account {
    private String accountNumber;
    private List<Account> subAccounts = new ArrayList<>();

    public CompositeAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

   public void addAccount(Account act)
   {
	   this.subAccounts.add(act);
   }

@Override
public void calcuInterest() {
	 
	for(Account obj : subAccounts)
	{
		obj.calcuInterest();
	}
	
}

@Override
public double getBalance() {
	double totalbalance=0;
	for(Account obj : subAccounts)
	{
		totalbalance+= obj.getBalance();
		
	}
	return totalbalance;
}
}

public class SampleComposite {
  
	  
	public static void main(String[] args) {
		
		Account account1=new SavingsAccount("A123",2000);
		Account account2=new RecurringAccount("A123",5000);
		account1.calcuInterest();
		account2.calcuInterest();
		CompositeAccount compose=new CompositeAccount("A1234" );
		compose.addAccount(account2);
		compose.addAccount(account1);
		compose.calcuInterest();
		
		System.out.println(account1.getBalance());
		
		System.out.println( compose.getBalance());
	}

}


