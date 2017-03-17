package ua.epam.fedorenko.ConsoleShop.entity;


public class Laptop extends Computer {

    private double weight;
    private String touchPadDesc;

    public Laptop(double price, double width, double height, String processor, int ramSize, int diskSize, double weight, String touchPadDesc) {
        super(price, width, height, processor, ramSize, diskSize);
        this.weight = weight;
        this.touchPadDesc = touchPadDesc;
    }

    public Laptop() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getTouchPadDesc() {
        return touchPadDesc;
    }

    public void setTouchPadDesc(String touchPadDesc) {
        this.touchPadDesc = touchPadDesc;
    }

    @Override
    public String toString() {
        return super.toString()+ " Laptop{" + "weight=" + weight + ", touchPadDesc='" + touchPadDesc + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Laptop laptop = (Laptop) o;

        if (Double.compare(laptop.weight, weight) != 0) return false;
        return touchPadDesc.equals(laptop.touchPadDesc);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + touchPadDesc.hashCode();
        return result;
    }
}
