Interface vs Abstract class

	* Abstract Class

		- A class declared using the abstract keyword
		- Represents an “is-a” relationship
		- Used when classes share common behavior + structure

	* Interface

		- A blueprint of a class declared using the interface keyword
		- Represents a contract
		- Used when multiple unrelated classes must follow the same behavior

	=> Key Differences: Abstract Class vs Interface

	| Feature     		| Abstract Class                            | Interface                                        |
	| ----------------- | ----------------------------------------- | ------------------------------------------------ |
	| Keyword     		| `abstract class`                          | `interface`                                      |
	| Methods     		| Can have both abstract & concrete methods | Abstract by default (default/static from Java 8) |
	| Variables   		| Can have instance variables               | Variables are `public static final` by default   |
	| Inheritance 		| Supports single inheritance               | Supports multiple inheritance                    |
	| Use Case    		| Common base with shared code              | Define contract for implementation               |
	| Constructors		| Yes							            | No  							                   |
	| Access Modifiers	| Any (private, protected, public)			| Methods are public by default					   |
	| Use Case      	| Base class with shared code    			| Define rules/contract							   |

	=> Abstract Class Example
	abstract class Vehicle {
	    int speed; // instance variable

	    abstract void start(); // abstract method

	    void stop() {           // concrete method
	        System.out.println("Vehicle stopped");
	    }
	}

	class Car extends Vehicle {
	    void start() {
	        System.out.println("Car starts with key");
	    }
	}

	✔ Can have variables
	✔ Can have implemented methods
	✔ Can have constructor

	=> Interface Example

	interface Payment {
	    int MAX_LIMIT = 10000; // public static final by default

	    void pay(double amount); // public abstract by default

	    default void status() {  // Java 8+
	        System.out.println("Payment in progress");
	    }
	}

	class UPI implements Payment {
	    public void pay(double amount) {
	        System.out.println("Paid ₹" + amount + " via UPI");
	    }
	}

	✔ Supports multiple inheritance
	✔ Cannot store object state
	✔ Used for loose coupling

	=> When to Use What?

	Use Abstract Class when:

		- You want to share code among related classes
		- You need constructors
		- You want to maintain state
		- You expect subclasses to be closely related

	Use Interface when:

		- You want to define a contract
		- Multiple classes need the same behavior
		- You need multiple inheritance
		- You want loose coupling (e.g., APIs, services)
		- Classes are unrelated
		- You want support for lambda expressions (functional interfaces)

	=> Java 8+ Special Points (Often Asked)

	| Feature              | Abstract Class  | Interface                  |
	| -------------------- | --------------  | -------------------------- |
	| Default Methods      | Not needed  	 |  Yes                       |
	| Static Methods       | Yes          	 |  Yes                       |
	| Functional Interface | No              |  (Single abstract method)  |
	| Lambda Support       | No              | Yes                        |

	Summary

	“An abstract class is used when we want to share common code and state among related classes. It can have both abstract and concrete methods, 
	instance variables, and constructors, but it supports only single inheritance.
	An interface is used to define a contract. It supports multiple inheritance and promotes loose coupling. Interfaces cannot hold state, 
	but since Java 8 they can have default and static methods.
	In practice, we use abstract classes for base implementations and interfaces for defining behavior across unrelated classes.”


	Common Interview Trap Questions

	1. Can we create an object of an interface or abstract class?
		No, but references are allowed.

	2. Can an abstract class implement an interface?
		Yes, without implementing all methods.

	3. Can a class extend an abstract class and implement interfaces?
		Yes (extend first, then implement).
		Example: class A extends B implements C, D {}

	4. Can an interface have method implementations?
		Yes, since Java 8.
		Interfaces can have: 
			* default methods (with implementation)
			* static methods
		They cannot have instance methods with state.

	5. Can an abstract class implement an interface without implementing its methods?
		Yes, The abstract class can choose not to implement interface methods, but then the concrete subclass must implement them.

	6. Can a class extend multiple abstract classes?
		No, Java allows single inheritance for classes to avoid ambiguity (diamond problem).

	7. Why does Java support multiple inheritance through interfaces but not classes?
		👉 Because:
			- Interfaces do not hold state
			- No constructor ambiguity
			- Method conflicts are resolved explicitly by the implementing class
		This avoids the diamond problem.	

	8. Can an interface extend another interface?
		Yes, and it can extend multiple interfaces.
		interface A {}
		interface B {}
		interface C extends A, B {}

	9. Can an abstract class have a constructor? Why?
		Yes, Constructors are used to initialize variables of the abstract class when a subclass object is created.

	10. What happens if two interfaces have the same default method?
		Compile-time error unless the class:
			Overrides the method, and
			Explicitly resolves the conflict
		Example: InterfaceA.super.method();

	11. Can variables in an interface be private?
		No, All variables in an interface are: public static final by default

	12. Can we use final with abstract methods or classes?
		No, 
			abstract → meant to be overridden
			final → prevents overriding
		They contradict each other.

