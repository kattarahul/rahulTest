package com.Actions;

import com.Waits.SeleniumWaits;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumActions {
    WebDriver driver;
    SeleniumWaits seleniumWaits;

    public SeleniumActions(WebDriver driver) {
        this.driver = driver;
        seleniumWaits = new SeleniumWaits(driver);
        seleniumWaits = new SeleniumWaits(driver);
    }

    public boolean clickOnElement(WebElement element) {
        boolean flag = false;

        try {
            element.click();
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (StaleElementReferenceException ser) {
            // TODO: handle exception
            System.out.println(ser.toString());
            flag = false;
        } catch (ElementNotInteractableException eni) {
            // TODO: handle exception
            System.out.println(eni.toString());
            flag = false;
        }
        return flag;
    }

    public boolean enterValueOnTextField(WebElement element, String value) {

        boolean flag = true;

        try {
            element.sendKeys(value);
        } catch (NoSuchElementException nse) {
            // TODO: handle exception
            System.out.println(nse.toString());
            flag = false;
        } catch (StaleElementReferenceException Ser) {
            // TODO: handle exception
            System.out.println(Ser.toString());
            flag = false;
        } catch (ElementNotInteractableException eni) {
            // TODO: handle exception
            System.out.println(eni.toString());
            flag = false;
        }
        return flag;

    }

    public boolean waitAndClickElement(WebElement element) {
        boolean flag = false;
        try {
            seleniumWaits.waitForElementTobeClickable(element).click();
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            return false;
        } catch (StaleElementReferenceException Ser) {
            // TODO: handle exception
            System.out.println(Ser.toString());
            flag = false;
        } catch (ElementNotInteractableException eni) {
            // TODO: handle exception
            System.out.println(eni.toString());
            flag = false;
        }catch (TimeoutException te){
            te.printStackTrace();
        }

        return flag;

    }

    public boolean waitForVisibleAndClick(WebElement element) {
        boolean flag = false;
        try {
            seleniumWaits.waitForElementTobeVisible(element).click();
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            return false;
        } catch (StaleElementReferenceException Ser) {
            // TODO: handle exception
            System.out.println(Ser.toString());
            flag = false;
        } catch (ElementNotInteractableException eni) {
            // TODO: handle exception
            System.out.println(eni.toString());
            flag = false;
        }
        return flag;

    }

    public boolean selectValueFromDropDown(WebElement element, String data, String typeSelect) {
        try {
            Select select = new Select(element);
            switch (typeSelect) {
                case "index":
                    select.selectByIndex(Integer.parseInt(data));
                    break;
                case "value":
                    select.selectByValue(data);
                    break;
                case "text":
                    select.selectByVisibleText(data);
                    break;
            }
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    public boolean javaScriptExcecutorClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        boolean flag = false;
        try {
            jse.executeScript("return arguments[0].click();", element);
            flag = true;
        } catch (StaleElementReferenceException Ser) {
            // TODO: handle exception
            System.out.println(Ser.toString());
            flag = false;
        } catch (ElementNotInteractableException eni) {
            // TODO: handle exception
            System.out.println(eni.toString());
            flag = false;
        }
        return flag;
    }

    public boolean clickOnWebElementUsingText(String tag, String text) {
        boolean flag = false;
        try {
            driver.findElement(By.xpath("//" + tag + "[text()='" + text + "'])")).click();
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (StaleElementReferenceException ser) {
            System.out.println(ser.toString());
            flag = false;
        } catch (ElementNotInteractableException eni) {
            System.out.println(eni.toString());
            flag = false;
        }
        return flag;
    }

    public boolean clickByAction(WebElement element) {
        Actions actions = new Actions(driver);
        boolean flag = false;
        try {
            actions.moveToElement(element).click().build().perform();
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (ElementNotInteractableException eni) {
            System.out.println(eni.toString());
            flag = false;
        } catch (StaleElementReferenceException ser) {
            System.out.println(ser.toString());
            flag = false;
        }
        return flag;
    }

    public boolean hoverOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        boolean flag = false;
        try {
            actions.moveToElement(element).build().perform();
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (ElementNotInteractableException eni) {
            System.out.println(eni.toString());
            flag = false;
        } catch (StaleElementReferenceException ser) {
            System.out.println(ser.toString());
            flag = false;
        }
        return flag;
    }

    public void scrollUsingJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void dragAndDropSliderusingWithMouse(WebElement element, int xoffset, int yoffset) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, xoffset, yoffset);
    }

    public void handleSliderUsingSendkeys(WebElement slider, int dragsliderto) {
        for (int i = 0; i < dragsliderto; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }
}