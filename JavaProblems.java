JAVA PROBLEMS

Java 8 Stream problems

	1. Reverse a String

		- Reverse a string without using built-in methods.

			String str = "Tony";
			String reversed = "";

			for(int i = str.length() - 1; i >= 0; i--) {
			    reversed += str.charAt(i);
			}

			System.out.println(reversed);

		- With build-in methods

			String str = "Tony";
			StringBuilder result = new StringBuilder();

		    for (int i = str.length() - 1; i >= 0; i--) {
		        result.append(str.charAt(i));
		    }

		    return result.toString();

		- Using Stream

			String streamValue = IntStream.range(0, str.length())
				.mapToObj(i -> String.valueOf(str.charAt(str.length() - 1 - i)))
				.collect(Collectors.joining());

			System.out.println("Stream reverse: " + streamValue);

	2. Check Palindrome

		- without stream and build in methods

			String str = "madam";
		
			int left = 0;
			int right = str.length() - 1;
			
			while (left < right) {
				if(str.charAt(left) != str.charAt(right)) {
					System.out.println("It is not polindrom");
					return;
				}
				
				left++;
				right--;
			}
			
			System.out.println("It is polindrom");

		- With build in methods

			String str = "madam";
		
			String rev = new StringBuilder(str).reverse().toString();
			
			if(rev.equals(str)) {
				System.out.println("It is polindrom");
				return;
			}
			
			System.out.println("It is not polindrom");

		- With Stream.

			String str = "madam";
		
			String rev = IntStream.range(0, str.length())
					.mapToObj(i -> String.valueOf(str.charAt(str.length() - 1 -i)))
					.collect(Collectors.joining());
			
			if(rev.equals(str)) {
				System.out.println("It is polindrom");
				return;
			}
			
			System.out.println("It is not polindrom");

	3. Reverse Integer

		- Without Stream

			int number = 12345;
			int reverseNumber = 0;
			
			while (number != 0) {
				reverseNumber = reverseNumber * 10 + number % 10;
				number /= 10;
			}
			
			System.out.println("Reverse integer : " + reverseNumber);

		- With Stream

			int number = 12345;

			int reverseNumber = Integer.parseInt(
					IntStream.range(0, String.valueOf(number).length())
					.mapToObj(i -> String.valueOf(number).charAt(String.valueOf(number).length() - 1 - i))
							.map(String::valueOf)
							.collect(Collectors.joining()));
			
			System.out.println("Reverse number: " + reverseNumber);

	4. Find Second Largest Number

		- Without Stream

			int[] arr = {10, 20, 5, 40};

			int first = Integer.MIN_VALUE;
			int second = Integer.MIN_VALUE;

			for(int num : arr){
			    if(num > first){	
			        second = first;
			        first = num;
			    } else if(num > second && num != first){
			        second = num;
			    }
			}

			System.out.println(second);

		- With Stream

			int[] arr = {10, 20, 5, 40};
		
			int secondLargest = Arrays.stream(arr)
					.distinct()
					.boxed()
					.sorted(Comparator.reverseOrder()) // .Sorted (If second smallest)
					.skip(1)
					.findFirst()
					.orElseThrow();
			
			System.out.println("Second largest number: " + secondLargest);

	5. Third largest number

		- Without Stream

			int[] arr = {10, 20, 5, 40};
			
			int largest = Integer.MIN_VALUE;
			int secondLargest = Integer.MIN_VALUE;
			int thiredLargest = Integer.MIN_VALUE;
			
			for(int num : arr) {
				if(num > largest) {
					thiredLargest = secondLargest;
					secondLargest = largest;
					largest = num;
				} else if (num > secondLargest && num != largest) {
					secondLargest = num;
				} else if (num > thiredLargest && num != secondLargest && num != thiredLargest) {
					thiredLargest = num;
				}
			}
			
			System.out.println("Second largest number: " + secondLargest);
			System.out.println("Thired largest number: " + thiredLargest);

		- With Stream

			int[] arr = {10, 20, 5, 40};
		
			int secondLargest = Arrays.stream(arr)
					.distinct()
					.boxed()
					.sorted(Comparator.reverseOrder())
					.skip(2)
					.findFirst()
					.orElseThrow();
			
			System.out.println("Second largest number: " + secondLargest);

	6. Remove Duplicates from Array

		int[] arr = { 1, 4, 4, 2, 2, 3 };

		Set<Integer> list = new HashSet<>();
		Set<Integer> linkedList = new LinkedHashSet<>();

		for (int n : arr) {
			list.add(n);
			linkedList.add(n);
		}

		int[] removeDuplicateArray = new int[list.size()];
		int index = 0;
				
		for (int a : list) {
			System.out.println("inside loop: " + a);
			removeDuplicateArray[index++] = a;
		}
		
		int[] streamValue = list.stream().mapToInt(Integer::intValue).toArray();
		
		int[] streamMapValue = Arrays.stream(arr).distinct().toArray();

		Remove duplicates and sort

		int[] result = Arrays.stream(arr).distinct().sorted().toArray();

		System.out.println("Remove duplicates: " + list);
		System.out.println("Remove duplicates: " + linkedList);
		System.out.println("Remove duplicates: " + Arrays.toString(streamMapValue));
		System.out.println("Remove duplicates: " + Arrays.toString(streamValue));
		System.out.println("Remove duplicates: " + Arrays.toString(removeDuplicateArray));

	7. Find Duplicate Elements

		- Without Stream

			int[] arr = {1,2,3,2,4,1};

			Set<Integer> seen = new HashSet<>();
			Set<Integer> duplicates = new HashSet<>();

			for(int num : arr) {
			    if(!seen.add(num)){
			        duplicates.add(num);
			    }
			}

			System.out.println(duplicates);

		- With Stream

			int[] arr = { 1, 4, 4, 2, 2, 3 };
			Set<Integer> seen = new HashSet<>();
			
			Set<Integer> duplicates = Arrays.stream(arr)
					.filter(i -> !seen.add(i))
					.boxed()
					.collect(Collectors.toCollection(LinkedHashSet::new));
			
			System.out.println("Duplicates Value: " + duplicates);

	8. Find Frequency of Characters


		- Without Stream

			String str = "programming";

			Map<Character, Integer> map = new HashMap<>();

			for(char c : str.toCharArray()){
			    map.put(c, map.getOrDefault(c, 0) + 1);
			}

			System.out.println(map);

		- With Stream

			String str = "Programming";
		
			Map<Character, Long> map = str.chars()
					.mapToObj(c -> (char) c)
					.collect(Collectors.groupingBy(
							Function.identity(),
							LinkedHashMap::new,
							Collectors.counting()
							));
			
			System.out.println("Frequency of character: " + map);

	9. First non repeated character

		- Without Stream

			String str = "Programming";
			Map<Character, Integer> map = new LinkedHashMap<>();
			
			for (char a : str.toCharArray()) {
				map.put(a, map.getOrDefault(a, 0) + 1);
			}
			
			for(Map.Entry<Character, Integer> entry : map.entrySet()) {
				if(entry.getValue() == 1) {
					System.out.println("First non repeated word: " + entry.getKey());
					return;
				}
			}

		- With Stream

			String str = "Programming";
		
			Map<Character, Long> map = str.chars()
					.mapToObj(c -> (char) c)
					.collect(Collectors.groupingBy(
							Function.identity(),
							LinkedHashMap::new,
							Collectors.counting()
							));
			
			Character a = map.entrySet()
					.stream()
					.filter(i -> i.getValue() == 1)
					.map(Map.Entry::getKey)
					.findFirst()
					.orElse(null);
					
			
			System.out.println("First non repeated word: " + a);

	10. Anagram Check

		- Without Stream

			String s1 = "listen";
			String s2 = "silent";

			char[] a = s1.toCharArray();
			char[] b = s2.toCharArray();

			Arrays.sort(a);
			Arrays.sort(b);

			System.out.println(Arrays.equals(a, b));

		- With Stream

			String s1 = "listen";
			String s2 = "silent";
			
			String sorted1 = s1.chars()
					.sorted()
					.mapToObj(i -> String.valueOf((char) i))
					.collect(Collectors.joining());
			
			String sorted2 = s2.chars()
					.sorted()
					.mapToObj(i -> String.valueOf((char) i))
					.collect(Collectors.joining());
			
			System.out.println("Anagram check: " + sorted1.equals(sorted2));

	11. Fibonacci Series

		- Without Stream

			int n = 10;
			int a = 0, b = 1;

			for(int i = 0; i < n; i++) {
			    System.out.print(a + " ");
			    int c = a + b;
			    a = b;
			    b = c;
			}

		- With Stream

			Stream.iterate(new int[] { 0, 1 }, pair -> new int[] { pair[1], pair[0] + pair[1] }).limit(10)
			.map(pair -> pair[0]).forEach(num -> System.out.print(num + " "));

	12. Check Prime Number

		- Without Stream

			int num = 29;
			boolean isPrime = true;

			for(int i = 2; i <= num / 2; i++){
			    if(num % i == 0){
			        isPrime = false;
			        break;
			    }
			}

			System.out.println(isPrime);

			int n = 29;
			
			for(int i = 2; i * i <= n; i++) {
				if(n % i == 0) {
					System.out.print("This is not prime");
					return;
				}
			}
			
			System.out.print("This is prime");

		- With Stream

			int num = 30;
		
			boolean isPrime = num >= 2 && IntStream.rangeClosed(2, (int) Math.sqrt(num))
					.noneMatch(i -> num % i == 0);
			
			System.out.print("prime: " + isPrime);

			Why only up to sqrt(num)? If a number has a factor greater than its square root, the corresponding factor must be smaller than the square root.

	13. Factorial

		- Without Stream

			int num = 5;
			int result = 1;
			
			for(int i = 1; i <= num; i++) {
				result *= i;
			}
			
			System.out.print(result);

		- With Stream

			int num = 5;
			long result = 1;
			
			result = LongStream.rangeClosed(1, num)
					.reduce(1, (a, b) -> a * b);
			
			System.out.print(result);

			Stream explanation: reduce() combines all values into one result.

	14. Missing Number

		- Without Stream

			int[] arr = {1, 2, 3, 5};
			int n = arr[arr.length - 1];
			
			int expectValue = n * (n + 1) / 2;
			int actualValue = 0;
			
			for(int a : arr) {
				actualValue += a;
			}
			
			System.out.print("Missing value is " + (expectValue - actualValue));

		- With Stream

			int[] arr = {1, 2, 3, 5};
			int n = arr[arr.length - 1];
			
			int expectValue = IntStream.rangeClosed(0, n).sum();
			int actualValue = Arrays.stream(arr).sum();
			
			System.out.print("Missing value is " + (expectValue - actualValue));

	15. Sort Array

		- Without Stream

			int[] arr = {5, 2, 9, 1};

			Arrays.sort(arr);

			System.out.println(Arrays.toString(arr));


			-------------------------------------

			int[] arr = { 5, 2, 9, 1 };

			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = 0; j < arr.length - 1 - i; j++) {
					if (arr[j] > arr[j + 1]) {
						int temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}

			System.out.print("Sorted array " + Arrays.toString(arr));

		- With Stream

			int[] arr = { 5, 2, 9, 1 };
		
			arr = Arrays.stream(arr).sorted().toArray();

			System.out.print("Sorted array " + Arrays.toString(arr));

	16. Find maximum/minimum

		- Without Stream

			int[] arr = { 5, 2, 9, 1 };
			
			int max = Integer.MIN_VALUE;
			
			for(int a : arr) {
				if(a > max) {
					max = a;
				}
			}
			
			System.out.println("Max value: " + max);
			
			int min = Integer.MAX_VALUE;
			
			for(int b : arr) {
				if(b < min) {
					min = b;
				}
			}

			System.out.println("Min Value: " + min);

		- With Stream

			max = Arrays.stream(arr).max().orElseThrow();
		
			System.out.println("Max value: " + max);
			
			min = Arrays.stream(arr).min().orElseThrow();
			
			System.out.println("Min value: " + min);

	17. Employee filtering

		- Without Stream

			Employee employee1 = new Employee(1, "Selvamani", "Developer", 58000, "Tech");
			Employee employee2 = new Employee(2, "Vijay", "Worker", 50000, "Management");
			Employee employee3 = new Employee(3, "Anitha", "Developer", 48000, "Tech");
			Employee employee4 = new Employee(4, "Divya", "Developer", 88000, "Mach");
			
			List<Employee> list = new ArrayList<>();
			
			list.add(employee1);
			list.add(employee2);
			list.add(employee3);
			list.add(employee4);
			
			List<Employee> result = new ArrayList<>();
			
			for(Employee e : list) {
				if(e.getSalary() > 50000) {
					result.add(e);
				}
			}
			
			System.out.println("List: " + result);

		- With Stream

			result = list.stream().filter(i -> i.getSalary() > 50000).collect(Collectors.toList());

			System.out.println("List: " + result);

	18. Group employees by role

		- Without Stream

			Map<String, List<Employee>> result = new HashMap<>();
		
			for(Employee e : list) {
				result.computeIfAbsent(e.getRole(), k -> new ArrayList()).add(e);
			}

			System.out.println("List: " + result);

		- With Stream

			Map<String, List<Employee>> result = new HashMap<>();
			
			result = list.stream().collect(Collectors.groupingBy(Employee::getRole));
			
			System.out.println("List: " + result);

	19. Find highest salary by department

		- Without Stream

			Map<String, Employee> map = new HashMap<>();
		
			for(Employee emp : list) {
				String dept = emp.getDepartment();
				
				
				if(!map.containsKey(dept) || emp.getSalary() > map.get(dept).getSalary()) {
					map.put(dept, emp);
				}			
			}
			
			System.out.println("Highest salary by department: " + map);

		- With Stream

			Map<String, Employee> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
			Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
		
			System.out.println("Map: " + map);

			Easy methods

				Map<String, Employee> map = list.stream().collect(Collectors.toMap(Employee::getDepartment, emp -> emp,
				(emp1, emp2) -> emp1.getSalary() > emp2.getSalary() ? emp1 : emp2));

				System.out.println("Map: " + map);

				Interview explanation: toMap() uses the department as the key. If two employees belong to the same department, the merge function keeps the employee with the higher salary.

	20. Find even numbers

		- Without Stream

			int[] a = {1, 2, 2, 3, 4, 5, 6};
			
			List<Integer> result = new ArrayList<>();
			
			for(int num : a) {
				if(num % 2 == 0) {
					result.add(num);
				}
			}
			
			System.out.println("Add number : " + result);

		- With Stream

			int[] a = {1, 2, 2, 3, 4, 5, 6};
		
			List<Integer> result = Arrays.stream(a).filter(num -> num % 2 ==0).boxed().collect(Collectors.toList());
		
			System.out.println("result: " + result);

	21. Find odd numbers

		List<Integer> oddNumbers = Arrays.stream(arr).filter(num -> num % 2 != 0).boxed().collect(Collectors.toList());

		System.out.println("oddNumbers: " + oddNumbers);

	22. Sum of all numbers

		- Without Stream

			int[] a = {1, 2, 2, 3, 4, 5, 6};

			int sum = 0;
			
			for(int n : a) {
				sum += n;
			}
			
			System.out.print("Sum: " + sum);

		- With Stream
			
			sum = Arrays.stream(a).sum();
			
			System.out.print("Sum: " + sum);

	23. Count numbers greater than 10

		int[] a = {1, 2, 2, 3, 4, 5, 6, 12};

		long count = Arrays.stream(a).filter(num -> num > 10).count();
		
		System.out.print("count: " + count);

	24. Find first number greater than 10

		int[] a = {1, 2, 2, 3, 4, 5, 6, 12};

		int count = Arrays.stream(a).filter(num -> num > 10).findFirst().orElseThrow();
		
		System.out.print("count: " + count);

	25. Sort ascending

		int[] a = {1, 52, 22, 3, 4, 5, 6, 12};

		int[] b = Arrays.stream(a).sorted().toArray();
		
		System.out.print("Ascending: " + Arrays.toString(b));

	26. Sort descending

		int[] a = {1, 52, 22, 3, 4, 5, 6, 12};
		
		List<Integer> c = Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		System.out.print("descending: " + c);

	27. Find average

		int[] a = {1, 52, 22, 3, 4, 5, 6, 12};
		
		double c = Arrays.stream(a).average().orElse(0.0);
		
		System.out.print("avg: " + c);

	28. Convert array to List

		int[] a = {1, 52, 22, 3, 4, 5, 6, 12};
		
		List<Integer> c = Arrays.stream(a).boxed().collect(Collectors.toList());
		
		System.out.print("avg: " + c);

	29. Convert List to Map

		Map<Integer, String> map = list.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
		
		System.out.println("List to map: " + map);	

	30. Count employees by role

		Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Employee::getRole, Collectors.counting()));
		
		System.out.println("Count employees by role: " + map);

	31. Find highest salary

		Employee e = list.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElseThrow();
		
		System.out.println("Find highest salary: " + e);

	32. Find employees with highest salary

		double max = list.stream().mapToDouble(Employee::getSalary).max().orElseThrow();
		
		List<Employee> emp = list.stream().filter(i -> i.getSalary() == max).collect(Collectors.toList());
		
		System.out.println("Find employees with highest salary: " + emp);

	34. Count Vowels in String

		String str = "Hello";

		int count = 0;

		for(char c : str.toLowerCase().toCharArray()){
		    if("aeiou".indexOf(c) != -1){
		        count++;
		    }
		}

		System.out.println(count);

	35. Two Sum Problem (Very Important ⭐)

		int[] arr = {2,7,11,15};
		int target = 9;

		Map<Integer,Integer> map = new HashMap<>();

		for(int i=0;i<arr.length;i++) {
		    int diff = target - arr[i];

		    if(map.containsKey(diff)) {
		        System.out.println(diff + " " + arr[i]);
		    }

		    map.put(arr[i], i);
		}

	36. String Compression

		String str = "aaabbc";
		String result = "";

		int count = 1;

		for(int i = 1; i < str.length(); i++){
		    if(str.charAt(i) == str.charAt(i-1)){
		        count++;
		    } else {
		        result += str.charAt(i-1) + "" + count;
		        count = 1;
		    }
		}
		result += str.charAt(str.length()-1) + "" + count;

		System.out.println(result);

	37. Filter last 5 employee using salary

		List<Employee> a = list.stream().sorted(
				Comparator.comparingDouble(Employee::getSalary).reversed()).limit(2).collect(Collectors.toList());

		--------------------------------------------------------------------------------------------------------------
		List<Transaction> result = new ArrayList<>(list1);

		result.sort(Comparator.comparingDouble(
		        Transaction::getAmount
		).reversed());

		if (result.size() > 5) {
		    result = new ArrayList<>(result.subList(0, 5));
		}

	38. Difference between map() and flatMap()

		- map() is used to transform each element into another element.

		List<String> names = Arrays.asList("John", "Ravi", "Kumar");

		List<Integer> lengths = names.stream()
		        .map(String::length)
		        .collect(Collectors.toList());

		System.out.println(lengths);

		-------------------------------------------------------------

		- flatMap() is used when each element produces multiple elements, and we want to flatten them into a single stream.

		List<List<Integer>> numbers = Arrays.asList(
	        Arrays.asList(1, 2),
	        Arrays.asList(3, 4),
	        Arrays.asList(5, 6)
		);

		List<Integer> result = numbers.stream()
		        .flatMap(List::stream)
		        .collect(Collectors.toList());

		System.out.println(result);

	39. Difference between filter() and map()

		- filter() Used to select elements based on a condition.
		- map() Used to transform elements.

	40. Difference between findFirst() and findAny()

		- findFirst() Returns the first element according to encounter order.

			Optional<Integer> result = Stream.of(10, 20, 30, 40).findFirst();

			System.out.println(result.get()); // 10

		- findAny() Returns any element.

			Optional<Integer> result = Stream.of(10, 20, 30, 40).findFirst();

			System.out.println(result.get()); // 10

			Sequentially, it will often return 10, but you should not rely on that, particularly with parallel streams.

			Optional<Integer> result = Stream.of(10, 20, 30, 40).parallel().findAny(); // 20

			It can return any element.
	
	41. Difference between reduce() and collect()

		- reduce() Used to combine multiple elements into one result.

			int sum = Arrays.asList(10, 20, 30, 40).stream().reduce(0, (a, b) -> a + b);

			System.out.println(sum); // 100

			Optional<Integer> max = Arrays.asList(10, 50, 30).stream().reduce(Integer::max);

			reduce → many values → one value

		- collect() Used to accumulate stream elements into a collection or other mutable result container.

			List<Integer> result = Arrays.asList(10, 20, 30).stream().collect(Collectors.toList());  // [10, 20, 30]

			Map<String, List<Employee>> result = employees.stream().collect(Collectors.groupingBy(Employee::getRole));  

Important Stream Methods to Remember

	Method	 Meaning

1. filter() - Select matching elements
2. map() - Transform elements
3. mapToInt() - Convert to primitive int stream
4. mapToDouble() - Convert to primitive double stream
5. sorted() - Sort elements
6. distinct() - Remove duplicates
7. limit() - Take first N elements
8. skip() - Skip first N elements
9. findFirst() - Get first element
10. findAny() - Get any element
11. count() - Count elements
12. sum() - Sum primitive numbers
13. average() - Calculate average
14. max() - Find maximum
15. min() - Find minimum
16. reduce() - Combine elements into one result
17. collect() - Collect results
18. groupingBy() - Group elements
19. toMap() - Convert to Map
20. forEach() - Perform action for each element
21. anyMatch() - At least one matches
22. allMatch() - All match
23. noneMatch() - None match



