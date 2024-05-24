// Import necessary libraries
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class loginTest {

    public static void main(String[] args) throws InterruptedException {

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open the Sauce Demo website
        driver.get("https://www.saucedemo.com/");

        // Set an implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Find the username input field and enter the username
        WebElement btnUserName = driver.findElement(By.xpath("//input[@id='user-name']"));
        btnUserName.sendKeys("standard_user");

        // Find the password input field and enter the password
        WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
        passWord.sendKeys("secret_sauce");

        // Find the login button and click it
        WebElement btnContinue = driver.findElement(By.id("login-button"));
        btnContinue.click();

        // Get the current URL after logging in
        String currentUrl = driver.getCurrentUrl();

        // Expected URL after login
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        // Assert that the current URL is the expected URL
        Assert.assertEquals(currentUrl, expectedUrl, "The user did not log in successfully.");
        System.out.println("Login successful. Current URL: " + currentUrl);

        // Find the product name (Sauce Labs Backpack) and get its text
        String productName = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();

        // Wait for 10 milliseconds
        Thread.sleep(10);

        // Find the "Add to Cart" button for the Sauce Labs Backpack and click it
        driver.findElement(By.xpath("//div/button[@id='add-to-cart-sauce-labs-backpack']")).click();

        // Wait for 5 milliseconds
        Thread.sleep(5);

        // Find and click the shopping cart icon
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a")).click();

        // Verify the product in the cart matches the added product
        String expectedProduct = driver.findElement(By.xpath("//div/a[@id='item_4_title_link']/div")).getText();

        // Click the "Checkout" button
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        // Enter the first name
        driver.findElement(By.id("first-name")).sendKeys("Neil");

        // Enter the last name
        driver.findElement(By.id("last-name")).sendKeys("Macenzie");

        // Enter the postal code
        driver.findElement(By.id("postal-code")).sendKeys("123456");

        // Click the "Continue" button
        driver.findElement(By.id("continue")).click();

        // Click the "Finish" button to complete the order
        driver.findElement(By.id("finish")).click();

        // Get the text indicating the order was successful
        String actualOrderSuccessfulText = driver.findElement(By.xpath("//div[@id='checkout_complete_container']/h2")).getText();

        // Expected order completion message
        String expectedOrderSuccessfulText = "Thank you for your order!";

        // Assert that the order was placed successfully
        Assert.assertEquals(actualOrderSuccessfulText, expectedOrderSuccessfulText, "Order is successfully placed");
        System.out.println("Order successful. Current Message: " + actualOrderSuccessfulText);

        // Close the browser
        driver.quit();
    }
}
