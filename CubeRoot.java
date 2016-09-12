/*
  File: CubeRoot.java

  Description: The purpose of this program is to the use binary search algorithm to find the cube root
*/

import java.util.*;

public class CubeRoot 
{
	// This method uses the binary search algorithm to find the cube root
	public static double cubeRoot(double numPos)
	{
		double low = 0;
		double high = 0;
		double mid = 0;
		double precision =  0.000001;
		
		if (numPos > 0 && numPos < 1) // Determining what is low and high because the algorithm is affected by a certain range
		{
			low = numPos;
			high = 1.;
		}
		else 
			if (numPos >= 1)
			{
				low = 1.;
				high = numPos;
			}
		while (low <= high) // Binary search algorithm
		{
			mid = (low + high) / 2.;
			if ((Math.abs((mid * mid * mid) - numPos)) <= precision)
				break;
			else 
				if (mid * mid * mid < numPos)
				{
				    low = mid;
				}
			else
			{
				high = mid;
			}
		}
		return (int)(mid * 10000) / 10000.0; // Sets the cube root to four decimals places
	}
	
	public static void main(String[] args) 
	{
		// Create a Scanner
		Scanner sc = new Scanner(System.in);
		
		// Prompt the user to enter a positive number
		System.out.print("Enter a positive number: ");
	
		for(int i = 0; i < 100; i++)
		{
			double numPos = sc.nextDouble();
			
			if(numPos >= 0) // Ensuring the values are positive
			{
				if (numPos > 0 && numPos < 1) // Outputting purposes
				{
					System.out.println("\nCube root of " + numPos + ": " + cubeRoot(numPos));
				}
				else 
					if (numPos > 1)
					{
						System.out.println("\nCube root of " + (int)numPos + ": " + cubeRoot(numPos));
					}			
				
				double diff = Math.abs(cubeRoot(numPos) - Math.pow(numPos, 1./3.));
				
				System.out.printf("\nDifference of Calculated Cube Root - Actual Cube Root: %.8f", diff); 
			}
			else
			{
				System.out.print("\nEnter a positive number: ");
			}	
		}
	}
}
