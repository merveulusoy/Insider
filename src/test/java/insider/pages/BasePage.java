package insider.pages;

import insider.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath = "//a[@data-cli_action='accept_all']")
    public WebElement acceptCookies;

    @FindBy(xpath = "//span[normalize-space()='More']")
    public WebElement MoreButton;

    @FindBy(xpath = "//h5[normalize-space()='Careers']")
    public WebElement CareersButton;
}
