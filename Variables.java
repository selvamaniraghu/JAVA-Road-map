Variables

	* A variable is a named memory location used to store data that can change during program execution.

	In simple words: A variable is a container for holding values in a program.

=> Why Do We Need Variables?
	
	- To store data temporarily
	- To perform calculations
	- To reuse values
	- To make programs dynamic and readable

=> Types of Variables in Java
	
	Java has three main types of variables:

	1. Local Variables

		- Declared inside a method or block
		- Accessible only within that method
		- Must be initialized before use

		Example:

			void show() {
			    int x = 10; // local variable
			}

		✔ No default value
		✔ Stored in stack memory


	2. Instance Variables (Non-static)

		- Declared inside a class but outside methods
		- Each object gets its own copy

		class Employee {
		    int id; // instance variable
		}

		✔ Default value provided
		✔ Stored in heap memory

	3. Static Variables (Class Variables)

		- Declared using static
		- Shared among all objects of the class

		class Company {
		    static String companyName = "FinAgg";
		}

		✔ Single copy for entire class
		✔ Stored in method area

	Summary:

		| Variable Type | Where Declared          | Scope        | Memory      |
		| ------------- | ----------------------- | ------------ | ----------- |
		| Local         | Inside method/block     | Method only  | Stack       |
		| Instance      | Inside class            | Object level | Heap        |
		| Static        | Inside class (`static`) | Class level  | Method area |

	Short Notes:

		“A variable is a named memory location used to store data that can change during program execution. 
		In Java, variables are classified as local, instance, and static variables based on their scope, lifetime, and memory allocation.”