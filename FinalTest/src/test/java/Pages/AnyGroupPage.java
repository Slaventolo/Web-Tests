package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class AnyGroupPage {

    private final SelenideElement GROUP_HEAD = $x("//a[@data-l='t,preview']");
    private final SelenideElement SUBSCRIBE = $x("//*[text()='Вступить']");


    // SelenideElements for After
    private final SelenideElement IN_GROUP_ICON = $x("//span[contains(@class, 'dropdown_ac button-pro')]");
    private final SelenideElement UNSUBSCRIBE = $x("//*[text()='Выйти из группы']");
    private final SelenideElement CONFIRM_UNSUBSCRIPTION = $x("// input[@data-l='t,confirm']");
    private final SelenideElement GROUP_NAME_ON_GROUP_PAGE = $x("//h1[contains(@class, 'group-name_h')]");


    public AnyGroupPage() {
        check();
    }

    private void check() {
        GROUP_HEAD.shouldBe(visible);
        GROUP_NAME_ON_GROUP_PAGE.shouldBe(visible);
    }

    public String getGroupName() {
        return GROUP_NAME_ON_GROUP_PAGE.getText();
    }

    public void subscribe() {
        SUBSCRIBE.click();
        IN_GROUP_ICON.shouldBe(visible);
    }

    public boolean checkIfSubscribed() {
        return IN_GROUP_ICON.is(visible);
    }

    public void unsubscribe() {
        IN_GROUP_ICON.click();
        UNSUBSCRIBE.click();
        CONFIRM_UNSUBSCRIPTION.click();
        IN_GROUP_ICON.should(disappear);
    }

    public boolean checkIfUnsubscribed() {
        return SUBSCRIBE.is(visible);
    }

}
