package jovelAsirot.U5W1D2.components;

import jovelAsirot.U5W1D2.entities.Menu;
import jovelAsirot.U5W1D2.entities.MenuItem;
import jovelAsirot.U5W1D2.entities.Order;
import jovelAsirot.U5W1D2.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.Supplier;

@Component
@PropertySource("application.properties")
public class OrderSupplier {

    @Value("${table.charge}")
    private double tableCharge;

    public Supplier<Order> getOrderSupplier(Menu menu) {
        Random rdm = new Random();
        OrderStatus[] orderStatuses = OrderStatus.values();
        int orderNumber = 0;

        return () -> {
            int rdmStatusIndex = rdm.nextInt(orderStatuses.length);

            Order order = new Order();
            order.setOrderNumber(orderNumber + 1);
            order.setStatus(orderStatuses[rdmStatusIndex]);
            order.setNumberOfSeats(rdm.nextInt(1, 8));
            order.setAcquisitionTime(LocalDateTime.now().plusDays(rdm.nextInt(0, 30)));


            order.getItems().add(menu.getItems().get(rdm.nextInt(0, 3)));
            order.getItems().add(menu.getItems().get(rdm.nextInt(0, 3)));


            double totalAmount = order.getItems().stream().mapToDouble(MenuItem::getPrice).sum() + tableCharge * order.getNumberOfSeats();
            order.setTotalAmount(totalAmount);

            return order;
        };
    }
}
