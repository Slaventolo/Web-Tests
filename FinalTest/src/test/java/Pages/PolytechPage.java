package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class PolytechPage {

    private final SelenideElement GROUP_HEAD = $x("//a[@data-l='t,preview']");
    private final SelenideElement SUBSCRIBE = $x("//*[text()='Вступить']");
    private final SelenideElement SUBSCRIPTIONS = $x("//*[text()='Подписки']");
    private final SelenideElement NOTIFY_OF_POSTS = $x("//*[text()='Оповещать о публикациях']");
    private final SelenideElement ALLOW_GROUP_MESSAGES = $x("//*[text()='Сообщения от группы']");
    private final SelenideElement IN_GROUP_ICON = $x("//*[text()='В группе']");
    private final SelenideElement UNSUBSCRIBE = $x("//*[text()='Выйти из группы']");
    private final SelenideElement CONFIRM_UNSUBSCRIPTION = $x("// input[@data-l='t,confirm']");
    private final SelenideElement GROUP_NAME_ON_GROUP_PAGE = $x("//h1[contains(@class, 'group-name_h')]");

    public String getGroupName() {
        return GROUP_NAME_ON_GROUP_PAGE.getText();
    }
    public void subscribe() {
        SUBSCRIBE.shouldBe(visible).click();
    }

    public void adjustSubscriptions() {
        SUBSCRIPTIONS.shouldBe(visible).click();
    }

    public void notifyOfPosts() {
        adjustSubscriptions();
        NOTIFY_OF_POSTS.shouldBe(visible).click();
        doSthToWait();
    }

    private void doSthToWait() {
        GROUP_HEAD.hover();
    }

    public void allowGroupMessages() {
        adjustSubscriptions();
        ALLOW_GROUP_MESSAGES.shouldBe(visible).click();
    }

    public void unsubscribe() {
        adjustSubscriptions();
        allowGroupMessages();
        IN_GROUP_ICON.shouldBe(visible).click();
        UNSUBSCRIBE.shouldBe(visible).click();
        CONFIRM_UNSUBSCRIPTION.shouldBe(visible).click();
    }
}
