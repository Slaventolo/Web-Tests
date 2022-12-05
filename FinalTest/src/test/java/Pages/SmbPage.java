package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SmbPage {

    private final SelenideElement WRITE_MESSAGE_BUTTON = $x("//a[contains(@hrefattrs, 'ButtonsSendMessage')]");

    public SmbPage() {
        check();
    }

    public void check() {
        WRITE_MESSAGE_BUTTON.shouldBe(visible);
    }

    public void writeMessage() {
        WRITE_MESSAGE_BUTTON.should(exist).click();
    }
}
