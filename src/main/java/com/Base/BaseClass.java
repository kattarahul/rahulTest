package com.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseClass {

    public WebDriver driver;
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;

    FirefoxOptions firefoxOptions;

    ChromeDriver chromeDriver;

    InternetExplorerOptions internetExplorerOptions;

    private String username = "tsoftware1112";
    private String accessKey = "PWYpTGomYrc3vwZv4t9ap1KjLcjTpDr0jvqdJvXVTdNQeQKMN2";
    private String hub = "@hub.lambdatest.com/wd/hub";


    @Parameters(value={"Browser", "Version", "Platform"})
    @BeforeTest
    public void OpenbrowserAndLaunchapp(String browser, String version,String platform) throws MalformedURLException {
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accessKey);
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("network", true);
        ltOptions.put("build", "LamdaTestApp");
        ltOptions.put("project", "LambdaTest");
        ltOptions.put("console", "info");
        ltOptions.put("w3c", true);

        switch(browser.toLowerCase()) {
            case "chrome":
                // driver = new ChromeDriver();
                chromeOptions = new ChromeOptions();
                chromeOptions.setPlatformName(platform);
                chromeOptions.setBrowserVersion(version);
                chromeOptions.setCapability("LT:Options", ltOptions);
                driver = new RemoteWebDriver(new URL("https://" +
                        username + ":" + accessKey + hub),chromeOptions);
                break;
            case "edge":
                 //driver = new EdgeDriver();
                edgeOptions = new EdgeOptions();
                edgeOptions.setPlatformName(platform);
                edgeOptions.setBrowserVersion(version);
                edgeOptions.setCapability("LT:Options", ltOptions);
                driver = new RemoteWebDriver(new URL("https://" +
                        username + ":" + accessKey + hub),edgeOptions);
                break;
            default	:
                System.out.println("Browser name is invalid");
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void launchApp(){
        driver.get("https://www.lambdatest.com/");
    }

    @AfterTest
    public void closebrowser() {
        driver.quit();

    }
}
