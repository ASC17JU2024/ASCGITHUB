package java8;

import java.util.Arrays;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

public class StreamAPI {
    public static void main(String[] args) {
        //What are Streams?
        //A stream is a sequence of elements from a source that supports aggregate operations.
        //Stream does not store data, it operates on the source data structure and produce pipelined data.
        //A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
        //Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
        //Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations can be pipelined.
        //Terminal operations mark the end of the stream and return the result.
        //Streams are consumable only once. They are like an Iterator.
        
          // Example array
        // Integer[] numbers = {1, 2, 3, 4, 5};
        Integer[] numbers = new Integer[]{1, 3, 5};

        // Creating a stream from an array using Arrays.stream()
        Stream<Integer> numberStream = Arrays.stream(numbers);
        System.out.println("Stream created using Arrays.stream():");
        numberStream.forEach(System.out::println);

        // Creating a stream from an array using Stream.of()
        Stream<Object> numberStream2 = Stream.of("Hi", "Hello", "Howdy", new RuntimeErrorException(null), Arrays.asList(1,2,3));
        System.out.println("Stream created using Stream.of():");
        numberStream2.forEach(System.out::println);

        // Create map, filter and reduce operations
        System.out.println("Map, filter and reduce operations:");
        Arrays.stream(numbers)
                .map(n -> n * n)
                .filter(n -> n % 2 == 0)
                .reduce((sum, n) -> sum + n)
                .ifPresent(System.out::println);
                //Intermediate and Terminal Operations
                //Intermediate operations return the stream itself so you can chain multiple methods in a row. 
                //Terminal operations return a result of a certain type instead of again a Stream. 
                //Intermediate operations: filter(), map(), flatMap(), distinct(), sorted(), peek(), limit(), skip() etc.
                //Terminal operations: forEach(), collect(), reduce(), min(), max(), count(), anyMatch(), allMatch(), noneMatch() etc.
    }
}
