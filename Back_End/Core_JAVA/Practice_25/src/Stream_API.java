/**
 * Stream API is a powerful tool for processing collections of data in a functional style. 
 * It provides a declarative way to express operations on data, making your code more concise and readable.
 * @author AshwinRaj
 *
 */
import java.util.Arrays;
import java.util.List;
//import java.util.Optional;
//import java.util.function.Consumer;
//import java.util.function.Function;
//import java.util.function.Predicate;
//import java.util.stream.Stream;

public class Stream_API {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 5, 6);
		
//		Consumer<Integer> con = new Consumer<Integer>() {
//			@Override
//			public void accept(Integer n) {
//				System.out.println(n);			
//			}
//		};
		
//		The above could be re-written as lambda Function, since Consumer is a functional Interface
//		Consumer<Integer> con = n -> System.out.println(n);
		
//		Since we are declaring the Consumer object for one use, we can directly pass it as input
		list.forEach(n -> System.out.println(n));
		
//		Predicate<Integer> pre = new Predicate<Integer>() {
//			@Override
//			public boolean test(Integer t) {
//				return t % 2 == 0 ? true : false;
//			}
//			
//		};
			
//		Predicate<Integer> pre = new Predicate<Integer>() {
//			@Override
//			public boolean test(Integer t) {
//				return t % 2 == 0 ? true : false;
//			}
//			
//		};
		
//		Function<Integer, Integer> fun = new Function<Integer, Integer>() {
//			@Override
//			public Integer apply(Integer t) {
//				return t*t;
//			}
//			
//		};
		
//		Stream<Integer> s1 = list.stream(); // converting to stream
//		Stream<Integer> s2 = s1.filter(n -> !(n % 2 == 0)); // filters the odd numbers
		
//		s1.forEach(con); // will not work, since streams could be used only once hence the name stream
//		
//		Stream<Integer> s3 = s2.map(n -> n * n); // Squaring the numbers
//		Stream<Integer> s4 = s3.distinct(); // Removing Duplicates
//		Stream<Integer> s5 = s4.sorted(); // Sorting the stream
//		int result = s5.reduce(1, (c, e) -> c * e); // Multiplying the elements of the stream, where 1 is the initial value
		
//		these lines could be written in a single line
		int result = list.stream()
				.filter(n -> !(n % 2 == 0))
				.map(n -> n * n)
				.distinct()
				.sorted()
				.reduce(1, (c, e) -> c * e);
		
		System.out.println(result);
	}

}
