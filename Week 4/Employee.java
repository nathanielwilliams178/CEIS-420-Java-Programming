
	abstract class EmployeeClass 
	{
		private String firstName = "";
		private String lastName = "";
		private String ssn = "";
	
		public EmployeeClass(String fName, String lName, String socsn) {
			firstName = fName;
			lastName = lName;
			ssn = socsn;
		
	}
	
		public void setFirstName(String fName) {
			firstName = fName;
	}
	
		public String getFirstName() {
			return firstName;
	}
	
		public void setLastName(String lName) {
			lastName = lName;
	}
	
		public String getLastName() {
			return lastName;
	}
	
		public void setSSN(String socsn) {
			ssn = socsn;
	}
	
		public String getsocsn() {
			return ssn;
	}
	
		public abstract double earnings();
	
		//String.format to format the information to showcase such as in the instructions
		public String toString(){
			return String.format("%s %s\nsocial security number: %s", 
			getFirstName(), getLastName(), getsocsn());
		}
	}
	
	class SalariedEmployee extends EmployeeClass
	{
		private double weeklySalary = 0;
		
		public SalariedEmployee(String first, String last, String ssn, double salary) {
			super(first, last, ssn);
			setSalary(salary);
		}
		
		public void setSalary(double salary) {
			if (salary >= 0.0)
			{
				weeklySalary = salary;
			}
			else
				throw new IllegalArgumentException("Weekly Salary must be Greater than or equal to 0");
				
		}
		
		public double getSalary() {
			return weeklySalary;
		}
		@Override
		public double earnings() {
			return getSalary();
		}
		@Override
		public String toString() {
			return String.format("Salaried employee: %s\n%s: $%,.2f",
					super.toString(), "Weekly Salary", getSalary());
		}
	}
	class HourlyEmployee extends EmployeeClass
	{
		private double hourlyWage = 0;
		private double hoursWorked = 0;
		
		public HourlyEmployee(String first, String last, String ssn, double hourlyWage, double hoursWorked ) {
			super(first, last, ssn);
			setHourlyWage(hourlyWage);
			setHoursWorked(hoursWorked);
		}
		
		public void setHourlyWage(double wage) {
			if (wage >= 0.0)
			{
				hourlyWage = wage;
			}
			else
				throw new IllegalArgumentException("Hourly Wage must be Greater than or equal to 0");
		
		}
		
		public double getHourlyWage() {
			return hourlyWage;
		}
		
		public void setHoursWorked(double hours) {
			if(hours >=0.0 && hours <=168.0) {
				hoursWorked = hours;
			}
			else
				throw new IllegalArgumentException("Hours worked must be between 0 and 168");
			
		}
		
		public double getHoursWorked(){
			return hoursWorked;
		}
		@Override
		public double earnings() {
			if(getHoursWorked() <= 40) 
			{
				return  getHourlyWage() * getHoursWorked();
			}
			else 
			{
				return 40 * getHourlyWage() + ( getHoursWorked() - 40) * getHourlyWage() *1.5;
			}
		}
		@Override
		public String toString() {
			return String.format("%s %s\n%s $%,.2f %s %,.2f",
					"Hourly Employee:", super.toString(), "Hourly Wage:", getHourlyWage(),"Hours Worked:", getHoursWorked());
		}
	}
	class CommissionEmployee extends EmployeeClass
	{
		private double salesAmount = 0.0;
		private double commissionRate = 0.0;
		
		public CommissionEmployee(String first, String last, String ssn, double sales, double commissionRate) {
			super(first, last, ssn);
			setSalesAmount(sales);
			setCommissionRate(commissionRate);
		}
		
		public void setSalesAmount(double sales) {
			if (sales >= 0.0) {
				salesAmount = sales;
			}
			else
				throw new IllegalArgumentException("Sales must be Greater than or equal to 0");
			
		}
		
		public void setCommissionRate(double commission) {
			if(commission > 0.0 && commission < 1.0) {
				commissionRate = commission;
			}
			else
				throw new IllegalArgumentException("Commission Rate must be between 0 and 1");
			
		}
		
		public double getSalesAmount() {
			return salesAmount;
		}
		
		public double getCommissionRate() {
			return commissionRate;
		}
		@Override
		public double earnings() {
			return getCommissionRate() * getSalesAmount();
		}
		@Override
		public String toString() {
			return String.format("%s: %s\n%s: $%,.2f %s:%.2f,",
					"Commission Employee", super.toString(),
					"Gross Sales", getSalesAmount(),
					"Commission Rate", getCommissionRate());
		}
	}
	class BasePlusClassEmployee extends CommissionEmployee
	{
		private double baseSalary;
		
		public BasePlusClassEmployee(String first, String last, String ssn, double sales, double rate, double salary)
		{
			super(first, last, ssn, sales, rate);
			setBaseSalary(salary);
		}
		
		public void setBaseSalary(double salary) {
			if (salary >= 0.0)
			{
				baseSalary = salary;
			}
			else
				throw new IllegalArgumentException("Salary must be more than 0");
			
		}
		
		public double getBaseSalary() {
			return baseSalary;
		}
		
		@Override
		public double earnings() {
			return super.earnings() + getBaseSalary();
		}
		
		@Override
		public String toString() {
			return String.format("%s %s %s: $%,.2f",
					"Base Salaried", super.toString(), 
					"Base Salary", getBaseSalary());
		}
		
	
public static class Employee
{
	public static void main(String[] args) 
	{
		SalariedEmployee salariedEmployee = new SalariedEmployee("Nathaniel", "Williams", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Robert", "Woods", "222-22-2222", 18.00, 40);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Justin", "Herbert", "333-33-3333", 10000, .07);
		BasePlusClassEmployee basePlusCommissionEmployee = new BasePlusClassEmployee("Cam", "Newton", "444-44-4444", 6000, .05, 300);
		System.out.println("Employees successfully processed.\n");
		
		System.out.printf("%s\n%s: $%, .2f\n\n", salariedEmployee, "Earned", salariedEmployee.earnings());
		System.out.printf("%s\n%s: $%, .2f\n\n", hourlyEmployee, "Earned", hourlyEmployee.earnings());
		System.out.printf("%s\n%s: $%, .2f\n\n", commissionEmployee, "Earned", commissionEmployee.earnings());
		System.out.printf("%s\n%s: $%, .2f\n\n", basePlusCommissionEmployee, "Earned", basePlusCommissionEmployee.earnings());
	
		
		EmployeeClass[] employees = new EmployeeClass[4];
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;
		System.out.println("Employees processed Polymorphically");
		
		//process through each element in the created array
		for(EmployeeClass currentEmployee : employees)
		{
			System.out.println(currentEmployee);
			
			//if element (employee) is a special case (basePlusClass)
			if (currentEmployee instanceof BasePlusClassEmployee)
			{
				BasePlusClassEmployee employee = (BasePlusClassEmployee) currentEmployee;
				employee.setBaseSalary(1.10*employee.getBaseSalary());
			
				System.out.printf("New Base Salary with 10%% increase is: $%,.2f\n",employee.getBaseSalary());
			}
			
			System.out.printf("Earned $%,.2f\n\n", currentEmployee.earnings());
			
			
		}
		for(int j = 0; j < employees.length; j++)
		{
			System.out.printf("Employee %d is a %s\n", j, employees[j].getClass().getName());
		}
	}

}
}


