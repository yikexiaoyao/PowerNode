package demo30;

public class Apple {
    double size;
    String color;

    public Apple(double size, String color) {
        this.size = size;
        this.color = color;
    }

    public Apple() {
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return size + "-" + color;
    }
}
