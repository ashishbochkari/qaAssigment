package Scenarios;

import Listners.CustomListener;
import Object.RegistrationDetailsPage;
import Object.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(CustomListener.class)
@Slf4j
public class RegistrationUser extends TestBase {

    @Test
    public void register_new_user() {
        RegistrationDetailsPage registrationDetailsPage = new RegistrationDetailsPage(driver);
        registrationDetailsPage.registerUser();
    }
}
