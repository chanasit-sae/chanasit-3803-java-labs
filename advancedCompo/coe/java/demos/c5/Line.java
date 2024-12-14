// package coe.java.demos.c5;
interface Drawable {
	public void draw();
}

interface Fillable {
	public void fill();
}

interface Colorable {
	public void color();
	public void rainbowColor();
}
public class Line implements Drawable, Fillable, Colorable {
	public void draw() {
		System.out.println("=== drawing a line ====");
	}
	public void fill() {
		System.out.println("=== Filling a line ====");
	}
	public void color() {
		System.out.println("=== Coloring a line ===");
	}
	public void rainbowColor() {
		
	}
	public static void main(String[] args) {
		Line l = new Line();
		l.draw();
		l.fill();
	}
} */
