Encapsulation

	- Encapsulation is the OOP concept of wrapping data (variables) and methods (functions) 
	that operate on that data into a single unit — a class — while controlling access to them.
	- In short: Data hiding + controlled access through getters/setters. (It protects internal data from unintended modification.)

	=> Real-World Analogy
	Think of a capsule (medicine capsule):
		- You see the capsule (interface)
		- You cannot directly see or change what's inside (data hiding)
	Similarly, in a Java class, internal details are hidden.

	=> How Encapsulation Works in Java

	1. Make variables private - Prevents direct access from outside the class.
	2. Provide public getters and setters - Allows controlled access to data.

	=> Code Example

	class BankAccount {
	    private double balance; // data hidden

	    // getter
	    public double getBalance() {
	        return balance;
	    }

	    // setter with validation
	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	        }
	    }
	}

	public class Main {
	    public static void main(String[] args) {
	        BankAccount acc = new BankAccount();
	        acc.deposit(500); // allowed
	        System.out.println(acc.getBalance());
	    }
	}

	✔ balance is protected
	✔ Access only through controlled methods

	=> Why Do We Use Encapsulation?

	✔ Data Security
		Prevents other classes from changing values in unsafe ways.

	✔ Data Validation
		Setter methods allow adding rules/conditions.

	✔ Loose Coupling
		Internal implementation can change without affecting outside code.

	✔ Better Code Maintainability
		Encapsulated code is modular and easier to modify.

	=> Differences: Encapsulation vs Abstraction
	
	| Encapsulation                                     | Abstraction                               |
	| ------------------------------------------------- | ----------------------------------------- |
	| Hides data                                        | Hides implementation                      |
	| Achieved with private variables + getters/setters | Achieved with abstract classes/interfaces |
	| Focuses on protection                             | Focuses on design                         |

	=> Summary
	“Encapsulation in Java means hiding data by making fields private and exposing them through public getters and setters. 
	This ensures controlled access, data security, and allows validation before modifying values. 
	It helps make the code modular and maintainable. 
	In simple terms, it’s data hiding plus controlled access.”