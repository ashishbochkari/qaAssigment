package Object;

import Utils.ConfigReader;
import Object.LoginDetailsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Slf4j
public class TestBase {
    public static WebDriver driver;
    File screenshotFile;
    ConfigReader configReader;


    /**
     * @param browserName browserName
     */
    @BeforeSuite(alwaysRun = true)
    @Parameters("browserName")
    public void setUp(String browserName)
    {
        System.out.println("Browser name is " + browserName);
        configReader = new ConfigReader();

        if (browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(configReader.getURL());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(configReader.getURL());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }else if (browserName.equalsIgnoreCase("ie"))
        {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            driver.get(configReader.getURL());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }else if (browserName.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.get(configReader.getURL());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void quitDriver(){
        driver.quit();
    }
    public void FailedTests()
    {
        System.out.println("Failed Tests");
        screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("D:\\E-Learning\\Rest API Course\\QA_Assignment\\test-output\\ScreenShots\\testfailure.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

