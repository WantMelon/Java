import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Runner extends Canvas {
    public static Point createPoint() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input x: ");
        double x = Double.parseDouble(sc.next());
        System.out.print("Input y: ");
        double y = Double.parseDouble(sc.next());

        return new Point(x, y);
    }

    public static Circle createCircle(Point A, Point B) {
        Segment AB = new Segment(A, B);

        // TODO
        Point C = new Point();
        C.setX(AB.getMiddlePoint().getX() + AB.getLength() / 2);
        C.setY(AB.getMiddlePoint().getY());
        System.out.println(C.getX() + ", " + C.getY());

        Segment BC = new Segment(B, C);
        Segment AC = new Segment(A, C);
        System.out.println("Length: " + AB.getLength() + ", " + BC.getLength()
                + ", " + AC.getLength());

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
        Point A = createPoint();
        Point B = createPoint();

        Circle circle = createCircle(A, B);
        System.out.println("Center of circle: (" + circle.getCenter().getX()
                + ", " + circle.getCenter().getY() + ")");
        System.out.println("Radius of circle: " + circle.getRadius());
    }
}
