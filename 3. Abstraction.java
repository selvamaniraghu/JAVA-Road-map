Abstraction

	- Abstraction is the process of hiding implementation details and showing only the essential features of an object.
		It is achieved using abstract classes and interfaces.
		Abstract classes can have both abstract and concrete methods, while interfaces define only the contract.
		Abstraction helps reduce complexity, improve maintainability, and promote a cleaner design.
	
	- In simple terms: We focus on what an object does, not how it does it.

		For example, when a user makes a payment through a PaymentService, they only call makePayment(). 
		They don't need to know the internal implementation of the bank, UPI, or card payment process.

	=> Abstract Class Example

		abstract class Vehicle {
		    abstract void start(); // abstract method (no body)
		    void fuelType() {      // concrete method
		        System.out.println("Uses petrol or diesel");
		    }
		}

		class Car extends Vehicle {
		    @Override
		    void start() {
		        System.out.println("Car starts with key ignition");
		    }
		}

		public class Main {
		    public static void main(String[] args) {
		        Vehicle obj = new Car();
		        obj.start();     // Car's implementation
		        obj.fuelType();  // Inherited concrete method
		    }
		}

	=> Benefits of Abstraction

		- Hides complex implementation details
		- Promotes loose coupling between components
		- Increases code flexibility and scalability
		- Makes maintenance and changes easier