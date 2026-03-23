Exception Handling

	* Exception handling is a mechanism used to handle runtime errors so that the program can continue execution without crashing.

	Example Without Exception Handling: 

		int a = 10;
		int b = 0;

		int result = a / b;  // ArithmeticException

		- Program crashes because division by zero is not allowed.

	Example With Exception Handling:

		try {
		    int a = 10;
		    int b = 0;
		    int result = a / b;
		}
		catch (ArithmeticException e) {
		    System.out.println("Cannot divide by zero");
		}

		Ouput : Cannot divide by zero

		✔ Program handles error safely.

	=> Keywords Used in Exception Handling


		| Keyword   | Purpose                       |
		| --------- | ----------------------------- |
		| `try`     | Code that may cause exception |
		| `catch`   | Handles exception             |
		| `finally` | Executes always               |
		| `throw`   | Manually throw exception      |
		| `throws`  | Declares exception            |

	1. try-catch

		* Used to handle exceptions.

			try {
			    int num = Integer.parseInt("abc");
			}
			catch(NumberFormatException e){
			    System.out.println("Invalid number");
			}

	2. finally

		* Runs always, whether exception occurs or not.

			try {
			    System.out.println("Inside try");
			}
			finally {
			    System.out.println("Cleanup code");
			}

			Used for:

				- Closing files
				- Database connections

	3. throw

		* Used to manually throw an exception.

			if(age < 18){
			    throw new ArithmeticException("Not eligible");
			}

		=> Key points:

			- Used inside method
			- Throws one exception at a time
			- Followed by exception object

	4. throws

		* throws is used in the method declaration to indicate that the method may throw exceptions.

			public void readFile() throws IOException {
			    FileReader file = new FileReader("data.txt");
			}

			- It tells the compiler that method may throw exception.

		=> Key points:

			- Used in method signature
			- Can declare multiple exceptions

	=> throw vs throws (Comparison)

		| Feature              | throw                    | throws            |
		| -------------------- | ------------------------ | ----------------- |
		| Purpose              | Manually throw exception | Declare exception |
		| Used in              | Method body              | Method signature  |
		| Number of exceptions | One                      | Multiple          |
		| Followed by          | Exception object         | Exception class   |

	=> Example Combining Both
	
		public void checkAge(int age) throws Exception {

		    if(age < 18){
		        throw new Exception("Age must be 18+");
		    }

		    System.out.println("Eligible");
		}

	=> throw vs Throws Short Notes:

		In Java, try-catch-finally is used to handle exceptions. 
		The try block contains code that may cause an exception, the catch block handles the exception, 
		and the finally block executes regardless of whether an exception occurs. 
		The throw keyword is used to manually throw an exception inside a method, 
		while throws is used in the method signature to declare that a method may throw certain exceptions.	

	=> Flow of Execution

		* try → exception occurs → catch → finally
		* try → no exception → finally

		- finally runs almost always (except JVM crash or System.exit()).

	=> Types of Exceptions in Java

			1. Checked Exceptions

				* Checked exceptions are checked by the compiler at compile time.

					This means the programmer must handle them using:

						- try-catch
						- or throws

					If not handled, the code will not compile.

					Example:

					 	FileReader file = new FileReader("data.txt");

					 	- Must use try-catch or throws.

					Handling:

						try {
						    FileReader file = new FileReader("data.txt");
						}
						catch(FileNotFoundException e){
						    System.out.println("File not found");
						}

				=> Common Checked Exceptions

					| Exception                | Description             |
					| ------------------------ | ----------------------- |
					| `IOException`            | File input/output error |
					| `SQLException`           | Database error          |
					| `FileNotFoundException`  | File missing            |
					| `ClassNotFoundException` | Class not found         |



			2. Unchecked Exceptions

				* Unchecked exceptions are not checked at compile time.

					- They occur during runtime due to programming errors.

					- The compiler does not force handling them.

					Example:

						String s = null;
						System.out.println(s.length());

				=> Common Unchecked Exceptions

					| Exception                        | Description           |
					| -------------------------------- | --------------------- |
					| `NullPointerException`           | Accessing null object |
					| `ArithmeticException`            | Divide by zero        |
					| `ArrayIndexOutOfBoundsException` | Invalid array index   |
					| `NumberFormatException`          | Invalid number format |

		=> Key Differences
		
			| Feature             | Checked Exception | Unchecked Exception  |
			| ------------------- | ----------------- | -------------------- |
			| Checked by compiler | Yes               | No                   |
			| Handling required   | Mandatory         | Optional             |
			| Occurs at           | Compile time      | Runtime              |
			| Cause               | External factors  | Programming errors   |
			| Example             | IOException       | NullPointerException |
				

	=> Exception Hierarchy

		Throwable
		   |
		-------------------------
		|                       |
		Exception               Error
		   |
		-------------------------
		|                       |
		Checked             RuntimeException
		                    |
		                 Unchecked

		- All unchecked exceptions extend RuntimeException.


	=> Checked & Unchecked Short Notes:

		Checked exceptions are checked at compile time and must be handled using try-catch or throws. 
		They usually represent external issues such as file or database errors. 
		Unchecked exceptions occur at runtime due to programming mistakes like null pointer access or division by zero, 
		and the compiler does not require them to be handled.

	=> Multiple Catch Example	

		try {
		    int arr[] = new int[5];
		    arr[10] = 50;
		}
		catch(ArithmeticException e){
		    System.out.println("Arithmetic error");
		}
		catch(ArrayIndexOutOfBoundsException e){
		    System.out.println("Array index error");
		}

	=> Short Notes:

		Exception handling in Java is a mechanism used to handle runtime errors so that the program continues execution normally. 
		It uses try, catch, finally, throw, and throws keywords to manage exceptions. 
		Java exceptions are classified into checked exceptions, which are handled at compile time, and unchecked exceptions, which occur at runtime.
