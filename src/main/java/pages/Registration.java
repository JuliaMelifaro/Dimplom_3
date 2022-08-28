package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class Registration {

    public final static String URL = "https://stellarburgers.nomoreparties.site/register";
    private SelenideElement userName = $(By.xpath(".//label[text()='Имя']//following::input"));
    private SelenideElement userEmail = $(By.xpath(".//label[text()='Email']//following::input"));
    private SelenideElement userPassword = $(By.xpath(".//input[@type='password']"));
    private SelenideElement registrationButton = $(By.xpath(".//button[text()='Зарегистрироваться']"));
    private SelenideElement enterButton = $(By.className("Auth_link__1fOlj"));
    private SelenideElement constructorButton = $(By.xpath(".//a[@class='AppHeader_header__link__3D_hX']" +
            "/p[text()='Конструктор']"));
    private SelenideElement stellarIcon = $(By.xpath(".//div[@class ='AppHeader_header__logo__2D0X2']" +
            "/a[@href='/']"));
    private SelenideElement passwordError = $(By.xpath(".//p[text()='Некорректный пароль']"));

    public void setUserName (String userName) {this.userName.setValue(userName); }
    public void setUserEmail (String userEmail) {
        this.userEmail.setValue(userEmail);
    }
    public void setUserPassword (String userPassword) {this.userPassword.setValue(userPassword);}
    public void clickingRegistrationButton() {registrationButton.click();}
    public UserEnter clickingLoginButton(){
        enterButton.click();
        UserEnter userPage = page(UserEnter.class);
        return userPage;
    }

    public void RegisteringUser(String userName, String userEmail, String userPassword){
        setUserName (userName);
        setUserEmail (userEmail);
        setUserPassword (userPassword);
        clickingRegistrationButton();
    }

    public UserEnter RegisteringUserRight(String userName, String userEmail, String userPassword){
        setUserName (userName);
        setUserEmail (userEmail);
        setUserPassword (userPassword);
        clickingRegistrationButton();
        UserEnter userPage = page(UserEnter.class);
        userPage.waitForLoad();
        return userPage;
    }

    public Boolean isPasswordErrorShown(){
        return passwordError.isDisplayed();
    }

    public void clickingConstructorButton(){
        constructorButton.click();
    }

    public void clickingSiteIcon(){
        stellarIcon.click();
    }
}
