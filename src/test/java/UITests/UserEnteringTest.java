package UITests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.Constructor;
import pages.RecoveryPassword;
import pages.Registration;
import pages.UserEnter;

import static api.DeleteUser.deletingUser;
import static com.codeborne.selenide.Selenide.closeWindow;
import static webdriver.createPages.*;

public class UserEnteringTest {
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
    @DisplayName("User enter - from personal cabinet")
    @Description("User enter by clicking personal cabinet")
    public void enterFromPersonalCabinetTest(){
        Constructor mainPage = createNewConstructorPage();
        UserEnter userPage = mainPage.clickingPersonalCabinet();
        Constructor mainPage2 = userPage.userEnter(testEmail, testPassword);
        Assert.assertTrue(mainPage2.isMainPageVisible());
    }

    @Test
    @DisplayName("User enter - from main page")
    @Description("User enter by clicking enter on main page")
    public void enterFromMainPageTest(){
        Constructor mainPage = createNewConstructorPage();
        UserEnter userPage = mainPage.clickingAccountButton();
        Constructor mainPage2 = userPage.userEnter(testEmail, testPassword);
        Assert.assertTrue(mainPage2.isMainPageVisible());
    }

    @Test
    @DisplayName("User enter - from registration page")
    @Description("User enter by clicking enter on registration page")
    public void enterFromRegistrationPageTest(){
        Registration regPage = createNewRegistrationPage();
        UserEnter userPage = regPage.clickingLoginButton();
        Constructor mainPage2 = userPage.userEnter(testEmail, testPassword);
        Assert.assertTrue(mainPage2.isMainPageVisible());
    }

    @Test
    @DisplayName("User enter - from recovery page")
    @Description("User enter by clicking enter on recovery page")
    public void enterFromRecoveryPageTest(){
        RecoveryPassword recoveryPage = createNewRecoveryPage();
        UserEnter userPage = recoveryPage.clickingEnterButton();
        Constructor mainPage2 = userPage.userEnter(testEmail, testPassword);
        Assert.assertTrue(mainPage2.isMainPageVisible());
    }

    @After
    public void resetData(){
        closeWindow();
        deletingUser(testEmail, testPassword);
    }
}
