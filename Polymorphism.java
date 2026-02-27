Polymorphism

	- Polymorphism means “many forms.” In Java, polymorphism allows the same method to behave differently depending on the object that invokes it.
	It helps achieve: Flexibility, Code reusability, Runtime dynamic behavior

	| Type                      | What it is                           | Achieved by        | When decided |
	| ------------------------- | ------------------------------------ | ------------------ | ------------ |
	| Compile-time Polymorphism | Method call resolved at compile-time | Method Overloading | Compile-time |
	| Runtime Polymorphism      | Method call resolved at runtime      | Method Overriding  | Runtime      |

	1. Compile-time Polymorphism

	 - Method Overloading: Same method name, different parameter list

	 class Calculator {
	    int add(int a, int b) { return a + b; }
	    double add(double a, double b) { return a + b; }
	}

	Why used?
	To increase method readability and usability.

	2. Runtime Polymorphism

	✔️ Method Overriding: Subclass provides specific implementation of a parent method
	✔️ Same method name + same parameters in subclass
	✔️ Uses dynamic method dispatch
	✔️ Runtime polymorphism requires:
		* Inheritance
		* Method overriding
		* Parent reference → Child object
	✔️ @Override annotation helps detect mistakes
	✔️ Static methods, private methods, and constructors cannot be overridden
		→ So they do not support runtime polymorphism

	class Animal {
	    void sound() { System.out.println("Animal makes a sound"); }
	}

	class Dog extends Animal {
	    @Override
	    void sound() { System.out.println("Dog barks"); }
	}

	public class Main {
	    public static void main(String[] args) {
	        Animal obj = new Dog(); // Parent reference → Child object
	        obj.sound(); // Output: Dog barks
	    }
	}

	➜ The method call is resolved at runtime, based on actual object type.


	=> Example of Dynamic Dispatch Diagram

	Animal obj = new Dog();
	       ↑        ↑
	   Reference   Object
	     Type       Type  ✅ Decides method at runtime


	=> Summary

	“Polymorphism in Java allows one interface or method to take many forms. It helps achieve dynamic behavior.
	There are two types: compile-time polymorphism through method overloading, and runtime polymorphism through method overriding.
	In runtime polymorphism, a parent reference can refer to a child object, and the overridden method of the child class is executed, determined at runtime.
	This makes the code more flexible, reusable, and easier to maintain.”

	
