Method References

	=> What is a Method Reference?

		* A method reference is a short way to refer to a method without executing it.

		👉 In simple terms: Method references allow you to use an existing method instead of writing a lambda expression.

		It uses the :: operator.

	=> Basic Syntax

		ClassName::methodName

		Example:

			System.out::println

	=> Lambda vs Method Reference

		# Lambda Expression

		list.forEach(s -> System.out.println(s));

		# Method Reference

		list.forEach(System.out::println);

		- Both do the same thing, but method reference is cleaner.

	=> Types of Method References

		* There are four types.

		1. Reference to Static Method

			Syntax:

				ClassName::staticMethod

			Example:

				import java.util.function.Function;

				Function<Integer, Integer> square = Math::abs;

				System.out.println(square.apply(-10));

			Output : 10

		2. Reference to Instance Method of an Object

			Syntax:

				objectName::methodName

			Example:

				Consumer<String> printer = System.out::println;

				printer.accept("Hello Java");

		3. Reference to Instance Method of Arbitrary Object

			Syntax:

				ClassName::methodName

			Example:

				List<String> list = Arrays.asList("java","python","c++");

				list.stream()
				    .map(String::toUpperCase)
				    .forEach(System.out::println);

			Output :

				JAVA
				PYTHON
				C++

		4. Reference to Constructor

			Syntax:

				ClassName::new

			Example:

				Supplier<List<String>> listSupplier = ArrayList::new;

				List<String> list = listSupplier.get();

	=> Example Using Streams

		List<String> names = Arrays.asList("Tony","John","Alex");

		names.stream()
		     .forEach(System.out::println);

		- Here System.out::println is a method reference.

	=> Advantages

		✔ Less code
		✔ Improves readability
		✔ Works well with functional interfaces
		✔ Makes Streams API cleaner

	=> When Method Reference Can Be Used

		* When the lambda expression only calls an existing method.

			Example:

				x -> System.out.println(x)

			Can become:

				System.out::println

	=> Short Notes:

		Method references in Java provide a shorthand way of referring to methods using the :: operator. 
		They are used instead of lambda expressions when the lambda simply calls an existing method. 
		Method references improve readability and are commonly used with functional interfaces and the Stream API.



