package Object;

import Utils.CaptureScreenShots;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


@Slf4j
public class ExterntReportGeneratorPage extends TestBase{
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports reports;
    public static ExtentTest test;

    @BeforeSuite
    public void ExtentReport() {

        File fs = new File("./Reports/ExtentReport.html");
        htmlReporter = new ExtentHtmlReporter(fs);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional Report");
        htmlReporter.config().setTheme(Theme.DARK);
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        reports.setSystemInfo("HostName", "https://automationteststore.com/");
        reports.setSystemInfo("Operating System", "Windows");
        reports.setSystemInfo("Tester Name ", "Ashish Bochkari");
    }


    @AfterTest
    public void endReport() {
        reports.flush();

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "TestCaseFailed" + result.getName());
            test.log(Status.FAIL, "TestCaseFailed" + result.getThrowable());
            String screenshotpath = CaptureScreenShots.captureScreenshot(result.getName(), driver);
            test.addScreenCaptureFromPath(screenshotpath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "TestCasePassed" + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "TestCaseSkipped" + result.getName());
        }

    }

    public void getHomepage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationteststore.com");
    }


}
