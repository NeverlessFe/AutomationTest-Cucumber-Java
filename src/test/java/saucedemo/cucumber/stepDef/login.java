package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseURL ="https://www.saucedemo.com/";
    String URLHome = "https://www.saucedemo.com/inventory.html";
    @Given("Halaman login terbuka")
    public void Halaman_login_terbuka(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @When("Input username")
    public void Input_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @When("Input Username Salah")
    public void Input_username_Salah() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void Input_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void Click_login_button() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("user redirect ke halaman home")
    public void user_redirect_ke_halaman_home() {
        String HalamanHomeText = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(HalamanHomeText,"Swag Labs");
    }

    @And("Input wrong passowrd")
    public void Input_wrong_password() {
        driver.findElement(By.id("password")).sendKeys("TestSalah");
    }

    @Then("user diberikan notifikasi error login")
    public void user_diberikan_notifikasi_error_login() {
        String ErrorMgs = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(ErrorMgs,"Epic sadface: Username and password do not match any user in this service");
    }

    @Then("user diberikan notifikasi username kosong")
    public void user_diberikan_notifikasi_username_kosong(){
        String ErrorMgs = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(ErrorMgs,"Epic sadface: Username is required");
    }

    @Then("user diberikan notifikasi password kosong")
    public void user_diberikan_notifikasi_password_kosong(){
        String ErrorMgs = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(ErrorMgs,"Epic sadface: Password is required");
    }

    @And("user add cart item")
    public void userAddCartItem() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
    }

    @And("user click cart button")
    public void userClickCartButton() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Then("user click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }

    @And("user input Firstname")
    public void userInputFirstname() {
        driver.findElement(By.id("first-name")).sendKeys("Dani");
    }

    @And("user input Last Name")
    public void userInputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Pernando");
    }

    @And("user input zip postal code")
    public void userInputZipPostalCode() {
        driver.findElement(By.id("postal-code")).sendKeys("Pernando");
    }

    @Then("user click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }

    @And("user click finish button")
    public void userClickFinishButton() {
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
    }

    @Then("checkout success")
    public void checkoutSuccess() {
        String ErrorMgs = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
        Assert.assertEquals(ErrorMgs,"Thank you for your order!");
    }

    @Then("Notifikasi block muncul")
    public void notifikasiBlockMuncul() {
        String ErrorMgs = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(ErrorMgs,"Epic sadface: You can only access '/inventory.html' when you are logged in.");
    }

    @When("Redirect url ke halaman inventory")
    public void redirectUrlKeHalamanInventory() {
        driver.get(URLHome);
    }
}
