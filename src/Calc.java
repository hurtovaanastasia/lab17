import java.io.*;

public class Calc implements Serializable {
    public double x;
    public double y;

    Calc(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calculate() {
        this.y = this.x - Math.sin(x);
        return this.y;
    }
}
