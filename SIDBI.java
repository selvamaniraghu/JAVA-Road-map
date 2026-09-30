SIDBI

I have had a good learning experience in my current organization and have worked on different business applications using Java, Spring Boot, Angular and MySQL. 
Over the last few years, I have gained good hands-on experience in development and production support.
At this stage of my career, I'm looking for an opportunity where I can work on more challenging and scalable applications, 
especially in areas like Spring Boot, microservices, cloud and full-stack development. I also want to take more ownership of technical design and end-to-end development.
So, I'm looking for a role that provides broader technical exposure, stronger engineering practices and long-term career growth. That's the main reason I'm considering a change.

I have gained good experience in my current company, and now I'm looking for better career growth and more challenging opportunities.

1. What are the main features introduced in Java 8?

	Java 8 introduced several important features, mainly focused on functional programming, easier collection processing, and better date/time handling.

		1. Lambda Expressions
		2. Functional Interfaces
		3. Stream API
		4. Default and Static methods in Interfaces
		5. Optional
		6. Method References
		7. New Date and Time API
		8. CompletableFuture
		9. Collectors
		10. JavaScript/Nashorn Engine (historical; removed in later Java versions)

	- New Date and Time API

		Java 8 introduced java.time, which is much better designed than the old Date/Calendar APIs.

		Example: 

			LocalDate date = LocalDate.now();

			LocalDateTime dateTime = LocalDateTime.now();

			LocalTime time = LocalTime.now();

		Other Example:

			LocalDate
			LocalTime
			LocalDateTime
			ZonedDateTime
			Instant
			Period
			Duration
			DateTimeFormatter

	- CompletableFuture

		Java 8 introduced CompletableFuture for asynchronous programming

		Example:

			CompletableFuture.supplyAsync(() -> {
			    return "Hello";
			}).thenAccept(System.out::println);

			- It is useful when we need to execute tasks asynchronously and combine multiple operations.
			- This is particularly relevant to your interview because you have been preparing multithreading and CompletableFuture.

	- Collectors

		Collectors are commonly used with Streams to collect processed data.

		Example:

			List<String> result = names.stream()
		        .filter(name -> name.startsWith("T"))
		        .collect(Collectors.toList());

		Other Example:

			Collectors.groupingBy()
			Collectors.partitioningBy()
			Collectors.joining()
			Collectors.counting()
			Collectors.toMap()

2. Difference between JDK, JRE and JVM.

	JDK ⟶ JRE ⟶ JVM

	1. JVM — Java Virtual Machine

		JVM runs Java bytecode.

		When you compile: Hello.java

		using: javac Hello.java

		it creates: Hello.class

		The .class file contains bytecode, and the JVM executes that bytecode.


		Java Source Code
		      ↓
		   javac
		      ↓
		Bytecode (.class)
		      ↓
		     JVM
		      ↓
		Machine Code

		The JVM is responsible for things such as:
			- Executing bytecode
			- Memory management
			- Garbage collection
			- JIT compilation
			- Providing platform independence
		Important: JVM is platform-dependent because each operating system has its own JVM implementation.

	2. JRE — Java Runtime Environment

		JRE provides the environment required to run Java applications.

		It contains:

			JVM
			Java libraries
			Runtime supporting files

		For example, if you only want to run an existing Java application, you need the runtime components, not necessarily the development tools.

		JRE does not contain development tools such as javac.

	3. JDK — Java Development Kit

		JDK is used to develop and run Java applications.

		javac is the Java compiler provided by the JDK.

	JDK → Develop + Run
	JRE → Run
	JVM → Execute bytecode

	JVM is the virtual machine that executes Java bytecode. 
	JRE provides the runtime environment required to run Java applications, including the JVM and Java libraries. 
	JDK is the complete development kit containing the JRE plus development tools such as the Java compiler, debugger and other utilities. 
	So, conceptually, JDK contains JRE, and JRE contains JVM

	One modern Java note: Since Java 11, Oracle/OpenJDK distributions generally don't provide a separate JRE download in the old Java 8 sense. 
	For interviews, the traditional JDK → JRE → JVM relationship is still the standard conceptual explanation.

3. Difference between == and .equals().

	The main difference between == and .equals() is what they compare.
	== operator compares the references of objects, meaning it checks whether two references point to the same object in memory. For primitive data types, it compares the actual values.
	.equals() method is used to compare the content or logical value of objects, provided the class has properly overridden the equals() method.

	For Example:

		String s1 = new String("Java");
		String s2 = new String("Java");

		System.out.println(s1 == s2);       // false
		System.out.println(s1.equals(s2));  // true

	Here, s1 and s2 are different objects, so == returns false, but their contents are the same, so .equals() returns true.
	
	For primitives:

	int a = 10;
	int b = 10;

	System.out.println(a == b); // true

	So, == checks reference equality for objects, while .equals() checks logical/content equality.

4. Why is String immutable in Java?

	String is immutable in Java, which means once a String object is created, its value cannot be changed. 
	If we perform any modification, Java creates a new String object instead of modifying the existing one.
	There are several reasons for this:

	1. String Pool:
	Java stores String literals in the String Pool and allows multiple references to share the same String object. Immutability makes this sharing safe.
	
	2. Security:
	Strings are commonly used for sensitive information such as file paths, URLs, database connection details, and class names. 
	If Strings were mutable, their values could be changed unexpectedly.
	
	3. Thread Safety:
	Since a String cannot be modified after creation, it is inherently thread-safe and can safely be shared between multiple threads.
	
	4. HashMap and HashSet:
	Strings are frequently used as keys in collections. Because their value and hashcode don't change, they can reliably be used as keys.

	For example:

		String city = new String("Delhi"); // String Object - stored in the string constant pool and heap memory
		String s = "Java"; // String literal - stored in the string constant pool
		s.concat(" Programming");

		System.out.println(s); // Java

	The original String remains unchanged. If we write:

		s = s.concat(" Programming");

		a new String object is created and assigned to s.
		So, in short: String immutability provides security, thread safety, String Pool optimization, and reliable behavior when Strings are used as keys in collections.


	- All the object are stored in heap memory 
	- there is one speacial space for string - String constant pool / String literal pool
	- there is no duplicates in the string constant pool

	String s1 = "Hello"; // store in pool
	String s2 = s1 + "world"; // store in heap memory only - world is store in pool

5. Difference between String, StringBuilder, and StringBuffer.

	The main difference between String, StringBuilder, and StringBuffer is mutability, store in memory and thread safety.
	String is immutable, meaning once a String object is created, its value cannot be changed. Any modification creates a new object.
	StringBuilder is mutable and is not synchronized, so it is generally faster. It is preferred when string modifications happen frequently in a single-threaded environment.
	StringBuffer is also mutable, but its methods are synchronized, making it thread-safe. Because of synchronization, it is generally slower than StringBuilder.

	For example:

		String s = "Java";
		s = s + " Programming";

		StringBuilder sb = new StringBuilder("Java");
		sb.append(" Programming");

		StringBuffer sf = new StringBuffer("Java");
		sf.append(" Programming");

		So, if the String value doesn't change, I use String. For frequent modifications in a single-threaded scenario, I use StringBuilder. 
		If thread-safe mutable strings are required, I use StringBuffer

6. What is the String Pool?
	
	String Pool is a special area maintained by the JVM to store String literals. It helps save memory by reusing the same String object when the same literal is created multiple times.

7. Explain equals() and hashCode().
	
	equals() and hashCode() are methods from the Object class and are mainly used to determine object equality, especially in collections like HashMap and HashSet.
	equals() is used to compare whether two objects are logically equal based on their content or properties.
	hashCode() returns an integer hash value for an object. Hash-based collections use this value to determine which bucket an object should be stored in.
	
	class Employee {
	    int id;
	    String name;

	    Employee(int id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        Employee e = (Employee) obj;
	        return this.id == e.id;
	    }

	    @Override
	    public int hashCode() {
	        return Integer.hashCode(id);
	    }
	}
	
	So, in short:
		
		equals() → checks logical equality.
		hashCode() → generates a hash value used by hash-based collections.
		Whenever we override equals(), we should also override hashCode() to maintain the contract.

8. Why should we override hashCode() when overriding equals()?

	We should override hashCode() whenever we override equals() because Java has a contract that equal objects must have the same hashcode.

	For example, if two Employee objects have the same id:

	e1.equals(e2)  // true

	then: e1.hashCode() == e2.hashCode()  // must be true

	This is especially important when using objects in HashMap, HashSet, and Hashtable.

	For example:

	Set<Employee> employees = new HashSet<>();

	employees.add(e1);
	employees.add(e2);

	If e1 and e2 are logically equal but we don't override hashCode(), they may produce different hashcodes. 
	The HashSet can then place them in different buckets and may treat them as different objects, even though equals() says they are equal.
	
	So the rule is:
	
		If a.equals(b) is true, a.hashCode() and b.hashCode() must be the same.
		Same hashcode does not necessarily mean objects are equal, because hash collisions are possible.
		Therefore, whenever we override equals(), we should also override hashCode() to ensure hash-based collections work correctly.

