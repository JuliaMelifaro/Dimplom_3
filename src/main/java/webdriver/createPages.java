package webdriver;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import pages.Constructor;
import pages.RecoveryPassword;
import pages.Registration;
import pages.UserEnter;

import static com.codeborne.selenide.Selenide.open;

public class createPages {
   // static String setBrowser = "firefox";
   static String setBrowser = "chrome";

   @Step("Creating new registration page")
   public static Registration createNewRegistrationPage(){
        Configuration.browserSize = "1920x1080";
        Configuration.browser = setBrowser;
        open(Registration.URL);
        Registration regPage = new Registration();
        return regPage;
    }

    @Step("Creating new constructor page")
    public static Constructor createNewConstructorPage(){
        Configuration.browserSize = "1920x1080";
        Configuration.browser = setBrowser;
        open(Constructor.URL);
        Constructor mainPage = new Constructor();
        return mainPage;
    }

    @Step("Creating new recovery page")
    public static RecoveryPassword createNewRecoveryPage(){
        Configuration.browserSize = "1920x1080";
        Configuration.browser = setBrowser;
        open(RecoveryPassword.URL);
        RecoveryPassword recoveryPage = new RecoveryPassword();
        return recoveryPage;
    }

    @Step("Creating new user enter page")
    public static UserEnter createNewEnterPage(){
        Configuration.browserSize = "1920x1080";
        Configuration.browser = setBrowser;
        open(UserEnter.URL);
        UserEnter enterPage = new UserEnter();
        return enterPage;
    }
}
