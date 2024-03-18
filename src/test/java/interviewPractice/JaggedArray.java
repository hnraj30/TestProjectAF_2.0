package interviewPractice;

public class JaggedArray {
	public static void main(String[]args)
	{
		int a[][] = {{1,2,},{2,4,6,},{2,5,7,3,5}};
		
		for(int b[]:a)
		{
			for(int c:b)
			{
				System.out.print("  "+c);
			}
		System.out.println();
		
		}
		
		//Empty jagged Array
		System.out.println();

		int c[][] = new int[3][4];
		
		for(int x[]:c)
		{
			for(int y:x)
			{
				System.out.print("  "+y);
			}
			System.out.println();
		}
		
		//Jagged array of 3 rows
		System.out.println();

		int d[][] =new int[3][];
		d[0] = new int[1];
		d[1] = new int[2];
		d[2] = new int[3];
		for(int i[]:d)
		{
			for(int j:i)
			{
				System.out.print("  "+j);
			}
			System.out.println();
		}
		
		
	}

}
