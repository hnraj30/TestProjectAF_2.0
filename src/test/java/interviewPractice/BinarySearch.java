package interviewPractice;

public class BinarySearch {
	
	public static void main(String[]args)
	{
		int[]a = {1,4,5,7,9,11,22};
		
		System.out.println(search(a,5));
		
	}
	public static int search(int[]a,int s)
	{
		int start=0;
		int end = a.length-1;
		
		while(start<=end)
		{
			int mid = (start+end)/2;
			if(s==a[mid])
			{
				return mid;
			}
			else if(s<a[mid])
			{
				end=mid-1;
			}
			else
			{
				start=mid+1;
			}
			
		}
		return -1;
		
		
		
	}

}
