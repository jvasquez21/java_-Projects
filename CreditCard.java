/*
  File: CreditCard.java
  
  Description: The program's purpose is to check the validity of a 15 or 16 digit credit card number by using 
               the Luhn's test and to identify the credit card.  
*/

import java.util.*;

public class CreditCard 
{
	// This method verifies if the credit card number is 15 or 16 digits long
	public static boolean cc_Length(long cc_num)
	{
		String cc_String = cc_num + "";
		
		if (cc_String.length() == 15 || cc_String.length() == 16)
		{
		  return true;
		}
		else
		    return false;							
	}
			
	// This method checks if a credit card number is valid	
	public static boolean is_valid(long cc_num)
	{
		int finalTotal = evenCC(cc_num) + oddCC(cc_num);
		
		if (finalTotal % 10 == 0)
		{
		  return true;
		}
		else
		    return false;				
	}
		  
	// This method finds the even elements and multiplies it by 2 and then it sums the even elements 
	public static int evenCC(long cc_num) 
	{
		long creditCard = cc_num / 10; // Removes the last digit
		int even = 0;
		int d0;

		while (creditCard > 0) 
		{	
		    d0 = (int) (creditCard % 10) * 2;	// Obtains the last digit	
		    even += doubleDigit(d0);
		    creditCard = creditCard / 100; // Removes last two digits to get an even position
		}
	  return even;
    }
	
	// This method finds and sum the odd elements  
	public static int oddCC(long cc_num) 
	{
		long creditCard = cc_num;
		int odd = 0;

		while (creditCard > 0) 
		{
			odd += (int) (creditCard % 10); // Obtains the last digit
			creditCard = creditCard / 100; // Removes the last two digits to get the next odd position
		}
		return odd;
	}
	
	//This method handles double digits from evenCC 
	public static int doubleDigit(int d0) 
	{
		int ddSum = 0;

		if (d0 < 10) 
		{
		  ddSum = d0;
		} 
		
		else 
			if (d0 >= 10)
		    { 
			  ddSum = (d0 % 10) + (d0 / 10); 
		    }

		return ddSum;
	}
	
	// This method checks the last digit
	public static boolean lastDigit(long cc_num)
	{
		String cc_String = cc_num + "";
		int d0 = (int)(cc_num % 10);
		
		if (d0 == cc_String.lastIndexOf(cc_String))
		{
		  return true;
		}
	   return false; 
	}
	
	// This method looks at the first credit card digit known as the Major Industry Identifier
	public static int mII(long cc_num)
	{
		String cc_String = cc_num + "";
		String first_Cc = cc_String.substring(0,1);
		int fCC = Integer.parseInt(first_Cc); // This converts a string to an integer value
		
		if (fCC == 3)
		{
		  return 3;
		}
		else 
			if (fCC == 4)
			{
			  return 4;
			}
			else 
				if (fCC== 5)
				{
				  return 5;
				}
				else 
					if (fCC== 6)
				    {
					  return 6;
				    }
		return 0;
	}

	// This method looks at the first six digits and returns the type of credit card
	public static String cc_type (long cc_num)
	{
		String cc_String = cc_num + "";
		String len = cc_String.substring(0,6); // This looks at the first six elements only
		int sixD = Integer.parseInt(len); // This converts a string to an integer value
		String type = " ";
		
			if (mII(cc_num) == 3 && ((sixD >= 340000 && sixD <= 349999) || (sixD >= 370000 && sixD <= 379999)))
			{
			  type = "American Express";
			}
			    else 
			    	if (mII(cc_num) == 6 && ((sixD >= 6011000 && sixD <= 6011999) || (sixD >= 644000 && sixD <= 644999)))
			    	{
			    	  type = "Discover";
			    	}
			    	else 
			    		if (mII(cc_num) == 5 && (sixD >= 500000 && sixD <= 559999))
			    		{
			    		  type = "MasterCard";
			    		}
			    		else
			    			if (mII(cc_num) == 4 && (sixD >= 400000 && sixD <= 499999))
			    			{
			    			  type = "Visa";
			    			}
			    			else
			    				return "";
		return type;
	}
	
	public static void main(String[] args)
	{
		// Create a Scanner
		Scanner sc = new Scanner(System.in);
		
		// Prompt the user to enter a credit card number
		System.out.print("Enter 15 or 16-digit credit card number: ");
		long cc_num = sc.nextLong();
		
		if(cc_Length(cc_num))
		{
		}
		else
		    {
			    System.out.println("\nNot a 15 or 16-digit number");
			    System.exit(0);   // Exits the program
		    }
		
		if (is_valid(cc_num) && lastDigit(cc_num))
		{
		  System.out.println("\nValid " + cc_type(cc_num) + " credit card number");
		}
		else
		    {
			    System.out.println("\nInvalid credit card number");
		    }			
	}
}
