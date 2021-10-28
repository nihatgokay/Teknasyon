package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

    @FindBy(css = "input.gLFyf")
    public WebElement searchBar;

    @FindBy(xpath = "//a[@href='https://teknasyon.com/']")
    public WebElement link;








}
