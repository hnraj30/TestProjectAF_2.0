package interviewPractice;

public class StringPrograms {
	public static void main(String[]args)
	{
		String str = "Rajendra";
		char[] ch = str.toCharArray();
		
		for(char n:ch) 
		{
			System.out.println(n);
		}
		boolean value = str.contains("Raje");
		System.out.println(value);
		
		String str2 = "Rajendra";
		String[] arr = str2.split("is");
		for(String n:arr) 
		{
			System.out.println(n);
		}
		
		boolean value2 = (str==str2);
		System.out.println(value2);
		
		
	}

}
