package intPractice;

public class Car {
	String brand;
	String model;
	double price;
	Car()
	{
		
	}
	
	Car(String brand)
	{
		this();
		this.brand=brand;
	}
	
	Car(String brand,String model)
	{
		this(brand);
		this.model=model;
	}

	Car(String brand,String model,double price)
	{
		this(brand,model);
		this.price=price;
	}

	public void carDetails()
	{
		System.out.println("Brand: "+ this.brand);
		System.out.println("Model: "+ this.model);
		System.out.println("Price: "+ this.price);
	}

}

