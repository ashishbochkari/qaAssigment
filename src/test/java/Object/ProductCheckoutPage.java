package Object;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

@Slf4j
public class ProductCheckoutPage extends TestBase{

    public ProductCheckoutPage(WebDriver driver)
    {
        this.driver= driver;
    }


    public void productCheckout()
    {
        try {
            WebElement quantity = driver.findElement(By.xpath("//input[contains(@id, 'product_quantity')]"));
            quantity.clear();
            quantity.sendKeys("3");
            String ProductPrice = driver.findElement(By.xpath("//span[@class='total-price']")).getText();
            System.out.println("Product Price is "+ProductPrice);
            Thread.sleep(2000);
            WebElement addToCard = driver.findElement(By.xpath("//a[contains(@class, 'cart')]"));
            addToCard.click();
            String pageTitle = driver.getTitle();
            Assert.assertEquals(pageTitle, "Shopping Cart");
            WebElement totalQuantity = driver.findElement(By.xpath("//input[starts-with(@id, 'cart_quantity')]"));
            totalQuantity.clear();
            totalQuantity.sendKeys("3");
            WebElement updatePage = driver.findElement(By.xpath("//button[contains(@title, 'Update')]"));
            updatePage.click();
            String expectedPrice = driver.findElement(By.xpath("//form[@id='cart']/div/div/table/tbody/tr[2]/td[6]")).getText();
            System.out.println("Expected Price " + expectedPrice);
            String actualPrice = driver.findElement(By.xpath("//table[@id='totals_table']/tbody/tr[1]/td[2]/span")).getText();
            System.out.println("Actual Price "+actualPrice);
            Assert.assertEquals(expectedPrice, actualPrice);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[contains(@id, 'cart_checkout2')]")).click();
            Thread.sleep(2000);
            WebElement OrderConfirm = driver.findElement(By.xpath("//button[@id='checkout_btn']"));
            OrderConfirm.click();
            Thread.sleep(2000);
            String lastTitle = driver.getTitle();
            System.out.println("Page Title is "+lastTitle);
            Assert.assertEquals(lastTitle, "Your Order Has Been Processed!");

        } catch (InterruptedException e) {
            System.out.println("Exception caught " + e.getMessage());
        }
    }
}
