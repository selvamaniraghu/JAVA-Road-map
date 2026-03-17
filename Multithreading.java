Multithreading

	* Multithreading means executing multiple threads (small units of a process) simultaneously within a program.

	In simple terms: Multithreading allows a program to perform multiple tasks at the same time.

	Example: 

		- Downloading a file while playing music
		- Web servers handling multiple users simultaneously

	=> What is a Thread?

		* A thread is the smallest unit of execution inside a process.

		Example:

			Process → Java Application
			Thread 1 → UI
			Thread 2 → Background task
			Thread 3 → Network request

	=> Ways to Create Threads in Java

		There are two main ways.

			1. Extending Thread Class

				class MyThread extends Thread {

				    public void run(){
				        System.out.println("Thread running");
				    }

				}

				public class Main {
				    public static void main(String[] args){
				        MyThread t = new MyThread();
				        t.start();
				    }
				}

				✔ start() creates a new thread
				✔ run() contains the thread logic

			2. Implementing Runnable Interface (Preferred)

				class MyTask implements Runnable {

				    public void run(){
				        System.out.println("Task running");
				    }

				}

				public class Main {
				    public static void main(String[] args){
				        Thread t = new Thread(new MyTask());
				        t.start();
				    }
				}

				✔ Preferred because Java supports single inheritance

		=> Thread Lifecycle

			* A thread goes through different states.

			New → Runnable → Running → Waiting → Terminated

			| State      | Meaning              |
			| ---------- | -------------------- |
			| New        | Thread created       |
			| Runnable   | Ready to run         |
			| Running    | Executing            |
			| Waiting    | Waiting for resource |
			| Terminated | Execution finished   |

		=> Important Thread Methods

			| Method    | Purpose                      |
			| --------- | ---------------------------- |
			| `start()` | Start thread                 |
			| `run()`   | Thread logic                 |
			| `sleep()` | Pause thread                 |
			| `join()`  | Wait for thread to finish    |
			| `yield()` | Give chance to other threads |

			Example:

				Thread.sleep(1000);

				- Pauses thread for 1 second.

	=> What is the Thread Class in Java?

		* The Thread class in Java is used to create and control threads in a program.			

		It is part of the java.lang package.

		In simple terms: A Thread class represents a separate path of execution within a program.

	=> Why Use Threads?

		* Threads allow programs to perform multiple tasks simultaneously.

			Examples:

				- Web servers handling multiple users
				- Downloading files while browsing
				- Background processing in applications

	=> start() vs run()

		| Method    | Purpose               |
		| --------- | --------------------- |
		| `start()` | Starts a new thread   |
		| `run()`   | Executes thread logic |

		=> Example mistake:

			t.run();

			 - This runs like a normal method, not a new thread.

			Correct:

				t.start();

	=> Important Methods of Thread Class

		| Method      | Description                     |
		| ----------- | ------------------------------- |
		| `start()`   | Starts thread execution         |
		| `run()`     | Contains thread logic           |
		| `sleep()`   | Pauses thread                   |
		| `join()`    | Waits for thread completion     |
		| `yield()`   | Allows other threads to execute |
		| `getName()` | Returns thread name             |
		| `setName()` | Sets thread name                |

		=> Example: sleep()

			Thread.sleep(1000);

				- Pauses thread for 1 second.

	=> Thread Lifecycle

		* A thread goes through several states:

			- New → Runnable → Running → Waiting → Terminated

			| State      | Meaning              |
			| ---------- | -------------------- |
			| New        | Thread created       |
			| Runnable   | Ready to run         |
			| Running    | Executing            |
			| Waiting    | Waiting for resource |
			| Terminated | Finished execution   |

	=> Thread Example with Multiple Threads

		class MyThread extends Thread {

		    public void run(){
		        for(int i=1;i<=3;i++){
		            System.out.println(Thread.currentThread().getName());
		        }
		    }

		}

		public class Main {

		    public static void main(String[] args){

		        MyThread t1 = new MyThread();
		        MyThread t2 = new MyThread();

		        t1.start();
		        t2.start();

		    }

		}

		- Two threads run simultaneously.

	=> Thread vs Runnable (Interview Point)

		| Feature              | Thread             | Runnable               |
		| -------------------- | ------------------ | ---------------------- |
		| Type                 | Class              | Interface              |
		| Inheritance          | Must extend Thread | Can implement Runnable |
		| Multiple inheritance | Not possible	    | Possible	             |
		| Flexibility          | Less flexible      | More flexible          |
		| Recommended          | Less preferred	    | Preferred	             |


	=> Thread Short Notes:

		The Thread class in Java is used to create and manage threads, enabling concurrent execution of tasks. 
		A thread can be created by extending the Thread class and overriding the run() method. 
		The start() method begins thread execution and internally calls run(). 
		Java also provides methods like sleep(), join(), and yield() to control thread behavior.

	=> What is Runnable in Java?

		* Runnable is an interface in Java used to create a thread. It belongs to the java.lang package.

		- In simple terms: Runnable provides a way to define the task that a thread will execute.

		- Instead of extending Thread, we implement Runnable and pass it to a Thread object.

	=> Runnable Interface Syntax

		public interface Runnable {
		    void run();
		}

		- It has only one method:

		run()

		- This method contains the thread execution logic.

	=> Example of Runnable

		class MyTask implements Runnable {

		    public void run() {
		        System.out.println("Thread is running");
		    }

		}

		public class Main {

		    public static void main(String[] args) {

		        MyTask task = new MyTask();
		        Thread t = new Thread(task);

		        t.start();

		    }
		}


		Steps:
			1. Implement Runnable
			2. Override run()
			3. Create Thread object
			4. Call start()


	=> Runnable Using Lambda (Modern Java)

		* Since Runnable is a functional interface, we can use lambda expressions.

			Thread t = new Thread(() -> {
			    System.out.println("Thread running");
			});

			t.start();

	=> Why Runnable is Preferred

		* Java supports single inheritance, so if a class extends Thread, it cannot extend any other class.

		- Using Runnable avoids this problem.

		Example: class MyClass extends SomeOtherClass implements Runnable

		✔ More flexible design
		✔ Better for large applications

	=> Runnable in Thread Pools

		* Runnable is heavily used with ExecutorService.

			Example:

				ExecutorService executor = Executors.newFixedThreadPool(2);

				executor.submit(() -> {
				    System.out.println("Task executed");
				});

				Used in:

					- Web servers
					- Spring Boot background tasks
					- Microservices

		=> Short Notes:

			Runnable is a functional interface in Java used to define a task that can be executed by a thread. 
			It contains a single method run(), which holds the thread logic. 
			A Runnable object is passed to a Thread object, and the thread is started using the start() method. 
			Runnable is preferred over extending Thread because it allows better flexibility and supports multiple inheritance.