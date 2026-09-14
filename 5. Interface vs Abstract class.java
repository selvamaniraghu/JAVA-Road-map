Interface vs Abstract class

	An abstract class is used when we want to share common code and state among related classes. It can have both abstract and concrete methods, 
	instance variables, and constructors, but it supports only single inheritance.

	An interface is used to define a contract. It supports multiple inheritance and promotes loose coupling. Interfaces cannot hold state, 
	but since Java 8 they can have default and static methods.

	In practice, we use abstract classes for base implementations and interfaces for defining behavior across unrelated classes.”

	=> Abstract Class Example

		abstract class Vehicle {
		    int speed; // instance variable

		    abstract void start(); // abstract method

		    void stop() {           // concrete method
		        System.out.println("Vehicle stopped");
		    }
		}

		class Car extends Vehicle {
		    void start() {
		        System.out.println("Car starts with key");
		    }
		}

		public class Test {
		    public static void main(String[] args) {

		        Vehicle v;     // abstract class reference
		        v = new Car(); // object of child class

		        v.start();
		    }
		}

	=> Interface Example

		interface Payment {
		    int MAX_LIMIT = 10000; // public static final by default
		    // public → accessible everywhere
			// static → belongs to the interface, not to objects
			// final → value cannot be changed (constant)

		    void pay(double amount); // public abstract by default

		    default void status() {  // Java 8+
		        System.out.println("Payment in progress");
		    }
		}

		class UPI implements Payment {
		    public void pay(double amount) {
		        System.out.println("Paid ₹" + amount + " via UPI");
		    }
		}

		class CreditCard implements Payment {
		    public void pay(double amount) {
		        System.out.println("Paid ₹" + amount + " using Credit Card");
		    }
		}

		// loose coupling example
		// The Main class only depends on the interface Payment, not on UPI or CreditCard.
		public class Main {
		    public static void main(String[] args) {

		        Payment p; // interface reference

		        p = new UPI(); // object of implementing class
		        p.pay(1000);

		        p = new CreditCard();
		        p.pay(2000);
		    }
		}

		//state
		 	State means variables that store data.

		// loose coupling
			Loose coupling means reducing the dependency between classes. 
			When using an interface, the main program depends on the interface, not on a specific class implementation. 
			This allows you to change implementations without changing the main code.

		// static method example
			interface Payment {
			    static void rules() {
			        System.out.println("Follow payment rules");
			    }
			}

			- You must call it using the interface name.
			- Payment.rules();
			- You cannot call it using an object.

		//contract
			Any class using Payment must provide a pay() method. otherwise throw error (UPI is not abstract and does not override abstract method pay(double))

	=> When to Use What?

		Use Abstract Class when:

			- We want to share code among related classes
			- We need constructors
			- We want to maintain state
			- We expect subclasses to be closely related

		Use Interface when:

			- We want to define a contract
			- Multiple classes need the same behavior
			- We need multiple inheritance
			- We want loose coupling (e.g., APIs, services)
			- Classes are unrelated
			- We want support for lambda expressions (functional interfaces)

	=> Java 8+ Special Points (Often Asked)

		| Feature              | Abstract Class  | Interface                  |
		| -------------------- | --------------  | -------------------------- |
		| Default Methods      | Not needed  	 |  Yes                       |
		| Static Methods       | Yes          	 |  Yes                       |
		| Functional Interface | No              |  (Single abstract method)  |
		| Lambda Support       | No              | 	Yes                       |


	=> Spring Boot Interview One-Minute Answer
			
			“Spring Boot heavily uses abstraction through interfaces to achieve loose coupling, dependency injection, and easy testing. 
			Controllers depend on service interfaces, repositories are interfaces implemented at runtime by Spring, 
			and multiple implementations can be swapped without changing business logic. 
			This design follows SOLID principles and makes applications scalable and maintainable.”
