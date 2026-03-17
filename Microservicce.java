Microservicce

	=> What are Microservices?

		Microservices architecture is a design approach where an application is built as a collection of small, independent services.

		👉 In simple terms: 

			Instead of building one large application (monolith), we break it into multiple smaller services, each responsible for a specific function.

		Each microservice:

			- Runs independently
			- Has its own database
			- Communicates with other services using APIs

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

		✔ Independent deployment
		✔ Easier scaling
		✔ Faster development
		✔ Fault isolation
		✔ Technology flexibility

		Example: You can scale Payment Service only if traffic increases.

	=> Challenges of Microservices

		❌ Complex architecture
		❌ Network latency
		❌ Difficult debugging
		❌ Distributed data management

	=> Microservices vs Monolithic Architecture

		| Feature      | Monolithic         | Microservices      |
		| ------------ | ------------------ | ------------------ |
		| Architecture | Single application | Multiple services  |
		| Deployment   | Entire app         | Individual service |
		| Scalability  | Limited            | Highly scalable    |
		| Maintenance  | Difficult          | Easier             |

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

	=> Short Notes:

		Microservices architecture is a design approach where an application is divided into small, independent services that communicate through APIs. 
		Each service is responsible for a specific business function and can be developed, deployed, and scaled independently. 
		In Java, microservices are commonly built using Spring Boot and Spring Cloud.

