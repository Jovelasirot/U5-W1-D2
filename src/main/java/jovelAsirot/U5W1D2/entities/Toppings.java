package jovelAsirot.U5W1D2.entities;

public class Toppings extends MenuItem {
    public Toppings(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Toppings{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
