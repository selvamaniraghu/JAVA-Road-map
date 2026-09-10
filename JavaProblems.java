JAVA PROBLEMS


Sort array
Find maximum/minimum
Employee filtering
Group employees by role
Find highest salary by department

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
					.sorted(Comparator.reverseOrder())
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

	9. Sort Array

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

	3. Find Largest Element in Array

		int[] arr = {10, 20, 5, 40};

		int max = arr[0];

		for(int num : arr){
		    if(num > max){
		        max = num;
		    }
		}

		System.out.println(max);

	4. Count Vowels in String

		String str = "Hello";

		int count = 0;

		for(char c : str.toLowerCase().toCharArray()){
		    if("aeiou".indexOf(c) != -1){
		        count++;
		    }
		}

		System.out.println(count);

	12. Two Sum Problem (Very Important ⭐)

		int[] arr = {2,7,11,15};
		int target = 9;

		Map<Integer,Integer> map = new HashMap<>();

		for(int i=0;i<arr.length;i++){
		    int diff = target - arr[i];

		    if(map.containsKey(diff)){
		        System.out.println(diff + " " + arr[i]);
		    }

		    map.put(arr[i], i);
		}

	15. String Compression

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