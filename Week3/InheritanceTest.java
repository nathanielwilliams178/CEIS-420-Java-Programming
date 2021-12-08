
class Point{
		private double x;
		private double y;
		
		public Point(){
			x = y = 0;
		}
		
		public Point(double x, double y) {
			setXCord(x);
			setYCord(y);
		}
		
		public double getXCord() {
			return x;
		}
		
		public double getYCord() {
			return y;
		}
		
		public void setXCord(double x){
			if (x >= 0)
			{
				this.x = x;
			}
			else
			{
				x = 0;
			}
		}
		
		public void setYCord(double y) {
			if (y >= 0)
			{
				this.y = y;
			}
			else
			{
				y = 0;
			}
		}
		
		public String toString() {
			return "The Plotted Coordinates are: " + x + " " + y + "\n";
		}
	
}
 class Square extends Point{
		double sideLength;
		
		public Square() {
			super();
			sideLength = 0;
		}
		
		public Square(double x, double y, double s) {
			super(x,y);
			sideLength = s;
		}
		
		public double getSideLength() {
			return sideLength;
		}
		
		public void setSideLength(double sideLength) {
			if(sideLength <= 0)
			{
				this.sideLength = sideLength;
			}
			else
				sideLength = 0;
		}
		
		public double Area() {
			return sideLength * sideLength;
		}
		
		public String toString() {
			return "The Square's side lengths is: " + sideLength + " \nThe Area of the Square is: " + Area()+"\n";
		}
		
		
		
	}
	
	 class Cube extends Square{
		private double depth;
		
		public Cube() {
			super();
			depth = 0;
		}
		
		public Cube(double x, double y, double s, double d){
			super(x,y,s);
			depth = d;
		}
		
		public double getDepth() {
			return depth;
		}
		
		public void setDepth( double depth) {
			if (depth >= 0)
			{
				this.depth = depth;
			}
			else
				depth = 0;
		}
		
		public double calcArea()
		{
			return 6 * super.Area();
		}
		
		public double calcVolume()
		{
			return Math.pow(depth, 3);
		}
		
		public String toString() {
			return "The Plotted Coordinates of the Cube are: " + "[" + super.getXCord() + " " + super.getYCord() + "]" + 
		"\nThe Area of the Cube is: " + calcArea() + "\nThe Volume of the Cube is: " + calcVolume();
		}
		
	}
	

public class InheritanceTest {

	
	public static void main(String[] args) {
		Point Test = new Point(2,4);
		Square Test1 = new Square(4,7,3);
		Cube Test2 = new Cube(8,5,3,4);
		
		System.out.println(Test);
		System.out.println(Test1);
		System.out.println(Test2);

	}

}
