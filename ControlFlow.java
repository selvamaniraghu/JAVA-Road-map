Control Flow

=> What is Control Flow in Java?

	* Control flow determines the order in which the program executes statements or blocks of code.

	In simple terms: Control flow controls which code runs and when it runs.

	=> Types of Control Flow in Java

		There are three main categories:

			1. Decision-Making Statements
			2. Looping Statements
			3. Branching Statements

		1. Decision-Making Statements

			* These are used when the program must choose between different paths.

				=> if Statement

					Example:

					int age = 18;

					if(age >= 18){
					    System.out.println("Eligible to vote");
					}

				=> if-else

					Example:

					int number = 5;

					if(number % 2 == 0){
					    System.out.println("Even");
					} else {
					    System.out.println("Odd");
					}

				=> else if Ladder

					* Used when multiple conditions exist.

					Example: 

					int marks = 75;

					if(marks >= 90){
					    System.out.println("Grade A");
					}
					else if(marks >= 75){
					    System.out.println("Grade B");
					}
					else{
					    System.out.println("Grade C");
					}

				=> switch Statement

					* Used when multiple fixed choices exist.

					Example:

					int day = 2;

					switch(day){
					    case 1:
					        System.out.println("Monday");
					        break;
					    case 2:
					        System.out.println("Tuesday");
					        break;
					    default:
					        System.out.println("Invalid day");
					}


		2. Looping Statements

			* Loops are used to repeat a block of code multiple times.

				=> for Loop

					Example:

					for(int i = 1; i <= 5; i++){
					    System.out.println(i);
					}

				=> while Loop

					Example:

					int i = 1;

					while(i <= 5){
					    System.out.println(i);
					    i++;
					}

				=> do-while Loop
				
					Executes at least once.

					Example:

					int i = 1;

					do{
					    System.out.println(i);
					    i++;
					} while(i <= 5);

					
		3. Branching Statements
		
			* Used to alter the normal flow of loops or switch statements.

				=> break

					* Stops the loop immediately.

					for(int i=1;i<=5;i++){
					    if(i==3){
					        break;
					    }
					    System.out.println(i);
					}

					Ouput: 1 2

				=> continue

					* Skips the current iteration.

					for(int i=1;i<=5;i++){
					    if(i==3){
					        continue;
					    }
					    System.out.println(i);
					}

					Output: 1 2 3 4 5

				=> return

					* Exits from a method.

						return value;

			=> Summary 

			| Category        | Statements                    |
			| --------------- | ----------------------------- |
			| Decision Making | `if`, `if-else`, `switch`     |
			| Looping         | `for`, `while`, `do-while`    |
			| Branching       | `break`, `continue`, `return` |

			
			Short Notes:

			Control flow in Java determines the order in which statements execute. 
			It includes decision-making statements like if and switch, looping statements like for, while, and do-while, 
			and branching statements like break, continue, and return that alter the normal execution flow.	
