package by.vsu;

public class Main {
    public static double expression(double a, double b, double c) {
        return (c/b + 3*(a-b));
    }

    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        System.out.println(expression(a, b, c));
    }
}