9. Difference between ArrayList and HashSet.

	Both ArrayList and HashSet are implementations of the Collection framework, but they are designed for different purposes.
	ArrayList maintains elements in an ordered sequence and allows duplicate elements. It provides fast access using an index, typically O(1).
	HashSet stores unique elements and does not guarantee insertion order. It uses hashing internally, so add(), remove(), and contains() are typically O(1) on average.


	List<String> list = new ArrayList<>();
	list.add("Java");
	list.add("Java");
	list.add("Spring");

	System.out.println(list);
	// [Java, Java, Spring]

	Set<String> set = new HashSet<>();
	set.add("Java");
	set.add("Java");
	set.add("Spring");

	System.out.println(set);
	// [Java, Spring]

10. How does HashMap work internally?

	HashMap stores data in key-value pairs and internally uses a hash table. The main concepts involved are hashCode(), buckets, and equals().

	internally the structure is array of linked list

	For example:

		Map<Integer, String> map = new HashMap<>();
		map.put(101, "Tony");

		When we call put(), the following happens:
		1. HashCode calculation:
		HashMap calls hashCode() on the key and calculates a hash value.

		2. Bucket/index calculation:
		HashMap uses the hash value to determine the bucket where the key-value pair should be stored.

		3. Store the entry:
		Internally, the entry contains:

		hash
		key
		value
		next

		4. Collision handling:
		If two different keys map to the same bucket, it is called a hash collision. HashMap stores both entries in the same bucket. 
		It uses equals() to determine whether the keys are actually equal.
		In Java 8+, if a bucket becomes sufficiently large, its linked-list structure can be converted into a Red-Black Tree to improve lookup performance.

		5. When we call get():
		map.get(101);
		HashMap calculates the hash of the key, finds the appropriate bucket, and then uses equals() to find the exact key.

		6. If the same key is inserted again:
		map.put(101, "Tony");
		map.put(101, "John");

		The second put() finds the existing key and updates the value from Tony to John.

		7. Resizing:
		HashMap has a default initial capacity of 16 and a default load factor of 0.75. 
		When the number of entries crosses the threshold (capacity × load factor), HashMap resizes and redistributes the entries.
		Time complexity:
		get(), put(), and remove() are generally O(1) average case. With tree-based collision handling, lookup can be O(log n) in the affected bucket.
		In short:

		put(key, value)
		      ↓
		 hashCode()
		      ↓
		Find bucket
		      ↓
		Check equals()
		      ↓
		Store / Update value

		So, hashCode() helps HashMap find the bucket, and equals() helps it identify the exact key.

11. What happens if two keys have the same hashcode?

	If two different keys have the same hashcode, it is called a hash collision. HashMap handles this by storing both entries in the same bucket.
	
	For example:

	map.put(key1, "Value1");
	map.put(key2, "Value2");

	key1.hashCode() == key2.hashCode()

	both entries will be placed in the same bucket.
	HashMap then uses equals() to check whether the keys are actually the same.
	- If key1.equals(key2) is false → both entries are stored.
	- If key1.equals(key2) is true → they are treated as the same key and the existing value is updated.
	In Java 8+, collisions are initially handled using a linked list, and if a bucket becomes sufficiently large, it can be converted into a Red-Black Tree.
	So, the key point is:
	Same hashcode does not mean same key. hashCode() finds the bucket, and equals() identifies the exact key.

12. Difference between HashMap, Hashtable, and ConcurrentHashMap.

	HashMap, Hashtable, and ConcurrentHashMap are key-value data structures, but the main differences are thread safety, synchronization, null support, and performance.
	HashMap is not thread-safe. It allows one null key and multiple null values. It provides good performance when multiple threads are not modifying the map concurrently.
	Hashtable is thread-safe because its methods are synchronized. It does not allow null keys or null values. It is a legacy class and generally isn't preferred for new applications.
	ConcurrentHashMap is thread-safe and designed specifically for concurrent applications. 
	It allows multiple threads to read and update the map efficiently and generally performs better than Hashtable under high concurrency. It does not allow null keys or null values.

	For example, if multiple threads need to access and modify the same map, I would prefer ConcurrentHashMap because it provides thread safety with better concurrency than Hashtable.
	In short: HashMap is not thread-safe, Hashtable is a legacy synchronized map, and ConcurrentHashMap is designed for efficient concurrent access.

13. What is an immutable class?
	
	An immutable class is a class whose object state cannot be changed after the object is created. Once the object is created, its fields cannot be modified.
	
	To create an immutable class, we generally follow these rules:
	1. Declare the class as final.
	2. Make all instance variables private and final.
	3. Initialize the fields through the constructor.
	4. Do not provide setter methods.
	5. If the class contains mutable objects, return defensive copies.
	
	Example:

		final class Employee {

		    private final int id;
		    private final String name;

		    public Employee(int id, String name) {
		        this.id = id;
		        this.name = name;
		    }

		    public int getId() {
		        return id;
		    }

		    public String getName() {
		        return name;
		    }
		}

	Here, the object's state cannot be changed after creation.
	For example, String is an immutable class in Java.
	The main advantages are thread safety, security, easier caching, and safe use in collections such as HashMap and HashSet.
	In short: An immutable class is a class whose object state cannot be modified after creation

14. Can we have multiple catch blocks?

	Yes, we can have multiple catch blocks for a single try block. This is used when we want to handle different types of exceptions differently.

	For example:

	try {
	    int result = 10 / 0;
	} catch (ArithmeticException e) {
	    System.out.println("Arithmetic exception");
	} catch (NullPointerException e) {
	    System.out.println("Null pointer exception");
	} catch (Exception e) {
	    System.out.println("General exception");
	}

	Here, Java checks the catch blocks from top to bottom and executes the first matching one.
	The important rule is that specific exceptions must come before their parent exception.
	Correct:
	catch (ArithmeticException e) { }
	catch (Exception e) { }

	Incorrect:
	catch (Exception e) { }
	catch (ArithmeticException e) { } // Compile-time error

	because Exception can already catch ArithmeticException.
	In short: Yes, multiple catch blocks are allowed, and they should be ordered from the most specific exception to the most general exception.


15. Can we override a method and throw a different exception?

	Yes, but there are rules. When overriding a method, the child class cannot throw a broader checked exception than the parent method.
		
		1. Same checked exception — allowed

			class Parent {
			    void display() throws IOException { }
			}

			class Child extends Parent {
			    @Override
			    void display() throws IOException { }
			}

		2. Subclass of the parent exception — allowed

			class Parent {
			    void display() throws IOException { }
			}

			class Child extends Parent {
			    @Override
			    void display() throws FileNotFoundException { }
			}

			FileNotFoundException is a subclass of IOException.

		3. Broader checked exception — not allowed

			class Parent {
			    void display() throws IOException { }
			}

			class Child extends Parent {
			    @Override
			    void display() throws Exception { } // Compile-time error
			}

		4. Unchecked exceptions — allowed
			
			The overriding method can throw any unchecked exception such as RuntimeException, NullPointerException, or ArithmeticException.
		
		5. Parent method has no checked exception — child cannot add one

			class Parent {
			    void display() { }
			}

			class Child extends Parent {
			    @Override
			    void display() throws IOException { } // Compile-time error
			}

	In short: An overriding method can throw the same checked exception, a narrower checked exception, or any unchecked exception, 
	but it cannot throw a broader checked exception than the parent method.

16. What is final, finally, and finalize()?

	final, finally, and finalize() are three different concepts in Java.

	1. final — Keyword

		final is used to restrict modification.
		- Final variable: value cannot be reassigned.
		- Final method: cannot be overridden.
		- Final class: cannot be inherited.

		final int x = 10;

		final class Employee { }

	2. finally — Block
	
		finally is used with exception handling. The code inside finally is normally executed whether an exception occurs or not, so it is commonly used for cleanup operations.

			try {
			    // code
			} catch (Exception e) {
			    // handle exception
			} finally {
			    // cleanup code
			}

	3. finalize() — Method
		
		finalize() was a method associated with garbage collection and was intended to be called before an object was reclaimed. 
		However, finalize() is deprecated for removal in modern Java and should not be used for resource cleanup.

	In short: final is a keyword, finally is an exception-handling block, and finalize() is a deprecated legacy method associated with garbage collection.

