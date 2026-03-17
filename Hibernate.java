Hibernate

	=> What is Hibernate?

		* Hibernate is an ORM (Object Relational Mapping) framework for Java.

		👉 In simple terms: Hibernate maps Java objects to database tables automatically, so developers don’t need to write SQL manually.

		It simplifies database operations like CRUD.

	=> What is ORM?

		* ORM means Object Relational Mapping.

			It maps:

				- Java Class  →  Database Table
				- Java Field  →  Table Column
				- Java Object →  Row in Table

			Example:

				| Java Class | Database Table |
				| ---------- | -------------- |
				| `User`     | `users`        |

				| Java Field | Column |
				| ---------- | ------ |
				| `id`       | id     |
				| `name`     | name   |

	=> Why Hibernate is Used

		Without Hibernate:

			Connection con = DriverManager.getConnection(...);
			PreparedStatement ps = con.prepareStatement("INSERT INTO user VALUES (?,?)");

		With Hibernate:

			session.save(user);

		✔ Less code
		✔ No manual SQL
		✔ Faster development

	=> Hibernate Architecture

		Application
		     ↓
		Hibernate API
		     ↓
		JDBC
		     ↓
		Database

		Main components:

			- Configuration
			- SessionFactory
			- Session
			- Transaction
			- Query

	=> Important Hibernate Components

		| Component      | Description                      |
		| -------------- | -------------------------------- |
		| Configuration  | Loads Hibernate configuration    |
		| SessionFactory | Creates session objects          |
		| Session        | Main interface for DB operations |
		| Transaction    | Handles DB transactions          |
		| Query          | Executes HQL queries             |

	=> Hibernate Entity Example

		import jakarta.persistence.*;

		@Entity
		public class User {

		    @Id
		    @GeneratedValue
		    private Long id;

		    private String name;

		}

		- Hibernate automatically creates a table mapping.

	=> Basic Hibernate Operations

		| Operation | Method     |
		| --------- | ---------- |
		| Insert    | `save()`   |
		| Update    | `update()` |
		| Delete    | `delete()` |
		| Read      | `get()`    |
		
		Example:

			Session session = sessionFactory.openSession();

			Transaction tx = session.beginTransaction();

			session.save(user);

			tx.commit();
			session.close();

	=> Hibernate Query Language (HQL)

		* Hibernate provides HQL, which works with objects instead of tables.

			Example:

				Query query = session.createQuery("FROM User");
				List<User> users = query.list();		

			Instead of:

				SELECT * FROM users

	=> Hibernate Caching

		* Hibernate improves performance using caching.

			First-Level Cache

				- Default cache
				- Stored in Session

			Second-Level Cache

				- Shared across sessions
				- Uses tools like EhCache

	=> Hibernate vs JDBC

		| Feature     | JDBC   | Hibernate |
		| ----------- | ------ | --------- |
		| SQL writing | Manual | Automatic |
		| Code size   | Large  | Small     |
		| ORM         | No     | Yes       |
		| Maintenance | Hard   | Easy      |

	=> Hibernate vs JPA

		| Feature | Hibernate              | JPA                       |
		| ------- | ---------------------- | ------------------------- |
		| Type    | ORM framework          | Specification             |
		| Purpose | Implements ORM         | Defines ORM rules         |
		| Usage   | Standalone or with JPA | Used with implementations |

		* Hibernate is the most popular JPA implementation.

	=> Advantages of Hibernate

		✔ Reduces SQL code
		✔ Database independent
		✔ Built-in caching
		✔ Automatic table mapping
		✔ Faster development

	=> Short Notes: 

		Hibernate is an ORM framework that simplifies database operations by mapping Java objects to database tables. 
		It eliminates the need for writing SQL queries manually and provides features like automatic table mapping, caching, and transaction management. 
		Hibernate is also the most widely used implementation of the JPA specification.

