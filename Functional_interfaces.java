Functional interfaces

	=> What is a Functional Interface?

		* A functional interface is an interface that contains exactly one abstract method.

			It can have:

				* One abstract method
				* Multiple default or static methods

				Example:

					@FunctionalInterface
					interface MyInterface {
					    void display();
					}

					- Functional interfaces are mainly used with Lambda expressions.

	=> Common Functional Interfaces in Java

		* Java provides built-in functional interfaces in the java.util.function package.

			Three very common ones are:

				1. Predicate
				2. Function
				3. Consumer

		1. Predicate

			* Predicate is used for testing a condition.

				Method

					boolean test(T t)

					- Returns true or false.

				Example:

					import java.util.function.Predicate;

					Predicate<Integer> isEven = n -> n % 2 == 0;

					System.out.println(isEven.test(10));

				Output : true

				Use Case

					* Filtering data:

						list.stream()
    						.filter(n -> n > 10)	


    	2. Function

    		* Function is used for transforming data.

    			Method

    				R apply(T t)

    				- Input → Output transformation.

    			Example

    				import java.util.function.Function;

					Function<Integer, Integer> square = n -> n * n;

					System.out.println(square.apply(5));

				Output : 25

				Use Case

					* Mapping values in streams:

					list.stream()
    					.map(n -> n * 2)

    	3. Consumer

    		* Consumer is used for performing operations without returning a value.

    			Method

    				void accept(T t)

    			Example

    				import java.util.function.Consumer;

					Consumer<String> print = s -> System.out.println(s);

					print.accept("Hello Java");

				Use Case

					Printing or processing elements.

					list.forEach(System.out::println);

	=> Comparison

		| Interface | Method     | Purpose         | Return  |
		| --------- | ---------- | --------------- | ------- |
		| Predicate | `test()`   | Check condition | boolean |
		| Function  | `apply()`  | Transform data  | value   |
		| Consumer  | `accept()` | Perform action  | void    |

	=> Example Using All Three

		List<Integer> numbers = Arrays.asList(1,2,3,4,5);

		numbers.stream()
		       .filter(n -> n % 2 == 0)   // Predicate
		       .map(n -> n * n)           // Function
		       .forEach(System.out::println); // Consumer


		Output : 4 16

	=> Short Notes: 

		Functional interfaces in Java contain exactly one abstract method and are used with lambda expressions. 
		The Predicate interface is used for testing conditions and returns a boolean. 
		The Function interface is used to transform data from one type to another. 
		The Consumer interface performs operations on data without returning a value. 

