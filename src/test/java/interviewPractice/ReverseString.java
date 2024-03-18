package interviewPractice;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class ReverseString {
	public static void main(String[]args)
	{
		String name = "Rajendra";
		int length = name.length();
		System.out.println("Length is "+length);
		System.out.println("Reverse of string "+name+ " is ");
		/*
		 for(int i=0;i<length;i++)
		{
			System.out.print(name.charAt(length-1-i));
		}
		*/
		for(int i=length-1;i>=0;i--)
		{
			System.out.print(name.charAt(i));
		}
		//Substrings of a string
		System.out.println();
		for(int j=0;j<=length;j++)
		{
			System.out.print(name.substring(0, j)+"  ");
		}	
		
		System.out.println();
		for(int j=0;j<length;j++)
		{
			System.out.print(name.substring(j+1, 8)+"  ");
		}	
	}

}
