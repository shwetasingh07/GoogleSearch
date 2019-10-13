package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

    WebDriver driver;

    public GoogleHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.NAME,using="q")
    public WebElement SEARCH_BOX;

    @FindBy(how=How.NAME,using="btnK")
    public WebElement GOOGLE_SEARCH_BUTTON;

    public void enterSearchTerm(String searchTerm){
        SEARCH_BOX.sendKeys(searchTerm);
        GOOGLE_SEARCH_BUTTON.click();
    }

    public void enterSearchTermUsingMouse(String searchTerm){
        Actions action=new Actions(driver);
        action.moveToElement(SEARCH_BOX).click().perform();
        action.moveToElement(SEARCH_BOX).sendKeys(searchTerm).perform();
        action.moveToElement(SEARCH_BOX).sendKeys(Keys.ENTER).perform();
    }
}
