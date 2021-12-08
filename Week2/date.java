import javax.swing.JOptionPane;

class date {
	//variables
	private int day;
	private int month;
	private int year;
	
	//default constructor
	public date(){
		day = 1;
		year = 2000;
		month = 1;
	}
	
	//regular constructor
	public date(int uDay, int uMonth, int uYear)
	{
		setDay(uDay);
		setMonth(uMonth);
		setYear(uYear);
		
	}
	
	//copy constructor
	public date(date dateObj) {
		day = dateObj.day;
		month = dateObj.month;
		year = dateObj.year;
	}
	
	//accessors
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	//mutators
	public void setDay(int day) {
		if (day >= 1 && day <= 31)
		{
			this.day = day;
		}
		else
		{
			this.day = 1;
		}
	}
	
	public void setMonth(int month) {
		if (month >=1 && month <= 12)
		{
			this.month = month;
		}
		else
		{
			this.month = 1;
		}
	}
	
	public void setYear(int year) {
		if (year >=2000 && year<= 2021)
		{
			this.year = year;
		}
		else
		{
			this.year = year;
		}
	}
	
	//functions
	public void increaseDay()
	{
		//array of days in each month
		//0 in first instance because dayMonth[0] would be month 0
		int[] dayMonths = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		//increment day by one and validate that it is not more than the days in the month
		++day;
		
		//this is as intended
		if(day <= dayMonths[month])
		{
			return;
		}
		
		//validation for leap year instances
		if(day == 28 && month == 2 && (year % 400 == 0 || (year % 100 != 100)))
		{
			return;
		}
		
		//if the day increment fails these checks == new month
		//reset the day counter and increment the month counter
		else
		{
			day = 1;
			++month;
		}
		
		//now check the month counter to make sure it doesn't exceed 12
		//if exceed == new year and reset the day and month counter
		if(month > 12)
		{
			month = 1;
			day = 1;
			++year;
		}
		
		
	}
	
	public String toDateString() {
		return month + "/" + day + "/" + year;
	}
	
	//main method
	public static void main(String[] args) {
	
		date myDate = new date(getInput("day"), getInput("month"), getInput("year"));
	
		System.out.println("Starting Date: " + myDate.toDateString());
		
		for (int i = 0; i < 100; i++)
		{
			myDate.increaseDay();
			System.out.println("Incremented Date: " + myDate.toDateString());
		}

	}

	public static int getInput(String input) {
		int num = 0; // will be used to transer user input to a integer
		String numStr = ""; // will hold the user input
		boolean isValid = false; //conditional to assist in looping
		
		while(!isValid)
		{
			numStr = JOptionPane.showInputDialog("Please provide the " + input);
			try //try loop to validate user input
			{ 
				if (numStr != null) //if there is user input, push user input to integer variable to be used in date class
				{
					num = Integer.parseInt(numStr);
					isValid = true;
					break;
				}
				else //if there is an error in the userInput
				{
					JOptionPane.showMessageDialog(null, "Action Cancelled", "Cancel", JOptionPane.INFORMATION_MESSAGE);
					isValid = true;
				}
			} catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Invalid number entered, try again.", "Error", JOptionPane.ERROR_MESSAGE );
			}
		}
		return num; //after all validation, return the parsed integer
	}
}

