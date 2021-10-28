package step_definitions;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import org.openqa.selenium.Keys;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Teknasyon_StepDef {

    HomePage homePage = new HomePage();

    @Given("the user is on the {string}")
    public void the_user_is_on_the(String google) {
        Driver.get().get(ConfigurationReader.get("url"));
        //System.out.println(Driver.get().getTitle().toLowerCase());
        assertEquals(Driver.get().getTitle().toLowerCase(),google);
    }

    @When("the user enters {string} into search bar to get {string}")
    public void the_user_enters_into_search_bar(String teknasyon,String link) {
        homePage.searchBar.sendKeys(teknasyon+ Keys.ENTER);
        System.out.println(homePage.link.getText());
        assertTrue(homePage.link.getText().toLowerCase().contains(link));
    }

    @Then("the user is on the {string} home page")
    public void the_user_is_on_the_home_page(String title) {
        homePage.link.click();
        System.out.println(Driver.get().getTitle());
        assertTrue(Driver.get().getTitle().contains(title));
    }



}
