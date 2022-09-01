package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RecoveryPassword {

    public final static String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    private SelenideElement enterAccountButton = $(By.xpath(".//p[text()='Вспомнили пароль?']" +
            "/a[text()='Войти']"));

    @Step("Clicking enter button")
    public UserEnter clickingEnterButton(){
        enterAccountButton.click();
        UserEnter userPage = page(UserEnter.class);
        return userPage;
    }
}
