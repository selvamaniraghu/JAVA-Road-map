Datatype

	=> What is a Data Type?
			“A data type in Java defines the type of data a variable can hold, how much memory is allocated, and what operations can be performed. 
		Java has primitive data types for simple values like int and boolean, and non-primitive data types like String, arrays, and objects for complex data.”

	Example:
		int age = 25;

		int → data type
		age → variable
		25 → value

		Here, int tells Java:
			
			Store an integer
			Allocate 4 bytes
			Allow arithmetic operations

	=> Types of Data Types in Java

		“Primitive data types store simple values directly and have fixed size, while non-primitive data types store references 
		to objects and can hold complex data. Primitives are faster and cannot be null, whereas non-primitives support methods, dynamic size, 
		and can be null.”

		1. Primitive Data Types

			| Data Type | Size          | Example                |
			| --------- | ------------- | ---------------------- |
			| `byte`    | 1 byte        | `byte b = 10;`         |
			| `short`   | 2 bytes       | `short s = 100;`       |
			| `int`     | 4 bytes       | `int x = 1000;`        |
			| `long`    | 8 bytes       | `long l = 1000L;`      |
			| `float`   | 4 bytes       | `float f = 10.5f;`     |
			| `double`  | 8 bytes       | `double d = 10.5;`     |
			| `char`    | 2 bytes       | `char c = 'A';`        |
			| `boolean` | JVM dependent | `boolean flag = true;` |

		2. Non-Primitive

			Examples:

				- String
				- Arrays
				- Classes
				- Interfaces
				- Enums

			String name = "Tony";
			int[] numbers = {1, 2, 3};

			✔ Stores reference (address)
			✔ Can have methods
			✔ Created using new (except String literals)	

		=> Key Differences (Most Important Table)

			| Feature       | Primitive                | Non-Primitive               |
			| ------------- | ------------------------ | --------------------------- |
			| Default value | `0`, `false`, `'\u0000'` | `null`                      |
			| Stored in     | Stack (usually)          | Heap (objects)              |

		=> Memory Understanding (Interview Favorite)

			int a = 5;

			Stack:
			a = 5

			String s = "Java";

			Stack:           Heap:
			s -----------> "Java"

	=> What are Wrapper Classes in Java?

		* Wrapper classes are classes that convert primitive data types into objects.

		=> Primitive to Wrapper Mapping

			Each primitive has a wrapper class:

			| Primitive Type | Wrapper Class |
			| -------------- | ------------- |
			| `byte`         | `Byte`        |
			| `short`        | `Short`       |
			| `int`          | `Integer`     |
			| `long`         | `Long`        |
			| `float`        | `Float`       |
			| `double`       | `Double`      |
			| `char`         | `Character`   |
			| `boolean`      | `Boolean`     |

			All wrapper classes belong to java.lang package.

			Example:
				
				int num = 10;              // primitive
				Integer obj = Integer.valueOf(num); // wrapper object

				- Now obj is an object containing the value 10.

		=> Why Wrapper Classes Are Needed

			1. Collections Require Objects

				* Java collections cannot store primitives.

				Example:

					List<int> list; ---> Not Allowed

					 List<Integer> list = new ArrayList<>(); ---> Allowed

			2. Utility Methods

				* Wrapper classes provide useful methods.

				Example: 

					Integer.parseInt("123"); 
					Double.parseDouble("10.5");

			3. Null Handling

				* Primitives cannot be null.

				Example:

					int a = null;   // ❌ error
					Integer b = null; // ✅ allowed

					- This is useful in databases and APIs.

		=> Autoboxing and Unboxing

			Autoboxing

				* Automatic conversion of primitive → wrapper

				Example:

					Integer a = 10; 

					Compiler converts it to: 

						Integer a = Integer.valueOf(10);

			Unboxing

				* Automatic conversion of wrapper → primitive

				Example:

					Integer a = 20;
					int b = a;


		Important Interview Trap

			Integer x = null;
			int y = x;

			- This causes NullPointerException during unboxing.

	=> What is Type Casting in Java?

		* Type casting in Java is the process of converting one data type to another. 
		It is of two types: implicit casting, also called widening, where a smaller data type is automatically converted to a larger type, 
		and explicit casting, also called narrowing, where a larger data type is manually converted to a smaller type and may cause data loss.

		=> Types of Type Casting

			Java has two types:

				1. Implicit Casting (Widening)
				2. Explicit Casting (Narrowing)

			=> Implicit Type Casting (Widening)

				- Done automatically by the compiler
				- Converting smaller data type → larger data type
			 	- No data loss

			 	Example:

			 		int a = 10;
					double b = a;

					System.out.println(b);

					Output: 10.0

					Conversion Order: byte → short → int → long → float → double

			=> Explicit Type Casting (Narrowing)

				- Done manually by the programmer
				- Converting larger data type → smaller data type
				- May cause data loss

				Example:

					double x = 10.75;
					int y = (int) x;

					System.out.println(y);

					Output: 10

					- The decimal part (.75) is lost.

					=> Example with Characters

						char c = 'A';
						int ascii = c;

						System.out.println(ascii);

						Output: 65

						- Because characters are stored as ASCII values.

		=> Type Casting with Objects (Upcasting / Downcasting)

			=> Upcasting (Automatic)

				Animal a = new Dog();

				Child object → Parent reference.

			=> Downcasting (Manual)

				Dog d = (Dog) a;

				Parent reference → Child object.