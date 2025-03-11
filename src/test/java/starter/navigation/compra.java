package com.saucedemo.steps;

import com.saucedemo.tasks.*;
import com.saucedemo.ui.ConfirmationPage;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class compra {

    @Managed
    WebDriver driver;
    Actor usuario = Actor.named("Standard User");

    @Dado("que el usuario ingresa a SauceDemo")
    public void queElUsuarioIngresaASauceDemo() {
        usuario.can(BrowseTheWeb.with(driver));
        driver.get("https://www.saucedemo.com/");
    }

    @Cuando("se autentica con el usuario {string} y password {string}")
    public void seAutenticaConElUsuarioYPassword(String username, String password) {
        usuario.attemptsTo(LoginTask.withCredentials(username, password));
    }

    @Cuando("agrega dos productos al carrito")
    public void agregaDosProductosAlCarrito() {
        usuario.attemptsTo(AddToCartTask.addTwoProducts());
    }

    @Cuando("visualiza el carrito")
    public void visualizaElCarrito() {
        usuario.attemptsTo(ViewCartTask.viewCart());
    }

    @Cuando("completa el formulario de compra con:")
    public void completaElFormularioDeCompraCon(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMaps(String.class, String.class).get(0);
        usuario.attemptsTo(CheckoutTask.withData(data.get("nombre"), data.get("apellido"), data.get("codigoPostal")));
    }

    @Cuando("finaliza la compra")
    public void finalizaLaCompra() {
        usuario.attemptsTo(FinishPurchaseTask.finish());
    }

    @Entonces("debería ver el mensaje de confirmación {string}")
    public void deberiaVerElMensajeDeConfirmacion(String mensaje) {
        usuario.attemptsTo(Ensure.that(ConfirmationPage.CONFIRMATION_MESSAGE).text().isEqualTo(mensaje));
    }
}
