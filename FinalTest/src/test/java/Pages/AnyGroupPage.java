package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class AnyGroupPage {

    private final SelenideElement GROUP_HEAD = $x("//a[@data-l='t,preview']");
    private final SelenideElement SUBSCRIBE = $x("//*[text()='Вступить']");
    //private final SelenideElement SUBSCRIPTIONS = $x("//*[text()='Подписки']");
    //private final SelenideElement NOTIFY_OF_POSTS = $x("//*[text()='Оповещать о публикациях']");
    //private final SelenideElement ALLOW_GROUP_MESSAGES = $x("//*[text()='Сообщения от группы']");
    //private final SelenideElement NOTIFICATIONS_ARE_ALLOWED = $x("//*[@data-l='outlandertarget,notifOff,t,notifOff']//input[@checked='checked']");
    //private final SelenideElement NOTIFICATIONS_ARE_ALLOWED = $x("//*[@data-l='outlandertarget,notifOff,t,notifOff']");
    //private final SelenideElement MESSAGES_ARE_ALLOWED = $x("//*[@data-l='outlandertarget,messagesOff,t,messagesOff']//input[@checked='checked']");
    //private final SelenideElement MESSAGES_ARE_ALLOWED = $x("//*[@data-l='outlandertarget,messagesOff,t,messagesOff']");

    //After
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

/*
    private void doSthToWait() {
        GROUP_HEAD.hover();
        sleep(500);
    }


    public void adjustSubscriptions() {
        doSthToWait();
        SUBSCRIPTIONS.click();
    }


    public void notifyOfPosts() {
        adjustSubscriptions();
        NOTIFY_OF_POSTS.click();
        NOTIFICATIONS_ARE_ALLOWED.shouldBe(visible);
    }
    public boolean checkIfAllowedNotifications() {
        //sleep(2000);
        return NOTIFICATIONS_ARE_ALLOWED.exists();
    }


    public void allowGroupMessages() {
        adjustSubscriptions();
        ALLOW_GROUP_MESSAGES.click();
        doSthToWait();
    }
    public boolean checkIfAllowedMessages() {
        return MESSAGES_ARE_ALLOWED.exists();
    }


    public void restrictGroupMessages() {
        adjustSubscriptions();
        ALLOW_GROUP_MESSAGES.click();
        doSthToWait();
    }
    public boolean checkIfRestrictedMessages() {
        return !NOTIFICATIONS_ARE_ALLOWED.exists();
    }

*/

}
