package intPractice;

public class ExceptionHandling {
	public static void main(String[]args) throws InterruptedException
	{
		int a=10;
		int b=0;
		
		try
		{
			int result = a/b;
			System.out.println("Result: "+result);
		}
		catch(Exception e)
		{
			System.out.println("Exception handled");
		}
		
		Thread.sleep(1000);
		String s1 = "Rajendra";
		try
		{
			System.out.println("Charactor at given Index is: '"+s1.charAt(0)+"'");

		}
		
		catch(Exception e)
		{
			System.out.println("Exception handled");

		}
		
	}
	

}
