package demo.stepdefs;

import static org.junit.Assert.assertEquals;

import demo.pages.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
public class StepDefs {

  private final BasePage basePage;

  @Given("A user logs into the website as a regular user")
  public void aUserLogsIntoTheWebSiteAsARegularUser() {
    basePage.navigateTo("https://www.saucedemo.com");
    basePage.driver.findElement(By.id("user-name")).sendKeys("standard_user");
    basePage.driver.findElement(By.id("password")).sendKeys("secret_sauce");
    basePage.driver.findElement(By.id("login-button")).click();
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
