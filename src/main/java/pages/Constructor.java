package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Constructor {
    public final static String URL = "https://stellarburgers.nomoreparties.site/";

    private SelenideElement personalCabinetButton = $(By.xpath(".//p[text()='Личный Кабинет']"));
    private SelenideElement enterAccountButton = $(By.xpath(".//button[text()='Войти в аккаунт']"));
    private SelenideElement constructorHeader = $(By.xpath(".//h1[text()='Соберите бургер']"));

    private  SelenideElement bunSection = $(By.xpath(".//span[text()='Булки']"));
    private  SelenideElement selectedBunSection = $(By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']" +
            "/span[text()='Булки']"));

    private  SelenideElement sauceSection = $(By.xpath(".//span[text()='Соусы']"));
    private  SelenideElement selectedSauceSection = $(By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']" +
            "/span[text()='Соусы']"));

    private  SelenideElement ingredientSection = $(By.xpath(".//span[text()='Начинки']"));
    private  SelenideElement selectedIngredientSection = $(By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']" +
            "/span[text()='Начинки']"));

    @Step("Clicking bun selection")
    public void selectBun(){
        bunSection.click();
    }

    @Step("Clicking sauce section")
    public void selectSauce(){
        sauceSection.click();
    }

    @Step("Clicking ingredient section")
    public void selectIngredient(){
        ingredientSection.click();
    }

    public boolean isBunSelected(){
        return selectedBunSection.exists();
    }

    public boolean isSauceSelected(){
        return selectedSauceSection.exists();
    }

    public boolean isIngredientSelected(){
        return selectedIngredientSection.exists();
    }
    @Step("Clicking personal cabinet button without login")
    public UserEnter clickingPersonalCabinet(){
        personalCabinetButton.click();
        UserEnter userPage = page(UserEnter.class);
        return userPage;
    }

    @Step("Clicking personal cabinet button after login")
    public PersonalCabinet clickingPersonalCabinetAfter(){
        personalCabinetButton.click();
        PersonalCabinet personalPage = page(PersonalCabinet.class);
        return personalPage;
    }

    @Step("Clicking account button")
    public UserEnter clickingAccountButton(){
        enterAccountButton.click();
        UserEnter userPage = page(UserEnter.class);
        return userPage;
    }

    public boolean isMainPageVisible(){
        return constructorHeader.isDisplayed();
    }
    public void waitForLoad(){
        constructorHeader.shouldBe(visible);
    }

}
