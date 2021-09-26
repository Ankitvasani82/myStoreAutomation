//import PageObject.Shopping_Page;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MyStepdefs extends Test_Runner {
    // public Shopping_Page shopping_page;
    @Before
    public void start_test() {

    }


    @After
    public void stop(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshotBytes, "image/png");
        }
    }

    @Given("^Launch Application$")
    public void launchApplication() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);


    }

    @When("^search for summer dresses$")
    public void searchForSummerDresses() throws InterruptedException {
        driver.findElement(By.xpath("//form[@id='searchbox']//input[@id='search_query_top']")).sendKeys("Summer Dresses");
        driver.findElement(By.xpath("//form[@id='searchbox']//button[@name='submit_search']")).click();
        Thread.sleep(5000);

    }

    @And("^Click on summer dresses result$")
    public void clickOnSummerDressesResult() {

        driver.findElement(By.linkText("Printed Chiffon Dress")).click();

    }

    @When("^Click on Add to cart button$")
    public void clickOnAddToCartButton() {
        driver.findElement(By.id("add_to_cart")).click();


    }

    @And("^Click on Processed to checkout button$")
    public void clickOnProcessedToCheckoutButton() {
        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.findElement(By.linkText("Proceed to checkout")).click();
        driver.switchTo().window(parentWindowHandler);

    }

    @And("^Click on Processed to checkout button on Shopping Cart Summary page$")
    public void clickOnProcessedToCheckoutButtonOnShoppingCartSummaryPage() throws InterruptedException {
        driver.findElement(By.linkText("Proceed to checkout")).click();
    }

    @When("^User enters <username> and Password as <password> on Authentication Page$")
    public void userEntersUsernameAndPasswordAsPasswordOnAuthenticationPage(){


        driver.findElement(By.xpath("//a[@Class=\"login\"]")).click();
        driver.findElement(By.id("email")).sendKeys("ankitvasani82@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Password123");
    }

    @And("^Click on Sign in button$")
    public void clickOnSignInButton() {
        driver.findElement(By.id("SubmitLogin")).click();

    }

    @Then("^verify user can successfully sign in and lands on Address page to confirm the address$")
    public void verifyUserCanSuccessfullySignInAndLandsOnAddressPageToConfirmTheAddress() {
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class=\"page-heading\"]")).isDisplayed());
    }

}
