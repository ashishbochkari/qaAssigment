package Object;

import Utils.ConfigReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static jdk.nashorn.internal.objects.NativeMath.log;

@Slf4j
public class LoginDetailsPage extends TestBase{
    ConfigReader configReader;
    public static ExtentReports reports;
    public static ExtentTest test;
    public LoginDetailsPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private By LoginUser = By.xpath("//a[contains(text(), 'Login or register')]");
    private By loginName = By.xpath("//input[@id='loginFrm_loginname']");
    private By loginPass = By.xpath("//input[@id='loginFrm_password']");
    private By loginBtn  = By.xpath("//*[@id='loginFrm']/fieldset/button");

    public void LoginUser()
    {
        configReader = new ConfigReader();
        try {
            driver.findElement(LoginUser).click();
            driver.findElement(loginName).sendKeys(configReader.getUser());
            driver.findElement(loginPass).sendKeys(configReader.getPass());
            driver.findElement(loginBtn).click();
            String title = driver.getTitle();
            System.out.println("Page Title is :" + title);
            Assert.assertEquals(title, "My Account");
            System.out.println("Page title matched");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
