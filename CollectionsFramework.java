Collections Framework

=> What is the Collections Framework in Java?

	* The Java Collections Framework is a set of classes and interfaces used to store, manage, and manipulate groups of objects dynamically.

	It is part of the java.util package.

=> Why Collections Framework is Needed

	Before collections, Java used arrays.

	Problems with arrays:

		- Fixed size
		- No built-in methods
		- Difficult to manage dynamic data

	Collections solve this by providing:

		- Dynamic resizing
		- Built-in algorithms
		- Easy data manipulation

=> Main Components of Collections Framework

	There are three main parts:	

		1. Interfaces
		2. Classes (Implementations)
		3. Algorithms (Utility methods)

=> Core Collection Interfaces

	Iterable
	   |
	Collection
	   |
	---------------------------------
	|        |        |              |
	List     Set      Queue          Map*

	- Map is not part of Collection, but part of the framework.

	1. List Interface

		* Stores ordered elements and allows duplicates.

			Characteristics

				- Maintains insertion order
				- Allows duplicate elements
				- Elements accessed using index

			Implementations

				- ArrayList
				- LinkedList
				- Vector
				- Stack

				Example:

					List<String> list = new ArrayList<>();

					list.add("Apple");
					list.add("Banana");
					list.add("Apple");

					System.out.println(list);

		=> ArrayList vs LinkedList

			| Feature            | ArrayList              | LinkedList             |
			| ------------------ | ---------------------- | ---------------------- |
			| Data Structure     | Dynamic Array          | Doubly Linked List     |
			| Access time        | Fast (O(1))            | Slow (O(n))            |
			| Insertion/Deletion | Slow (shifting needed) | Fast                   |
			| Memory             | Less memory            | More memory            |
			| Best for           | Read operations        | Frequent insert/delete |


	2. Set Interface

		* Stores unique elements only.

			Characteristics

				- No duplicates
				- No indexing
				- Some implementations maintain order

			Implementations

				- HashSet
				- LinkedHashSet
				- TreeSet					

				Example:

					Set<Integer> set = new HashSet<>();

					set.add(10);
					set.add(20);
					set.add(10);

					System.out.println(set);

					Output: [10, 20]

		=> HashSet vs TreeSet

			| Feature        | HashSet         | TreeSet             |
			| -------------- | --------------- | ------------------- |
			| Order          | No order        | Sorted order        |
			| Data structure | Hash table      | Red-Black Tree      |
			| Performance    | Faster (O(1))   | Slower (O(log n))   |
			| Null values    | Allows one null | Does not allow null |
			| Use case       | Fast lookup     | Sorted data         |

	3. Queue Interface

		* Used for FIFO (First In First Out) operations.

			Implementations

				- PriorityQueue
				- LinkedList
				- ArrayDeque

				Example:

					Queue<Integer> queue = new LinkedList<>();

					queue.add(1);
					queue.add(2);

					System.out.println(queue.poll());

	4. Map Interface

		* Stores key-value pairs.

			Characteristics

				- Keys must be unique
				- Values can be duplicated
				- Not part of Collection interface

			Implementations

				- HashMap
				- LinkedHashMap
				- TreeMap
				- Hashtable

		=> HashMap vs LinkedHashMap vs TreeMap
		
			| Feature        | HashMap        | LinkedHashMap             | TreeMap           |
			| -------------- | -------------- | ------------------------- | ----------------- |
			| Order          | No order       | Maintains insertion order | Sorted by key     |
			| Data structure | Hash table     | Hash table + linked list  | Red-Black Tree    |
			| Performance    | Fastest (O(1)) | Slightly slower           | Slower (O(log n)) |
			| Null key       | 1 allowed      | 1 allowed                 | Not allowed       |
			| Use case       | Fast lookup    | Ordered data              | Sorted data       |

			=> HashMap Example

				Map<Integer,String> map = new HashMap<>();
				map.put(3,"C");
				map.put(1,"A");
				map.put(2,"B");

				System.out.println(map);

				- Order not guaranteed

			=> LinkedHashMap Example
			
				Map<Integer,String> map = new LinkedHashMap<>();

				Maintains insertion order.

			=> TreeMap Example	

				Map<Integer,String> map = new TreeMap<>();

				Output automatically sorted by key.

=> Quick Summary
	
	| Interface | Feature                     | Example Classes       |
	| --------- | --------------------------- | --------------------- |
	| List      | Ordered, duplicates allowed | ArrayList, LinkedList |
	| Set       | Unique elements             | HashSet, TreeSet      |
	| Map       | Key-value pairs             | HashMap, TreeMap      |

	=> Short Notes:

		List stores ordered elements and allows duplicates, with common implementations like ArrayList and LinkedList. 
		Set stores unique elements and includes implementations like HashSet and TreeSet. 
		Map stores key-value pairs with unique keys, implemented by classes like HashMap, LinkedHashMap, and TreeMap. 
		HashMap provides fast access, LinkedHashMap maintains insertion order, and TreeMap stores elements in sorted order.			


=> Important Collection Classes

	| Interface | Class      | 특징                     |
	| --------- | ---------- | ----------------------- |
	| List      | ArrayList  | Fast access             |
	| List      | LinkedList | Fast insertion/deletion |
	| Set       | HashSet    | No duplicates           |
	| Set       | TreeSet    | Sorted set              |
	| Map       | HashMap    | Fast key-value storage  |
	| Map       | TreeMap    | Sorted map              |

