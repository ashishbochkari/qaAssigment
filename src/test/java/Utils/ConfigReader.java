package Utils;



import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class ConfigReader {

    public Properties pro;

    public ConfigReader() {
        try {
            File src = new File("D:\\E-Learning\\Rest API Course\\QA_Assignment\\src\\test\\testconfig.properties");
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getUser()
    {
        return pro.getProperty("automation.username");
    }

    public String getPass()
    {
        return pro.getProperty("automation.password");
    }

    public String getURL()
    {
        return pro.getProperty("automaion.URL");
    }
}
