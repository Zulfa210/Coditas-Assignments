import java.util.*;

public class Calculator{

//addition function 
public static int add(int a, int b)
{
	return a + b;
}

//subtraction function 
public static int subtract(int a, int b)
{
	return a - b;
}

//multiplication function 
public static int multiply(int a, int b)
{
	return a * b;
}

//division function 
public static int divide(int a, int b)
{
	return a / b;
}
}

class Main {

public static void main(String args[])
{
	int a = 7;
	int b = 5;

	System.out.println("Addition of a and b is "+ " " + Calculator.add(a,b));
	System.out.println("Subraction of a and b is "+ " " + Calculator.subtract(a,b));
	System.out.println("Multiplication of a and b is "+ " " + Calculator.multiply(a,b));
	System.out.println("Division of a and b is "+ " " + Calculator.divide(a,b));

 
}

}