Race condition

	=> Race condition

		* A race condition occurs when multiple threads access and modify shared data at the same time, 
			and the final result depends on the timing of thread execution.

		👉 In simple terms: A race condition happens when threads compete to update shared data, causing unpredictable results.

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

	=> Race Condition vs Deadlock

		| Feature | Race Condition           | Deadlock                       |
		| ------- | ------------------------ | ------------------------------ |
		| Cause   | Simultaneous data access | Threads waiting for each other |
		| Result  | Incorrect data           | Program stuck                  |
		| Example | count++ issue            | Lock dependency                |

	=> Real-Life Example

		* Imagine two people editing the same bank account balance simultaneously.

			Balance = 1000

			Thread A withdraws 200
			Thread B withdraws 300

			- Without synchronization:

				Final balance may be incorrect

	=> Short Notes: 

		A race condition occurs when multiple threads access and modify shared data concurrently, and the final result depends on the order of execution. 
		It leads to unpredictable or incorrect results. 
		Race conditions can be prevented using synchronization mechanisms such as synchronized blocks, locks, or atomic variables.