Notes:

	- Interface methods are public by default
	- Interface constructors ❌ not allowed
	- Static interface methods are not inherited
	- Abstract classes can have private methods


=> Real-World Scenario-Based Questions

1. Payment System Design
	* You are designing a payment system with UPI, Credit Card, and Net Banking. Which would you use — interface or abstract class?

	Interface. Because,
		- Payment methods are unrelated implementations
		- Common behavior (pay()) but different logic
		- Need loose coupling and extensibility
	
	interface Payment {
	    void pay(double amount);
	}

	✔ Supports multiple implementations
	✔ Easy to add new payment types

2. Shared Logic + Mandatory Rules
	* You have a base class with common validation logic, but subclasses must implement their own processing logic. What do you choose?

	Abstract class, Because, We want to reuse code. Also want to force method implementation

	abstract class OrderProcessor {
	    void validateOrder() { /* common logic */ }
	    abstract void processOrder();
	}

3. Multiple Capabilities Requirement

	* A class must support logging, auditing, and security features. How would you design it?

	Use multiple interfaces. Java does not support multiple class inheritance, Interfaces allow multiple behavior contracts.

	Example: class Service implements Loggable, Auditable, Secure {} 

4. Framework / API Design

	* Why do frameworks (Spring, JDBC) expose interfaces instead of abstract classes?

	- Promotes loose coupling
	- Allows developers to provide custom implementations
	- Supports dependency injection
	- Avoids inheritance restrictions

5. State Management Requirement

	* You need to store instance variables and control access to them. Interface or abstract class?

	Abstract class. Because, Interfaces cannot maintain object state.

6. Legacy System Upgrade (Java 8 Case)
	
	* You need to add a new method to an interface used by 100+ classes without breaking them. How?

	Use a default method in the interface.

	Example:

		default void log() {
		    System.out.println("Logging...");
		}

7. Plugin-Based Architecture

	* You are designing a plugin system where third-party developers can add features. What do you use?

	Interface. Because, 
		- Defines a strict contract
		- Independent implementations
		- Future-proof design

8. Abstract Class + Interface Together

	* Can you use both abstract class and interface together in real projects?

	Yes — very common.

	Example:

	abstract class BaseService implements Service {
	    // shared logic
	}

	✔ Interface → contract
	✔ Abstract class → shared implementation

9. Tight vs Loose Coupling Scenario

	* You expect frequent changes in implementation logic. Which is safer?

	Interface. Because, Client code depends on behavior, not implementation, Easy to swap implementations

10. Microservices / Clean Architecture

	* In microservices, why are interfaces preferred in service layers?

	- Encourages dependency inversion
	- Improves testability (mocking)
	- Makes services independent and scalable

🧠 How to Answer in Interviews (Pro Tip)

	Use this structure:
	Choice → Reason → Small example → Benefit

	Example:
	“I would use an interface here because it supports multiple implementations and loose coupling, 
	which is important for scalable systems like payment gateways.”


=> Spring Boot–Specific

1. Service Layer → Interface + Implementation

	* Why does Spring recommend interfaces in the service layer?
	- Loose coupling
	- Easy testing (mocking)
	- Flexible implementations

	public interface OrderService {
	    Order placeOrder(OrderRequest request);
	}

	@Service
	public class OrderServiceImpl implements OrderService {
	    @Override
	    public Order placeOrder(OrderRequest request) {
	        // business logic
	    }
	}

	// “Spring injects dependencies using the interface type, not the implementation.”


2. Dependency Injection → Abstraction in Action

	@RestController
	public class OrderController {

	    private final OrderService orderService;

	    public OrderController(OrderService orderService) {
	        this.orderService = orderService;
	    }
	}

	✔ Controller depends on abstraction, not implementation
	✔ Follows Dependency Inversion Principle (SOLID)

3. Switching Implementations Without Code Change

	Today you use MySQL, tomorrow MongoDB.

	public interface OrderRepository {
	    void save(Order order);
	}

	@Repository
	public class MySqlOrderRepository implements OrderRepository { }

	@Repository
	public class MongoOrderRepository implements OrderRepository { }

	@Qualifier("mongoOrderRepository")

	// “Only configuration changes, no business code changes.”

4. Spring Data JPA → Heavy Interface Usage

	* Why are repositories interfaces?

	public interface UserRepository extends JpaRepository<User, Long> {}

	- Spring provides runtime implementations
	- Uses proxy pattern
	- Reduces boilerplate code

	// “Spring generates the implementation at runtime.”

5. Abstraction via Spring Annotations

	| Annotation    | Abstracts What?       |
	| ------------- | --------------------- |
	| `@Controller` | HTTP request handling |
	| `@Service`    | Business logic        |
	| `@Repository` | Database access       |
	| `@Component`  | Generic bean          |
	
	// “Annotations hide infrastructure complexity.”

6. Interface for External Integrations	

	Calling third-party APIs (Payment Gateway, SMS, Email)

	public interface PaymentGateway {
	    void pay(double amount);
	}

	@Service
	public class RazorpayGateway implements PaymentGateway { }

	@Service
	public class StripeGateway implements PaymentGateway { }

	✔ Easy to swap vendors
	✔ Clean abstraction

