package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PersonalCabinet {

    public final static String URL = "https://stellarburgers.nomoreparties.site/account/profile";

    private SelenideElement profileHeader = $(By.xpath(".//a[text()='Профиль']"));
    private SelenideElement exitButton = $(By.xpath(".//button[text()='Выход']"));

    public UserEnter clickingExitButton(){
        exitButton.click();
        UserEnter userPage = page(UserEnter.class);
        userPage.waitForLoad();
        return userPage;
    }

    public boolean isProfileVisible(){
        return profileHeader.isDisplayed();
    }

    public void waitForLoad(){
        profileHeader.shouldBe(visible);
    }
}
