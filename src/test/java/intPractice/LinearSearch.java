package intPractice;

public class LinearSearch {
	public static void main(String[]args)
	{
		int []a = {1,8,2,9,4,7,3};
		System.out.println(searchInArray(a,9));
		
		
		
	}
	public static int searchInArray(int[] a,int b) 
	{
		for(int i=0;i<a.length;i++)
		{
			if (a[i]==b)
			{
				return i;
			}
		}
		return -1;
		
		
	}

}
