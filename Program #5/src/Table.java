import java.util.*;

public class Table {
	public String tableNumber;
	public HashMap<String, ArrayList<String>> table;
	public ArrayList<String> guestsAtTable;
	
	public Table(int count, ArrayList<String> guests){     //a constructor for Table objects
		tableNumber = "Table " + Integer.toString(count);
		table.put(tableNumber, guests);
	}
	public Table(){               //a constructor if the guests are unknown
		table = new HashMap<String, ArrayList<String>>();
	}
	public HashMap<String, ArrayList<String>> getTable(){    //get method
		return table;
	}
	public void setTable(int count, ArrayList<String> guests) {  //set method
		tableNumber = "Table " + Integer.toString(count);
		table.put(tableNumber, guests);
	}
	public boolean isSeatedAt(String str, Person person) {  //uses the string name of the table and the person's name to return a boolean if the person is seated there
		guestsAtTable = table.get(str);
		return (guestsAtTable.contains(person.getName()));
	}
}