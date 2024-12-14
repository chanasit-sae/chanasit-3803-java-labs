package coe.java.demos.c5.part1;
public class Person  {
	// instance variable
	protected String name;
	public Person() {
		
	}
	public Person(String name) {
		this.name = name;
	}
	// instance method
    public void greeting() {
		System.out.println("Sawasdee " + name);
	}
	public void setName(String n) {
		name = n;
	}
	String getName() {
		return name;
	}
}
