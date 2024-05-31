package P2;

import java.util.ArrayList;

public class Person {
	private String name;
	private static ArrayList<String> personlist = new ArrayList<String>();

	/**
	 * Constructor with label
	 * @param nameString
	 *            the label of person
	 */
	public Person(String nameString) {
		if (personlist.contains(nameString)) {
			System.out.println("Repeated!");
		} else {
			this.name = nameString;
			personlist.add(nameString);
		}
	}

	/**
	 * Get name of the person
	 * @return name
	 */
	public String getName() {
		return name;
	}
}
