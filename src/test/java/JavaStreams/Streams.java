package JavaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Streams {
	
	//count the number of names starting with in List
	
	
	
	@Test(enabled = false)
	public void regular() {
		List<String> names = new ArrayList<String>();
		int count = 0;
		names.add("Anyt");
		names.add("Angela");
		names.add("Andres");
		names.add("Daniel");
		names.add("Allison");
		names.add("Don");
		for(String value : names) {
			if(value.startsWith("A")) {
				count+=1;
			}		
		}
		System.out.println("Regular count " + count);
	}
	
	@Test(enabled = false)
	public void StreamFilter() {
		List<String> names = new ArrayList<String>();
		int count = 0;
		names.add("Anyt");
		names.add("Angela");
		names.add("Andres");
		names.add("Daniel");
		names.add("Allison");
		names.add("Don");
		
		//count element that start with A
		count = (int) names.stream().filter(value -> value.startsWith("A")).count();
		System.out.println(count);
		Stream.of("Anyt", "Angela", "Andres", "Daniel", "Allison", "Don").filter(value -> value.startsWith("A")).count();
		
		//print all the names
		names.stream().filter(value -> value.length() > 4).forEach(s -> System.out.println(s));
		System.out.println("");
		names.stream().filter(value -> value.length() > 4).limit(2).forEach(s -> System.out.println(s));
	}
	
	@Test(enabled = false)
	public void StreamMap() {
		
		List<String> gender = new ArrayList<String>();
		int count = 0;
		gender.add("none");
		gender.add("Male");
		gender.add("Female");
		//
		
		List<String> name = Arrays.asList("Anyt", "Angela", "Andres", "Daniel", "Allison", "Don");
		name.stream()
		.filter(value -> value.endsWith("n"))
		.map(value -> value.toUpperCase())
		.forEach(s -> System.out.println(s));;
		
		System.out.println("");
		
		name.stream()
		.filter(value -> value.startsWith("A"))
		.map(value -> value.toUpperCase())
		.sorted()
		.forEach(s -> System.out.println(s));
		
		//merging 2 list
		System.out.println("");
		Stream.concat(gender.stream(), name.stream()).forEach(value -> System.out.println(value));;
		
	}
	
	@Test(enabled = true)
	public void streamCollect() {
		List<String> ls = Stream.of("Anyt", "Angela", "Andres", "Daniel", "Allison", "Don")
		.filter(value -> value.endsWith("n"))
		.map(value -> value.toUpperCase())
		.collect(Collectors.toList());
		for(String value : ls) {
			System.out.println(value);
		}
		
		System.out.println("");
		List<Integer> number = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
		number.stream().distinct().sorted().forEach(value -> System.out.println(value));
	}

}
