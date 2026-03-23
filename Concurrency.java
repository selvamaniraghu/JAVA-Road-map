Concurrency

	=> What is Concurrency?

		* Concurrency means managing multiple tasks at the same time, even if they are not running simultaneously.

	=> Multithreading vs Concurrency

		| Feature | Multithreading             | Concurrency             |
		| ------- | -------------------------- | ----------------------- |
		| Meaning | Multiple threads executing | Managing multiple tasks |
		| Focus   | Parallel execution         | Task coordination       |
		| Example | Threads in Java            | Thread pools, executors |

	=> Synchronization (Thread Safety)

		* When multiple threads access shared data, problems can occur.

		- Example problem: Race Condition

			count++;

			Two threads updating simultaneously may cause incorrect result.

			Solution → synchronized

				synchronized void increment(){
				    count++;
				}

				✔ Ensures only one thread accesses at a time

	=> Thread Pool (Executor Framework)

		* Instead of creating threads manually, Java provides ExecutorService.

			Example: 

				ExecutorService executor = Executors.newFixedThreadPool(3);

				executor.submit(() -> {
				    System.out.println("Task executed");
				});

				executor.shutdown();

				✔ Efficient thread management
				✔ Used in Spring Boot / backend services

	=> Common Multithreading Problems

		| Problem        | Description                    |
		| -------------- | ------------------------------ |
		| Race condition | Threads modify shared data     |
		| Deadlock       | Threads waiting for each other |
		| Starvation     | Thread never gets CPU          |
		| Livelock       | Threads active but no progress |

	=> Short Notes:

		Multithreading in Java allows multiple threads to run concurrently within a program to improve performance and responsiveness. 
		Threads can be created by extending the Thread class or implementing the Runnable interface. 
		Java provides synchronization mechanisms to ensure thread safety when multiple threads access shared resources. 
		For efficient thread management, Java offers the Executor framework and thread pools.

ExecutorService

	=> What is ExecutorService in Java?

		* ExecutorService is an interface from the java.util.concurrent package used to manage and control a pool of threads.

		In simple terms: ExecutorService helps execute multiple tasks asynchronously without manually creating threads.

		- Instead of creating threads using:

		- new Thread()

		- we use thread pools managed by ExecutorService.

	=> Why ExecutorService is Needed

		Creating threads manually has problems:

			- Too many threads → memory issues
			- Poor performance
			- Difficult thread management

		ExecutorService solves this by:

			✔ Reusing threads
			✔ Managing task queues
			✔ Controlling concurrency

	=> Creating ExecutorService

		* The Executors utility class provides factory methods.

		- Fixed Thread Pool

			ExecutorService executor = Executors.newFixedThreadPool(3);

			- Creates 3 reusable threads.

	=> Example of ExecutorService

		import java.util.concurrent.*;

		public class Main {

		    public static void main(String[] args) {

		        ExecutorService executor = Executors.newFixedThreadPool(2);

		        executor.submit(() -> {
		            System.out.println("Task executed by thread: " +
		                    Thread.currentThread().getName());
		        });

		        executor.shutdown();
		    }

		}

		Output example: Task executed by thread: pool-1-thread-1

	=> Important Methods of ExecutorService

		| Method          | Purpose                    |
		| --------------- | -------------------------- |
		| `submit()`      | Submit task                |
		| `execute()`     | Execute task               |
		| `shutdown()`    | Stop accepting tasks       |
		| `shutdownNow()` | Stop immediately           |
		| `invokeAll()`   | Execute multiple tasks     |
		| `invokeAny()`   | Execute one task from many |

	submit() vs execute()

		| Feature            | submit()             | execute()     |
		| ------------------ | -------------------- | ------------- |
		| Return value       | Future object        | No return     |
		| Exception handling | Supported            | Limited       |
		| Usage              | Callable or Runnable | Runnable only |

	Example:

		Future<Integer> result = executor.submit(() -> 10 + 20);

	=> Types of Thread Pools

		* Java provides different thread pool types.

			| Thread Pool                 | Description               |
			| --------------------------- | ------------------------- |
			| `newFixedThreadPool(n)`     | Fixed number of threads   |
			| `newCachedThreadPool()`     | Creates threads as needed |
			| `newSingleThreadExecutor()` | Single worker thread      |
			| `newScheduledThreadPool()`  | Scheduled tasks           |

	=> Scheduled Executor Example

		ScheduledExecutorService scheduler =
        Executors.newScheduledThreadPool(1);

		scheduler.schedule(() ->
		        System.out.println("Task executed"), 2, TimeUnit.SECONDS);

		- Runs after 2 seconds.

	=> ExecutorService Workflow

		Task → ExecutorService → Thread Pool → Execution

		- Tasks are placed in a queue and executed by available threads.

	=> Advantages of ExecutorService

		✔ Better performance
		✔ Thread reuse
		✔ Task management
		✔ Prevents too many threads
		✔ Used in high-concurrency systems

	=> ExecutorService Short Notes:

		ExecutorService is a Java concurrency framework used to manage thread pools and execute asynchronous tasks efficiently. 
		Instead of creating threads manually, tasks are submitted to an ExecutorService, which manages thread allocation and execution. 
		It improves performance by reusing threads and provides methods like submit(), execute(), shutdown(), and invokeAll() for task management.

