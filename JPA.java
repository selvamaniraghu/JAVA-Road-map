JPA

	=> What is JPA?

		* JPA (Java Persistence API) is a Java specification used for managing relational data in Java applications.

		👉 In simple terms: JPA allows Java objects to be stored and retrieved from a database automatically.

		- It provides Object Relational Mapping (ORM).

	=> Important Point

		* JPA is not an implementation, it is just a specification.

			Actual implementations include:

				| Implementation | Description                     |
				| -------------- | ------------------------------- |
				| Hibernate      | Most popular JPA implementation |
				| EclipseLink    | Oracle implementation           |
				| OpenJPA        | Apache implementation           |

				- In Spring Boot, JPA usually works with Hibernate.

	=> Example Entity Class

		import jakarta.persistence.*;

		@Entity
		public class User {

		    @Id
		    @GeneratedValue
		    private Long id;

		    private String name;
		}

		Mapping:

			User class → user table
			id → primary key

	=> Important JPA Annotations

		| Annotation        | Purpose                        |
		| ----------------- | ------------------------------ |
		| `@Entity`         | Marks class as database entity |
		| `@Table`          | Specifies table name           |
		| `@Id`             | Primary key                    |
		| `@GeneratedValue` | Auto-generate ID               |
		| `@Column`         | Map column                     |
		| `@OneToMany`      | One-to-many relationship       |
		| `@ManyToOne`      | Many-to-one relationship       |

	=> Repository Example

		* Spring Data JPA provides repositories.

			public interface UserRepository extends JpaRepository<User, Long> {
			}

			Now you automatically get:

				- save()
				- findById()
				- findAll()
				- delete()
				
				Without writing SQL.

	=> Example Service Usage

		@Service
		public class UserService {

		    @Autowired
		    private UserRepository repo;

		    public List<User> getUsers(){
		        return repo.findAll();
		    }

		}


	=> JPA Architecture

		Application
		     ↓
		JPA API
		     ↓
		Hibernate (Implementation)
		     ↓
		Database

	=> Advantages of JPA

		✔ Reduces boilerplate SQL code
		✔ Easy database operations
		✔ Supports object-oriented programming
		✔ Database independent
		✔ Integrates well with Spring Boot

	=> JPA vs Hibernate

		| Feature    | JPA                 | Hibernate      |
		| ---------- | ------------------- | -------------- |
		| Type       | Specification       | Implementation |
		| Purpose    | Defines ORM rules   | Implements ORM |
		| Dependency | Uses implementation | Standalone ORM |

	=> Short Notes: 

		JPA (Java Persistence API) is a Java specification used to manage relational data using object-relational mapping. 
		It allows Java objects to be mapped to database tables using annotations. JPA itself is not an implementation; 
		frameworks like Hibernate implement it. In Spring Boot, JPA simplifies database operations by using repositories and entity classes.
