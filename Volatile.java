volatile

	=> What is volatile in Java?

		* volatile is a keyword used to ensure that a variable’s value is always read from main memory, not from a thread’s local cache.

			👉 In simple terms: volatile guarantees visibility of changes across multiple threads.

				- When one thread changes a volatile variable, all other threads immediately see the updated value.

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

	=> Short Notes:

		The volatile keyword in Java ensures that a variable’s value is always read from main memory rather than a thread’s local cache, 
		guaranteeing visibility of changes across threads. However, volatile does not ensure atomicity or mutual exclusion, 
		so it is typically used for simple shared variables like flags or status indicators.


