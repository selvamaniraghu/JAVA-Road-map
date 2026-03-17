Optional

	=> What is Optional in Java?

		* Optional is a container object that may or may not contain a value.

		In simple terms: Optional helps avoid NullPointerException by explicitly handling missing values.

		It belongs to the package: java.util.Optional

	=> Why Optional is Needed

		Before Java 8:

			String name = null;
			System.out.println(name.length());

			This throws: NullPointerException

		Using Optional: 

			Optional<String> name = Optional.ofNullable(null);
			System.out.println(name.orElse("Default Name"));

			Output : Default Name

	=> Creating Optional Objects

		1. Optional.of()

			* Used when the value must not be null.

				Optional<String> name = Optional.of("Tony");

				- If null → NullPointerException

		2. Optional.ofNullable()

			* Used when value may be null.

				Optional<String> name = Optional.ofNullable(null);

		3. Optional.empty()

			* Creates an empty Optional.

				Optional<String> empty = Optional.empty();

	=> Important Optional Methods

		| Method          | Purpose                      |
		| --------------- | ---------------------------- |
		| `isPresent()`   | Check if value exists        |
		| `get()`         | Get value (not recommended)  |
		| `orElse()`      | Return default value         |
		| `orElseGet()`   | Return value using supplier  |
		| `orElseThrow()` | Throw exception if empty     |
		| `ifPresent()`   | Execute code if value exists |
		| `map()`         | Transform value              |

	=> Example

		Optional<String> name = Optional.ofNullable("Tony");

		name.ifPresent(n -> System.out.println(n));

		Output : Tony

	=> Using orElse()

		Optional<String> name = Optional.ofNullable(null);
		String result = name.orElse("Guest");
		System.out.println(result);

		Output : Guest

	=> Using map()

		Optional<String> name = Optional.of("Tony");
		Optional<Integer> length = name.map(String::length);
		System.out.println(length.get());

		Output : 4

	=> Optional with Streams

		List<String> list = Arrays.asList("Java","Python","C++");

		Optional<String> result =
		        list.stream()
		            .filter(s -> s.startsWith("J"))
		            .findFirst();

		result.ifPresent(System.out::println);

	=> Advantages of Optional

		✔ Avoids NullPointerException
		✔ Encourages null-safe programming
		✔ Makes code more readable and expressive

	=> Optional vs Null

		| Feature           | Optional  | Null        |
		| ----------------- | --------- | ----------- |
		| Safety            | Null-safe | Risk of NPE |
		| Explicit handling | Yes       | No          |
		| Code readability  | Better    | Poor        |

	=> Short Notes: 

		Optional is a container object introduced in Java 8 that may contain a value or be empty. 
		It helps prevent NullPointerException by forcing developers to explicitly handle missing values. 
		Optional provides methods like orElse(), ifPresent(), and map() to safely operate on values.


