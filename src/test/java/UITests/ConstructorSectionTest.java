package UITests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.Constructor;

import static webdriver.createPages.createNewConstructorPage;

public class ConstructorSectionTest {

    @Test
    @DisplayName("Select sauce section")
    @Description("Selecting sauce section in constructor")
    public void selectSauceSectionTest() {
        Constructor mainPage = createNewConstructorPage();
        mainPage.selectSauce();
        Assert.assertTrue(mainPage.isSauceSelected());
    }

    @Test
    @DisplayName("Select ingredient section")
    @Description("Selecting ingredient section in constructor")
    public void selectIngredientSectionTest() {
        Constructor mainPage = createNewConstructorPage();
        mainPage.selectIngredient();
        Assert.assertTrue(mainPage.isIngredientSelected());
    }

    @Test
    @DisplayName("Select bun section")
    @Description("Selecting bun section in constructor")
    public void selectBunSectionTest() {
        Constructor mainPage = createNewConstructorPage();
        mainPage.selectIngredient();
        mainPage.selectBun();
        Assert.assertTrue(mainPage.isBunSelected());
    }
}
