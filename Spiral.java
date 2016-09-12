/*
  File: Spiral.java

  Description: The programs purpose is to search the square spiral and return it's neighboring numbers into three lines of code 
 */

import java.util.*;

public class Spiral 
{
	// This methods constructs the spiral depending on the dimensions and searches for the number in the spiral 
	public static void arraySpiral(int dimension, int nSpiral)
	{
	    int[][] spiralArray = new int[dimension][dimension];
	 
	    int numSpiral = (int) Math.ceil((dimension) / 2.0);
	 
	    int j;
	    int lenSpiral = dimension;
	    int squaredDim = (int) Math.pow(dimension, 2);
	 
	    for (int i = 0; i <= numSpiral; i++) // The for loops places the elements in the array starting from the squaredDim 
	    {
	      for (j = lenSpiral - 1; j >= 0; j--) 
	      {
	        spiralArray[i][i + j] = squaredDim--; 
	      }
	      
	      for (j = 1; j < lenSpiral; j++) 
	      {
	        spiralArray[i + j][i] = squaredDim--;
	      }
	      
	      for (j = 1; j < lenSpiral; j++) 
	      {
	        spiralArray[dimension - 1 - i][i + j] = squaredDim--;
	      }
	      
	      for (j = lenSpiral - 2; j > 0; j--) 
	      {
	        spiralArray[i + j][dimension - 1 - i] = squaredDim--;
	      }
	 
	      lenSpiral -= 2;
	    }
	     
	    int [][] searchSpiral = new int [3][3];
	   
    	for (int k = 0; k < spiralArray.length; k++) // Using a sequential searching to extract the specified the number in the spiral
    	{
    		for (int m = 0; m < spiralArray.length; m++)
    		{
    			if (spiralArray[k][m] == nSpiral)
    			{
    				
    				if (k == 0 || k == dimension - 1 || m == 0 || m == dimension - 1) // Avoids the outer edges of the spiral
    				{
    					System.out.println("Number on Outer Edge");
    					System.exit(0);// Exits the program
    				}
    				else 
    					{
    					    searchSpiral[0][0] = spiralArray[k - 1][m - 1]; // This places the elements in the searchSpiral 3 X 3 array
    					    searchSpiral[0][1] = spiralArray[k - 1][m];
    					    searchSpiral[0][2] = spiralArray[k - 1][m + 1];
    			    
    					    searchSpiral[1][0] = spiralArray[k][m - 1];
    					    searchSpiral[1][1] = spiralArray[k][m];
    					    searchSpiral[1][2] = spiralArray[k][m + 1];
    				
    					    searchSpiral[2][0] = spiralArray[k + 1][m - 1];
    					    searchSpiral[2][1] = spiralArray[k + 1][m];
    					    searchSpiral[2][2] = spiralArray[k + 1][m + 1];
    					}
    			}						
    		}
    	}
	    pSpiral(searchSpiral);
	  }
	
	// This method prints the spiral from the arraySpiral method
	public static void pSpiral(int [][] array) 
    {
	    for (int[] spiral : array) 
	    {
	      for (int infiniteSpiral: spiral) 
	      {
	        System.out.printf("%3d"+"",  infiniteSpiral);
	      }
	      System.out.println();
	    }
    }
	
	public static void main(String[] args) 
	{
		// Create a scanner
		Scanner sc = new Scanner(System.in);
		
		// Prompt the user to enter dimensions
		System.out.print("Enter dimension: ");
		int dimension = sc.nextInt();
		
		if (dimension % 2 != 0)
		{
		}
		else 
			dimension+=1;
		
		// Prompt the user to enter a number in the spiral 
		System.out.print("Enter number in spiral: ");
		int nSpiral = sc.nextInt();
		
		if (nSpiral >= 1 && nSpiral <= Math.pow(dimension, 2))
		{
			arraySpiral(dimension, nSpiral);
		}
		else 
			if (!(nSpiral >= 1 && nSpiral <= Math.pow(dimension, 2)))
			{
				System.out.println("Number not in Range");
			}
	}

}
