package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class UserEnter {

    public final static String URL = "https://stellarburgers.nomoreparties.site/login";
    private SelenideElement enterEmail = $(By.xpath(".//label[text()='Email']//following::input"));
    private SelenideElement enterPassword = $(By.xpath(".//input[@type='password']"));
    private SelenideElement enterButton = $(By.xpath(".//button[text()='Войти']"));

    @Step("Typing email")
    public void setEnterEmail (String enterEmail) {this.enterEmail.setValue(enterEmail); }
    @Step("Typing password")
    public void setEnterPassword (String enterPassword) {this.enterPassword.setValue(enterPassword); }
    @Step("Clicking enter button")
    public void clickingEnterButton() {enterButton.click();}

    @Step("User entering")
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
