transient

	=> What is transient in Java?

		* transient is a keyword used to indicate that a variable should not be serialized.

		👉 In simple terms: If a variable is marked as transient, its value will not be saved when the object is serialized.

	=> What is Serialization?

		* Serialization is the process of converting a Java object into a byte stream so it can be:

			- Stored in a file
			- Sent over a network
			- Saved in a database

			Example: ObjectOutputStream.writeObject(object);

	=> Why Use transient?

		* Some data should not be saved during serialization, such as:

			- Passwords
			- Temporary data
			- Session information

		Example: 

			import java.io.Serializable;

			class User implements Serializable {

			    String username;
			    transient String password;

			}

			Here:

				username → serialized
				password → not serialized

		Example Program:

		 	import java.io.*;

			class User implements Serializable {

			    String name = "Tony";
			    transient String password = "12345";

			}

			public class Main {

			    public static void main(String[] args) throws Exception {

			        User user = new User();

			        ObjectOutputStream out =
			                new ObjectOutputStream(new FileOutputStream("user.txt"));

			        out.writeObject(user);

			        out.close();

			        ObjectInputStream in =
			                new ObjectInputStream(new FileInputStream("user.txt"));

			        User u = (User) in.readObject();

			        System.out.println(u.name);
			        System.out.println(u.password);

			    }

			}

			Output : 

				Tony
				null

				- password becomes null because it was not serialized.

	=> Important Points

		✔ transient works only with Serializable objects
		✔ Used to exclude fields from serialization
		✔ After deserialization, transient variables get default values

		Example default values:

		| Type    | Default Value |
		| ------- | ------------- |
		| int     | 0             |
		| boolean | false         |
		| Object  | null          |

	=> transient vs static

		| Feature       | transient          | static               |
		| ------------- | ------------------ | -------------------- |
		| Purpose       | Skip serialization | Class-level variable |
		| Serialization | Not saved          | Not saved            |
		| Scope         | Object-level       | Class-level          |

	=> Short Notes:

		The transient keyword in Java is used to prevent a variable from being serialized when an object is converted into a byte stream. 
		It is typically used for sensitive or temporary data like passwords. 
		When an object is deserialized, transient variables receive their default values.