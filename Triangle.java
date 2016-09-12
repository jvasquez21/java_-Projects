/*
  File: Triangle.java

  Description: The purpose of the program is to find the greatest path of sum in the triangle
*/

import java.io.File;
import java.io.*;
import java.util.*;

public class Triangle 
{	
	// This method finds the greatest sum of path starting from the bottom
	public static void SumOFPath(int [][] arr)
	{	
		for(int row = arr.length - 2; row >= 0; row--) // Starts from the second to the last row
			for(int column = 0; column < arr.length - 1; column++)
			{
			  arr[row][column] += Math.max(arr[row + 1][column], arr[row + 1][column + 1]);	
			}
		System.out.print("The greatest path sum is " + arr[0][0]);
	}
	
	/*public static int SumRecursion(int [][]arr, int i, int j)
	{
		if(i + 1 == arr.length - 1)
			return arr[i][j];  
			
			int s =  SumRecursion(arr, i + 1, j);
			int s1 = SumRecursion(arr, i + 1, j + 1);
			return Math.max(s, s1) + arr[i][j];
	}*/
	
	
	public static void main(String[] args) throws IOException
	{
		
	    int numArray = 0;
	    	
	    File inFile = new File ("triangle.txt"); // Reads the file
	    Scanner sc = new Scanner(inFile);
	        
	    String lineTxt = "";
	    String [] temp;
	       
	    numArray = Integer.parseInt(sc.nextLine()); //Reads the first line 
	    int [][] arr = new int [numArray][numArray];

	    for (int i = 0; i < arr.length; i++) //Reads from the second line and turns it into a 2-D array 
	    {
	        String temp1 = sc.nextLine();
	        temp = temp1.split("\\s+");
	    		for(int j = 0; j < temp.length; j++)
	    	    {              
	              arr[i][j] = Integer.parseInt(temp[j]);      
	            } 
	        }
	        SumOFPath(arr);
	        //SumRecursion(arr, 0, 0);
    }
}
	
	
	

