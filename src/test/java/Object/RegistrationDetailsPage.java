package Object;

import Utils.utility;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

@Slf4j
public class RegistrationDetailsPage extends TestBase {

    public RegistrationDetailsPage(WebDriver driver){
        this.driver = driver;
    }



    By NewUserRegister = By.xpath("//a[contains(text(), 'Login or register')]");
    By RegisterAccountRadioBtn = By.id("accountFrm_accountregister");
    By ContinueBtn = By.xpath("//button[contains(@title, 'Continue')]");
    By FirstName = By.id("AccountFrm_firstname");
    By LastName = By.id("AccountFrm_lastname");
    By Email = By.id("AccountFrm_email");
    By Address = By.id("AccountFrm_address_1");
    By City = By.id("AccountFrm_city");
    By Country = By.id("AccountFrm_country_id");
    By State = By.id("AccountFrm_zone_id");
    By ZIP = By.id("AccountFrm_postcode");
    By LoginName = By.id("AccountFrm_loginname");
    By Password = By.id("AccountFrm_password");
    By ConfirmPass = By.id("AccountFrm_confirm");
    By Subscribe = By.id("AccountFrm_newsletter1");
    By PrivacyP = By.id("AccountFrm_agree");
    By ContinueRegister = By.xpath("//button[contains(@class, 'btn btn-orange pull-right lock-on-click')]");

    public void registerUser()
    {
        try {

            driver.findElement(NewUserRegister).click();
            String TestText = driver.findElement(NewUserRegister).getText();
            System.out.println(TestText);
            log.info(TestText);
            Assert.assertEquals(TestText, "Login or register");
            Assert.assertTrue(driver.findElement(RegisterAccountRadioBtn).isSelected());
            driver.findElement(ContinueBtn).click();
            Thread.sleep(10000);

            driver.findElement(FirstName).sendKeys(utility.generateRandomString(6));
            driver.findElement(LastName).sendKeys(utility.generateRandomString(8));
            driver.findElement(Email).sendKeys(utility.generateRandomString(7) + "@gmail.com");
            driver.findElement(Address).sendKeys("High Street");
            driver.findElement(City).sendKeys("Pune");

            WebElement countrySelect = driver.findElement(Country);
            Select countryList = new Select(countrySelect);
            countryList.selectByVisibleText("India");
            Thread.sleep(2000);
            WebElement stateSelect = driver.findElement(State);
            Select stateList = new Select(stateSelect);
            stateList.selectByVisibleText("Maharashtra");

            driver.findElement(ZIP).sendKeys("412101");
            driver.findElement(LoginName).sendKeys(utility.generateRandomString(6));
            String pass = utility.generatePassString(10);
            log.info(pass);
            driver.findElement(Password).sendKeys("@17Apr1992");
            driver.findElement(ConfirmPass).sendKeys("@17Apr1992");

            WebElement radioButton = driver.findElement(Subscribe);
            radioButton.click();
            Assert.assertTrue(radioButton.isSelected());
            Thread.sleep(2000);
            driver.findElement(PrivacyP).click();
            Thread.sleep(2000);
            driver.findElement(ContinueRegister).click();
            String title = driver.getTitle();
            log.info(title);
            Assert.assertEquals(title, "Your Account Has Been Created!");
            WebElement account = driver.findElement(By.xpath("//body[@class='account-success']/div/header/div/div/div[2]/div/div[2]/div/ul/li"));
            System.out.println(account.getText());
            Actions act = new Actions(driver);
            act.moveToElement(account).contextClick().build().perform();
            WebElement listElements = driver.findElement(By.xpath("//body[@class='account-success']/div/header/div/div/div[2]/div/div[2]/div/ul/li/ul/li[10]/a/i[@class='fa fa-lock fa-fw']"));
            System.out.println(listElements.getText());
            act.moveToElement(listElements).click().build().perform();
        }catch (Exception e){
            System.out.println("Exception Caught " + e.getMessage());
        }
    }
}
