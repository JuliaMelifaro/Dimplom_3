package UITests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.Constructor;
import pages.PersonalCabinet;
import pages.Registration;
import pages.UserEnter;

import static api.DeleteUser.deletingUser;
import static com.codeborne.selenide.Selenide.closeWindow;
import static webdriver.createPages.createNewEnterPage;
import static webdriver.createPages.createNewRegistrationPage;

public class EnteringPersonalCabinetTest {

    String testEmail;
    String testPassword;

    @Before
    public void creatingUser(){
        String testName = "HungryUser" + Math.random()*1000;
        testEmail = "Tapioka" + Math.random()*1000 + "@ya.ru";
        testPassword = "qwerty" + Math.random()*1000;
        Registration regPage = createNewRegistrationPage();
        regPage.RegisteringUser(testName, testEmail, testPassword);
    }

    @Test
    @DisplayName("Entering personal cabinet")
    @Description("Entering personal cabinet from main page")
    public void personalCabinetEnterTest(){
        UserEnter enterPage = createNewEnterPage();
        Constructor mainPage = enterPage.userEnter(testEmail, testPassword);
        mainPage.waitForLoad();
        PersonalCabinet personalPage = mainPage.clickingPersonalCabinetAfter();
        personalPage.waitForLoad();
        Assert.assertTrue(personalPage.isProfileVisible());
    }

    @After
    public void resetData(){
        closeWindow();
        deletingUser(testEmail, testPassword);
    }
}
