package com.saucedemo.tasks;

import com.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class checkOut implements Task {

    private final String nombre;
    private final String apellido;
    private final String codigoPostal;

    public checkOut(String nombre, String apellido, String codigoPostal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoPostal = codigoPostal;
    }

    public static com.saucedemo.tasks.checkOut withData(String nombre, String apellido, String codigoPostal) {
        return instrumented(com.saucedemo.tasks.checkOut.class, nombre, apellido, codigoPostal);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into(CheckoutPage.FIRST_NAME),
                Enter.theValue(apellido).into(CheckoutPage.LAST_NAME),
                Enter.theValue(codigoPostal).into(CheckoutPage.POSTAL_CODE),
                Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }
}