17. What are Java access modifiers?

	Java has four access modifiers: private, default, protected, and public. They control the visibility and accessibility of classes, methods, and variables.

	1. private
		
		Accessible only within the same class.

		private int salary;

	2. Default / Package-private
	
		If no modifier is specified, it is accessible only within the same package.

		int salary;

	3. protected
		
		Accessible within the same package and also in subclasses outside the package.

		protected int salary;

	4. public
		
		Accessible from anywhere.

		public int salary;

		* For protected, outside the package, access is through inheritance (the subclass context), not arbitrary access through an unrelated object.
		
		In short: private provides the most restricted access, public provides the widest access, and default and protected provide package-level and inheritance-based access respectively.


18. Difference between map() and flatMap().

	The main difference between map() and flatMap() is that map() transforms each element into another element, 
	while flatMap() transforms each element and then flattens the resulting nested structure into a single stream.

	map() example:

		List<String> names = Arrays.asList("Tony", "John");

		List<Integer> lengths = names.stream()
		        .map(String::length)
		        .collect(Collectors.toList());

		Output: [4, 4]

	flatMap() example:

		List<List<String>> names = Arrays.asList(
	        Arrays.asList("Tony", "John"),
	        Arrays.asList("Raj", "Sam")
		);

		List<String> result = names.stream()
		        .flatMap(List::stream)
		        .collect(Collectors.toList());

		Output: [Tony, John, Raj, Sam]

	Here, map() would produce a Stream of Lists, while flatMap() converts the nested lists into a single Stream of Strings.

	In short:

		map() → One input → One output
		flatMap() → One input → Multiple outputs, then flattens them into one stream.
		Real-time example: If I have a list of customers and each customer has multiple orders, 
		map() can give me a stream of customer order lists, whereas flatMap() can give me a single stream containing all orders from all customers

19. Difference between filter() and map().

	The main difference between filter() and map() is that filter() is used to select elements based on a condition, while map() is used to transform each element into another value.
	
	filter() example:

		List<Integer> numbers = Arrays.asList(10, 15, 20, 25);

		List<Integer> result = numbers.stream()
		        .filter(n -> n > 15)
		        .collect(Collectors.toList());

		Output: [20, 25]

	Here, filter() removes the elements that don't satisfy the condition.
	map() example:

	List<Integer> numbers = Arrays.asList(10, 15, 20);

	List<Integer> result = numbers.stream()
	        .map(n -> n * 2)
	        .collect(Collectors.toList());

	Output: [20, 30, 40]

	Here, map() transforms every element.

	In short:

	filter() → Selects elements → may reduce the number of elements.
	map() → Transforms elements → normally maintains the same number of elements.
	Real-time example: If I have a list of employees, filter() can find employees whose salary is greater than ₹10 LPA, while map() can extract their names from the employee objects.       

20. What is reduce()?

	reduce() is a terminal operation in the Java Stream API used to combine multiple elements into a single result. 
	It is commonly used for operations like sum, multiplication, finding the maximum, or combining values.

	For example:

		List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

		int sum = numbers.stream()
		        .reduce(0, (a, b) -> a + b);

		Output: 100

		Here, 0 is the initial value, and the lambda combines the elements one by one.

		0 + 10 = 10
		10 + 20 = 30
		30 + 30 = 60
		60 + 40 = 100

		In short: reduce() takes multiple stream elements and reduces them into a single result.

21. What is collect()?

	collect() is a terminal operation in the Java Stream API used to collect the processed stream elements into a result such as a List, Set, Map, or String

	For example:

	List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

	List<Integer> result = numbers.stream()
	        .filter(n -> n > 20)
	        .collect(Collectors.toList());

	Output: [30, 40]

	We can also use different collectors:

	Collectors.toList()
	Collectors.toSet()
	Collectors.toMap()
	Collectors.groupingBy()
	Collectors.joining()
	Collectors.counting()

	In short: collect() is mainly used to gather the results of Stream processing into a collection or another final data structure.”

22. Difference between findFirst() and findAny().

	Both findFirst() and findAny() are terminal operations in the Java Stream API that return an Optional. The main difference is which element they return.
	findFirst() returns the first element according to the stream's encounter order.

	List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

	Optional<Integer> result = numbers.stream()
	        .filter(n -> n > 15)
	        .findFirst();

	Output: 20

	findAny() returns any matching element. It is especially useful with parallel streams, where the implementation can return whichever matching element is found efficiently.

	Optional<Integer> result = numbers.parallelStream()
        .filter(n -> n > 15)
        .findAny();

    The result could be 20, 30, or 40.

    In short: findFirst() is used when I need the first matching element, while findAny() is used when any matching element is sufficient, especially with parallel processing

23. What is a parallel stream?
	
	A parallel stream is a Java Stream that processes elements concurrently using multiple threads, usually through the ForkJoinPool. 
	It is useful when we have a large amount of data and the operations are independent.

	We can create a parallel stream using:

	List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

	numbers.parallelStream()
	       .forEach(System.out::println);

	Or

	numbers.stream()
       .parallel()
       .forEach(System.out::println);

    Internally, Java divides the data into smaller parts, processes those parts concurrently, and combines the results when required.
	Advantages:
	- Can improve performance for large datasets.
	- Utilizes multiple CPU cores.
	- Useful for CPU-intensive and independent operations.
	Disadvantages:
	- Has overhead for creating and managing parallel tasks.
	- Not always faster for small datasets.
	- Avoid shared mutable state because it can cause thread-safety issues.
	- Operations depending heavily on order may reduce the benefit.
	For example, if I need to process millions of independent records, a parallel stream may improve performance. 
	But for a small collection or simple operation, a normal sequential stream is usually preferable.
	In short: A parallel stream divides stream processing across multiple threads to potentially improve performance on suitable workloads.

24. Difference between Stream and Collection.

	Collection is used to store and manage a group of objects, whereas Stream is used to process and perform operations on data from a collection, such as filtering, mapping, and sorting

Spring / Spring Boot — Very High Priority
Spring Core
25. What is Spring Framework?

	Spring Framework is an open-source Java framework used to build enterprise applications. 
	It provides infrastructure and features that make Java application development easier, more modular, and loosely coupled.
	The core concept of Spring is IoC (Inversion of Control) and Dependency Injection (DI), where Spring manages the creation and lifecycle of objects and injects their dependencies.
	Spring provides several modules, such as:
	- Spring Core – IoC and Dependency Injection
	- Spring MVC – Web and REST API development
	- Spring Data – Database access
	- Spring AOP – Cross-cutting concerns like logging and security
	- Spring Security – Authentication and authorization
	- Spring Transaction Management – Managing database transactions
	For example, instead of manually creating a service object:

		UserService service = new UserService();

	Spring can manage it as a bean and inject it where required:

		@Service
		public class UserService {

		}

	In short: Spring Framework helps us build loosely coupled, maintainable, testable, and scalable Java applications mainly through IoC and Dependency Injection

26. What are the advantages of Spring?

	The main advantages of the Spring Framework are:
		1. Loose Coupling – Spring uses Dependency Injection, which reduces dependency between classes.
		2. Dependency Injection – Spring manages object creation and injects dependencies automatically.
		3. Modular Architecture – Spring provides different modules such as Spring Core, MVC, Data, Security, and AOP.
		4. Easy Testing – Loose coupling and Dependency Injection make unit testing easier.
		5. Transaction Management – Spring provides simple and consistent transaction management using @Transactional.
		6. AOP Support – It helps handle cross-cutting concerns such as logging, security, and transaction management.
		7. Integration Support – Spring integrates easily with databases, Hibernate, JPA, messaging systems, and other technologies.
		8. Web and REST API Development – Spring MVC makes it easy to develop web applications and REST APIs.
		9. Scalability and Maintainability – Its modular and loosely coupled architecture makes applications easier to maintain and scale.
		10. Spring Security – It provides features for authentication and authorization.
		In short: Spring helps us build loosely coupled, modular, testable, maintainable, and scalable enterprise Java applications

27. What is IoC?

	IoC stands for Inversion of Control. It is a design principle where the control of creating and managing objects is transferred from the application code to the Spring IoC container.
	Normally, we create objects ourselves:

		UserService service = new UserService();

	With Spring IoC:

		@Service
		public class UserService {
		
		}

	Spring creates and manages the UserService object as a Spring Bean and provides it wherever required.
	IoC is mainly achieved through Dependency Injection (DI).
	For example:

	@Service
	class UserService {
	}

	@RestController
	class UserController {

	    private final UserService userService;

	    @Autowired
	    UserController(UserService userService) {
	        this.userService = userService;
	    }
	}

	Here, the controller doesn't create UserService using new. Spring creates it and injects it into the controller.
	In short: IoC means Spring takes control of object creation and dependency management instead of the application doing it manually

