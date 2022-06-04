package insider.stepdefinitions;

import insider.pages.CareersPage;
import insider.pages.InsiderPage;
import insider.utilities.BrowserUtils;
import insider.utilities.ConfigurationReader;
import insider.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TaskStepDefs {

    InsiderPage insiderPage = new InsiderPage();
    CareersPage careersPage = new CareersPage();


    @Given("the user enters the web page")
    public void the_user_enters_the_web_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);


        BrowserUtils.waitFor(3);
        //Accept the cookies.
        insiderPage.acceptCookies.click();


    }

    @Then("the web page title should seen {string}")
    public void the_web_page_title_should_seen(String expectedPageTitle) {
        String actualPageTitle = Driver.get().getTitle();
        System.out.println(actualPageTitle);
        Assert.assertEquals(expectedPageTitle,actualPageTitle);


    }



    @Then("the user navigates to {string} button")
    public void the_user_navigates_to_button(String MoreButton) {
        insiderPage.MoreButton.click();
        BrowserUtils.waitFor(3);


    }

    @Then("the user able to click {string}")
    public void the_user_able_to_click(String CareersButton) {
        insiderPage.CareersButton.click();


    }

    @When("the user verify to {string}, {string} and {string} blocks")
    public void the_user_verify_to_and_blocks(String Teams, String Locations, String LifeAtInsider) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();

        for (int i = 0; i < 15; i++) {
            BrowserUtils.waitFor(2);
            jse.executeScript("window.scrollBy(0,250)");


        }

        LifeAtInsider = "We’re here to grow and drive growth—as none of us did before. Together, we’re building a culture that inspires us to create our life’s work—and creates a bold(er) impact. We know that we’re smarter as a group than we are alone. Become one of us if you dare to play bigger.";
        assertEquals(Locations,careersPage.OurLocations.getText());
        assertEquals(Teams, careersPage.FindYourCalling.getText());
        assertEquals(LifeAtInsider, careersPage.LifeAtInsider.getText());

    }


    @Then("the user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();

        for (int i = 0; i < 10; i++) {
            BrowserUtils.waitFor(3);
            jse.executeScript("window.scrollBy(0,250)");


        }
        careersPage.SeeAllTeamsButton.click();
        BrowserUtils.waitFor(2);

    }

    @Then("the user selects {string}")
    public void the_user_selects(String string) {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();

        for (int i = 0; i < 10; i++) {
            BrowserUtils.waitFor(3);
            jse.executeScript("window.scrollBy(0,250)");
        }

        careersPage.QualityAssurance.click();
        BrowserUtils.waitFor(2);

    }

    @Then("the user clicks to {string} button")
    public void the_user_clicks_to_button(String string) {
        careersPage.SeeAllQAJobs.click();
        BrowserUtils.waitFor(5);

    }

    @When("the user chooses {string} filter by Location")
    public void the_user_chooses_filter_by_Location(String string) {
        Select dropdown = new Select(careersPage.LocationFilterDropDown);
        List<WebElement> allOptions = dropdown.getOptions();
        for (WebElement option : allOptions) {
            if (option.getText().equals("Istanbul, Turkey")){
                option.click();
                break;
            }

        }



    }

    @Then("the user should be able to see presence of {string} jobs list")
    public void the_user_should_be_able_to_see_presence_of_jobs_list(String expectedQA) {


        BrowserUtils.waitFor(2);
       for (int i = 0; i <4; i++) {
            List <WebElement> QAText = Driver.get()
                    .findElements(By.xpath("//*[@id=\"jobs-list\"]/div"));

            Assert.assertEquals("istanbul-turkey", QAText.get(i).getAttribute("data-location"));
            Assert.assertEquals("qualityassurance",QAText.get(i).getAttribute("data-team"));


        }



    }


    @Then("the user clicks {string} Apply Now button and see application page")
    public void the_user_clicks_Apply_Now_button_and_see_application_page(String string) {

        Actions actions = new Actions(Driver.get());
        actions.moveToElement(careersPage.QAAnalyst);
        BrowserUtils.waitFor(3);

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();

        for (int i = 0; i < 5; i++) {
            BrowserUtils.waitFor(2);
            jse.executeScript("window.scrollBy(0,100)");

        }



//Creating object of an Actions class
        Actions action = new Actions(Driver.get());

        String parentWindow = Driver.get().getWindowHandle();


//Performing the mouse hover action on the target element.
        actions.moveToElement(careersPage.ApplyButton).perform();
        careersPage.ApplyButton.click();

        BrowserUtils.waitFor(5);

        for (String childTab : Driver.get().getWindowHandles()) {

            Driver.get().switchTo().window(childTab);

        }

        BrowserUtils.waitFor(3);

        System.out.println(Driver.get().getTitle());
        String expectedResult = "Insider. - Software Quality Assurance Analyst";
        Assert.assertEquals(expectedResult, Driver.get().getTitle());


       //ArrayList<String> tabs2 = new ArrayList<String> (Driver.get().getWindowHandles());
       // Driver.get().switchTo().window(tabs2.get(0));
       // Driver.get().close();
       // Driver.get().switchTo().window(Driver.get().);







    }

  //  @Then("the user should be see {string} application page")
   // public void the_user_should_be_see_application_page(String expectedPageTitle) {
    //    expectedPageTitle = "Insider. - " + expectedPageTitle;



    //}


// browser.getAllWindowHandles().then(function (handles) { browser.driver.switchTo().window(handles[1]);
//browser.driver.close();
//browser.driver.switchTo().window(handles[0]);
//}




}
