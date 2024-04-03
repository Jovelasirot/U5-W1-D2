package jovelAsirot.U5W1D2.entities;

public class Pizza extends MenuItem {
    public Pizza(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
