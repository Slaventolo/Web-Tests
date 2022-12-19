package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement LOGIN_INPUT = $x("//input[@name='st.email']");
    private final SelenideElement PASSWORD_INPUT = $x("//input[@name='st.password']");

    public LoginPage(String url) {
        Selenide.open(url);
        check();
    }

    private void check() {
        LOGIN_INPUT.shouldBe(visible);
        PASSWORD_INPUT.shouldBe(visible);
    }

    /*public void openSite(String url) {
        Selenide.open(url);
    }*/

    public void login(String login, String password) {
        LOGIN_INPUT.setValue(login);
        PASSWORD_INPUT
                .setValue(password)
                .sendKeys(Keys.ENTER);
    }
}
