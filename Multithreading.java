Multithreading & Concurrency

Multithreading
	
	=> What is Multithreading?

		* 	Multithreading in Java allows multiple threads to run concurrently within a program to improve performance and responsiveness. 
			Threads can be created by extending the Thread class or implementing the Runnable interface. 
			Java provides synchronization mechanisms to ensure thread safety when multiple threads access shared resources. 
			For efficient thread management, Java offers the Executor framework and thread pools.

		Example: 

			- Downloading a file while playing music
			- Web servers handling multiple users simultaneously

	=> Common Multithreading Problems

		| Problem        | Description                    |
		| -------------- | ------------------------------ |
		| Race condition | Threads modify shared data     |
		| Deadlock       | Threads waiting for each other |
		| Starvation     | Thread never gets CPU          |
		| Livelock       | Threads active but no progress |

Concurrency

	=> What is Concurrency?

		* Concurrency means managing multiple tasks at the same time, even if they are not running simultaneously.

	=> Multithreading vs Concurrency

		| Feature | Multithreading             | Concurrency             |
		| ------- | -------------------------- | ----------------------- |
		| Meaning | Multiple threads executing | Managing multiple tasks |
		| Focus   | Parallel execution         | Task coordination       |
		| Example | Threads in Java            | Thread pools, executors |


	=> What is a Thread?

		* The Thread class in Java is used to create and manage threads, enabling concurrent execution of tasks. 
		A thread can be created by extending the Thread class and overriding the run() method. 
		The start() method begins thread execution and internally calls run(). 
		Java also provides methods like sleep(), join(), and yield() to control thread behavior.

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

	=> Why Use Threads?

		* Threads allow programs to perform multiple tasks simultaneously.

			Examples:

				- Web servers handling multiple users
				- Downloading files while browsing
				- Background processing in applications

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

	=> What is Runnable in Java?

		* Runnable is a functional interface in Java used to define a task that can be executed by a thread. 
		It contains a single method run(), which holds the thread logic. 
		A Runnable object is passed to a Thread object, and the thread is started using the start() method. 
		Runnable is preferred over extending Thread because it allows better flexibility and supports multiple inheritance.

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

	=> Thread vs Runnable (Interview Point)

		| Feature              | Thread             | Runnable               |
		| -------------------- | ------------------ | ---------------------- |
		| Type                 | Class              | Interface              |
		| Inheritance          | Must extend Thread | Can implement Runnable |
		| Multiple inheritance | Not possible	    | Possible	             |
		| Flexibility          | Less flexible      | More flexible          |
		| Recommended          | Less preferred	    | Preferred	             |

	=> ExecutorService

		=> What is ExecutorService in Java?

			* ExecutorService is a Java concurrency framework used to manage thread pools and execute asynchronous tasks efficiently. 
			Instead of creating threads manually, tasks are submitted to an ExecutorService, which manages thread allocation and execution. 
			It improves performance by reusing threads and provides methods like submit(), execute(), shutdown(), and invokeAll() for task management.

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

			ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

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

	=> synchronized

		=> What is synchronized in Java?

			* The synchronized keyword in Java is used to control access to shared resources in multithreaded environments. 
			It ensures that only one thread can execute a synchronized method or block at a time, preventing race conditions and ensuring thread safety. 
			Synchronization can be applied to methods, blocks, or static methods.

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
volatile

	=> What is volatile in Java?

		* The volatile keyword in Java ensures that a variable’s value is always read from main memory rather than a thread’s local cache, 
		guaranteeing visibility of changes across threads. However, volatile does not ensure atomicity or mutual exclusion, 
		so it is typically used for simple shared variables like flags or status indicators.

	=> Why volatile is Needed

		* In multithreading, each thread may cache variables locally.

			Example problem:

				Thread 1 → updates variable
				Thread 2 → still reads old cached value

				- This causes inconsistent results.

				- volatile solves this by forcing reads/writes directly from main memory.

	=> Example Without volatile:

		class SharedData {
		    boolean flag = false;
		}

		Thread 1:

			flag = true;

		Thread 2 might still see:

			flag = false

			- because of thread caching.

	=> Example With volatile

		class SharedData {
		    volatile boolean flag = false;
		}

		- Now when Thread 1 updates flag, all threads see the change immediately.

		Example Program

			class Example {

			    volatile boolean running = true;

			    void stop() {
			        running = false;
			    }

			    public static void main(String[] args) {

			        Example obj = new Example();

			        new Thread(() -> {
			            while(obj.running) {
			                // loop
			            }
			            System.out.println("Stopped");
			        }).start();

			        try { Thread.sleep(1000); } catch(Exception e) {}

			        obj.stop();
			    }
			}

			- Without volatile, the loop might never stop.

	=> Key Characteristics of volatile

		✔ Ensures visibility of changes between threads
		✔ Prevents thread caching issues
		✔ Lightweight compared to synchronization

	=> Limitations of volatile

		* Does not provide atomicity

			Example problem:

				volatile int count = 0;
				count++; 

				- count++ is not atomic, so race conditions may still occur.

			For this, use:

				- synchronized
				- AtomicInteger

	=> volatile vs synchronized

		| Feature       | volatile   | synchronized           |
		| ------------- | ---------- | ---------------------- |
		| Purpose       | Visibility | Visibility + atomicity |
		| Locking       | No locking | Uses locks             |
		| Performance   | Faster     | Slower                 |
		| Thread safety | Partial    | Full                   |

	=> When to Use volatile

		Use volatile when:

			- Variable is read by multiple threads
			- Only one thread writes
			- No complex operations like ++

		Common examples:

			- Flags
			- Status variables
			- Shutdown signals

	Wait/Notify

		=> What are wait() and notify() in Java?

			* The wait() and notify() methods in Java are used for inter-thread communication. 
			The wait() method causes a thread to release the object lock and enter a waiting state until another thread calls notify() or notifyAll(). 
			The notify() method wakes up one waiting thread, while notifyAll() wakes up all waiting threads. 
			These methods must be used inside synchronized blocks.

		=> Why Do We Need wait/notify?

			In multithreading, sometimes:

				- One thread must wait for another thread to complete a task
				- Threads must share data safely

		=> wait() Method

			wait() causes the current thread to:

				- Release the object lock
				- Enter waiting state
				- Wait until another thread calls notify() or notifyAll()

					Example:

						synchronized(obj) {
						    obj.wait();
						}

		=> notify() Method

			* notify() wakes up one waiting thread.

				Example:

					synchronized(obj) {
					    obj.notify();
					}

		=> notifyAll() Method

			* notifyAll() wakes up all waiting threads.

				Example:

					synchronized(obj) {
					    obj.notifyAll();
					}

		=> Example: Producer–Consumer

			class Shared {

			    synchronized void produce() throws InterruptedException {
			        System.out.println("Producing...");
			        wait();
			        System.out.println("Resumed production");
			    }

			    synchronized void consume() {
			        System.out.println("Consuming...");
			        notify();
			    }

			}

			Main program:

			public class Main {

			    public static void main(String[] args) {

			        Shared s = new Shared();

			        Thread producer = new Thread(() -> {
			            try {
			                s.produce();
			            } catch(Exception e){}
			        });

			        Thread consumer = new Thread(() -> {
			            try {
			                Thread.sleep(1000);
			                s.consume();
			            } catch(Exception e){}
			        });

			        producer.start();
			        consumer.start();
			    }

			}


			Output example:

			Producing...
			Consuming...
			Resumed production

		=> Important Rules

			1. Must be called inside synchronized block
			2. They belong to Object class
			3. Thread must own the object's monitor lock

		=> wait vs sleep

			| Feature      | wait()               | sleep()               |
			| ------------ | -------------------- | --------------------- |
			| Class        | Object               | Thread                |
			| Lock release | Releases lock        | Does not release lock |
			| Purpose      | Thread communication | Delay execution       |
			| Used in      | synchronized block   | Anywhere              |

		=> Thread Communication Flow

			Thread A → wait()
			Thread B → notify()
			Thread A → resumes execution

	Race condition

		=> Race condition

			* A race condition occurs when multiple threads access and modify shared data concurrently, and the final result depends on the order of execution. 
			It leads to unpredictable or incorrect results. 
			Race conditions can be prevented using synchronization mechanisms such as synchronized blocks, locks, or atomic variables.

		=> Example of Race Condition

			* Suppose two threads increment a shared variable.

				count++;

			- This operation is actually three steps internally:

				1. Read value of count
				2. Add 1
				3. Write value back

			- If two threads execute this at the same time:

				Thread 1 reads count = 5
				Thread 2 reads count = 5
				Thread 1 writes 6
				Thread 2 writes 6

				- Expected result → 7
				- Actual result → 6

				- This is a race condition.

		=> Example Program

			class Counter {

			    int count = 0;

			    void increment() {
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

			Expected output: 2000

			Actual output may be: 1873

			- Because of race condition.

		=> How to Prevent Race Condition

			1. Using synchronized

				synchronized void increment(){
				    count++;
				}

				- Ensures only one thread accesses the method at a time.

			2. Using Atomic Variables

				AtomicInteger count = new AtomicInteger();
				count.incrementAndGet();

				- Atomic operations are thread-safe.

			3. Using Locks

				ReentrantLock lock = new ReentrantLock();

				- Provides more advanced thread control.

		=> Real-Life Example

			* Imagine two people editing the same bank account balance simultaneously.

				Balance = 1000

				Thread A withdraws 200
				Thread B withdraws 300

				- Without synchronization:

					Final balance may be incorrect

	Deadlock

	=> What is Deadlock in Java?

		Deadlock is a situation in multithreading where two or more threads are blocked forever waiting for each other to release resources. 
		It usually occurs when threads locks in different orders, creating circular dependency. 
		Deadlocks can be avoided by maintaining consistent lock order, minimizing nested locks, or using timeout-based locking mechanisms.

	=> Simple Example

		Imagine two threads:

			Thread A → holds Lock 1 → waiting for Lock 2
			Thread B → holds Lock 2 → waiting for Lock 1

			- Both threads wait forever.

	=> Example Program

		class Resource {

		    void method1(Resource r) {
		        synchronized(this) {

		            System.out.println("Thread1 locked Resource1");

		            try { Thread.sleep(100); } catch(Exception e){}

		            synchronized(r) {
		                System.out.println("Thread1 locked Resource2");
		            }

		        }
		    }

		    void method2(Resource r) {
		        synchronized(this) {

		            System.out.println("Thread2 locked Resource2");

		            try { Thread.sleep(100); } catch(Exception e){}

		            synchronized(r) {
		                System.out.println("Thread2 locked Resource1");
		            }

		        }
		    }

		}

		Main program:

		public class Main {

		    public static void main(String[] args) {

		        Resource r1 = new Resource();
		        Resource r2 = new Resource();

		        Thread t1 = new Thread(() -> r1.method1(r2));
		        Thread t2 = new Thread(() -> r2.method2(r1));

		        t1.start();
		        t2.start();

		    }

		}

		- This program can cause deadlock.

	=> Four Conditions for Deadlock

		* Deadlock occurs when all four conditions happen simultaneously.

		| Condition        | Description                         |
		| ---------------- | ----------------------------------- |
		| Mutual Exclusion | Only one thread can use a resource  |
		| Hold and Wait    | Thread holds resource while waiting |
		| No Preemption    | Resource cannot be forcibly taken   |
		| Circular Wait    | Threads waiting in a cycle          |

	=> Deadlock Visualization

		Thread A → Resource 1 → waiting for Resource 2
		Thread B → Resource 2 → waiting for Resource 1

		Result: Both threads stuck forever

	=> How to Prevent Deadlock

		1. Lock Ordering

			* Always acquire locks in the same order.

				Example:

					Thread1 → Lock1 → Lock2
					Thread2 → Lock1 → Lock2

		2. Use tryLock()

			* Using ReentrantLock

				lock.tryLock();

				- Prevents waiting forever.

		3. Avoid Nested Locks

			* Minimize locking multiple resources.

		4. Use Timeout Locks

			* lock.tryLock(2, TimeUnit.SECONDS);

	=> Deadlock vs Race Condition

		| Feature | Deadlock         | Race Condition           |
		| ------- | ---------------- | ------------------------ |
		| Problem | Threads stuck    | Incorrect data           |
		| Cause   | Circular waiting | Simultaneous data access |
		| Result  | Program freezes  | Wrong results            |
		| Example | count++ issue    | Lock dependency          |