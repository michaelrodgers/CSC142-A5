/* This is a basic Person class.  There is one field, a private String 'name'
*/
public class Person {
	
	private String name;
	
	public Person(String str){     // a constructor that sets the name 
		name = str;
	}
	public Person(){            // a constructor if the name isn't known
	 	name = null;	
	}

	public String getName(){
		return name;
	}
	
	public void setName(String str) {
		name = str;
	}
	
	
	public static void main(String[] args) {   // a main for testing
		// TODO Auto-generated method stub
		
		
		Person person = new Person("Barney Rubble");
		Person person1 = new Person();
		
		System.out.println(person.getName());
		System.out.println(person1.getName());
		person1.setName("Fred Flintstone");
		System.out.println(person1.getName());
	}

}