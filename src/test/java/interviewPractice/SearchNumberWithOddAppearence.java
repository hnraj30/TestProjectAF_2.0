package interviewPractice;

public class SearchNumberWithOddAppearence {
	public static void main(String[]args)
	{
		int a[] = {1,2,2,3,4,3,4,1,3};
		int length = a.length;
		int count = 1;
		for(int i=0;i<length;i++)
		{
			
			//System.out.println(count);
			for(int j=i+1;j<length;j++)
			{
				if(a[i]==a[j])
				{
					System.out.println("count is: "+count);
					count++;
					System.out.println("count is: "+count);
				}
			}	
			if(count%2==1)
			{
				System.out.println(" number with Odd no. of appearence is: "+a[i]);
				i=length;
			}
			else
			{
				count=1;
			}
			
			
		}
		
		
	}

}
