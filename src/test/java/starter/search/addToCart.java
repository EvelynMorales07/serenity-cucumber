package com.saucedemo.tasks;

import com.saucedemo.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class addToCart implements Task {

    public static com.saucedemo.tasks.addToCart addTwoProducts() {
        return instrumented(com.saucedemo.tasks.addToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsPage.ADD_FIRST_PRODUCT),
                Click.on(ProductsPage.ADD_SECOND_PRODUCT)
        );
    }
}
