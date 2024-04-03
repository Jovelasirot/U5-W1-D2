package jovelAsirot.U5W1D2.entities;

public class Beverage extends MenuItem {
    public Beverage(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}