28. What is Dependency Injection?

	Dependency Injection, or DI, is a design pattern where an object receives its required dependencies from an external source instead of creating them itself. 
	In Spring, the Spring IoC container creates and injects those dependencies.
	
	For example, without DI:

		class UserController {
		    private UserService userService = new UserService();
		}

	Here, UserController is tightly coupled to UserService.
	With Dependency Injection:

		@RestController
		class UserController {

		    private final UserService userService;

		    @Autowired
		    public UserController(UserService userService) {
		        this.userService = userService;
		    }
		}

	Here, Spring creates the UserService object and injects it into UserController.

		There are three common types of Dependency Injection:
		
			1. Constructor Injection – dependency is provided through the constructor.
			2. Setter Injection – dependency is provided through a setter method.
			3. Field Injection – dependency is injected directly into the field using @Autowired.
		
		Constructor injection is generally preferred because the dependency is explicit, required dependencies can be made final, and the class is easier to test.
		
		In short: Dependency Injection means providing an object's required dependencies from outside rather than creating those dependencies inside the object.

29. Constructor injection vs setter injection.

	Constructor injection and setter injection are two ways of injecting dependencies into a Spring class.
	Constructor Injection: The dependency is provided through the class constructor.

		@Service
		class UserService {
		}

		@RestController
		class UserController {

		    private final UserService userService;

		    public UserController(UserService userService) {
		        this.userService = userService;
		    }
		}

	Setter Injection: The dependency is provided through a setter method.

		@RestController
		class UserController {

		    private UserService userService;

		    @Autowired
		    public void setUserService(UserService userService) {
		        this.userService = userService;
		    }
		}

30. What is a Spring Bean?

	A Spring Bean is an object that is created, configured, and managed by the Spring IoC container. Instead of creating the object manually using new, we let Spring create and manage it.

	For example:

		@Service
		public class UserService {
		
		}

	Spring detects @Service during component scanning, creates a UserService object, and manages its lifecycle.
	We can also define a Bean explicitly using @Bean:

		@Configuration
		public class AppConfig {

		    @Bean
		    public UserService userService() {
		        return new UserService();
		    }
		}

	Then Spring can inject that Bean wherever it is required:

		@Autowired
		private UserService userService;

	Spring Bean lifecycle is managed by the Spring container, including creation, dependency injection, initialization, and destruction.
	In short: A Spring Bean is simply an object whose creation and lifecycle are managed by the Spring IoC container.


31. What is @Component?

	@Component is a Spring annotation used to mark a class as a Spring-managed Bean. 
	When Spring performs component scanning, it detects the class, creates its object, and manages its lifecycle through the IoC container.

	Example:

		@Component
		public class EmailService {

		    public void sendEmail() {
		        System.out.println("Email sent");
		    }
		}

	Then Spring can inject it into another class:

		@Autowired
		private EmailService emailService;


	@Service, @Repository, and @Controller are specialized forms of @Component, used to represent different layers of an application.
	In short: @Component tells Spring, ‘Create and manage an object of this class as a Spring Bean.


32. Difference between:
   - @Component
   - @Service
   - @Repository
   - @Controller

   	@Component, @Service, @Repository, and @Controller are Spring stereotype annotations. 
   	All of them allow Spring to detect the class during component scanning and register it as a Spring Bean, but they represent different layers or responsibilities.
	
	1. @Component
	
		It is the generic stereotype annotation. We use it when a class doesn't specifically belong to the service, repository, or controller layer.

		@Component
		public class EmailUtil {
		}

	2. @Service
	
		It is used for the service/business logic layer.

		@Service
		public class LoanService {
		}

	3. @Repository
		
		It is used for the data access/persistence layer, such as database operations. It also provides Spring's exception translation for persistence-related exceptions.

		@Repository
		public class LoanRepository {
		}

	4. @Controller
	
		It is used for the web/controller layer to handle incoming HTTP requests and return views or responses.

		@Controller
		public class LoanController {
		}

		For REST APIs, we commonly use:

		@RestController

		which effectively combines @Controller and @ResponseBody.

		In short: @Component is generic, @Service is for business logic, @Repository is for database access, and @Controller is for handling web requests. 
		All are managed by the Spring IoC container.

33. What is @Autowired?

	@Autowired is used in Spring to inject one class object into another class automatically.

	For example, if I have a UserService:

		@Service
		public class UserService {
		
		}

	And I need UserService inside UserController:

		@RestController
		public class UserController {

		    private final UserService userService;

		    @Autowired
		    public UserController(UserService userService) {
		        this.userService = userService;
		    }
		}

	Here, I don't create the object using new UserService(). Spring creates the object and automatically gives it to the controller.

	So, simply:

	@Autowired tells Spring: "Give me the required object here."

	It is mainly used for Dependency Injection.

34. What is component scanning?
	
	Component scanning means Spring searches our application for Spring components and automatically creates and manages their objects.

	For example:

		@Service
		public class UserService {
		
		}

	When Spring starts the application, it scans the configured packages, finds UserService, creates its object, and manages it as a Spring Bean.

	In Spring Boot, component scanning is enabled automatically through:

		@SpringBootApplication

35. What is Bean lifecycle?

	Bean lifecycle is the complete journey of a Spring Bean from creation to destruction.

	The main steps are:

		1. Bean creation – Spring creates the Bean object.
		2. Dependency Injection – Spring provides the required dependencies.
		3. Initialization – Spring performs any initialization logic, such as @PostConstruct.
		4. Bean is ready – The Bean is now available for use in the application.
		5. Destruction – When the Spring application shuts down, Spring destroys the Bean and can execute cleanup logic such as @PreDestroy.

			Create Bean
			     ↓
			Inject Dependencies
			     ↓
			Initialize Bean
			     ↓
			Bean Ready / In Use
			     ↓
			Application Shutdown
			     ↓
			Destroy Bean

36. What are Spring Bean scopes?

	Bean scope tells Spring how many objects to create and how long each Bean should live. Singleton is the default scope in Spring

	1. Singleton - Spring creates only one object of the Bean for the entire Spring container.

		@Service
		@Scope("singleton")
		public class UserService {
		
		}

	2. Prototype - Spring creates a new object every time the Bean is requested.

		@Service
		@Scope("prototype")
		public class UserService {
		
		}

	3. Request - A new Bean is created for each HTTP request. This is mainly used in web applications.
	4. Session - A new Bean is created for each HTTP session.
	5. Application - One Bean is created for the entire web application context.
	6. WebSocket - A new Bean is created for the lifecycle of a WebSocket session.

37. Singleton vs Prototype scope.

	Singleton means “create once and reuse,” while Prototype means “create a new object whenever requested.

	Singleton:
		
		Spring creates only one object of the Bean per Spring container. This is the default scope.

			@Service
			@Scope("singleton")
			public class UserService {
			
			}

		If multiple classes request UserService, Spring gives them the same object.

	Prototype:
	
		Spring creates a new object every time the Bean is requested.

			@Service
			@Scope("prototype")
			public class UserService {
			
			}

		So, if two classes request UserService, they can get two different objects.

38. What is @Configuration?

	@Configuration is used to tell Spring that a class contains Bean configuration.

		@Configuration
		public class AppConfig {

		    @Bean
		    public UserService userService() {
		        return new UserService();
		    }
		}

	Here:

		@Configuration tells Spring this is a configuration class.
		@Bean tells Spring to create and manage the UserService object as a Bean.
		We don't need to use new UserService() in other classes; Spring provides the Bean through Dependency Injection.

	@Configuration is used to define a Spring configuration class. 
	It tells Spring that the class contains Bean definitions. We usually use @Bean methods inside it to create objects that Spring manages. 
	It is mainly used when we want to configure Beans manually instead of using annotations like @Service or @Component.

39. What is @Bean?

	@Bean is used to tell Spring to create and manage an object as a Spring Bean.

	We normally use @Bean inside a class marked with @Configuration.

	Example:

		@Configuration
		public class AppConfig {

		    @Bean
		    public UserService userService() {
		        return new UserService();
		    }
		}

	Here:

		@Configuration → tells Spring this is a configuration class.
		@Bean → tells Spring to create and manage the UserService object.
		Spring creates the object and we can inject it wherever required.


	For example:

		@Service
		public class OrderService {

		    private final UserService userService;

		    public OrderService(UserService userService) {
		        this.userService = userService;
		    }
		}

	We don't need to write:

		new UserService();

	Spring provides the object automatically.

	@Bean is used to tell Spring to create and manage an object as a Bean. 
	It is usually used inside a @Configuration class. We use it when we want to manually configure and create an object that should be managed by the Spring container.

	Simple way to remember:

		@Configuration → Where to configure

		@Bean → What object Spring should create


