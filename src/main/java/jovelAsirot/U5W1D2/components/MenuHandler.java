package jovelAsirot.U5W1D2.components;

import jovelAsirot.U5W1D2.entities.Menu;
import jovelAsirot.U5W1D2.entities.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MenuHandler implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MenuHandler.class);

    private final Menu menu;
    private final double tableCharge;

    public MenuHandler(Menu menu, @Value("${table.charge}") double tableCharge) {
        this.menu = menu;
        this.tableCharge = tableCharge;
    }

    @Override
    public void run(String... args) {
        logger.info("Menu:");
        for (MenuItem item : menu.getItems()) {
            logger.info("- {} - ${}", item.getName(), item.getPrice());
        }
    }
}