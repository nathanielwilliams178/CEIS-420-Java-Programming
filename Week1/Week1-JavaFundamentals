
package week.pkg1.lab.java.fundamentals;
import java.text.NumberFormat; //currency formatter
import java.util.Scanner; //user Input

public class SalesTracking {
	public static void main(String[] args)
	{
	//initializing variables
		double totalSales = 0;
		double averageSales = 0;
		double highestSales = 0;
		double lowestSales = 0;
		String highestMonth = "";
		String lowestMonth = "";
	
		
		
		//initializing arrays
		double[] monthlySales = new double[12];
		String[] monthArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

		//initializing methods
		getSales(monthlySales, monthArray); //input from the user will be directed from here
		totalSales = computeTotalSales(monthlySales);
		averageSales = computeAverageSales(monthlySales);
		highestSales = computeHighestMonth(monthlySales);
		lowestSales = computeLowestMonth(monthlySales);
		highestMonth = findHighestMonth(monthlySales, monthArray);
		lowestMonth = findLowestMonth(monthlySales, monthArray);
		displayInfo(totalSales, averageSales, highestSales, lowestSales, highestMonth, lowestMonth);

	}

	  static void getSales(double[] monthlySales, String[] monthArray) {
		  //Since this is for input, the scanner will be used to keep track of the user input
		  Scanner input = new Scanner(System.in);
		  int i; // iterator
		  try 
		  {
		  for( i = 0; i < monthlySales.length; i++)
		  	{
			System.out.println("Please provide the monthly sales price for " + monthArray[i] + ":");
			
			//validation to ensure there is not incorrect data being input
			while(!input.hasNextBigDecimal())
				{
				System.out.println("Incorrect data has been entered for " + monthArray[i] + " . Try again. ");
				input.next();
				}
			 monthlySales[i] = input.nextInt(); 
		  	}
		  }
		  finally 
		  {
			//Scanner must be closed once ran through the Try loop to prevent data leak
			 input.close(); 
		  }
		  System.out.println();
		
	  	}
	
	  public static double computeTotalSales(double[] monthlySales)
	  {	
		int i;
		double total = 0;
		for(i = 0; i < monthlySales.length; i++)
		{
			total += monthlySales[i];
		}
		return total;
	  }
	
	  
	 public static double computeAverageSales(double[] monthlySales) {
		  int i;
		  double total = 0;
		  double average = 0;
		  for( i = 0; i < monthlySales.length; i++)
		  {
			total += monthlySales[i];  
		  }
		  //return the average of this information
		  average = total/12;
		  return average;
	  }
	  
	  public static double computeHighestMonth(double[] monthlySales) {
		//to find the highest, it is implied that the first month is the highest and then you compare
		//the next month with the highest and change if the next month is higher.
		  int i;
		  double highest = monthlySales[0];
		  for(i = 1; i < monthlySales.length; i++)
		  {
			  if( monthlySales[i] > highest)
			  {
				  highest = monthlySales[i];
			  }
		  }
		  return highest;
	  }
	  
	  public static double computeLowestMonth(double[] monthlySales) {
		//same as before. imply the lowest is the first month and then compare the next month with that month.
		  int i;
		  double lowest = monthlySales[0];
		  for(i = 1; i < monthlySales.length; i++)
		  {
			  if( monthlySales[i] < lowest)
			  {
				  lowest = monthlySales[i];
			  }
		  }
		  return lowest;
	  }
	  
	  public static String findHighestMonth(double[] monthlySales, String[] monthArray) {
		//same logic as finding the highest sales.
		  //just goes a step further to find and return the month alongside.
		  int i;
		  double highest = monthlySales[0];
		  String highestmonth = monthArray[0];
		  for(i = 1; i < monthlySales.length; i++)
		  {
			  if( monthlySales[i] > highest)
			  {
				  highest = monthlySales[i];
				  highestmonth = monthArray[i];
			  }
		  }
		  return highestmonth;
	  }
	  
	  public static String findLowestMonth(double[] monthlySales, String[] monthArray) {
		  //same logic as finding the lowest sales.
		  //just goes a step further to find and return the month alongside.
		  int i;
		  double lowest = monthlySales[0];
		  String lowestmonth = monthArray[0];
		  for(i = 1; i < monthlySales.length; i++)
		  {
			  if( monthlySales[i] < lowest)
			  {
				  lowest = monthlySales[i];
				  lowestmonth = monthArray[i];
			  }
		  }
		  return lowestmonth; 
	  }
	  
	  public static void displayInfo(double totalSales, double averageSales, double highestSales, double lowestSales, String highestMonth, String lowestMonth) 
	  {
		  //take all computed information and display it into a concatenated string
		  NumberFormat formatter = NumberFormat.getCurrencyInstance();
		  System.out.print("Total Annual Sales: " + formatter.format(totalSales) + "\n");
		  System.out.print("Total Average Sales: " + formatter.format(averageSales) + "\n");
		  System.out.print("Highest Sales  Month: " + highestMonth + " with a Total of "+ formatter.format(highestSales) + "\n");
		  System.out.print("Lowest Sales  Month: " + lowestMonth + " with a Total of "+ formatter.format(lowestSales) + "\n");
		 
	  }
	  
}