Spring Boot
40. What is Spring Boot?

	Spring Boot is built on top of the Spring Framework. 
	It simplifies Spring application development by providing auto-configuration, starter dependencies, embedded servers, and production-ready features. 
	It helps us develop and deploy REST APIs and microservices quickly with less configuration.

	Easy way to remember:

		Spring = Framework
		Spring Boot = Spring made easier and faster

41. Spring vs Spring Boot?

	Spring is a Java framework used to build enterprise applications, but it requires more configuration. 
	Spring Boot is built on top of Spring and simplifies development using auto-configuration, starter dependencies, and embedded servers. 
	So, Spring Boot helps us develop and run Spring applications faster with less configuration.

		Spring → More configuration
		Spring Boot → Less configuration + faster development


42. What is @SpringBootApplication?

	@SpringBootApplication is the main annotation of a Spring Boot application.

	It tells Spring Boot to start the application, scan the components, and automatically configure the application.

	It is a combination of three annotations:

		1. @Configuration → Defines the class as a configuration class.
		2. @EnableAutoConfiguration → Automatically configures the application based on the dependencies.
		3. @ComponentScan → Scans packages for classes like @Component, @Service, @Repository, and @Controller.

43. What is auto-configuration?

	Auto-configuration means Spring Boot automatically configures the application based on the dependencies available in the project (pom.xml).

	We don't need to manually configure many common settings.

	For example, if we add the Spring Web dependency, Spring Boot automatically configures Spring MVC and an embedded server. 
	This reduces the amount of manual configuration we need to write

44. What is Spring Boot Starter?

	Spring Boot Starter is a predefined set of dependencies for a particular functionality. 
	Instead of adding multiple dependencies manually, we add one starter dependency. 
	For example, spring-boot-starter-web provides the dependencies required to build REST APIs and web applications. It makes dependency management easier and faster.

45. What is application.properties / application.yml?

	application.properties and application.yml are configuration files used in Spring Boot. 
	We use them to store application settings such as database details, server port, JPA configuration, logging, and external URL.
	Both can be used for the same purpose. The main difference is format/syntax.
	Instead of hardcoding configuration in Java code: we keep it in the configuration file:
	This makes it easier to change configuration for different environments like development, testing, and production.

46. What are Spring Profiles?

	Spring Profiles are used to maintain different configurations for different environments like development, testing, and production. 
	We can create separate configuration files such as application-dev.properties and application-prod.properties and activate the required profile. 
	We can also use @Profile to create specific Beans only for a particular environment.

47. How do you maintain separate configurations for DEV, QA and PROD?

	We maintain separate configurations using Spring Profiles. We create files like application-dev.properties, application-qa.properties, and application-prod.properties. 
	Each file contains environment-specific settings such as database URL, server port, and external API URLs. We activate the required profile using spring.profiles.active. 
	For production secrets, we use a secure secret-management system instead of storing passwords in the configuration file

	We should not keep production passwords or sensitive credentials directly in Git. Usually, 
	secrets are managed through environment variables, AWS Secrets Manager, Kubernetes Secrets, Vault, or another secret-management system.

48. What is Actuator?

	Spring Boot Actuator is used to monitor and manage Spring Boot applications, especially in production. 
	It provides ready-made endpoints such as /actuator/health and /actuator/metrics to check application health, metrics, and other operational information.

		<dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>

49. How do you handle exceptions globally?

	In Spring Boot, I handle exceptions globally using @RestControllerAdvice and @ExceptionHandler. 
	I create a global exception handler class and define handlers for different exceptions. 
	This avoids writing try-catch blocks in every controller and gives a consistent error response across all APIs.

		@RestControllerAdvice → Global exception handler
		@ExceptionHandler → Handles a specific exception

		@RestControllerAdvice
		public class GlobalExceptionHandler {

		    @ExceptionHandler(ResourceNotFoundException.class)
		    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
		        return ResponseEntity
		                .status(HttpStatus.NOT_FOUND)
		                .body(ex.getMessage());
		    }

		    @ExceptionHandler(Exception.class)
		    public ResponseEntity<String> handleException(Exception ex) {
		        return ResponseEntity
		                .status(HttpStatus.INTERNAL_SERVER_ERROR)
		                .body("Something went wrong");
		    }
		}


50. What is @ControllerAdvice?

	@ControllerAdvice is used to handle common controller-related logic globally, especially exceptions. 

51. What is @ExceptionHandler?

	@ExceptionHandler is used inside the advice class to handle a specific exception and return an appropriate response.

		@ControllerAdvice
		public class GlobalExceptionHandler {

		    @ExceptionHandler(ResourceNotFoundException.class)
		    public ResponseEntity<String> handleNotFound(
		            ResourceNotFoundException ex) {

		        return ResponseEntity
		                .status(HttpStatus.NOT_FOUND)
		                .body(ex.getMessage());
		    }
		}

52. How do you validate request data?

	I use Bean Validation in Spring Boot to validate request data. 
	I add validation annotations like @NotBlank, @Email, @Size, and @Min to the request DTO, and use @Valid in the controller. 
	If validation fails, Spring generates a validation error, which I handle globally using @RestControllerAdvice

		public class UserRequest {

		    @NotBlank(message = "Name is required")
		    private String name;

		    @Email(message = "Invalid email")
		    private String email;

		    @Min(value = 18, message = "Age must be at least 18")
		    private int age;
		}

		@PostMapping("/users")
		public ResponseEntity<String> createUser(
		        @Valid @RequestBody UserRequest request) {

		    return ResponseEntity.ok("User created");
		}


53. Explain @Valid and @NotNull.

	@Valid is used to trigger validation on an object.

	It tells Spring: Check the validation rules defined in this request object.

		@PostMapping("/users")
		public ResponseEntity<String> createUser(
		        @Valid @RequestBody UserRequest request) {
		    return ResponseEntity.ok("User created");
		}

	Here, @Valid tells Spring to check all validation annotations inside UserRequest.

	@NotNull is a validation rule that says a value must not be null.

		public class UserRequest {

		    @NotNull(message = "User ID is required")
		    private Long userId;

		    private String name;
		}

		If the request contains:

			{
			    "userId": null,
			    "name": "Tony"
			}

			validation fails because userId is null.

	@Valid is used to trigger validation for a request object. @NotNull is a validation annotation that ensures a field is not null. 
	For example, if I have @NotNull on userId and use @Valid in the controller, Spring checks userId and returns a validation error if it is null.

		@Valid → Check the rules
		@NotNull → Value cannot be null

54. What is the difference between @RequestParam, @PathVariable, and @RequestBody?

	@RequestParam is used to get values from query parameters, for example /users?id=101. 
	@PathVariable is used to get values from the URL path, for example /users/101. 
	@RequestBody is used to get data from the request body, usually JSON, and convert it into a Java object

		@GetMapping("/users")
		public User getUser(@RequestParam Long id) {
		    // ...
		}

		@GetMapping("/users/{id}")
		public User getUser(@PathVariable Long id) {
		    // ...
		}

		@PostMapping("/users")
		public User createUser(@RequestBody UserRequest request) {
		    // ...
		}


3. REST API — Very High Priority
55. What is REST?

	REST stands for Representational State Transfer. It is an architectural style used to build APIs that allow applications to communicate over HTTP. 
	REST uses resources and HTTP methods like GET, POST, PUT, and DELETE to perform operations. REST APIs are generally stateless and commonly use JSON for data exchange

	REST = Resources + HTTP methods + Stateless communication

56. What are REST principles?

	Stateless – Each request should contain the information needed to process it.
	Client-Server – Client and server are separated.
	Resource-based URLs – URLs represent resources.
	Uses HTTP methods – GET, POST, PUT, DELETE, etc.
	Usually uses JSON – REST APIs commonly exchange JSON data.

57. Difference between GET, POST, PUT, PATCH and DELETE.

	GET → Read
	POST → Create
	PUT → Full Update
	PATCH → Partial Update
	DELETE → Remove

58. What are HTTP status codes?
Explain:- 200
- 201
- 400
- 401
- 403
- 404
- 409
- 500

	HTTP status codes are numbers returned by the server to tell the client what happened with the request.

	They are mainly divided into:
		
		2xx → Success
		4xx → Client-side error
		5xx → Server-side error

		200 → Success
		201 → Created
		400 → Bad Request
		401 → Not Authenticated
		403 → Not Allowed
		404 → Not Found
		409 → Conflict
		500 → Server Error

