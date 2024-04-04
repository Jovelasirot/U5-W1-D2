package jovelAsirot.U5W1D2;

import jovelAsirot.U5W1D2.components.OrderSupplier;
import jovelAsirot.U5W1D2.entities.Menu;
import jovelAsirot.U5W1D2.entities.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@SpringBootApplication
public class U5W1D2Application {

    public static void main(String[] args) {
        SpringApplication.run(U5W1D2Application.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1D2Application.class);

        Menu menu = ctx.getBean(Menu.class);
        OrderSupplier orderSupplier = ctx.getBean(OrderSupplier.class);

        System.out.println();

        generateAndPrintOrders(orderSupplier, menu);

    }

    public static void generateAndPrintOrders(OrderSupplier orderSupplier, Menu menu) {
        Supplier<Order> orderSupplierComponent = orderSupplier.getOrderSupplier(menu);
        List<Order> orderList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            orderList.add(orderSupplierComponent.get());
        }
        orderList.forEach(System.out::println);
    }
}
