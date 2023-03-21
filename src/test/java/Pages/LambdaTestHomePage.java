package Pages;

import com.Actions.SeleniumActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class LambdaTestHomePage {

    WebDriver driver;
    SeleniumActions seleniumActions;
    public LambdaTestHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumActions(driver);
    }

    @FindBy(xpath = "//a[.='See All Integrations']")
    WebElement seeAllIntegrationsLink;

    @FindBy(xpath = "//div[@ id='codeless_row']/h2")
    WebElement codlessAutomationHeading;

    @FindBy(xpath = "//a[.='Integrate Testing Whiz with LambdaTest']")
    WebElement integrateTestingWhizLink;


    public void waitForVisibilityOfAllElementsInDom(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(seeAllIntegrationsLink));
    }

    public String scrollTillSeeAllIntegrationsAndClick(){
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("arguments[0].scrollIntoView(true);", seeAllIntegrationsLink);
        String url = seeAllIntegrationsLink.getAttribute("href");
        js.executeScript("return arguments[0].setAttribute('target', '_blank')", seeAllIntegrationsLink);
        js.executeScript("return arguments[0].click()", seeAllIntegrationsLink);
       //seeAllIntegrationsLink.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
        return url;
    }

    public void clickOnIntegrateTestingWhizLink(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return arguments[0].click();", integrateTestingWhizLink );
    }

    public void scrollcolessAutomation(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", codlessAutomationHeading);
    }
}
