package lambda;

public class Person {
     private String firstName;
     private String lastName;
     private int age;
     
     public Person(String fn, String ln, int age) {
    	 this.lastName = ln;
    	 this.firstName = fn;
    	 this.age = age;
     }
     
     public void setFirstName(String name) {
    	 this.firstName = name;
     }
     public String getFirstName() {
    	 return firstName;
     }
     
     public void setLastName(String name) {
    	 this.lastName = name;
     }
     public String getLastName() {
    	 return lastName;
     }
     
     public void setAge(int age) {
    	 this.age = age;
     }
     public int getAge() {
    	 return age;
     }

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
     
     
     
}
