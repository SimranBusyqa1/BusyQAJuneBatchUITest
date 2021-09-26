package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {

    @FindBy(id ="txtUsername")
    WebElement email;


    @FindBy(id ="txtPassword")
    WebElement password;

    @FindBy(id = "btnLogin")
    WebElement btn;

    @FindBy(xpath="//span[text()='Invalid credentials']")
    WebElement msg;


    public LoginPageClass(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String loginInto(String emailId,String pass) {


        String message = null;
        email.sendKeys(emailId);
        password.sendKeys(pass);
        btn.click();
        message= msg.getText();
        return message;
    }

    public void loginSuccess(String emailId,String pass) {

        email.sendKeys(emailId);
        password.sendKeys(pass);
        btn.click();
    }
}
