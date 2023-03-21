package Test;

import Pages.LambdaTestBlogPage;
import Pages.LambdaTestHomePage;
import com.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class AdvancedSeleniumTestClass extends BaseClass {

    LambdaTestHomePage lambdaTestHomePage;

    LambdaTestBlogPage lambdaTestBlogPage;

    AdvancedSeleniumTestClass advancedSeleniumTestClass;
    @BeforeClass
    public void initialisePages(){
        advancedSeleniumTestClass = new AdvancedSeleniumTestClass();
        lambdaTestHomePage = new LambdaTestHomePage(driver);
        lambdaTestBlogPage = new LambdaTestBlogPage(driver);
    }



    @Test
    public void completeTest() throws InterruptedException {
        lambdaTestHomePage.waitForVisibilityOfAllElementsInDom();
        String ExpectedUrl =lambdaTestHomePage.scrollTillSeeAllIntegrationsAndClick();
        Set<String> windowids =driver.getWindowHandles();
        System.out.println(windowids);
        for (String windowid : windowids){
            driver.switchTo().window(windowid);
        }
        String actualUrl =driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,ExpectedUrl);
        lambdaTestHomePage.scrollcolessAutomation();
        lambdaTestHomePage.clickOnIntegrateTestingWhizLink();
        String title = driver.getTitle();
        System.out.println(title);
        String expectedTitle = "TestingWhiz LambdaTest | LambdaTest";
        try {
            Assert.assertEquals(title, expectedTitle);
        }catch (AssertionError as){
            System.out.println(as.toString());
        }
        windowids.remove(driver.getWindowHandle());
        driver.close();
        for (String windowid: windowids){
            driver.switchTo().window(windowid);
        }
        System.out.println("Current window count is "+windowids.size());
        driver.get("https://www.lambdatest.com/blog");
        String expectedurl= lambdaTestBlogPage.clickOnCommunityLink();
        String actualurl =driver.getCurrentUrl();
        Assert.assertEquals(actualurl,expectedurl);
    }

}
