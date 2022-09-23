package Object;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

@Slf4j
public class HomePageAct extends TestBase{

    public static ExtentReports reports;
    public static ExtentTest test;

    public HomePageAct(WebDriver driver){
        this.driver=driver;
    }

    By SelectListCat = By.xpath("//ul[@class='nav-pills categorymenu']/li");
    By SubCatory     = By.xpath("//ul[@class='nav-pills categorymenu']/li[5]/div/ul[1]/li[1]/a");
    public void SelectMenu()
    {
        try {
            List<WebElement> selectCatagory = driver.findElements(SelectListCat);
            System.out.println(selectCatagory.size());
            System.out.println((selectCatagory.get(4).getText()));
            for (int i = 0 ; i<selectCatagory.size(); i++){
                System.out.println(selectCatagory.get(i).getText());
            }
            Actions actions = new Actions(driver);
            actions.moveToElement(selectCatagory.get(4)).contextClick().build().perform();
        } catch (Exception e) {
            System.out.println("Exception caught " + e.getMessage());
        }
    }

    public void subCatagoryPerfume()
    {
        try {
            WebElement Mens= driver.findElement(SubCatory);
            Actions actions = new Actions(driver);
            actions.moveToElement(Mens).click().build().perform();
            System.out.println(driver.getTitle());
        } catch (Exception e) {
            System.out.println("Exception caught " + e.getMessage());
        }
    }

    public void selectPerfumeCatagoryPage()
    {
        try {
            List<WebElement> pefumes = driver.findElements(By.xpath("//body[@class='product-category']/div/div[2]/div/div/div/div/div[2]/div"));
            System.out.println(pefumes.size());
            for (int i = 0 ; i < pefumes.size(); i++){
                System.out.println(pefumes.get(i).getText());
            }
            Thread.sleep(5000);
            pefumes.get(1).click();
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Exception caught " + e.getMessage());
        }
    }
}
