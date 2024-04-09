package intPractice;

import java.util.ArrayList;

public class ArrayTranspose {

	public static void main(String[] args) 
	{
		int a[][] = {{1,2,3},{2,4,6},{3,6,9}};
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print("  "+a[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print("  "+a[j][i]);
			}
			System.out.println();
		}
		
		//for handling heterogeneous elements
		//ArrayList al =new ArrayList();
		
		
	}

}