59. What is idempotency?

	Idempotency means sending the same request multiple times produces the same final result as sending it once. 
	GET, PUT, and DELETE are generally idempotent, while POST is generally not. 
	In payment APIs, we can use an idempotency key to prevent duplicate transactions when the same request is retried.

	Same request + multiple times = same final result

60. How do you design a REST API?

	When designing a REST API, I first identify the resources and create resource-based URLs. 
	Then I define appropriate HTTP methods like GET, POST, PUT, PATCH, and DELETE. 
	I use proper status codes and JSON request/response formats, add request validation, global exception handling, authentication and authorization, and keep the API stateless. 
	I also consider pagination, filtering, versioning, logging, and performance for production applications.

	Resource → URL → HTTP Method → Request/Response → Validation → Error Handling → Security → Performance

61. How do you handle API exceptions?

	I handle API exceptions globally using @RestControllerAdvice and @ExceptionHandler. 
	I create separate handlers for custom exceptions, validation errors, and unexpected exceptions, and return proper HTTP status codes with a consistent error response. 
	This avoids writing exception-handling code in every controller.

		@RestControllerAdvice → Global exception handling
		@ExceptionHandler → Handle specific exception
		HTTP Status → Tell client what went wrong
	
62. How do you implement validation?

	I implement validation using Bean Validation annotations in the request DTO and use @Valid in the controller. 
	For example, I use @NotBlank, @NotNull, @Email, and @Min based on the requirement. 
	If validation fails, Spring generates a validation error, which I handle globally using @RestControllerAdvice

63. How do you secure REST APIs?

	I secure REST APIs using Spring Security. 
	First, I authenticate users using mechanisms such as JWT or OAuth2. 
	Then I implement authorization using roles and permissions. 
	I use HTTPS, validate request data, securely hash passwords, protect sensitive information, configure CORS properly, 
	and handle common security risks such as SQL injection, XSS, and CSRF. 
	I also avoid storing secrets directly in source code.

64. What is JWT?

	JWT stands for JSON Web Token. 
	It is commonly used for authentication in REST APIs. 
	After successful login, the server generates a JWT and sends it to the client. 
	The client sends the JWT in the Authorization header with subsequent requests. 
	The server validates the token and, if it is valid, allows access to the protected API.

	How to generate a JWT token in Spring Boot

		A simple JWT flow is:

			User Login
			    ↓
			Validate username/password
			    ↓
			Generate JWT
			    ↓
			Send JWT to client
			    ↓
			Client sends JWT with every protected API
			    ↓
			Server validates JWT
			    ↓
			Allow / Reject request

		1. Add JWT dependency

			For a simple example, using JJWT:

			<dependency>
			    <groupId>io.jsonwebtoken</groupId>
			    <artifactId>jjwt-api</artifactId>
			    <version>0.12.6</version>
			</dependency>

			<dependency>
			    <groupId>io.jsonwebtoken</groupId>
			    <artifactId>jjwt-impl</artifactId>
			    <version>0.12.6</version>
			    <scope>runtime</scope>
			</dependency>

			<dependency>
			    <groupId>io.jsonwebtoken</groupId>
			    <artifactId>jjwt-jackson</artifactId>
			    <version>0.12.6</version>
			    <scope>runtime</scope>
			</dependency>

		2. Create a JWT Service

			@Service
			public class JwtService {

			    private final String secretKey =
			            "mySecretKeyForJwtGeneration12345678901234567890";

			    public String generateToken(String username) {

			        return Jwts.builder()
			                .subject(username)
			                .issuedAt(new Date())
			                .expiration(
			                    new Date(System.currentTimeMillis() + 1000 * 60 * 60)
			                )
			                .signWith(
			                    Keys.hmacShaKeyFor(
			                        secretKey.getBytes(StandardCharsets.UTF_8)
			                    )
			                )
			                .compact();
			    }
			}

		3. Generate token after login

			@RestController
			public class AuthController {

			    private final JwtService jwtService;

			    public AuthController(JwtService jwtService) {
			        this.jwtService = jwtService;
			    }

			    @PostMapping("/login")
			    public String login(@RequestParam String username,
			                        @RequestParam String password) {

			        // Normally validate username/password from database

			        if (username.equals("tony") && password.equals("1234")) {

			            return jwtService.generateToken(username);
			        }

			        throw new RuntimeException("Invalid username or password");
			    }
			}

		If we call:

			POST /login?username=tony&password=1234

			The server generates something like: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b255IiwiaWF0IjoxNz... 

		How is the JWT working?

			The generated JWT contains three parts:

			HEADER.PAYLOAD.SIGNATURE

			1. Header

				Contains information about the token, such as the algorithm.

				{
				  "alg": "HS256",
				  "typ": "JWT"
				}

			2. Payload

				Contains information called claims.

				For our example:

					{
					  "sub": "tony",
					  "iat": 1720000000,
					  "exp": 1720003600
					}

				Here:

					sub → username
					iat → token issued time
					exp → token expiration time

			3. Signature

				The server signs the header and payload using a secret key.

				Header + Payload + Secret Key
				            ↓
				        Signature

				The signature helps the server verify that the token hasn't been modified.

		How client uses the JWT

			After login, the client receives the token.

			For the next API:

				GET /users
				Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...

			The server:

				Receive Request
				      ↓
				Read JWT from Authorization header
				      ↓
				Verify Signature
				      ↓
				Check Expiration
				      ↓
				Get username/claims
				      ↓
				Allow API

			If the token is invalid or expired:

				401 Unauthorized

		Important interview point

			In a real application, don't hardcode the secret key or plain-text passwords like this example. 
			The secret should be stored securely, and passwords should be verified using a password-hashing mechanism such as BCrypt.

		Simple interview answer

			To generate a JWT, first the user logs in and we validate the username and password. 
			If authentication is successful, the server creates a JWT containing claims like username and expiration time and signs it using a secret key. 
			The token is returned to the client. For subsequent requests, the client sends the token in the Authorization header as a Bearer token. 
			The server validates the signature and expiration, and if the token is valid, it allows access to the API.

			Login → Validate → Generate JWT → Client sends Bearer token → Server validates → API access


65. Authentication vs Authorization.

	Authentication is the process of verifying who the user is, while authorization checks what that authenticated user is allowed to access. 
	For example, username and password or JWT can be used for authentication, while roles and permissions are used for authorization

	🔐 Authentication → Who are you?
	🛡️ Authorization → What can you access?

		@PreAuthorize("hasRole('ADMIN')")
		@GetMapping("/admin/users")
		public List<User> getUsers() {
		    return userService.getUsers();
		}

66. What is CORS?

	CORS stands for Cross-Origin Resource Sharing. It is a browser security mechanism that controls whether a frontend from one origin can access an API from another origin. 
	In Spring Boot, we can configure CORS using @CrossOrigin or global Spring Security/CORS configuration. 
	In production, we should allow only trusted frontend origins instead of allowing all origins.

	CORS = Controls which frontend origins can call my backend API.

	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	public class UserController {

	    @GetMapping("/users")
	    public List<User> getUsers() {
	        return userService.getUsers();
	    }
	}

67. How do you handle pagination?

	I handle pagination using Spring Data JPA's Pageable and Page. 
	Instead of fetching all records, I request only a specific page and page size. 
	For example, GET /users?page=0&size=10 returns the first 10 records. 
	We can also add sorting using the sort parameter. This improves performance when dealing with large datasets

	GET /users?page=0&size=10&sort=name,asc

68. How do you implement sorting and filtering?

	For sorting, I use Spring Data JPA's Sort or Pageable, for example ?sort=name,asc. 
	For filtering, I use request parameters and repository methods such as findByDepartment(). 
	If the filtering is dynamic or complex, I use JPA Specifications or custom queries. 
	I can also combine filtering, sorting, and pagination in the same API

69. How do you version APIs?

	API versioning is used to support different versions of an API when there are breaking changes. 
	For example, we can use /api/v1/users for the existing API and /api/v2/users for the new version. 
	This allows existing clients to continue working while new clients use the updated API. 
	Common approaches are URL versioning, header versioning, and query parameter versioning.

70. How do you test REST APIs?

	I test REST APIs using tools like Postman for manual testing and JUnit, Mockito, and MockMvc for automated testing. 
	I verify the status code, response body, headers, validation, authentication, authorization, and error scenarios. 
	I also test positive and negative cases to make sure the API behaves correctly.

