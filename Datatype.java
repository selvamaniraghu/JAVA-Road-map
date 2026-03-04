Datatype

=> What is a Data Type?
	A data type defines:
	- What kind of data a variable can store
	- How much memory is allocated
	- What operations can be performed on that data

	In simple terms: A data type tells the compiler how to interpret a value.

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

	1. Primitive Data Types (Used to store simple values)

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

	✔ Fast
	✔ Stores actual value
	✔ No methods


	2. Non-Primitive (Reference) Data Types (Used to store objects and complex data)

	Examples:

		String
		Arrays
		Classes
		Interfaces
		Enums

	String name = "Tony";
	int[] numbers = {1, 2, 3};

	✔ Stores reference (address)
	✔ Can have methods
	✔ Created using new (except String literals)

	Key Differences: Primitive vs Non-Primitive

	| Primitive             | Non-Primitive    |
	| --------------------- | ---------------- |
	| Stores value directly | Stores reference |
	| Fixed size            | Dynamic size     |
	| Faster                | Slightly slower  |
	| No methods            | Has methods      |
	| Cannot be null        | Can be null      |


	Short Notes:

	“A data type in Java defines the type of data a variable can hold, how much memory is allocated, and what operations can be performed. 
	Java has primitive data types for simple values like int and boolean, and non-primitive data types like String, arrays, and objects for complex data.”