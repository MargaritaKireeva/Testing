import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import pages.MainPage;
import pages.SignInPage;
import pages.CatalogPage;
import pages.SpecialsPage;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;

public class Tests {
    private MainPage mainPage;
    private SignInPage signInPage;
    private CatalogPage catalogPage;

    @BeforeMethod
    public void openPage()  {
        mainPage = new MainPage();
        mainPage.Open();
    }
    @Test
    public void TooltipTest() {
        signInPage = mainPage.SignInPageOpen();
        Assert.assertEquals("Телефон в формате: 7 000 000 00 00\nФормат e-mail: name@example.ru", signInPage.GetTooltip());
    }
    @Test
    public void SignInTest() {
        signInPage = mainPage.SignInPageOpen();
        signInPage.SignIn("ritakireeva@mail.ru");
        Assert.assertEquals("Не все поля заполнены", signInPage.GetPasswordError());
    }
    @Test
    public void FilterTest() {
        catalogPage = mainPage.OpenCatalogLights();
        catalogPage.SetFilterByPrice("85", "150");
        Assert.assertTrue(catalogPage.CheckFilter(85, 150, 13));

    }
}