71. Swagger vs Postman.

	Swagger, or OpenAPI, is mainly used to document and describe REST APIs and provides an interactive UI to try the APIs. 
	Postman is mainly used for API testing, where we can send requests, verify responses, use authentication, create collections, and automate tests. 
	In a project, I can use Swagger for API documentation and Postman for detailed API testing.


72. Scenario Interviewer: "Suppose your API is taking 10 seconds. How will you troubleshoot it?"

	If an API is taking 10 seconds, first I would identify where the time is being spent by checking logs, monitoring, and APM. 
	I would break_ the request into controller, service, database, and external API calls and measure each part. 
	If the database query is slow, I would check the SQL, indexes, joins, and execution plan using EXPLAIN. 
	If an external API is slow, I would check its response time and network latency. 
	I would also check application code, thread pool, database connection pool, CPU, memory, and GC. 
	After identifying the bottleneck, I would optimize that specific area and measure the response time again.

Hibernate / JPA — Very High Priority

73. What is an Entity?
	
	An Entity is a Java class that represents a database table in JPA. 
	We use the @Entity annotation to tell Hibernate that the class should be mapped to a database table. 
	Each object represents a row, and the class fields generally represent columns.

74. What is @Id?

	@Id is a JPA annotation used to identify the primary key of an Entity. 
	It tells Hibernate which field uniquely identifies each database record. 
	Usually, we use @Id with @GeneratedValue when we want the database to generate the ID automatically.

75. Different ID generation strategies.
	
	@GeneratedValue is used to automatically generate primary key values. 
	JPA provides four strategies: IDENTITY, SEQUENCE, TABLE, and AUTO. 
	IDENTITY usually uses database auto-increment, SEQUENCE uses a database sequence, TABLE uses a separate table for ID generation, and AUTO allows JPA to choose the appropriate strategy.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 101 102 103 - Commonly used with MySQL AUTO_INCREMENT.

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id; // This is commonly used with databases such as Oracle/PostgreSQL. Uses a database sequence to generate IDs.

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id; // JPA uses a separate table to keep track of the next ID. - It is less commonly used because it can have more overhead.

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // JPA decides which strategy to use based on the database and JPA provider.

76. Explain:- @OneToOne
- @OneToMany
- @ManyToOne
- @ManyToMany

	@OneToOne means one entity is related to one entity, like User and Passport. 
	@OneToMany means one entity is related to multiple entities, like Department and Employees. 
	@ManyToOne means multiple entities are related to one entity, like many Employees belonging to one Department. 
	@ManyToMany means multiple entities are related to multiple entities, like Students and Courses.

	@Entity
	public class User {

	    @Id
	    private Long id;

	    @OneToOne
	    private Passport passport;

	    @OneToMany
	    private List<Employee> employees;

	   	@ManyToOne
    	private Department department;

    	@ManyToMany
    	private List<Course> courses;
	}

77. What is lazy loading?

	Lazy loading means related data is loaded only when we actually need it. 
	For example, when I fetch a Department, Hibernate may load the Department first and load its Employees only when I call getEmployees(). 
	It helps avoid loading unnecessary data and can improve performance, especially for large relationships

	With lazy loading, if the Hibernate session is already closed when you access the relationship, you may get: LazyInitializationException

78. What is eager loading?

	Eager loading means related data is loaded immediately along with the main entity. 
	For example, when I fetch a Department, Hibernate also loads its Employees at the same time. 
	We use FetchType.EAGER for this. However, eager loading can load unnecessary data and affect performance if the relationship contains a large amount of data.

79. Lazy vs eager loading.

	Lazy loading loads related data only when we access it, while eager loading loads related data immediately along with the main entity. 
	Lazy loading can help avoid unnecessary database queries and is generally useful for large relationships. 
	Eager loading is useful when the related data is always required, but it can load unnecessary data and affect performance

80. What is cascading?

	Cascading in JPA means an operation performed on a parent entity is automatically applied to its related child entities. 
	For example, with CascadeType.PERSIST, when I save a User, its new Address can also be saved automatically. 
	Common cascade types are PERSIST, MERGE, REMOVE, REFRESH, DETACH, and ALL

		@Entity
		public class User {

		    @Id
		    private Long id;

		    @OneToOne(cascade = CascadeType.ALL)
		    private Address address;
		}

81. Explain cascade types.

	| Cascade Type | Meaning                                |
	| ------------ | -------------------------------------- |
	| `PERSIST`    | Save child when parent is saved        |
	| `MERGE`      | Update child when parent is updated    |
	| `REMOVE`     | Delete child when parent is deleted    |
	| `REFRESH`    | Refresh child when parent is refreshed |
	| `DETACH`     | Detach child when parent is detached   |
	| `ALL`        | Applies all cascade operations         |

82. What is the N+1 problem?

	The N+1 problem occurs when Hibernate executes one query to fetch the parent records and then executes one additional query for each parent to fetch its related data. 
	For example, if we fetch 100 departments and then load employees for each department, Hibernate may execute 101 queries. 
	This can cause performance problems. We can solve it using JOIN FETCH, Entity Graphs, or DTO projections.

83. How do you solve N+1?

	1. JOIN FETCH
		@Query("SELECT d FROM Department d JOIN FETCH d.employees")
		List<Department> findDepartmentsWithEmployees();

	2. Entity Graph

		@EntityGraph(attributePaths = "employees")
		List<Department> findAll();

	3. Use DTO projections

		Fetch only the data actually required instead of loading the complete entity graph.

84. What is JPQL?

	JPQL stands for Java Persistence Query Language. It is used with JPA to query Entity objects. 
	Unlike SQL, which works with database tables and columns, JPQL works with Entity classes and their fields. 
	For example, we can write SELECT u FROM User u WHERE u.department = :department to fetch users from a particular department

85. JPQL vs native SQL.

	SQL works with database tables and columns.
	JPQL works with Entity classes and their fields.

89. What is Hibernate first-level cache?

	Hibernate first-level cache is a cache maintained within the current Hibernate Session or JPA persistence context. 
	When an Entity is loaded, Hibernate keeps it in this cache. 
	If we request the same Entity again within the same Session, Hibernate can return it from the cache instead of querying the database again. 
	It is enabled by default

90. What is second-level cache?

	Hibernate second-level cache is a cache maintained at the SessionFactory level. 
	Unlike first-level cache, which is limited to one Session, second-level cache can be shared across multiple Sessions. 
	If an Entity is already available in the second-level cache, Hibernate can retrieve it without going to the database. 
	It is not enabled by default and requires configuration with a cache provider.

		@Entity
		@Cacheable
		@org.hibernate.annotations.Cache(
		    usage = CacheConcurrencyStrategy.READ_ONLY
		)
		public class Product {

		    @Id
		    private Long id;

		    private String name;
		}

91. What is dirty checking?

	Dirty checking is a Hibernate feature that automatically detects changes made to a managed Entity. 
	When an Entity is modified inside a transaction, 
		Hibernate compares its current state with its original state and automatically generates an UPDATE query during flush or transaction commit. 
	We don't need to explicitly call an update method.

		@Transactional
		public void updateUser(Long id) {

		    User user = userRepository.findById(id).get();

		    user.setName("Tony");
		}

92. What is persistence context?

	Persistence Context is a memory area managed by JPA/Hibernate where entity objects are managed during a transaction. 
	When an entity is loaded, Hibernate keeps it in the persistence context and tracks its changes. 
	Because of dirty checking, if I modify the entity, Hibernate automatically generates the UPDATE query during transaction commit. 
	It also acts as the first-level cache.

		@Transactional
		public void updateUser(Long id) {

		    User user = userRepository.findById(id).get();

		    user.setName("Tony");
		}

93. What is EntityManager?

	EntityManager is a JPA interface used to manage entities and interact with the persistence context. 
	It provides methods like persist, find, merge, and remove for database operations. 
	EntityManager also helps Hibernate track entity changes through the persistence context and dirty checking.

		@Transactional
		public void createUser(User user) {
		    entityManager.persist(user);
		}

		Common operations

			entityManager.persist(user);       // Insert
			entityManager.find(User.class, 1L); // Find
			entityManager.merge(user);         // Update
			entityManager.remove(user);        // Delete

	EntityManager = Manager of entities and Persistence Context.

94. What is @Transactional?

	@Transactional is a Spring annotation used to manage database transactions. 
	It makes multiple database operations execute as a single unit. 
	If all operations are successful, the transaction is committed. 
	If an exception occurs, the transaction can be rolled back, which helps maintain data consistency.

