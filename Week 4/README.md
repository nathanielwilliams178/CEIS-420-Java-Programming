###### Weekly Project Overview
A company pays its employees on a weekly basis. The employees are of four types: Salaried 
employees are paid a fixed weekly salary regardless of the number of hours worked, hourly 
employees are paid by the hour and receive overtime pay (i.e., 1.5 times their hourly salary rate) 
for all hours worked in excess of 40 hours, commission employees are paid a percentage of their 
sales and base-salaried commission employees receive a base salary plus a percentage of their 
sales. For the current pay period, the company has decided to reward salaried-commission 
employees by adding 10% to their base salaries. The company wants to write an application that 
performs its payroll calculations polymorphically.

###### Step 1: Class Employee 
We use abstract class Employee to represent the general concept of an employee. The classes 
that extend Employee are SalariedEmployee, CommissionEmployee and HourlyEmployee. Class 
BasePlusCommissionEmployee—which extends CommissionEmployee— represents the last 
employee type. The UML class diagram above shows the inheritance hierarchy for our 
polymorphic employee-payroll application. Abstract class name Employee is italicized—a 
convention of the UML.
Abstract superclass Employee declares the “interface” to the hierarchy—that is, the set of 
methods that a program can invoke on all Employee objects. We use the term “interface” here in 
a general sense to refer to the various ways programs can communicate with objects of any 
Employee subclass. Each employee, regardless of the way his or her earnings are calculated, has 
a first name, a last name and a social security number, so private instance variables firstName, 
lastName and socialSecurityNumber appear in abstract superclass Employee.

###### Step 2: Class SalariedEmployee
Class SalariedEmployee extends class Employee and overrides abstract method earnings, which 
makes SalariedEmployee a concrete class. The class includes a constructor that takes a first 
name, a last name, a social security number and a weekly salary as arguments; a set method to 
assign a new nonnegative value to instance variable weeklySalary; a get method to return 
weeklySalary’s value; a method earnings to calculate a SalariedEmployee’s earnings; and a 
method toString, which returns a String including the employee’s type, namely, "salaried 
employee: " followed by employeespecific information produced by superclass Employee’s 
toString method and SalariedEmployee’s getWeeklySalary method. Class SalariedEmployee’s 
constructor passes the first name, last name and social security number to the Employee 
constructor to initialize the private instance variables not inherited from the superclass. Method 
earnings overrides Employee’s abstract method earnings to provide a concrete implementation 
that returns the SalariedEmployee’s weekly salary. If we do not implement earnings, class 
SalariedEmployee must be declared abstract—otherwise, class SalariedEmployee will not 
compile. Of course, we want SalariedEmployee to be a concrete class.

###### Step 3: Class HourlyEmployee
Class HourlyEmployee also extends Employee. The class includes a constructor that takes as 
arguments a first name, a last name, a social security number, an hourly wage and the number of 
hours worked. Declare set methods that assign new values to instance variables wage and hours, 
respectively. Method setWage needs to ensures that wage is nonnegative, and method setHours 
needs to ensures that hours is between 0 and 168 (the total number of hours in a week) inclusive. 
Class HourlyEmployee also includes get methods to return the values of wage and hours, 
respectively; a method earnings to calculate an HourlyEmployee’s earnings; and a method 
toString, which returns a String containing the employee’s type ("hourly employee: ") and the 
employee-specific information. The HourlyEmployee constructor, like the SalariedEmployee 
constructor, passes the first name, last name and social security number to the superclass 
Employee constructor to initialize the private instance variables. In addition, method toString 
calls superclass method toString to obtain the Employee-specific information (i.e., first name, 
last name and social security number)—this is another nice example of code reuse.

###### Step 4: Class CommissionEmployee
Class CommissionEmployee extends class Employee. The class includes a constructor that takes 
a first name, a last name, a social security number, a sales amount and a commission rate; set 
methods to assign new values to instance variables commissionRate and grossSales, respectively; 
get methods that retrieve the values of these instance variables; method earnings to calculate a 
CommissionEmployee’s earnings; and method toString, which returns the employee’s type, 
namely, "commission employee: " and employee-specific information. The constructor also 
passes the first name, last name and social security number to Employee’s constructor to 
initialize Employee’s private instance variables. Method toString calls superclass method 
toString to obtain the Employee-specific information (i.e., first name, last name and social 
security number).

###### Step 5: Class BasePlusCommissionEmployee
Class BasePlusCommissionEmployee extends class CommissionEmployee and therefore is an 
indirect subclass of class Employee. Class BasePlusCommissionEmployee has a constructor that 
takes as arguments a first name, a last name, a social security number, a sales amount, a 
commission rate and a base salary. It then passes all of these except the base salary to the 
CommissionEmployee constructor to initialize the inherited members. 
BasePlusCommissionEmployee also contains a set method to assign a new value to instance 
variable baseSalary and a get method to return baseSalary’s value. Method earnings calculates a 
BasePlusCommissionEmployee’s earnings. BasePlusCommissionEmployee’s toString method 
creates a String representation of a BasePlusCommissionEmployee that contains "base-salaried", 
followed by the String obtained by invoking superclass CommissionEmployee’s toString method 
(example of code reuse), then the base salary. The result is a String beginning with "base-salaried 
commission employee" followed by the rest of the BasePlusCommissionEmployee’s 
information. Recall that CommissionEmployee’s toString obtains the employee’s first name, last 
name and social security number by invoking the toString method of its superclass (i.e., 
Employee)—yet another example of code reuse. BasePlusCommissionEmployee’s toString 
initiates a chain of method calls that span all three levels of the Employee hierarchy.

###### Step 6: Class PayrollSystemTest
To test our Employee hierarchy, the application creates an object of each of the four concrete 
classes SalariedEmployee, HourlyEmployee, CommissionEmployee and 
BasePlusCommissionEmployee. The program manipulates these objects nonpolymorphically, 
via variables of each object’s own type, then polymorphically, using an array of Employee 
variables. While processing the objects polymorphically, the program increases the base salary of 
each BasePlusCommissionEmployee by 10%—this requires determining the object’s type at 
execution time. Finally, the program polymorphically determines and outputs the type of each 
object in the Employee array. Go ahead create objects of each of the four concrete Employee 
subclasses. Display the String representation and earnings of each of these objects 
nonpolymorphically. Each object’s toString method is called implicitly by printf when the object 
is output as a String with the %s format specifier.
