package insider.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends BasePage{

    @FindBy (xpath = "//p[@class='mt-5 mb-0 mt-lg-0 mx-auto pl-0']")
    public WebElement OurLocations;

    @FindBy (xpath = "//h3[normalize-space(text())='Find your calling']")
    public WebElement FindYourCalling; // I cannot see "Teams" block, so instead of it, I used "Find your calling" title.

    @FindBy (xpath = "//p[contains(text(),'We’re here to grow and drive growth—as none of us ')]")
    public WebElement LifeAtInsider;

    @FindBy (xpath = "//a[normalize-space(text())='See all teams']")
    public WebElement SeeAllTeamsButton;

    @FindBy (xpath = "//h3[normalize-space()='Quality Assurance']")
    public WebElement QualityAssurance;

    @FindBy (xpath = "//a[normalize-space()='See all QA jobs']")
    public WebElement SeeAllQAJobs;

    @FindBy (id = "filter-by-location")
    public WebElement LocationFilterDropDown;

    @FindBy (css = ".btn.btn-navy.rounded.pt-2.pr-5.pb-2.pl-5[href='https://jobs.lever.co/useinsider/0e39c3f1-0dde-455f-8b15-3f68bbce5a0e']")
    public WebElement ApplyButton;

    @FindBy (xpath = "//p[normalize-space()='Software Quality Assurance Analyst']")
    public WebElement QAAnalyst;



}
