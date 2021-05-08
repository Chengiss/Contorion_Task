package com.contorion.pages;

import com.contorion.utilities.ConfigurationReader;
import com.contorion.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Dashboard extends BasePage{

    public Dashboard() { PageFactory.initElements(Driver.get(), this);}

    @FindBy(id="popin_tc_privacy_button")
    public List<WebElement> acceptCookies;

    @FindBy(linkText = "Anmelden")
    public WebElement anmelden;

    @FindBy(id="login_email")
    public WebElement inputMail;

    @FindBy(id="login_password")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@data-qa='loginButtonSubmit']")
    public WebElement loginPageLogin;

    @FindBy(xpath = "//span[.='Jetzt anmelden']")
    public WebElement homePageLogin;

    @FindBy(css = "div.alert.alert--success._my3.js-notification")
    public WebElement successMessage;


}
