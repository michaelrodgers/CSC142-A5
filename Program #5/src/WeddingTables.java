import java.io.*;
import java.util.*;

public class WeddingTables {
	
	//creates a public string to identify the formatted text file with the list of names
	private static String file = "500names.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
		
		try {
		
				//declarations
				Scanner s = new Scanner(System.in);
				int totalGuests, m, n, tablesAtOptimal, tablesShortOne, leftOver;
				//gets user input for table size and number of guests
				System.out.print("How many guests will each table hold? ");
				m = s.nextInt();
				n = m-1;
				System.out.print("How many guests will be attending the wedding? ");
			    totalGuests = s.nextInt();
			    //assigns and remaining people as leftOver guests
			    leftOver = totalGuests%m;
			    //sets initial values of tablesAtOptimal and tablesShortOne
			    tablesAtOptimal = 0;
			    tablesShortOne = 0;
			    if (n>totalGuests) {
			    	System.out.print("There is no optimal solution.");  
			    } else {
			    //if m is a factor of total guests, divides total guests by m 
			    	} if (leftOver == 0) {
			    		tablesAtOptimal = totalGuests/m;
			    		n=0;
			    //check if leftOver is evenly divisible by tablesShortOne 
			    	} else if (leftOver%n == 0) {
			    		tablesShortOne = leftOver/n;
			    		tablesAtOptimal = (totalGuests-leftOver)/m;
			  
			    	} else {
			    		tablesAtOptimal = (totalGuests-leftOver)/m;
			    		if (leftOver%n >= n) {
			    			while (leftOver%n >= n) {
			    				tablesShortOne++;
			    				leftOver = leftOver - 9;
			    			}
			    		
			    		} else {
			    			tablesShortOne = 1;
			    			while (leftOver%n != 0){
			    			leftOver++;
			    			tablesAtOptimal--;
			    			tablesShortOne++; 
			    			}
			    		}
			    	}
			    	if (tablesShortOne < 0 || tablesAtOptimal < 0) {
			    		System.out.println("There is no optimal solution.");
			    	} else {
			    		System.out.println("With "+totalGuests+ " guests and a maximum of "+m+
						" guests per table, the optimal seating arrangement should have "
						+tablesAtOptimal+" tables of " +m+ " guests, and "+tablesShortOne + 
						" tables of "+n+ " guests.");
			    	}
			    	s.close();
		
		//opens 500names.txt
		Scanner sc = new Scanner(new File(file));
			
			//declarations for loop variables
			int i;
			int x;
			int count = 0;
			
			//loop to create tables when tables are at optimal 
			for (i = 0; i < tablesAtOptimal; i++) {
				Table table = new Table();
				ArrayList<String> guests = new ArrayList<String>();
				
				//loop to assign names to person class and assign names to a table
				for (x = 0; x < m; x++) {
					Person person = new Person();
					person.setName(sc.nextLine());
					guests.add(person.getName());
				}
				count++;
				table.setTable(count, guests);
				
				//prints results for tables at optimal
				System.out.println(table.getTable().keySet().toString().replace("[", "").replace("]", ""));
				System.out.println("\n "+table.getTable().values().toString().replace("[", "").replace("]", "").replace(",", "\n")+"\n");
			}
			
			//loop to create tables when tables are at short one
			for (i = 0; i < tablesShortOne; i++) {
				Table table = new Table();
				ArrayList<String> guests = new ArrayList<String>();
				
				//loop to assign names to person class and assign names to a table
				for (x = 0; x < (m-1); x++) {
					Person person = new Person();
					person.setName(sc.nextLine());
					guests.add(person.getName());
				}
				count++;
				table.setTable(count, guests);
				
				//prints results for tables at optimal
				System.out.println(table.getTable().keySet().toString().replace("[", "").replace("]", ""));
				System.out.println("\n "+table.getTable().values().toString().replace("[", "").replace("]", "").replace(",", "\n")+"\n");
			}
		sc.close();
		}
		
		//exception handling
		catch (IOException e) {
		e.printStackTrace();
		}
	}
}
