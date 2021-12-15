package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage {
    private SelenideElement AllFilters = $x(".//a[contains(text(), 'Все фильтры')]");
    private SelenideElement Price = $x(".//div[@class='filters-extended__filters']/.//span[contains(text(),'Цена')]");
    private SelenideElement SmallestPrice = $x(".//div[@class='filters-extended__filters']/.//input[@placeholder='от 85']");
    private SelenideElement HighestPrice = $x(".//div[@class='filters-extended__filters']/.//input[@placeholder='до 4550']");
    private SelenideElement SubmitButton = $x(".//div[@class='filters-extended__buttons']/.//button[contains(text(),'Применить')]");
    private ElementsCollection Lights = $$x(".//div[@class='catalog-product ui-button-widget']");

    public void SetFilterByPrice(String smallestPrice, String highestPrice) {
        AllFilters.shouldBe(Condition.visible).click();
        Price.shouldBe(Condition.visible).click();
        SmallestPrice.shouldBe(Condition.visible).setValue(smallestPrice).shouldBe(Condition.exactValue(smallestPrice));
        HighestPrice.shouldBe(Condition.visible).setValue(highestPrice).shouldBe(Condition.exactValue(highestPrice));
        SubmitButton.shouldBe(Condition.visible).click();
    }

    public boolean CheckFilter(int smallestPrice, int highestPrice, int countOfElements) {
        String priceStr;
        int price;
        Lights.shouldBe(CollectionCondition.size(countOfElements));
        for (SelenideElement light : Lights) {
            if (light.find(By.xpath(".//div[@class='product-buy__price']")).exists()) {
                priceStr = light.find(By.xpath(".//div[@class='product-buy__price']")).shouldBe(Condition.visible).getText();
                price = Integer.parseInt(priceStr.split(" ")[0]);
            }
            else {
                priceStr = light.find(By.xpath(".//div[@class='product-buy__price product-buy__price_active']")).shouldBe(Condition.visible).getText();
                price = Integer.parseInt(priceStr.split(" ")[0]);
            }
            if (price < smallestPrice || price > highestPrice)
                return false;
        }
        return true;
    }
}
