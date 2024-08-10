// GeometricObject Class
abstract class GeometricObject implements Comparable<GeometricObject> {
    public abstract double getArea();

    public static GeometricObject max(GeometricObject obj1, GeometricObject obj2) {
        return (obj1.compareTo(obj2) > 0) ? obj1 : obj2;
    }

    @Override
    public int compareTo(GeometricObject o) {
        return Double.compare(this.getArea(), o.getArea());
    }
}

// Circle Class
class Circle extends GeometricObject {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle with radius " + radius + " and area " + getArea();
    }
}

// Cylinder Class
class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * getRadius() * (getRadius() + height);
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    @Override
    public String toString() {
        return "Cylinder with radius " + getRadius() + ", height " + height + ", surface area " + getArea() + ", and volume " + getVolume();
    }
}

// ComparableCylinder Class
class ComparableCylinder extends Cylinder implements Comparable<ComparableCylinder> {
    public ComparableCylinder(double radius, double height) {
        super(radius, height);
    }

    @Override
    public int compareTo(ComparableCylinder o) {
        return Double.compare(this.getVolume(), o.getVolume());
    }
}

// Colorable Interface
interface Colorable {
    void howToColor();
}

// Square Class
class Square extends GeometricObject implements Colorable {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides of the square.");
    }

    @Override
    public String toString() {
        return "Square with side " + side + " and area " + getArea();
    }
}

// Main Class to Test the Program
public class Main {
    public static void main(String[] args) {
        // Test GeometricObject max method for Circle
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(7);
        System.out.println("Larger Circle: " + GeometricObject.max(circle1, circle2));

        // Test GeometricObject max method for Cylinder
        Cylinder cylinder1 = new Cylinder(3, 5);
        Cylinder cylinder2 = new Cylinder(4, 4);
        System.out.println("Larger Cylinder: " + GeometricObject.max(cylinder1, cylinder2));

        // Test ComparableCylinder
        ComparableCylinder comparableCylinder1 = new ComparableCylinder(3, 5);
        ComparableCylinder comparableCylinder2 = new ComparableCylinder(4, 4);
        System.out.println("Larger ComparableCylinder: " + (comparableCylinder1.compareTo(comparableCylinder2) > 0 ? comparableCylinder1 : comparableCylinder2));

        // Test Colorable Square
        Square square = new Square(6);
        square.howToColor();
        System.out.println(square);
    }
}
