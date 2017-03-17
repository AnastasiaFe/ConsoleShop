package ua.epam.fedorenko.ConsoleShop.entity;


public abstract class Gadget {

    private double price;
    private double width;
    private double height;

    @Override
    public String toString() {
        return "Gadget{" + "price=" + price + ", width=" + width + ", height=" + height + '}';
    }

    public Gadget(double price, double width, double height) {
        this.price = price;
        this.width = width;
        this.height = height;
    }

    public Gadget() {

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gadget gadget = (Gadget) o;

        if (Double.compare(gadget.price, price) != 0) return false;
        if (Double.compare(gadget.width, width) != 0) return false;
        return Double.compare(gadget.height, height) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
