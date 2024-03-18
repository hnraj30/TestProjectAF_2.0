package interviewPractice;

import java.util.Arrays;

public class BubbleSort{
	public static void main(String[]args)
	{
		int[]a = {1,4,6,3,9};
		//Arrays.sort(a);
		
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+"  ");
		}
		System.out.println();
		int temp=0;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length-1;j++)
			{
				if(a[j]>a[j+1])
				{
					temp =a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+"  ");
		}
		
	}
	
	
	
	

}
