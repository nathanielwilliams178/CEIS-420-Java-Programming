
class rectangle {

	//initiation of variables
	private double length = 0;
	private double width = 0;
	
	//default constructor
	public rectangle() {
		length  = 0;
		width = 0;
	
	}
	
	//constructor
	public rectangle(double uLength, double uWidth) {
		setLength(uLength);
		setWidth(uWidth);
	}
	
	//conversion constructor
	public rectangle(double uLength) {
		length = uLength;
		width = 0;
		
	}
	//copy constructor
	public rectangle(rectangle rectangleObj) {
		length = rectangleObj.length;
		width = rectangleObj.width;
	}
	
	//accessors
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	//mutators
	public void setLength(double length)
	{
		if (length >= 1 && length <= 20)
		{
			this.length = length;
		}
		else // if the input is outside of the given restrictions
		{
			length = 0;
		}
	}
	
	public void setWidth(double width)
	{
		if ( width >= 1 && width <= 20)
		{
			this.width = width;
		}
		else // if the input is outside of the given restrictions
		{
			width = 0;
		}
	}
	
	//function
	public  double calcArea()
	{
		return length*width;	
	}
	
	//to String
	
	public String toString()
	{
		return "The length is " + length + ". The width is: " + width + ". The complete area is: " + calcArea();
	}
	public static void main(String[] args) {
		rectangle r1 = new rectangle(); //default constructor
		rectangle r2 = new rectangle(12,18); //regular constructor
		rectangle r3 = new rectangle(r2); //copy constructor
		rectangle r4 = new rectangle(15); //conversion constructor
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);

	}
}




