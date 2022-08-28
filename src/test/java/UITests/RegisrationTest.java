package UITests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import pages.Registration;
import org.junit.Test;
import pages.UserEnter;

import static api.DeleteUser.deletingUser;
import static com.codeborne.selenide.Selenide.closeWindow;
import static webdriver.createPages.createNewRegistrationPage;

public class RegisrationTest {
    String testEmail;
    String testPassword;

    @Test
    @DisplayName("Registration test - short password")
    @Description("Registering a new user - using short password")
    public void registrationShortPasswordTest() {
        String testName = "HungryUser" + Math.random()*1000;
        testEmail = "Tapioka" + Math.random()*1000 + "@ya.ru";
        testPassword = "qwer";
        Registration regPage = createNewRegistrationPage();
        regPage.RegisteringUser(testName, testEmail, testPassword);
        Assert.assertTrue(regPage.isPasswordErrorShown());
    }

    @Test
    @DisplayName("Registration test - successful")
    @Description("Registering a new user - successful test")
    public void registrationValidTest() {
        String testName = "HungryUser" + Math.random()*1000;
        testEmail = "Tapioka" + Math.random()*1000 + "@ya.ru";
        testPassword = "qwerty" + Math.random()*1000;
        Registration regPage = createNewRegistrationPage();
        UserEnter userPage = regPage.RegisteringUserRight(testName, testEmail, testPassword);
        Assert.assertTrue(userPage.isLoginPageLoad());
    }

    @After
    public void resetData(){
        closeWindow();
        deletingUser(testEmail, testPassword);
    }
}
