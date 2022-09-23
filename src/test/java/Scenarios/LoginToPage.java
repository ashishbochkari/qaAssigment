package Scenarios;

import Listners.CustomListener;
import Object.LoginDetailsPage;
import Object.HomePageAct;
import Object.ProductCheckoutPage;
import Object.TestBase;
import Utils.ConfigReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static Object.ExterntReportGeneratorPage.reports;

@Listeners(CustomListener.class)
@Slf4j
public class LoginToPage extends TestBase {
    HomePageAct homePageAct;
    ConfigReader configReader;

    @Test(priority = 0)
    public void login_user()
    {
        LoginDetailsPage loginDetailsPage = new LoginDetailsPage(driver);
        loginDetailsPage.LoginUser();
    }

    @Test(priority = 1)
    public void select_fragrance_catagory()
    {
        homePageAct= new HomePageAct(driver);
        homePageAct.SelectMenu();
    }

    @Test(priority = 2)
    public void select_fragrance_sub_category()
    {
        homePageAct= new HomePageAct(driver);
        homePageAct.subCatagoryPerfume();
    }

    @Test(priority = 3)
    public void select_perfume(){
        homePageAct = new HomePageAct(driver);
        homePageAct.selectPerfumeCatagoryPage();
    }

    @Test(priority = 4)
    public void product_checkout()
    {
        ProductCheckoutPage productCheckoutPage = new ProductCheckoutPage(driver);
        productCheckoutPage.productCheckout();
    }
}
