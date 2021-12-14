import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import pages.MainPage;
import pages.SignInPage;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;

public class test {

    @Test
    public void testTrue()  {
        assertTrue(main.luckyTicket("123123"));
    }
    @Test
    public void Test() {
        $(By.xpath(".//a[contains(text(),'Акции')]")).click();

    }
    @Test
    public void testFalse1() {
        assertFalse(main.luckyTicket("123124"));
    }
    @Test
    public void testFalse2() {
        assertFalse(main.luckyTicket("12341234"));
    }
    @Test
    public void testFalse3() {
        assertFalse(main.luckyTicket(""));
    }
    @Test
    public void testFalse4() {
        assertFalse(main.luckyTicket("      "));
    }
}