95. Where should @Transactional normally be placed?

	@Transactional is normally placed at the Service layer because the Service layer contains business logic and defines the transaction boundary. 
	If a business operation involves multiple database operations, 
	I can put @Transactional on the service method so that all operations are committed together or rolled back if an error occurs.

	@Transactional
	public void transferMoney(Long fromId, Long toId, double amount) {

	    debitAccount(fromId, amount);

	    creditAccount(toId, amount);
	}

96. What happens when a transaction fails?

	When a transaction fails, Spring rolls back the transaction, so the database changes made within that transaction are undone. 
	This helps maintain data consistency. By default, Spring rolls back for unchecked exceptions. 
	For checked exceptions, we can use rollbackFor to configure rollback

97. What is transaction propagation?

	Transaction propagation defines how a method should behave when it is called from another transactional method. 
	It decides whether the method should join the existing transaction or create a new one. 
	The default is REQUIRED, which joins the existing transaction if one exists, otherwise it creates a new transaction. REQUIRES_NEW always creates a separate transaction.

	Propagation = What should happen when another transaction already exists?

98. What is transaction isolation?

	Transaction isolation defines how one transaction is isolated from other concurrent transactions. 
	It controls what changes from other transactions can be seen and helps prevent issues like dirty reads, non-repeatable reads, and phantom reads. 
	The main isolation levels are Read Uncommitted, Read Committed, Repeatable Read, and Serializable.

	Isolation = How much one transaction can see from other transactions.

SQL / Oracle — Very High Priority
SQL theory
99. UNION vs UNION ALL.

	UNION combines the result of multiple SELECT queries and removes duplicate records. 
	UNION ALL also combines the results but keeps duplicates. Because UNION ALL doesn't perform duplicate removal, it is generally faster. 
	If I don't need duplicate removal, I prefer UNION ALL.

	UNION = Combine + Remove duplicates
	UNION ALL = Combine + Keep all

100. What causes slow SQL queries?

		A SQL query can become slow for several reasons. The most common causes are:

			1. Missing indexes
				
				Searching/filtering on columns without proper indexes can cause a full table scan.

			2. Wrong or inefficient indexes
			
				An index exists, but the query doesn't use it effectively because of column order, functions, or low selectivity.

			3. Large amount of data
				
				Querying millions of rows without filtering or pagination can be slow.
			
			4. Complex JOINs
				
				Joining many large tables without proper indexes on join columns can increase execution time.
			
			5. Using SELECT *
				
				Fetching unnecessary columns increases I/O and network overhead.
			
			6. Subqueries / correlated subqueries
		
				Some subqueries can execute repeatedly and become expensive.
			
			7. Functions on indexed columns

				WHERE YEAR(created_date) = 2026
				This can prevent efficient index usage in many databases.

			8. Sorting and grouping large datasets

				ORDER BY
				GROUP BY
				DISTINCT

				can require significant processing when working with large result sets.

			9. Locks / blocking
				
				Another transaction may be holding a lock, causing the query to wait.

			10. Poor database design

				Incorrect data types, unnecessary joins, or poor table structure can affect performance.

		How do you identify the problem?

			I would first check the query execution plan:

			EXPLAIN SELECT ...

			For MySQL, EXPLAIN ANALYZE can also provide actual execution information.

			I would check:

				Is the query doing a full table scan?
				Which indexes are being used?
				How many rows are being examined?
				Which JOIN is expensive?
				Is sorting/grouping expensive?
				Is the query waiting because of locks?

101. How do you optimize SQL?

	First, I check the query execution plan using EXPLAIN to identify the bottleneck. 
	Then I optimize indexes, joins, filters, and unnecessary columns. 
	I avoid SELECT *, reduce unnecessary data processing, use pagination for large results, and avoid functions on indexed columns where possible. 
	I also check for locking and long-running transactions. Finally, I compare the execution time before and after optimization.


102. What is an execution plan?

	An execution plan shows how the database plans to execute a SQL query. 
	It helps us understand whether the query is using indexes, doing full table scans, how joins are performed, and how many rows are being processed. 
	I use EXPLAIN or EXPLAIN ANALYZE to identify SQL performance bottlenecks and optimize the query.

6. Microservices — High Priority

103. What is microservices architecture?
Monolithic vs microservices architecture.
Advantages and disadvantages of microservices.
How do microservices communicate?
REST vs messaging.
What is API Gateway?
What is service discovery?
What is Eureka?
What is OpenFeign?
What is circuit breaker?
What is Resilience4j?
What happens if one service is down?
How do you handle distributed transactions?
What is Saga pattern?
What is centralized configuration?
How do you secure microservices?
How do you monitor microservices?
How do you trace a request across multiple services?
What is correlation ID?
How do you handle logging in microservices?

Important scenario
"Loan Service calls Customer Service and Customer Service is down. What should happen?"

You should discuss:

Loan Service
     ↓
Customer Service
     ↓
Timeout
     ↓
Retry
     ↓
Circuit Breaker
     ↓
Fallback / proper error response

7. Angular — High Priority for You

Although React is listed as primary and Angular as secondary, your real experience is Angular, so expect questions based on your resume.
1. What is Angular?
2. Angular architecture.
3. Components vs services.
4. What is dependency injection?
5. Lifecycle hooks.
6. ngOnInit() vs constructor.
7. What is RxJS?
8. Observable vs Promise.
9. Subject vs BehaviorSubject.
10. What is an interceptor?
11. How do you implement HTTP authentication?
12. How do you handle API errors?
13. What are route guards?
14. What is lazy loading?
15. What are Angular modules?
16. What is a pipe?
17. Pure vs impure pipe.
18. What is a directive?
19. Structural vs attribute directive.
20. Reactive forms vs template-driven forms.
21. How do you implement form validation?
22. How do you share data between components?
23. Parent → child communication.
24. Child → parent communication.
25. What is state management?
26. How does Redux/Ngrx work?
27. How do you optimize Angular performance?
28. What is change detection?
29. What is trackBy?
30. How do you implement debounce search?

11. Security / OWASP — Very Important
What is OWASP?
What is OWASP Top 10?
What is SQL Injection?
How do you prevent SQL Injection?
What is XSS?
How do you prevent XSS?
What is CSRF?
How do you prevent CSRF?
What is broken authentication?
What is broken access control?
What is sensitive data exposure?
How should passwords be stored?
Why shouldn't passwords be stored as plain text?
What is JWT?
Authentication vs authorization.
What is CORS?
How do you secure REST APIs?
How do you protect sensitive information in logs?


12. High Availability / Performance

This sentence in the JD is important:
"high-volume and low latency, required for production systems"

So expect:
1. How do you improve application performance?
2. How do you handle high traffic?
3. What is caching?
4. What is Redis?
5. What is database indexing?
6. How does connection pooling work?
7. What is HikariCP?
8. How do you optimize a slow API?
9. How do you optimize a slow SQL query?
10. How do you handle concurrent requests?
11. What is multithreading?
12. What is ExecutorService?
13. What is CompletableFuture?
14. What is race condition?
15. What is thread safety?
16. How would you design an application handling 10,000 requests per second?

13. Production / Scenario-Based Questions
This JD has a strong production-development focus, so these are very important.
Scenario 1
Production API suddenly becomes slow. What will you do?

Scenario 2
Production API is returning 500 errors. How will you investigate?

Scenario 3
Database query takes 10 seconds. How will you optimize it?

Scenario 4
Two users update the same record simultaneously. How will you handle it?

Scenario 5
An external API is down. Your API depends on it. What will you do?

Scenario 6
A production bug is reported by QA. What steps will you follow?

Scenario 7
Your application is consuming too much memory. How will you investigate?

Scenario 8
A user clicks Submit twice and two records are created. How will you prevent duplicate transactions?

Scenario 9
How would you design a high-volume loan application API?

This one is especially relevant to your FinTech/loan-system experience.

14. Your Project — Expect Deep Questions
Because you have real Spring Boot + Angular project experience, I would expect the interviewer to spend significant time here.
Prepare a 5-minute project explanation:

Project
   ↓
Business Problem
   ↓
Your Responsibilities
   ↓
Architecture
   ↓
Angular
   ↓
REST APIs
   ↓
Spring Boot
   ↓
Hibernate/JPA
   ↓
Database
   ↓
External APIs
   ↓
Security
   ↓
Testing
   ↓
Deployment
   ↓
Production Issues

They may ask:
- Explain your current project.
- What exactly is your responsibility?
- Explain one feature you developed end-to-end.
- Explain one complex API you developed.
- How does Angular communicate with Spring Boot?
- How do you handle exceptions?
- How do you handle authentication?
- How do you optimize database queries?
- What production issue did you solve?
- What was the most difficult feature you implemented?
- How did you debug a production issue?
- How do you test your APIs?
- How do you deploy your application?
- What improvements have you made to the application?