Wait/Notify

	=> What are wait() and notify() in Java?

		* wait() and notify() are methods of the Object class used to control communication between threads.

			👉 In simple terms: wait() makes a thread pause until another thread signals it using notify().

				- These methods are usually used inside synchronized blocks or methods.

	=> Why Do We Need wait/notify?

		In multithreading, sometimes:

			- One thread must wait for another thread to complete a task
			- Threads must share data safely

			Example scenario:

			Producer → produces data
			Consumer → consumes data

			If data is not available, the consumer should wait.

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

	=> Short Notes:

		The wait() and notify() methods in Java are used for inter-thread communication. 
		The wait() method causes a thread to release the object lock and enter a waiting state until another thread calls notify() or notifyAll(). 
		The notify() method wakes up one waiting thread, while notifyAll() wakes up all waiting threads. 
		These methods must be used inside synchronized blocks.