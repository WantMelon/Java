import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Runner extends Canvas {
    public static Point inputPoints() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input x: ");
        double x = Double.parseDouble(sc.next());
        System.out.print("Input y: ");
        double y = Double.parseDouble(sc.next());

        return new Point(x, y);
    }

    public static Point getThirdPoint(Point A, Point B) {
        double x;
        double y;

        x = ((A.getX() + B.getX()) + (A.getY() - B.getY())) / 2;
        y = ((A.getY() + B.getY()) - (A.getX() - B.getX())) / 2;

        return new Point(x, y);
    }

    public static Circle createCircle(Point A, Point B) {
        Point C = getThirdPoint(A, B);

        Segment AB = new Segment(A, B);
        Segment BC = new Segment(B, C);
        Segment AC = new Segment(A, C);

        double perimeter;
        perimeter = AB.getLength() + AC.getLength() + BC.getLength();

        Point O = new Point();
        O.setX((A.getX() * BC.getLength() + B.getX() * AC.getLength() + C.getX() * AB.getLength())
                / perimeter);
        O.setY((A.getY() * BC.getLength() + B.getY() * AC.getLength() + C.getY() * AB.getLength())
                / perimeter);

        double radius = (AC.getLength() + BC.getLength() - AB.getLength()) / 2;

        return new Circle(O, radius);
    }

    public static void main(String[] args) {
        Point A = inputPoints();
        Point B = inputPoints();
        System.out.println();

        Circle circle = createCircle(A, B);
        System.out.println("Center of circle: " + circle.getCenter().toString());
        System.out.println("Radius of circle: " + circle.getRadius());
    }
}
