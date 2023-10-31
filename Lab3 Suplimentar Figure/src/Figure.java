public class Figure implements FigureOperations {
    double dim1;
    double dim2;

    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    @Override
    public double Area() {
        System.out.println("Area for Figure is undefined.");
        return 0;
    }
}
