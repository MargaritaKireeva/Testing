package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SpecialsPage {
    private SelenideElement tooltipPlace = $x(".//button[@id='uw-main-button']");
    private SelenideElement tooltip = $x(".//div[contains(text(),'Есть вопрос? Свяжитесь с нами!')]");
    //<div class="sc-kafWEX uw__tooltip-label lUCMR" font-size="17">Есть вопрос? Свяжитесь с нами!</div>
    public String GetTooltip() {
        tooltipPlace.shouldBe(Condition.visible).hover();
        return tooltip.shouldBe(Condition.visible).getText();
    }
}
