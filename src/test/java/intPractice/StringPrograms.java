package intPractice;

import java.util.stream.IntStream;

public class StringPrograms {
	public static void main(String[]args)
	{
		String str = "   Rajendra";
		String str2 = "Rajendra";
		char[] ch = str.toCharArray();
		
		for(char n:ch) 
		{
			System.out.println(n);
		}
		boolean value = str.contains("Raje");
		System.out.println(value);
		
		
		String[] arr = str2.split("a");
		for(String n:arr) 
		{
			System.out.println(n);
		}
		
		boolean value2 = (str==str2);
		System.out.println(value2);

		boolean value3 = (str.equals(str2));		
		System.out.println(value3);
		
		char charactor = str.charAt(0);
		System.out.println(charactor);
		
		IntStream chars = str.chars();
		System.out.println(chars);

		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		System.out.println(str.indexOf("j"));
		System.out.println(str.concat(str2));
		System.out.println(str.equalsIgnoreCase(str2));
		System.out.println(str.isEmpty());
		System.out.println(str.length());
		System.out.println(str.lastIndexOf("nd"));
		System.out.println(str.replace('R', 'r'));
		//Reverse string
		String  rev ="";
		for(int i=str.length()-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
		}
		System.out.println(rev);
		
		System.out.println(str==str2);
		System.out.println(str.equalsIgnoreCase(str2));
		System.out.println(str.compareTo(str2));
		System.out.println(str.trim());
		
		
		
	
	//String Buffer excercises
	System.out.println("---------------------String Buffer excercises----------------------------");
	StringBuffer sb1,sb2;
	sb1 = new StringBuffer("Himalayan");
	//sb2 = new StringBuffer("Himalayan");
	sb2=sb1;
	System.out.println(sb1==sb2);
	System.out.println(sb1.equals(sb2));
	

	
	
	}

}
