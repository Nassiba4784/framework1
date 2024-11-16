package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BaseClass {

    @FindBy(xpath = "//p[@class='oxd-userderopdown-name']")
    WebElement dropdown;

    public AccountPage(){

        PageFactory.initElements(driver, this);
    }
    public void clickDropDown(){
        dropdown.click();
    }
}
