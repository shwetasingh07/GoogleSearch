package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchResultsPage {

    WebDriver driver;

    public GoogleSearchResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID,using="resultStats")
    public WebElement RESULTS_TEXT;

    //@FindBy(how=How.XPATH,using="//div[@class='r']/a/h3")
    //public List<WebElement> RESULTS;

    @FindBy(how=How.CSS,using="#rso > div:nth-child(1) > div > div > div > div > div.r > a > h3")
    public WebElement RESULTS;



}
