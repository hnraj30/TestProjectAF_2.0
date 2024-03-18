package interviewPractice;

public class LengthOfString {
	public static void main(String[]args)
	{
		String name = "Rajendra N H";
		int length = name.length();
		
		//Length of string
		int count = 0;
		for(int i=0;i<length;i++)
		{
			count++;
		}
		System.out.println("Length of string '"+name+"' is " + count);		
		
		String stringWithoutSpaces = name.replace(" ", "");
		System.out.println(stringWithoutSpaces);
		int length2 = stringWithoutSpaces.length();
		int numOfSpaces = length-length2;
		System.out.println(numOfSpaces);
		
	}

}
