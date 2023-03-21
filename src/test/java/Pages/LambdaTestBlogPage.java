package Pages;

import com.Actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LambdaTestBlogPage {
    WebDriver driver;

    SeleniumActions seleniumActions;
    public LambdaTestBlogPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumActions(driver);
    }

    @FindBy(linkText = "Community")
    WebElement communityLinkTest;


    public String  clickOnCommunityLink(){
        seleniumActions.clickOnElement(communityLinkTest);
        return communityLinkTest.getAttribute("href");
    }

}
