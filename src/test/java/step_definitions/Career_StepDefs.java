package step_definitions;

import io.cucumber.java.en.*;
import pages.CareerPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import static org.junit.Assert.*;


public class Career_StepDefs {

    CareerPage careerPage = new CareerPage();

    @Given("user navigate to Teknasyon.com")
    public void user_navigate_to_Teknasyon_com() {
        Driver.get().get(ConfigurationReader.get("url2"));
    }

    @When("the user click {string} button")
    public void the_user_click_button(String careerButton) {
        BrowserUtils.waitFor(3);
        BrowserUtils.scrollToElement(careerPage.career);
        BrowserUtils.waitForClickability(careerPage.career,3);
        assertTrue(careerPage.career.isDisplayed());
        assertTrue(careerPage.career.getText().toLowerCase().contains(careerButton));
        careerPage.career.click();
    }


    @Then("the user should be able to click {string} position")
    public void the_user_should_be_able_to_click_position(String position) {
        //System.out.println("careerPage.description.getText() = " + careerPage.description.getText());
        assertTrue(careerPage.description.getText().contains("Seni tanımak isteriz!"));
        assertTrue(careerPage.position.isDisplayed());
        BrowserUtils.clickWithJS(careerPage.position);
        //System.out.println("Driver.get().getTitle() = " + Driver.get().getTitle());
        assertTrue(Driver.get().getTitle().contains(position));

        BrowserUtils.clickWithJS(careerPage.apply1);
        BrowserUtils.waitForClickability(careerPage.apply2,5);
        assertTrue(careerPage.apply2.isDisplayed());
        BrowserUtils.clickWithJS(careerPage.apply2);
    }

    @Then("the user should be able to see the warning messages in the application form without taking any action")
    public void the_user_should_be_able_to_see_the_warning_messages_in_the_application_form_without_taking_any_action() {
        assertEquals(careerPage.nameError.getText(),"Bu alanın doldurulması zorunludur.");
        assertEquals(careerPage.emailError.getText(),"Bu alanın doldurulması zorunludur.");
        assertEquals(careerPage.fileError.getText(),"Bu alanın doldurulması zorunludur.");
        assertEquals(careerPage.letError.getText(),"CV'nizi bizimle paylaşmadan önce, Aydınlatma Metni’ni okuyup, kutucuğu işaretlemeniz gerekmektedir.");
        assertEquals(careerPage.recaptError.getText(),"Lütfen recaptcha doğrulamasını yapınız.");
    }


    @Then("the user should be able to fill in the application form and upload resume")
    public void the_user_should_be_able_to_fill_in_the_application_form_and_upload_resume() {
        assertTrue(careerPage.addCV.isDisplayed());
        careerPage.nameSurname.sendKeys("Gökay");
        careerPage.email.sendKeys("nihatgokay@gmail.com");

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/Nihat Gokay YUZBASIOGLU - Resume (1).docx";
        String fullPath = projectPath + "/" + filePath;

        careerPage.upload.sendKeys(fullPath);
        //After uploading the resume, the error message is still present
    }

    @Then("the user should be able to complete application")
    public void the_user_should_be_able_to_complete_application() {
        assertTrue(careerPage.recapt.isDisplayed());
        careerPage.verify.click();
        assertFalse(careerPage.letError.isDisplayed());
        BrowserUtils.waitFor(30);
        BrowserUtils.clickWithJS(careerPage.apply3);
        assertTrue(Driver.get().getTitle().contains("İş Başvuru Formu - Başarılı - Teknasyon"));
    }


}
