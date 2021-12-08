class Account{
	private int accNum;
	private String name;
	private double balance;
	private int routNum;
	
	public Account() {
		accNum = 0;
		name = "";
		balance = 0;
		routNum = 0;
	}
	
	public Account(int a, String n, double b, int r) {
		setAccNum(a);
		setName(n);
		setBalance(b);
		setRoutNum(r);
	}
	
	public int getAccNum() {
		return accNum;
	}
	public String getName() {
		return name;
	}
	public double getBalance() {
		return balance;
	}
	public int getRoutNum() {
		return routNum;
	}
	
	//mutators
	public void setAccNum(int accNum) {
		if (accNum >= 0) 
		{
			this.accNum = accNum;
		}
		else
			accNum = 0;
	}
	public void setName(String name) {
		if (!name.isEmpty()) 
		{
			this.name = name;
		}
		else
			name = "";
	}
	public void setBalance(double balance) {
		if (balance >= 0) 
		{
			this.balance = balance;
		}
		else
			balance = 0;
	}
	public void setRoutNum(int routNum) {
		if (routNum >= 0) 
		{
			this.routNum = routNum;
		}
		else
			routNum = 0;
	}
	
	public void deposite(double aBalance) {
		System.out.println("\nYou have deposited: $" + aBalance +"\n");
		balance = (balance + aBalance);
	}
	
	public void withdraw(double aBalance) {
		
		if(balance > aBalance)
			{
			System.out.println("\nYou withdrew: $" + aBalance +" from your Account.\n");
				balance = (balance - aBalance);
			}
		else
			System.out.println("Invalid. Not enough funds in Account to withdraw that amount.");
	}
	
	public String toString() {
		return "Account Name: " + name + "\nAccount Number: " + accNum + "\nAccount Balance: $" + balance + "\nAccount Routing Number: " + routNum;
	}
}

class SavingsAccount extends Account{
	private double intRate; //interest rate
	
	public SavingsAccount() {
		super();
		intRate = 0;
	}
	
	public SavingsAccount(int a, String n, double b, int r, double i)// constructor takes info from account + intRate
	{
		super(a,n,b,r);
		setIntRate(i);
	}
	
	public double getIntRate()
	{
		return intRate;
	}
	
	public void setIntRate(double intRate) {
		if (intRate >= 0)
		{
			this.intRate = intRate;
		}
		else
			intRate = 0;
	}
	
	public void calcIntRate() {
		double calcBal = getBalance();
		calcBal = (calcBal + ((intRate/100)* calcBal));
		setBalance(calcBal);
	}
	
	public String toString()
	{
		calcIntRate(); //to ensure that the interest rate is applied
		return super.toString() + "\nThe Interest Rate is: " + intRate;
	}
	
}

class CheckingAccount extends Account{
	private double withdrawFee;
	
	public CheckingAccount() {
		super();
		withdrawFee = 0;
	}
	
	public CheckingAccount(int a, String n, double b, int r, double w) {
		
		super(a,n,b,r);
		setWithdraw(w);
	}
	
	public double getWithdrawFee() {
		return withdrawFee;
	}
	
	public void setWithdraw(double w) {
		if (w >= 0) {
			withdrawFee = w;
		}
		else
			withdrawFee = 0;
	}
	
	public void withdraw(double amt)
	{
		double temp = 0; // temp variable holder for balance
		if(amt <= 100) // if you are withdrawing less than $100
		{
			System.out.println("\nYou have a fee of $" + withdrawFee + " applied to your withdrawal request of $" + amt + ".");
			temp = (getBalance() - withdrawFee);
			setBalance(temp);
			super.withdraw(amt);
		}
		else // if your withdrawal is under the threshold, no fee applied
		{
		super.withdraw(amt);	
		}
	}
	
	public String toString() {
		return super.toString() + " \nThe Withdraw Fee is: " + withdrawFee;
	}
	
}
	



public class InheritanceTest1 {
	public static void main(String[] args) {
		Account Test = new Account(1, "Nathaniel", 1000, 313131);
		System.out.println(Test);
		Test.deposite(400);
		System.out.println(Test);
		Test.withdraw(300);
		System.out.println(Test+"\n");
		
		System.out.println("-- SAVINGS ACCOUNT TESTING --");
		
		SavingsAccount Test1 = new SavingsAccount(1, "Nathaniel", 1000, 313131, 2);
		System.out.println(Test1);
		Test1.deposite(750);
		System.out.println(Test1);
		Test1.withdraw(500);
		System.out.println(Test1 + "\n");
		
		System.out.println("-- CHECKING ACCCOUNT TESTING --");
		
		CheckingAccount Test2 = new CheckingAccount(1, "Nathaniel", 1000, 313131,3);
		Test2.deposite(400);
		System.out.println(Test2);
		Test2.withdraw(75);
		System.out.println(Test2);

	}

}
