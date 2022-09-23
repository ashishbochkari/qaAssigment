package Utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class CaptureScreenShots {
    public void screenshot() {}

    public static String customDate() {
        String dateformat = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        return dateformat;
    }

    public static String captureScreenshot(String screenShotName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir") + "/CaptureScreenShots/" + screenShotName + customDate()
                + ".png";
        File destFile = new File(screenshotPath);
        FileHandler.copy(srcFile, destFile);

        return screenshotPath;
    }



}
