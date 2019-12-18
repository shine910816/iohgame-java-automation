package com.iohgame.automation.property;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.iohgame.framework.utility.MainClass;
import com.iohgame.framework.utility.parameters.property.Parameters;

public class LaunchBrowser extends MainClass
{
    private WebDriver m_driver;

    public LaunchBrowser(Browsers type)
    {
        switch (type)
        {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/main/resource/driver/gecko/geckodriver.exe");
                m_driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/main/resource/driver/chrome/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addExtensions(new File("src/main/resource/driver/chrome/chromeconfig.zip"));
                m_driver = new ChromeDriver(chromeOptions);
                break;
            default:
                LOG.error("Not found browser " + type);
        }
        if (m_driver != null)
        {
            m_driver.manage().window().maximize();
        }
    }

    public WebDriver driver()
    {
        return m_driver;
    }

    public enum Browsers implements Parameters
    {
        FIREFOX,

        CHROME,

        UNKNOWN;

        @Override
        public String val()
        {
            return name();
        }

        @Override
        public Parameters unknown()
        {
            return UNKNOWN;
        }
    }
}
