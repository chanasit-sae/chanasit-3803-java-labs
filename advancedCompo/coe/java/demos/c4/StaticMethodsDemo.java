package coe.java.demos.c4;

public class StaticMethodsDemo {
	// static method
	static void hello() {
		System.out.println("Hello");
	}
	//non-static method
	static void bye() {
		System.out.println("Bye");
	}
	// static method
	public static void main(String[] args) {
		hello();
		// static method cannot call
		// non-static method
		bye();
	}
}