synchronized

	=> What is synchronized in Java?

		* synchronized is a keyword used to control access to shared resources in multithreading.

		In simple terms: synchronized allows only one thread at a time to access a block of code or method.

		- This prevents race conditions.

	=> What is a Race Condition?

		* A race condition occurs when multiple threads modify shared data simultaneously, causing incorrect results.

			Example (Problem):

				count++;

					- If two threads run this at the same time, the result may be wrong.

				Using synchronized to Fix It

					synchronized void increment() {
					    count++;
					}

					- Now only one thread can execute this method at a time.

	=> Types of Synchronization

		Java provides two types:

			1. Synchronized Method
			2. Synchronized Block

			1. Synchronized Method

				* Locks the entire method.

					Example:

						class Counter {

						    int count = 0;

						    synchronized void increment() {
						        count++;
						    }

						}

						✔ Only one thread can execute increment() at a time.

			2. Synchronized Block

				* Locks only a specific part of the code.

					Example:

						class Counter {

						    int count = 0;

						    void increment() {

						        synchronized(this) {
						            count++;
						        }

						    }

						}

						✔ More efficient than method-level synchronization.

	=> Static Synchronization

		* Used when multiple threads access static data.

			Example:

				synchronized static void display() {
				    System.out.println("Static synchronized method");
				}

				- Locks class-level object.

	=> How synchronized Works

		* Each object has a monitor lock.

			Thread 1 → acquires lock → executes code
			Thread 2 → waits until lock is released

	=> Example with Multiple Threads

		class Counter {

		    int count = 0;

		    synchronized void increment() {
		        count++;
		    }

		}

		public class Main {

		    public static void main(String[] args) throws Exception {

		        Counter c = new Counter();

		        Thread t1 = new Thread(() -> {
		            for(int i=0;i<1000;i++)
		                c.increment();
		        });

		        Thread t2 = new Thread(() -> {
		            for(int i=0;i<1000;i++)
		                c.increment();
		        });

		        t1.start();
		        t2.start();

		        t1.join();
		        t2.join();

		        System.out.println(c.count);
		    }

		}

		Output : 2000

		- Without synchronized, result might be incorrect.

	=> Advantages of synchronized

		✔ Prevents race conditions
		✔ Ensures thread safety
		✔ Protects shared resources

	=> Disadvantages

		❌ Slower performance due to locking
		❌ Risk of deadlock
		❌ Reduced concurrency	

	=> Short Notes Synchronized:

		The synchronized keyword in Java is used to control access to shared resources in multithreaded environments. 
		It ensures that only one thread can execute a synchronized method or block at a time, preventing race conditions and ensuring thread safety. 
		Synchronization can be applied to methods, blocks, or static methods.
