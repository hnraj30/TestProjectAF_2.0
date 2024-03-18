package interviewPractice;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TwoDArray {
	public static void main(String[]args) 
	{
		//int a[][] = {{1,2,3,},{2,4,6,}};
		
		int a[][]= new int[3][3];
		a[0][0] = 1;
		a[1][1] = 2;
		a[2][2] = 3;
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print("  "+ a[i][j]);
			}
			System.out.println();
			SoftAssert sa = new SoftAssert();
		}
	}

}
