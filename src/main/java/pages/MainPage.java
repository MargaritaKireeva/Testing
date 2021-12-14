package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private String url = "https://www.dns-shop.ru/";
    private SelenideElement SignInButtonMain = $x(".//button[@data-role='login-button']");
    //"Гирлянды"(находится на главной странице в актуальных предложениях)
    private SelenideElement HouseDecor = $x(".//a[contains(text(),'Дом, декор и кухня')]");
    private SelenideElement LightingAccessories = $x(".//span[contains(text(),'Освещение и аксессуары')]");
    private SelenideElement NewYearLighting = $x(".//span[contains(text(),'Новогоднее освещение')]");
    private SelenideElement Lights = $x(".//span[contains(text(),'Гирлянды')]");
    //private String url = "https://fix-price.com/";
    //private SelenideElement SignInButtonMain = $x(".//div[@class='controls-link profile']");
   // private SelenideElement CatalogButton = $x(".//a[@class='catalog no-adaptive catalog-link']");
   // private SelenideElement AllForNewYearButton = $x(".//div[contains(text(),'Всё для Нового Года!')]");
    //private SelenideElement NoChangeCityButton =  $x(".//button[contains(text(),'Да')]");
    //private SelenideElement SpecialsButton = $x(".//a[@class='controls-link specials']");

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
   // public SpecialsPage OpenSpecials() {
     //   SpecialsButton.click();
     //   return new SpecialsPage();
   // }
}
