Lambda expressions

	=> Lambda expressions

		- Lambda expressions in Java provide a Short way to implement functional interfaces using anonymous functions. 
		In Java 8, It is reduce boilerplate code and improve readability. It is widely used with collections, streams, 
		and functional interfaces such as Predicate, Function, and Consumer.

	=> Syntax of Lambda Expression

		Basic syntax:

			(parameters) -> { body }

		Example:

			(a, b) -> a + b

	=> Example Without Lambda

		Before Java 8:

			Runnable r = new Runnable() {
			    public void run() {
			        System.out.println("Thread running");
			    }
			};

	=> Example With Lambda

		Runnable r = () -> {
		    System.out.println("Thread running");
		};

		- Much simpler and cleaner.

	=> Functional Interface

		- Lambda expressions work only with functional interfaces.
		- A functional interface has exactly one abstract method.

		Example:

			@FunctionalInterface
			interface MyInterface {
			    void display();
			}

	=> Lambda Example

		MyInterface obj = () -> {
		    System.out.println("Hello Lambda");
		};

		obj.display();

	=> Lambda With Parameters

		Example:

			interface Add {
			    int sum(int a, int b);
			}

			public class Main {

			    public static void main(String[] args) {

			        Add add = (a, b) -> a + b;

			        System.out.println(add.sum(10, 20));

			    }

			}

		Output : 30

	=> Lambda in Collections

		* Used for sorting and iteration.

			Example:

				List<String> list = Arrays.asList("Java","Python","C++");
				list.forEach(s -> System.out.println(s));

	=> Lambda With Comparator

		Collections.sort(list, (a, b) -> a.compareTo(b));

	=> Advantages of Lambda

		✔ Less boilerplate code
		✔ Improves readability
		✔ Supports functional programming
		✔ Used with Streams API

	=> Common Built-in Functional Interfaces

		| Interface    | Method      |
		| ------------ | ----------- |
		| `Runnable`   | `run()`     |
		| `Callable`   | `call()`    |
		| `Comparator` | `compare()` |
		| `Predicate`  | `test()`    |
		| `Function`   | `apply()`   |
		| `Consumer`   | `accept()`  |

	=> Example Using Predicate

		Predicate<Integer> isEven = n -> n % 2 == 0;

		System.out.println(isEven.test(10));

		Output : true