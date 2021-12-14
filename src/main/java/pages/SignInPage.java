package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SignInPage {
    private SelenideElement SignInWithPasswordButton = $x(".//div[contains(text(),'Войти с паролем')]");
    private SelenideElement InputEmail = $x(".//input[@autocomplete='username']");
    private SelenideElement SignInButton = $x(".//div[contains(text(),'Войти')]");
    private SelenideElement PasswordError = $x(".//div[@class='error-message-block form-entry-with-password__error']");
    private SelenideElement QuestionMark = $x(".//span[@class='form-entry-or-registry__ask-icon']");
    private SelenideElement Tooltip = $x(".//div[@class='auth-tooltip']");
   // private SelenideElement InputPhone = $x(".//input[@class='input-text']");
    //private SelenideElement SignInButton = $x(".//button[contains(text(),'Войти')]");
   // private SelenideElement PasswordError = $x(".//div[contains(text(),'Password cannot be blank')]");

    public void SignIn(String email) {
        SignInWithPasswordButton.click();
        InputEmail.setValue(email).pressEnter();
        SignInButton.click();
    }
     public String GetPasswordError() {
         return PasswordError.shouldBe(Condition.visible).getText();
     }
     public String GetTooltip() {
        QuestionMark.shouldBe(Condition.visible).click();
        return Tooltip.shouldBe(Condition.visible).getText();
     }
}
