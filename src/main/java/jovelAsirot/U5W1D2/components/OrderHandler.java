package jovelAsirot.U5W1D2.components;

import jovelAsirot.U5W1D2.entities.Menu;
import jovelAsirot.U5W1D2.entities.MenuItem;
import jovelAsirot.U5W1D2.entities.Order;
import jovelAsirot.U5W1D2.enums.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderHandler implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OrderHandler.class);

    private final Menu menu;
    private final double tableCharge;

    public OrderHandler(Menu menu, @Value("${table.charge}") double tableCharge) {
        this.menu = menu;
        this.tableCharge = tableCharge;
    }

    @Override
    public void run(String... args) throws Exception {

        Order order = new Order();
        order.setOrderNumber(1);
        order.setStatus(OrderStatus.IN_PROGRESS);
        order.setNumberOfSeats(4);
        order.setAcquisitionTime(LocalDateTime.now());

        order.getItems().add(menu.getItems().get(0));
        order.getItems().add(menu.getItems().get(2));

        double totalAmount = order.getItems().stream().mapToDouble(MenuItem::getPrice).sum() + tableCharge * order.getNumberOfSeats();
        order.setTotalAmount(totalAmount);

        logger.info("Order Number: {}", order.getOrderNumber());
        logger.info("Status: {}", order.getStatus());
        logger.info("Number of Seats: {}", order.getNumberOfSeats());
        logger.info("Acquisition Time: {}", order.getAcquisitionTime());
        logger.info("Total Amount: {}", order.getTotalAmount());
        logger.info("Items:");
        for (MenuItem item : order.getItems()) {
            logger.info("- {} - ${}", item.getName(), item.getPrice());
        }
    }
}
