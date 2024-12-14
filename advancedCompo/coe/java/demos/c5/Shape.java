package coe.java.demos.c5;

public abstract class Shape {
	private String color;

	public void setColor(String newColor) {
		color = newColor;
	}

	public String getColor() {
		return color;
	}

	public abstract void redraw();

	public static void main(String[] args) {
		Shape s = new RoundRectangle();
		RoundRectangle r = new RoundRectangle();
		Oval o = new Oval();
		o.redraw();
		r.redraw();
	}
}

/*
 * class Triangle extends Shape { private float height, width; }
 */

class Triangle extends Shape {
	private float height, width;
	public void redraw() {}
}

class Oval extends Shape {
	public void redraw() {
		System.out.println("I'm an oval");
	}
}

// Rectangle3 is a subclass of abstract
// class Shape
class Rectangle3 extends Shape {
	// abstract class Shape has
	// abstract method redraw
	// that the subclass of class Shape
	// needs to define
	public void redraw() {
		
	}
}

class Triangle2 extends Shape {
		private float height, width;
		public void redraw() {
			
		}
}
