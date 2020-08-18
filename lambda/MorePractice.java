package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MorePractice {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Shubham","Garg",22),
				new Person("Aman","Garg",20),
				new Person("Manav","Singhal",21),
				new Person("Amit","Jindal",20)
				);
		
		// sort by last name
		Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()) );
		
		
		// print all
		printConditionally(people, p -> true);
		
		
		// print lastname start with c
		printConditionally(people, p -> p.getLastName().startsWith("G"));
		
		
		// print firstname start with c
		printConditionally(people, p -> p.getFirstName().startsWith("A"));
		

	}
	
	static void printConditionally(List<Person> people,Condition condition) {
		for(Person p : people) {
			if(condition.test(p)) {
				System.out.println(p);
			}
		}
	}

}

interface Condition{
	boolean test(Person p);
}