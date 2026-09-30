Microservicce

	=> What are Microservices?

		Microservices architecture is an approach where a large application is divided into small, independent services, with each service responsible for a specific business functionality. 
		These services communicate through APIs or messaging systems and can be independently developed, deployed, and scaled. 
		For example, in a banking application, we can have separate User, Loan, Payment, and Notification services.
		In Java, microservices are commonly built using Spring Boot and Spring Cloud.

	=> Example: E-Commerce Application

		- In a monolithic application everything is in one system:

			User
			Product
			Order
			Payment
			Shipping

		- In microservices architecture:

			User Service
			Product Service
			Order Service
			Payment Service
			Shipping Service

			- Each service runs independently.

	=> Each service runs independently.

		Client
		  ↓
		API Gateway
		  ↓
		-----------------------------
		| User Service              |
		| Product Service           |
		| Order Service             |
		| Payment Service           |
		-----------------------------
		        ↓
		      Databases

	=> Technologies Used for Java Microservices

		* Most Java microservices are built using:

		| Technology   | Purpose               |
		| ------------ | --------------------- |
		| Spring Boot  | Build microservices   |
		| Spring Cloud | Microservice tools    |
		| Eureka       | Service discovery     |
		| API Gateway  | Routing requests      |
		| Feign Client | Service communication |
		| Docker       | Containerization      |
		| Kubernetes   | Deployment & scaling  |

	=> Communication Between Microservices

		* Microservices communicate using:

			1. REST APIs

				HTTP / JSON

				Example: Order Service → calls → Payment Service

			2. Messaging Systems

				Using message brokers like:

					- Kafka
					- RabbitMQ
					- ActiveMQ

				Example: Order created → message sent → Payment Service processes it

	=> Advantages of Microservices

		The main advantages of microservices are independent deployment, independent scaling, fault isolation, smaller codebases, and the ability for teams to work independently. 
		The main disadvantages are increased architectural complexity, network communication, distributed transaction management, data consistency issues, 
			monitoring and debugging challenges, and higher infrastructure requirements

	=> Microservices vs Monolithic Architecture

		Monolithic = One application, one deployment
		Microservices = Multiple services, independent deployment

	=> Example Microservice in Spring Boot

		@RestController
		@RequestMapping("/users")
		public class UserController {

		    @GetMapping
		    public String getUsers() {
		        return "User Service Running";
		    }

		}

		- This service can run independently.
