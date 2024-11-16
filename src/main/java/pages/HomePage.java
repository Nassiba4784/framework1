package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass {

    @FindBy(name = "username")
    WebElement inputUsername;
    @FindBy(name = "password")
    WebElement inputPassword;
    @FindBy(tagName = "button")
    WebElement loginButton;
    @FindBy(xpath = "//label[@class='oxd-label oxd-input-field-required']")
    WebElement requiredMsg;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    public void enterUsername(String username){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        typeText(inputUsername, username);
    }
    public void enterPassword(String password){
        typeText(inputPassword, password);
    }
    public void clicklogin(){
        clickOnElement(loginButton);
    }
    public boolean requiredMsgDisplay(){
        wait.until(ExpectedConditions.visibilityOf(requiredMsg));
        return requiredMsg.isDisplayed();
    }
    public void dologin(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clicklogin();
        
    }
}


