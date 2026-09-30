1. What is OOPS?

	OOPS stands for Object-Oriented Programming System, a computer programming model that builds software around data, or "objects," rather than functions and logic.

	There are four pillars 

		1. Inheritance
		2. Polymorphism
		3. Abstraction
		4. Encapsulation

2. What is Inheritance? 
		
	* Inheritance is one of the core concepts of Object-Oriented Programming (OOP).
	* It allows a class (child/subclass) to inherit fields and methods from another class (parent/superclass).

	=> Types of Inheritance in Java

	| Type             | Description                                                                                                     | Example          |
	| ---------------- | --------------------------------------------------------------------------------------------------------------- | ---------------- |
	| Single       	   | One class inherits another                                                                                      | `A -> B`         |
	| Multilevel       | A class is derived from another derived class                                                                   | `A -> B -> C`    |
	| Hierarchical     | Multiple classes inherit the same parent                                                                        | `A -> B, A -> C` |
	| Multiple         | Java does not support multiple inheritance with classes (to avoid ambiguity). But it’s possible via interfaces. |                  |

	Interface - abstract methods, don’t contain state or conflicting
				Java 8 - 

	Polymorphism - many form
	static, private, constuctor can't be override