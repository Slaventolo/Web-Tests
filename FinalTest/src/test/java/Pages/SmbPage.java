package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SmbPage {

    private final SelenideElement USER_NAME = $x("//*[contains(@class, 'user-profile-name')]");
    private final SelenideElement WRITE_MESSAGE_BUTTON = $x("//a[contains(@hrefattrs, 'ButtonsSendMessage')]");

    public SmbPage() {
        //check();
    }

    public void check() {
        USER_NAME.should(visible);
        WRITE_MESSAGE_BUTTON.shouldBe(visible);
    }

    public String getUserName() {
        return USER_NAME.shouldBe(visible).getText();
    }

    public void writeMessage() {
        WRITE_MESSAGE_BUTTON.click();
    }
}