7. Testing & Mocking (Very Important)

	* Why interfaces make testing easier?

	@MockBean
	private OrderService orderService;

	✔ Mocking interfaces is simpler
	✔ Isolates business logic

	// “Abstraction enables testability.”

8. Abstract Classes in Spring Boot (When Used?)

	- Shared utility logic
	- Template pattern

	public abstract class BaseService {
	    void log() { }
	    abstract void execute();
	}

	Less common than interfaces, but useful for shared logic.

9. Strategy Pattern with Spring
	
	public interface DiscountStrategy {
	    double applyDiscount(double amount);
	}

	@Service
	public class SeasonalDiscount implements DiscountStrategy { }

	// Spring automatically injects the correct strategy.

10. Spring Boot Interview One-Minute Answer
	
	“Spring Boot heavily uses abstraction through interfaces to achieve loose coupling, dependency injection, and easy testing. 
	Controllers depend on service interfaces, repositories are interfaces implemented at runtime by Spring, 
	and multiple implementations can be swapped without changing business logic. 
	This design follows SOLID principles and makes applications scalable and maintainable.”

=> Quick Summary

	| Layer         | Prefer                   |
	| ------------- | ------------------------ |
	| Controller    | Interface-based services |
	| Service       | Interface + Impl         |
	| Repository    | Interface                |
	| External APIs | Interface                |
	| Shared logic  | Abstract class           |


=> Real Project-Based Examples

	1. E-Commerce Order & Payment System

	Support multiple payment modes: UPI, Credit Card, Wallet
	New payment methods may be added later.

	Design (Abstraction)

	public interface PaymentService {
	    void pay(double amount);
	}

	@Service
	public class UpiPaymentService implements PaymentService {
	    public void pay(double amount) {
	        System.out.println("Paid via UPI: " + amount);
	    }
	}


	@Service
	public class CardPaymentService implements PaymentService {
	    public void pay(double amount) {
	        System.out.println("Paid via Card: " + amount);
	    }
	}


	@Service
	public class OrderServiceImpl implements OrderService {

	    private final PaymentService paymentService;

	    public OrderServiceImpl(@Qualifier("upiPaymentService") 
	                            PaymentService paymentService) {
	        this.paymentService = paymentService;
	    }

	    public void placeOrder(double amount) {
	        paymentService.pay(amount);
	    }
	}

	// “We used an interface to abstract payment logic so that adding a new payment method requires no change to order logic.”

	2. FinTech Loan Processing System

	Problem:
	Different loan types: Personal Loan, Business Loan
	Shared validation, different eligibility logic.

	Design (Abstract Class + Interface)

	public abstract class LoanProcessor {

	    public void validateCustomer() {
	        // common validation
	    }

	    public abstract boolean checkEligibility();
	}


	@Component
	public class PersonalLoanProcessor extends LoanProcessor {
	    public boolean checkEligibility() {
	        return true;
	    }
	}


	@Component
	public class BusinessLoanProcessor extends LoanProcessor {
	    public boolean checkEligibility() {
	        return false;
	    }
	}

	// “Abstract class was used to share common validation while enforcing loan-specific eligibility logic.”

	3. Warehouse / Inventory Management System

	Problem: Inventory stored in MySQL initially
	Later migrated to MongoDB.

	Design (Repository Abstraction)

	public interface InventoryRepository {
	    void save(Item item);
	}

	@Repository
	public class MySqlInventoryRepository implements InventoryRepository {
	    public void save(Item item) {
	        // MySQL logic
	    }
	}

	@Repository
	public class MongoInventoryRepository implements InventoryRepository {
	    public void save(Item item) {
	        // MongoDB logic
	    }
	}

	// “We switched databases without touching service logic, only configuration changed.”


	4. Notification System (Email, SMS, Push)

	Problem: Send notifications via multiple channels.

	Design (Strategy Pattern)

	public interface NotificationService {
	    void notifyUser(String message);
	}

	@Service
	public class EmailNotificationService implements NotificationService {
	    public void notifyUser(String message) {
	        System.out.println("Email sent");
	    }
	}


	@Service
	public class SmsNotificationService implements NotificationService {
	    public void notifyUser(String message) {
	        System.out.println("SMS sent");
	    }
	}

	// “Strategy pattern using interfaces allowed dynamic selection of notification channel.”

	5. Testing Example (Why Interfaces Matter)

	@MockBean
	private PaymentService paymentService;

	✔ Controller tested without real payment
	✔ Faster, isolated unit tests

	🧠 Interview Cheat Lines (Memorize These)

		Use these exact sentences:

		“We depend on interfaces to follow Dependency Inversion.”
		“Spring injects implementations at runtime.”
		“Abstraction helped us swap implementations without touching business logic.”
		“This design improved testability and scalability.”

	🎯 How to Answer in Interviews (Perfect Format)

		Problem → Design choice → Why → Benefit

		Example:

		“In our e-commerce project, we used a PaymentService interface so new payment methods could be added without modifying order logic.”