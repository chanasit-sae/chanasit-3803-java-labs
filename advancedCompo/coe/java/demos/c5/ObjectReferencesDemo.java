package coe.java.demos.c5;

class Person {
	String name;
}
public class ObjectReferencesDemo {
	// pass by value
	static void method1(int z) {
			// z is at address 1111
		    z = 42;
	}
	// p holds the address of the object
	static void method2(Person p) {
		// p is at address 3333
		p.name = "Chanapat";
	}
	public static void main(String[] args) {
		int x = 17;
		// x is at address 2222
		method1(x);
		System.out.println(x);	
		// p is at address 3333
		Person p = new Person(); // p is an object
		p.name = "Ta";
		// pass by reference
		method2(p);
		System.out.println(p.name);
	}
}
