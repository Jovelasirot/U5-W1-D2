package jovelAsirot.U5W1D2;

import jovelAsirot.U5W1D2.entities.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    @Bean
    public Menu menu(@Value("${table.charge}") double tableCharge) {
        Menu menu = new Menu();
        menu.addItem(margheritaPizza());
        menu.addItem(fourSeasonsPizza());
        menu.addItem(prosciuttoToppings());
        menu.addItem(friesToppings());
        menu.addItem(cokeZeroBeverage());
        menu.addItem(spriteBeverage());
        menu.addItem(GetTableCharge(tableCharge));
        return menu;
    }

    @Bean
    public MenuItem margheritaPizza() {
        return new Pizza("Margherita", 7.0);
    }

    @Bean
    public MenuItem fourSeasonsPizza() {
        return new Pizza("Four seasons", 7.0);
    }

    @Bean
    public MenuItem prosciuttoToppings() {
        return new Toppings("Prosciutto", 2.0);
    }

    @Bean
    public MenuItem friesToppings() {
        return new Toppings("Fries", 4.0);
    }

    @Bean
    public MenuItem cokeZeroBeverage() {
        return new Beverage("Coke zero", 3.5);
    }

    @Bean
    public MenuItem spriteBeverage() {
        return new Beverage("Sprite", 3.5);
    }

    @Bean
    public MenuItem GetTableCharge(double tableCharge) {
        return new MenuItem("Cover Charge", tableCharge) {
        };
    }
}
