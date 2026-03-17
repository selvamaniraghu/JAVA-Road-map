Deadlock

	=> What is Deadlock in Java?

		* A deadlock occurs when two or more threads are waiting for each other to release resources, and none of them can proceed.

		👉 In simple terms: Deadlock is a situation where threads are stuck forever because they are waiting for each other’s locks.

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

	=> Short Notes:

		Deadlock is a situation in multithreading where two or more threads are blocked forever waiting for each other to release resources. 
		It usually occurs when threads acquire locks in different orders, creating circular dependency. 
		Deadlocks can be avoided by maintaining consistent lock order, minimizing nested locks, or using timeout-based locking mechanisms.

