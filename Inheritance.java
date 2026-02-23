Inheritance

	* Inheritance is one of the core concepts of Object-Oriented Programming (OOP).
	* It allows a class (child/subclass) to inherit fields and methods from another class (parent/superclass).

	This helps in:
		- Code reusability (no need to rewrite existing logic)
		- Extensibility (add or override behavior)
		- Maintainability (common behavior in one place)

	Syntax:
	class Parent {
    	// parent class members
	}

	class Child extends Parent {
	    // child class members
	}

	Here, Child inherits all accessible members (fields, methods) from Parent.

	Example:
	// Parent class
	class Vehicle {
	    String brand = "Ford";

	    void start() {
	        System.out.println("Vehicle is starting...");
	    }
	}

	// Child class
	class Car extends Vehicle {
	    int wheels = 4;

	    void display() {
	        System.out.println("Brand: " + brand);
	        System.out.println("Wheels: " + wheels);
	    }
	}

	// Main class
	public class Main {
	    public static void main(String[] args) {
	        Car car = new Car();
	        car.start();   // inherited method
	        car.display(); // own method
	    }
	}

	=> Types of Inheritance in Java
	
	| Type             | Description                                                                                                     | Example          |
	| ---------------- | --------------------------------------------------------------------------------------------------------------- | ---------------- |
	| Single       	   | One class inherits another                                                                                      | `A -> B`         |
	| Multilevel       | A class is derived from another derived class                                                                   | `A -> B -> C`    |
	| Hierarchical     | Multiple classes inherit the same parent                                                                        | `A -> B, A -> C` |
	| Multiple         | Java does not support multiple inheritance with classes (to avoid ambiguity). But it’s possible via interfaces. |                  |

	=> Key Points
	1. Constructors are not inherited, but the parent constructor is automatically called (via super()).
	2. You can override parent methods in the child class to provide a specific implementation.
	3. Access modifiers affect what is inherited:
		private → not inherited
		protected, public → inherited
		default → inherited only within the same package
	4. You can call parent members using super:
		super.methodName();
		super.variableName;
	5. Avoids code duplication and supports polymorphism

	=> Example of Method Overriding

	class Animal {
	    void sound() {
	        System.out.println("Animal makes a sound");
	    }
	}

	class Dog extends Animal {
	    @Override
	    void sound() {
	        System.out.println("Dog barks");
	    }
	}

	public class Test {
	    public static void main(String[] args) {
	        Animal a = new Dog();
	        a.sound(); // Output: Dog barks
	    }
	}

	//This is also an example of runtime polymorphism using inheritance.

	1. Why doesn’t Java support multiple inheritance with classes?
		To avoid ambiguity known as the “diamond problem.” If two parent classes have the same method, the compiler won’t know which one to inherit.

	2. Difference between extends and implements
		* extends → for class inheritance
		* implements → for interface implementation

	=> Inheritance Hierarchy Diagram

	        ┌─────────────┐
	        │   Vehicle   │   ← Superclass / Parent
	        └─────┬───────┘
	              │
	   ┌──────────┴──────────┐
	   │                     │
	┌───────┐           ┌────────┐
	│  Car  │           │  Bike  │  ← Subclasses / Child classes
	└───────┘           └────────┘

	Explanation:
		- Both Car and Bike inherit the common properties and behavior from Vehicle.
		- Each subclass can add or override functionality as needed.

	Code Snippet Example

	class Vehicle {
	    void start() {
	        System.out.println("Vehicle is starting...");
	    }
	}

	class Car extends Vehicle {
	    void honk() {
	        System.out.println("Car horn: Beep Beep!");
	    }
	}

	class Bike extends Vehicle {
	    void kickStart() {
	        System.out.println("Bike started with a kick!");
	    }
	}

	public class Main {
	    public static void main(String[] args) {
	        Car car = new Car();
	        car.start();  // inherited
	        car.honk();   // own method

	        Bike bike = new Bike();
	        bike.start();     // inherited
	        bike.kickStart(); // own method
	    }
	}

	=> Multiple Inheritance via Interfaces

	      ┌──────────────┐       ┌──────────────┐
	      │  Interface A │       │  Interface B │
	      └──────┬───────┘       └──────┬───────┘
	             │                       │
	             └──────────┬────────────┘
	                        │
	                ┌───────────────┐
	                │   Class C     │
	                └───────────────┘

	- Java does not allow multiple inheritance with classes to avoid ambiguity (the diamond problem).

	- But it allows a class to implement multiple interfaces, since interfaces only contain abstract methods (no implementation conflict).

	- The implementing class provides its own method definitions — so there’s no ambiguity.


	=> Code Example

	interface A {
	    void showA();
	}

	interface B {
	    void showB();
	}

	// Class implementing both interfaces
	class C implements A, B {
	    public void showA() {
	        System.out.println("Interface A method");
	    }

	    public void showB() {
	        System.out.println("Interface B method");
	    }
	}

	public class Main {
	    public static void main(String[] args) {
	        C obj = new C();
	        obj.showA();
	        obj.showB();
	    }
	}

	Notes :
	- A class can extend only one class, but implement multiple interfaces.
	- Syntax:
		class Child extends Parent implements Interface1, Interface2 { ... }
	- If two interfaces have the same default method, the class must override it to resolve the conflict.
	- Interfaces support multiple inheritance safely because they don’t contain state or conflicting implementations (before Java 8).

	=> Java 8 and Default Methods in Interfaces

	* What Changed

		Before Java 8, interfaces could only have abstract methods — no method body.
		From Java 8 onward, interfaces can include:
			- Default methods (with implementation)
			- Static methods
		This allowed Java to add new functionality to existing interfaces without breaking the classes that implement them.

	=> The Problem: Multiple Inheritance Conflict
		If a class implements two interfaces that both define a default method with the same signature, the compiler gets confused — it doesn’t know which one to use.
		That’s the diamond problem reappearing through interfaces.

	Example

	interface A {
	    default void show() {
	        System.out.println("Interface A default method");
	    }
	}

	interface B {
	    default void show() {
	        System.out.println("Interface B default method");
	    }
	}

	// Class implements both interfaces
	class C implements A, B {
	    // Must override show() to resolve conflict
	    @Override
	    public void show() {
	        // We can choose one or customize
	        A.super.show(); // explicitly call A's version
	        System.out.println("Class C custom method");
	    }
	}

	public class Main {
	    public static void main(String[] args) {
	        C obj = new C();
	        obj.show();
	    }
	}


	Key points

	| Concept        | Explanation                                                                                                        |
	| -------------- | ------------------------------------------------------------------------------------------------------------------ |
	| Default method | Has a body inside an interface (declared with `default`)                                                           |
	| Conflict       | Occurs if multiple interfaces have same default method                                                             |
	| Resolution     | Class must override the method and can call a specific interface’s method using `InterfaceName.super.methodName()` |
	| Static methods | Declared in interface using `static`, called via interface name only (not inherited)                               |

