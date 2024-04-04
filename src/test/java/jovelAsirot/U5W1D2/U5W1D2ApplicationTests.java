package jovelAsirot.U5W1D2;

import jovelAsirot.U5W1D2.entities.Menu;
import jovelAsirot.U5W1D2.entities.MenuItem;
import jovelAsirot.U5W1D2.entities.Order;
import jovelAsirot.U5W1D2.entities.Pizza;
import jovelAsirot.U5W1D2.enums.OrderStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class U5W1D2ApplicationTests {

    @Test
    public void testOrderInitialize() {
        System.out.println("Order initialization");
        Order order = new Order();
        Assertions.assertNotNull(order);
    }

    @Test
    public void testOrderStatusA() {
        System.out.println("Order status - in progress");
        Order order = new Order();
        order.setStatus(OrderStatus.IN_PROGRESS);
        Assertions.assertEquals(OrderStatus.IN_PROGRESS, order.getStatus());
    }

    @Test
    public void testOrderTotal() {
        Order orderB = new Order();
        Pizza pizzaA = new Pizza("Salsiccia", 7.50);
        Pizza pizzaB = new Pizza("Diavola", 7.50);

        double tableCharge = 2.5;

        orderB.getItems().add(pizzaA);
        orderB.getItems().add(pizzaB);
        orderB.setNumberOfSeats(2);

        double expectedTotal = (7.50 + 7.50) + 2.5 * 2;
        double actualTotalAmount = orderB.getItems().stream().mapToDouble(MenuItem::getPrice).sum() + tableCharge * orderB.getNumberOfSeats();

        Assertions.assertEquals(expectedTotal, actualTotalAmount);
    }

    @Test
    public void testOrderAcquisitionDate() {
        Order orderC = new Order();

        LocalDate acquisitionDate = LocalDate.now();
        orderC.setAcquisitionTime(acquisitionDate);

        Assertions.assertEquals(acquisitionDate, orderC.getAcquisitionTime());
    }

    @ParameterizedTest
    @CsvSource({"Pizza A, 5.0", "Pizza B, 7.50"})
    public void testAddItemToOrder(String menuItemName, double itemPrice) {
        Menu menu = new Menu();

        MenuItem menuItem = new MenuItem(menuItemName, itemPrice);
        menu.addItem(menuItem);

        Assertions.assertTrue(menu.getItems().contains(menuItem));
    }
    

}
