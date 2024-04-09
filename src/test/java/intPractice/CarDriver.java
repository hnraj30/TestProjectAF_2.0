package intPractice;

public class CarDriver {
	public static void main(String[]args)
	{
		Car c1= new Car("Benz","S6",5000000);
		c1.carDetails();
		System.out.println();
		Car c2= new Car("Audi","Q5");
		c2.carDetails();
	}

}
