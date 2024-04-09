package intPractice;

public class DemoProgram
{


	public static void demo(String s1)
	{
		System.out.println(s1);
		
	}
	
	public static void demo(String s1,int i1)
	{
		System.out.println(s1);
		System.out.println(i1);
	}

public static void main(String[]args)
{
	int i1=10;
	String s1 = "Rajendra";

	demo(s1);
	demo(s1,i1);

}	

}