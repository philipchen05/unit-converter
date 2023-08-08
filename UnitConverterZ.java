/* Name: Philip Chen
Teacher: Mr. Guglielmi
Date: October 20, 2020
Assignment: Using conditional statements and try/catch blocks to handle exceptions and logical input errors
*/
import hsa.Console;

// UnitConverterZ class
public class UnitConverterZ
{
    // declaration statements
    // c; instance variable for Console object
    // from; stores user String input for what unit to convert from
    // to; stores user String input for what unit to convert to
    // num; stores double amount to convert
    // amount; stores user String input for what amount to convert that is parsed into type double for valid double input check
    // convertedNum; stores double value of converted result
    private Console c;
    private String from;
    private String to;
    private double num;
    private String amount;
    private double convertedNum;
    
    // UnitConverterZ class constructor; creates new Console object for output display
    public UnitConverterZ()
    {
	c = new Console("Unit Converter");
    }
    
    
    // title method; prints program title
    private void title()
    {
	c.print(' ',32);
	c.println("Unit Converter");
	c.println();
    }
    
    
    // intro method; prints program introduction
    public void intro()
    {
	c.println("Welcome to the Unit Converter!");
	c.println("This program converts weights between grams, pounds, and kilograms.");
	c.println("(Press any key to continue)");
	c.getChar();
    }
    
    
    // askData method; prompts user for units and amount to convert and stores input results as variables
    public void askData()
    {        
	while(true)
	{
	    // run; stores boolean value for controlling error handling loops
	    boolean run = true;
	    
	    c.clear();
	    
	    // prompts for what unit to convert from
	    while(run)
	    {                
		c.println("What unit will you be converting from?");
		from = c.readLine();
		if(!from.equals("grams") && !from.equals("pounds") && !from.equals("kilograms"))
		{
		    c.clear();
		    c.println("Invalid unit. Please enter a valid unit.");
		}
		else
		{
		    run = false;
		}
	    }
	    run = true;
	    
	    // prompts for what unit to convert to
	    while(run)
	    {
		c.println("What unit will you be converting to?");
		to = c.readLine();
		if(to.equals(from))
		{
		    c.clear();
		    c.println("What unit will you be converting from?");
		    c.println(from);
		    c.println("Unit cannot be the same as unit being converted from. Please enter a valid unit.");
		}
		else if(!to.equals("grams") && !to.equals("pounds") && !to.equals("kilograms"))
		{
		    c.clear();
		    c.println("What unit will you be converting from?");
		    c.println(from);
		    c.println("Invalid unit. Please enter a valid unit");
		}
		else
		{
		    run = false;
		}
	    }
	    run = true;
	    
	    // prompts for what amount to convert
	    while(run)
	    {
		c.println("Enter amount in " + from + ": ");
		try
		{
		    amount = c.readLine();
		    num = Double.parseDouble(amount);
		    run = false;
		}
		catch(Exception e)
		{
		    c.clear();
		    c.println("What unit will you be converting from?");
		    c.println(from);
		    c.println("What unit will you be converting to?");
		    c.println(to);
		    c.println("Invalid amount. Please enter a valid amount.");
		}
	    }
	    
	    c.println();
	    display();
	}
    }
    
    
    // display method; calculates converted result and prints final output statement with converted result
    public void display()
    {
	// conversion calculation
	if(from.equals("grams") && to.equals("pounds"))
	{
	    convertedNum = num * 0.00220462;
	}
	else if(from.equals("grams") && to.equals("kilograms"))
	{
	    convertedNum = num * 0.001;
	}
	else if(from.equals("pounds") && to.equals("grams"))
	{
	    convertedNum = num * 453.592;
	}
	else if(from.equals("pounds") && to.equals("kilograms"))
	{
	    convertedNum = num * 0.453592;
	}
	else if(from.equals("kilograms") && to.equals("grams"))
	{
	    convertedNum = num * 1000;
	}
	else if(from.equals("kilograms") && to.equals("pounds"))
	{
	    convertedNum = num * 2.20462;
	}
	
	// output statement with converted result
	c.print(num + " " + from + " = ");
	c.print(convertedNum,0,2);
	c.println(" " + to);
	c.println();
	
	pauseProgram();
    }
    
    
    // pauseProgram method; pauses program and asks user whether they wish to continue or exit loop
    private void pauseProgram()
    {
	// loop; stores user String input for program loop control
	// ask; stores boolean value for method local loop control
	String loop;
	boolean ask = true;
	
	while(ask)
	{
	    c.println("Program paused. Would you like to convert another number?");
	    loop = c.readLine();
	    if(loop.equals("yes"))
	    {
		c.println();
		from = "";
		to = "";
		num = 0;
		amount = "";
		convertedNum = 0;
		ask = false;
	    }
	    else if(loop.equals("no"))
	    {
		c.clear();
		goodbye();
	    }
	    else
	    {
		c.clear();
		c.println("Invalid response. Please enter a valid response.");
	    }
	}
    }
    
    
    // goodbye method; displays program exit screen
    public void goodbye()
    {
	c.println("Exited program.");
	c.println("Thank you for using the Unit Converter.");
	c.println("Goodbye!");
	c.println("(Press any key to quit)");
	c.getChar();
	System.exit(0);
    }
    
    
    // main method; executes program
    public static void main(String[] args)
    {
	UnitConverterZ u = new UnitConverterZ();
	u.title();
	u.intro();
	u.askData();
    }
}
