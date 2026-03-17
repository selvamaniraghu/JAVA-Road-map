Annotations

	=> What are Annotations in Java?

		* Annotations are metadata added to Java code that provide information to the compiler or runtime.

		👉 In simple terms: Annotations give extra instructions to the compiler or frameworks without changing the program logic.

		They start with `@`.

		Example:

			@Override
			public String toString() {
			    return "Hello";
			}

			- Here `@Override` is an annotation.

---

	=> Why Annotations Are Used

		Annotations help:

		✔ Reduce boilerplate code
		✔ Provide configuration without XML
		✔ Enable frameworks like Spring and Hibernate
		✔ Improve code readability

---

	=> Types of Annotations

		* Java annotations are mainly three types.

---

		1. Built-in Annotations

			* Provided by Java.

			Examples

			| Annotation             | Purpose                    |
			| ---------------------- | -------------------------- |
			| `@Override`            | Indicates method override  |
			| `@Deprecated`          | Marks method as obsolete   |
			| `@SuppressWarnings`    | Suppress compiler warnings |
			| `@FunctionalInterface` | Marks functional interface |

			Example:

			class Parent {
			    void display() {}
			}

			class Child extends Parent {

			    @Override
			    void display() {
						        System.out.println("Override method");
						    }

						}

		2. Custom Annotations

			* Developers can create their own annotations.

			Example:

					@interface MyAnnotation {
					    String value();
					}

			Usage :

				@MyAnnotation(value = "Example")
				class Test {}

		3. Meta Annotations

			* Annotations that define behavior of other annotations.

			Examples:

			| Annotation    | Purpose                         |
			| ------------- | ------------------------------- |
			| `@Target`     | Where annotation can be used    |
			| `@Retention`  | How long annotation is retained |
			| `@Documented` | Include in Javadoc              |
			| `@Inherited`  | Allow inheritance               |

			Example:
	
			@Retention(RetentionPolicy.RUNTIME)
			@Target(ElementType.METHOD)
			@interface MyAnnotation {}
					

	=> Annotations in Spring Boot

		* Spring heavily uses annotations.

		Examples:

		| Annotation               | Purpose                |
		| ------------------------ | ---------------------- |
		| `@SpringBootApplication` | Main application class |
		| `@RestController`        | REST API controller    |
		| `@Service`               | Service layer          |
		| `@Repository`            | Database layer         |
		| `@Autowired`             | Dependency injection   |
		| `@GetMapping`            | HTTP GET endpoint      |


		* Example:

		@RestController
		public class UserController {

		    @GetMapping("/users")
		    public String getUsers() {
		        return "Users list";
		    }

		}

	=> Annotations in JPA / Hibernate

		| Annotation   | Purpose              |
		| ------------ | -------------------- |
		| `@Entity`    | Database entity      |
		| `@Table`     | Table mapping        |
		| `@Id`        | Primary key          |
		| `@Column`    | Column mapping       |
		| `@OneToMany` | Relationship mapping |

		Example:

			@Entity
			public class User {

			    @Id
			    private Long id;

			    private String name;

			}

	=> Advantages of Annotations

		✔ Cleaner code
		✔ Less XML configuration
		✔ Better integration with frameworks
		✔ Compile-time checking	

	=> Short Notes:

		Annotations in Java are metadata that provide additional information about the program to the compiler or runtime environment. 
		They are used for configuration, code analysis, and framework integration. 
		Common examples include @Override, @Deprecated, and framework-specific annotations like @RestController and @Entity.
