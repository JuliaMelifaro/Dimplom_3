package UITests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pages.Constructor;
import pages.Registration;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.WebDriverRunner.url;
import static webdriver.createPages.createNewRegistrationPage;

public class MovingToConstructorTest {

    @Test
    @DisplayName("Click on constructor button")
    @Description("Click on constructor button must move to constructor page")
    public void ClickConstructorButtonTest() {
        Registration regPage = createNewRegistrationPage();
        regPage.clickingConstructorButton();
        Assert.assertEquals(url(), Constructor.URL);
    }

    @Test
    @DisplayName("Click on site icon")
    @Description("Click on site icon must move to constructor page")
    public void ClickSiteIconTest() {
        Registration regPage = createNewRegistrationPage();
        regPage.clickingSiteIcon();
        Assert.assertEquals(url(), Constructor.URL);
    }

    @After
    public void resetData(){
        closeWindow();
    }
}