=> Common Methods in Collections

	| Method       | Purpose             |
	| ------------ | ------------------- |
	| `add()`      | Add element         |
	| `remove()`   | Remove element      |
	| `size()`     | Number of elements  |
	| `contains()` | Check element       |
	| `clear()`    | Remove all elements |

=> Collections Utility Class

	* Java provides a Collections class with useful algorithms.

	Example: 

		Collections.sort(list);
		Collections.reverse(list);
		Collections.shuffle(list);


=> Short Notes:

	The Java Collections Framework is a set of interfaces and classes used to store and manipulate groups of objects dynamically. 
	It includes core interfaces like List, Set, Queue, and Map with implementations such as ArrayList, HashSet, and HashMap. 
	It provides built-in algorithms and improves efficiency compared to arrays


Iterators

=> What is an Iterator in Java?

	* An Iterator is an object used to traverse (iterate) through elements of a collection one by one.

	In simple terms: Iterator helps you read and remove elements from a collection safely.

	- It belongs to the java.util package.

=> Why Iterator is Used

	- To loop through collections
	- To avoid ConcurrentModificationException
	- To remove elements safely during iteration

=> How to Use an Iterator

	1. Get iterator from collection
	2. Check if next element exists
	3. Access element

	Example:

		import java.util.*;

		public class Main {
		    public static void main(String[] args) {
		        List<String> list = new ArrayList<>();

		        list.add("Java");
		        list.add("Python");
		        list.add("C++");

		        Iterator<String> it = list.iterator();

		        while(it.hasNext()){
		            System.out.println(it.next());
		        }
		    }
		}

		Output: Java Python C++

=> Important Methods of Iterator

	| Method      | Description                   |
	| ----------- | ----------------------------- |
	| `hasNext()` | Checks if next element exists |
	| `next()`    | Returns next element          |
	| `remove()`  | Removes current element       |

	=> Example Using remove()

		Iterator<Integer> it = list.iterator();

		while(it.hasNext()){
		    int num = it.next();
		    if(num == 10){
		        it.remove();
		    }
		}

		✔ Safe removal during iteration.

=> Types of Iterators

	* Java provides three main iterators:

	| Iterator       | Used For             | Direction          |
	| -------------- | -------------------- | ------------------ |
	| `Iterator`     | All collections      | Forward only       |
	| `ListIterator` | List implementations | Forward & backward |
	| `Enumeration`  | Legacy classes       | Forward only       |

=> ListIterator Example

	ListIterator<String> it = list.listIterator();

	while(it.hasNext()){
	    System.out.println(it.next());
	}

	while(it.hasPrevious()){
	    System.out.println(it.previous());
	}

	✔ Supports bi-directional traversal

=> Iterator vs For Loop

	| Feature                | Iterator | For Loop |
	| ---------------------- | -------- | -------- |
	| Remove elements safely | Yes    	| Risky  	|
	| Works with collections | Yes    	| Limited  |
	| Index access           | No     	| Yes    	|

=> Iterator vs Enumeration

	| Feature         | Iterator    | Enumeration       |
	| --------------- | ----------- | ----------------- |
	| Remove elements | Yes       	| No        	     |
	| Modern API      | Yes       	| Legacy	         |
	| Used with       | Collections | Vector, Hashtable |

Comparable vs Comparator in Java

	* Both Comparable and Comparator are used to sort objects in Java.

		The key difference:

			Comparable → defines natural sorting inside the class
			Comparator → defines custom sorting outside the class

		1. Comparable Interface

			* Used to define natural ordering of objects.

				It belongs to:

					java.lang.Comparable

				Method

					compareTo()

				Syntax

					public int compareTo(Object obj)

				Example

					class Student implements Comparable<Student> {

					    int age;

					    Student(int age){
					        this.age = age;
					    }

					    public int compareTo(Student s){
					        return this.age - s.age;
					    }
					}

				Sorting:

					Collections.sort(studentList);

					✔ Sorting logic is inside the class

		2. Comparator Interface
		
			* Used to define custom sorting logic.

				It belongs to:

					java.util.Comparator

				Method

					compare()

				Syntax

					public int compare(Object o1, Object o2)

				Example

					class AgeComparator implements Comparator<Student> {

					    public int compare(Student s1, Student s2){
					        return s1.age - s2.age;
					    }
					}


				Sorting:

					Collections.sort(studentList, new AgeComparator());

					✔ Sorting logic is outside the class

		=> Key Differences

			| Feature                   | Comparable        | Comparator              |
			| ------------------------- | ----------------- | ----------------------- |
			| Package                   | `java.lang`       | `java.util`             |
			| Method                    | `compareTo()`     | `compare()`             |
			| Sorting logic             | Inside class      | Outside class           |
			| Number of sorting options | One               | Multiple                |
			| Modification              | Must modify class | No need to modify class |

		=> Example Scenario

			Suppose Student has:

				- Age
				- Name
				- Marks

			Comparable

				Sort by default field (e.g., age)

			Comparator

				Sort by different fields

					- Name
					- Marks
					- Age

	=> Modern Java (Lambda Example)

		* Comparator can be simplified:

			Example:

				studentList.sort((s1, s2) -> s1.age - s2.age);

	=> Short Notes:

		Comparable is used to define the natural ordering of objects within the class by implementing the compareTo() method. 
		Comparator is used to define custom sorting logic outside the class using the compare() method. 
		Comparable allows only one sorting logic, while Comparator supports multiple sorting strategies.