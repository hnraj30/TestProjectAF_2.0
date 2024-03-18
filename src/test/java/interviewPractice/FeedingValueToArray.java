package interviewPractice;

import java.util.Scanner;

public class FeedingValueToArray {
	public static void main(String[]args)
	{
		System.out.println("Enter size of an array");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter elements of array one by one");
		for(int i=0;i<size;i++) 
		{
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Elements of array are as follows");
		for(int i=0;i<size;i++) 
		{
			System.out.print(arr[i]+"  ");;
		}
		
		//Finding smallest number in an array
		int smallestNum = arr[0];
		for(int i=0;i<size;i++) 
		{
			if(arr[i]<smallestNum)
			{
				smallestNum = arr[i];
			}
			
		}
		System.out.println("\nSmallest number = "+smallestNum);
		
		//Finding second smallest number in an array
		//int secondSmallestNum = arr[0];
		int temp = 0;
		for(int i=0;i<size;i++) 
		{
			for(int j=i+1;j<size;j++)
			{
				if(arr[i]>arr[j])
				{
					temp =arr[i];
					arr[i] = arr[j];
					arr[j] =temp;
				}
			}
			
			
		}
		System.out.println("\nSecond Smallest number = "+arr[1]);
		
		
	}

}
