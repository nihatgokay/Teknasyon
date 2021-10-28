package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerPage extends BasePage{

    @FindBy(xpath = "//li[@id='menu-item-128']//a")
    public WebElement career;

    @FindBy(xpath = "//h2[.='Seni tanımak isteriz!']")
    public WebElement description;

    @FindBy(xpath =" //a[@title='Test Otomasyon Mühendisi']")
    public WebElement position;


    @FindBy(xpath = "//a[@title='Başvur']")
    public WebElement apply1;

    @FindBy(xpath = "//span[.='Başvur']")
    public WebElement apply2;

    @FindBy(id = "jobNameSurname-error")
    public WebElement nameError;

    @FindBy(id = "jobEmail-error")
    public WebElement emailError;

    @FindBy(id = "jobFile-error")
    public WebElement fileError;

    @FindBy(id = "jobLet-error")
    public WebElement letError;

    @FindBy(id = "recaptchaControl-error")
    public WebElement recaptError;

    @FindBy(xpath = "//span[.='CV Yükle']")
    public WebElement addCV;

    @FindBy(id = "jobNameSurname")
    public WebElement nameSurname;

    @FindBy(id = "jobEmail")
    public WebElement email;

    @FindBy(id = "jobFile")
    public WebElement upload;

    @FindBy(className = "ci-effect")
    public WebElement verify;

    @FindBy(id = "recaptcha")
    public WebElement recapt;

    @FindBy(xpath = "//span[.='Başvur']")
    public WebElement apply3;











}
