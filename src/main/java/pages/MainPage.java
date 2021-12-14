package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private String url = "https://www.dns-shop.ru/";
    private SelenideElement SignInButtonMain = $x(".//button[@data-role='login-button']");
    private SelenideElement HouseDecor = $x(".//a[contains(text(),'Дом, декор и кухня')]");
    private SelenideElement LightingAccessories = $x(".//span[contains(text(),'Освещение и аксессуары')]");
    private SelenideElement NewYearLighting = $x(".//span[contains(text(),'Новогоднее освещение')]");
    private SelenideElement Lights = $x(".//span[contains(text(),'Гирлянды')]");

    public void Open(){
        open(url);
    }
    public SelenideElement GetSignInButtonMain(){
        return SignInButtonMain;
    }
    public SignInPage SignInPageOpen() {
        SignInButtonMain.shouldBe(Condition.visible).click();
        return new SignInPage();
    }

    public CatalogPage OpenCatalogLights() {
        HouseDecor.shouldBe(Condition.visible).click();
        LightingAccessories.shouldBe(Condition.visible).click();
        NewYearLighting.shouldBe(Condition.visible).click();
        Lights.shouldBe(Condition.visible).click();
       return new CatalogPage();
    }
}
