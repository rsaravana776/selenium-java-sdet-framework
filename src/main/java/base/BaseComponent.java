package base;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseComponent extends BasePage {

    protected WebDriver driver;

    public BaseComponent() {
        super();
        this.driver = DriverManager.getDriver();
    }

    protected boolean isComponentDisplayed(By locator) {
        return isDisplayed(locator);
    }

    protected void clickComponent(By locator) {
        click(locator);
    }

    protected String getComponentText(By locator) {
        return getText(locator);
    }
}