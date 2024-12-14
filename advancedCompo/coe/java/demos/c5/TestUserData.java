package coe.java.demos.c5;
class UserData {
		// class variable such as Math.PI
		// variable shared by all objects
		static String name;
		// non-static variable
		// instance variable
		// each object has its own value
		int age;
}
public class TestUserData {
	public static void main(String[] args) {
		UserData u1, u2;
		u1 = new UserData();
		u2 = new UserData();
		UserData.name = "Manee";
		System.out.println(UserData.name);
		u1.age = 2;
		u2.age = 3;
		System.out.println(u1.age);
		System.out.println(u2.age);
	}

}
