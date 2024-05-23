import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class loginTest {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

               driver.get("https://www.saucedemo.com/");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement btnUserName = driver.findElement(By.xpath("//input[@id='user-name']"));
        btnUserName.sendKeys("standard_user");



        WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));

        passWord.sendKeys("secret_sauce");



        WebElement btnContinue = driver.findElement(By.id("login-button"));

        btnContinue.click();

        String currentUrl = driver.getCurrentUrl();

        // Expected URL after login
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        // Assert that the current URL is the expected URL
        Assert.assertEquals(currentUrl, expectedUrl, "The user did not log in successfully.");
        System.out.println("Login successful. Current URL: " + currentUrl);

       String productName= driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
        Thread.sleep(10);

       driver.findElement(By.xpath("//div/button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(5);

       driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a")).click();

       String expectedProduct = driver.findElement(By.xpath("//div/a[@id='item_4_title_link']/div")).getText();

       driver.findElement(By.xpath("//button[@id='checkout']")).click();

       driver.findElement(By.id("first-name")).sendKeys("Neil");

        driver.findElement(By.id("last-name")).sendKeys("Macenzie");
        driver.findElement(By.id("postal-code")).sendKeys("123456");

        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();

        String actualOrderSuccessfulText = driver.findElement(By.xpath("//div[@id='checkout_complete_container']/h2")).getText();

        String expectedOrderSuccessfulText = "Thank you for your order!";


        Assert.assertEquals(actualOrderSuccessfulText, expectedOrderSuccessfulText, "Order is successfully placed");

        System.out.println("Order successful. Current Message: " + actualOrderSuccessfulText);

        driver.quit();


    }
}
