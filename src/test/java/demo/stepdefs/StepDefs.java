package demo.stepdefs;

import static org.junit.Assert.assertEquals;

import demo.pages.BasePage;
import demo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
public class StepDefs {

  private final BasePage basePage;
  private final LoginPage loginPage;

  @Given("A user logs into the website as a regular user")
  public void aUserLogsIntoTheWebSiteAsARegularUser() {
    basePage.navigateTo("https://www.saucedemo.com");
    loginPage.enterUsername("standard_user");
    loginPage.enterPassword("secret_sauce");
    loginPage.findById("login-button").click();
  }

  @When("They add the {string} to their cart")
  public void theyAddTheItemToTheirCart(String productName) {
    String nameToUse = productName.replace(" ", "-");
    basePage
        .driver
        .findElement(By.id(String.format("add-to-cart-sauce-labs-%s", nameToUse)))
        .click();
  }

  @Then("Their cart shows {string} items added")
  public void theirCartShowsItemsAdded(String numberOfItems) {
    String expected =
        basePage.driver.findElement(By.cssSelector("span.shopping_cart_badge")).getText();
    assertEquals(expected, numberOfItems);
  }
}
