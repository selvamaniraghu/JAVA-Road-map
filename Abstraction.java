Abstraction

	- Abstraction is the process of hiding implementation details and showing only the essential features of an object.
	- In simple terms: You focus on what an object does, not how it does it.

	=> Real-World Analogy
		Think of a car:
			- You use the steering wheel, accelerator, and brakes (what it does)
			- You don’t see the internal engine or fuel combustion process (how it works)
		That’s abstraction in action.

	=> How Abstraction is Achieved in Java	

	| Approach         | Keyword/Concept     | Key Points                                                                          |
	| ---------------- | ------------------- | ----------------------------------------------------------------------------------- |
	| Abstract Classes | `abstract` keyword  | Can have both abstract and concrete (implemented) methods                           |
	| Interfaces       | `interface` keyword | 100% abstract (till Java 7), can have `default` and `static` methods (since Java 8) |
	

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

	=> Interface Example (Modern Java)

	interface Payment {
	    void pay(double amount); // abstract method

	    default void displayMessage() { // default method (Java 8+)
	        System.out.println("Payment in process...");
	    }
	}

	class UPI implements Payment {
	    public void pay(double amount) {
	        System.out.println("Paid ₹" + amount + " via UPI");
	    }
	}

	public class Test {
	    public static void main(String[] args) {
	        Payment p = new UPI();
	        p.displayMessage();
	        p.pay(500);
	    }
	}

	=> Key Differences: Abstract Class vs Interface

	| Feature     | Abstract Class                            | Interface                                        |
	| ----------- | ----------------------------------------- | ------------------------------------------------ |
	| Keyword     | `abstract class`                          | `interface`                                      |
	| Methods     | Can have both abstract & concrete methods | Abstract by default (default/static from Java 8) |
	| Variables   | Can have instance variables               | Variables are `public static final` by default   |
	| Inheritance | Supports single inheritance               | Supports multiple inheritance                    |
	| Use Case    | Common base with shared code              | Define contract for implementation               |

	=> Benefits of Abstraction
	- Hides complex implementation details
	- Promotes loose coupling between components
	- Increases code flexibility and scalability
	- Makes maintenance and changes easier

	=> Summary
	“Abstraction in Java means hiding the implementation details and exposing only the essential functionalities.
	It is achieved using abstract classes and interfaces.
	Abstract classes can have both abstract and concrete methods, while interfaces define only the contract.
	Abstraction helps reduce complexity, improve maintainability, and promote a cleaner design.
	For example, a car class hides how the engine works — we just call start().”

	