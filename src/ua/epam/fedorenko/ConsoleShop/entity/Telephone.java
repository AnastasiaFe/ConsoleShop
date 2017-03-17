package ua.epam.fedorenko.ConsoleShop.entity;


public class Telephone extends Gadget {

    private int numberOfSimCards;
    private String wayOfInput;

    public Telephone(double price, double width, double height, int numberOfSimCards, String wayOfInput) {
        super(price, width, height);
        this.numberOfSimCards = numberOfSimCards;
        this.wayOfInput = wayOfInput;
    }

    public Telephone() {

    }

    @Override
    public String toString() {
        return super.toString() + " Telephone{" + "numberOfSimCards=" + numberOfSimCards + ", wayOfInput='" + wayOfInput + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Telephone telephone = (Telephone) o;

        if (numberOfSimCards != telephone.numberOfSimCards) {
            return false;
        }
        return wayOfInput.equals(telephone.wayOfInput);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numberOfSimCards;
        result = 31 * result + wayOfInput.hashCode();
        return result;
    }

    public int getNumberOfSimCards() {

        return numberOfSimCards;
    }

    public void setNumberOfSimCards(int numberOfSimCards) {
        this.numberOfSimCards = numberOfSimCards;
    }

    public String getWayOfInput() {
        return wayOfInput;
    }

    public void setWayOfInput(String wayOfInput) {
        this.wayOfInput = wayOfInput;
    }
}
