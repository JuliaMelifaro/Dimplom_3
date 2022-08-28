package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class UserEnter {

    public final static String URL = "https://stellarburgers.nomoreparties.site/login";
    private SelenideElement enterEmail = $(By.xpath(".//label[text()='Email']//following::input"));
    private SelenideElement enterPassword = $(By.xpath(".//input[@type='password']"));
    private SelenideElement enterButton = $(By.xpath(".//button[text()='Войти']"));

    public void setEnterEmail (String enterEmail) {this.enterEmail.setValue(enterEmail); }
    public void setEnterPassword (String enterPassword) {this.enterPassword.setValue(enterPassword); }
    public void clickingEnterButton() {enterButton.click();}

    public Constructor userEnter(String email, String password){
        setEnterEmail(email);
        setEnterPassword(password);
        clickingEnterButton();
        Constructor mainPage = page(Constructor.class);
        mainPage.waitForLoad();
        return mainPage;
    }

    public boolean isLoginPageLoad(){
        return enterButton.isDisplayed();
    }

    public void waitForLoad(){
        enterButton.shouldBe(visible);
    }



}
