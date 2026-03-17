Streams API

	=> What is Stream API in Java?

		* The Stream API is used to process collections of data in a functional and efficient way.

		👉 In simple terms: 

			Stream API allows you to perform operations like filtering, mapping, sorting, and collecting data from collections using functional programming.

		- It is part of java.util.stream package.

	=> Why Stream API is Needed

		Before Java 8:

			List<Integer> list = Arrays.asList(1,2,3,4,5);

			for(int num : list){
			    if(num % 2 == 0){
			        System.out.println(num);
			    }
			}

		With Stream API:

			list.stream()
		    .filter(n -> n % 2 == 0)
		    .forEach(System.out::println);

		✔ Cleaner
		✔ Less code
		✔ More readable

	=> What is a Stream?

		* A stream is a sequence of elements supporting functional operations.

		Important point: Streams do not store data, they process data from collections.

	=> Stream Processing Flow

		Collection → Stream → Intermediate Operations → Terminal Operation

		Example:

			list.stream()
			    .filter(n -> n > 5)
			    .map(n -> n * 2)
			    .forEach(System.out::println);

	=> Types of Stream Operations

		There are two types:

			1. Intermediate Operations
			2. Terminal Operations

		1. Intermediate Operations

			* These operations transform the stream and return another stream.

				| Method       | Purpose            |
				| ------------ | ------------------ |
				| `filter()`   | Select elements    |
				| `map()`      | Transform elements |
				| `sorted()`   | Sort elements      |
				| `distinct()` | Remove duplicates  |
				| `limit()`    | Limit elements     |

			Example:

				list.stream()
				    .filter(n -> n > 10)
				    .map(n -> n * 2)

				- These operations are lazy (executed only when terminal operation runs).

		2. Terminal Operations

			* These operations produce a result or end the stream.

				| Method        | Purpose               |
				| ------------- | --------------------- |
				| `forEach()`   | Iterate elements      |
				| `collect()`   | Convert to collection |
				| `count()`     | Count elements        |
				| `reduce()`    | Combine elements      |
				| `findFirst()` | Get first element     |

			Example:

				list.stream()
				    .filter(n -> n > 10)
				    .count();

	=> Example Using Stream

		List<Integer> numbers = Arrays.asList(1,2,3,4,5);

		numbers.stream()
		       .filter(n -> n % 2 == 0)
		       .map(n -> n * n)
		       .forEach(System.out::println);

		Output : 4 16

	=> collect() Example

		List<Integer> result =
	        numbers.stream()
	               .filter(n -> n > 2)
	               .collect(Collectors.toList());

	=> Parallel Streams

		* Java streams can run in parallel.

			numbers.parallelStream()
       				.forEach(System.out::println);

       		- Used for large datasets.

    => Advantages of Stream API

		✔ Less boilerplate code
		✔ Functional programming style
		✔ Easy data processing
		✔ Supports parallel processing
		✔ Improves readability

	=> Stream vs Collection

		| Feature         | Stream       | Collection |
		| --------------- | ------------ | ---------- |
		| Purpose         | Process data | Store data |
		| Traversal       | One-time     | Multiple   |
		| Lazy evaluation | Yes          | No         |

	=> Short Notes : 

		The Stream API in Java provides a functional approach to processing collections of data. 
		It allows operations like filtering, mapping, and sorting using lambda expressions. 
		Streams consist of intermediate operations that transform data and terminal operations that produce results. 
		They improve code readability and support parallel processing.