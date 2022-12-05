package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class MessagesPage {

    //private final SelenideElement WRITE_MESSAGE = $x("//a[contains(@hrefattrs, 'ButtonsSendMessage')]"); // не работает
    private final SelenideElement MESSAGE_FIELD = $x("//msg-input[@placeholder='Напишите сообщение...']");
    private final SelenideElement SEND_MESSAGE_BUTTON = $x("//msg-button[@data-tsid='button_send']");

    private final SelenideElement CLOSE_MESSAGES_WINDOW = $x("//div[@data-l='t,closeLayer']");
    private final SelenideElement bot1Message = $x("//msg-chats-list-item[@data-l='t,chatsListItem']/a"); // temporary

    public MessagesPage() {
        check();
    }

    private void check() {

    }

    public void chooseTheDialog(String DialogName) {
        //SelenideElement bot1Message = chooseNeededDialog();
        bot1Message.should(exist).click();

    }

/*    private SelenideElement chooseNeededDialog() {
        List<SelenideElement> searchResults = $$x("//div[@data-tsid='conversation_name']");
        for(SelenideElement element : searchResults) {
            if (element.text().equals(DialogName)) // тут выбираем подэлемент. Будет ли так работать?
                return element;
        }
        return null;
    }
*/

    public void writeMessage(String message) {
        MESSAGE_FIELD.shouldBe(visible).setValue(message);  // а оно будет ждать, когда прогрузится страница?
        MESSAGE_FIELD.shouldHave(exactText(message));
        SEND_MESSAGE_BUTTON.shouldBe(visible).click();
    }

    public void closeMessageWindow() {
        CLOSE_MESSAGES_WINDOW.should(exist).click();
    }

    public void reply(String message) {
        bot1Message.should(exist).click();
        writeMessage(message);
    }

    //@AfterEach

    private final SelenideElement MY_MESSAGE_LINE = $x("//msg-message[@mine='' and @class='']");
    private final SelenideElement MESSAGE_MENU = $x("//msg-icon[@icon='menu']");
    private final SelenideElement DELETE_BUTTON = $x("//msg-l10n[@key='message-action-remove']");
    //private final SelenideElement CONFIRM_DELETION = $x("//*[text()='Удалить']");
    //private final SelenideElement CONFIRM_DELETION = $x("//msg-tico[@icon='delete']");
    private final SelenideElement CONFIRM_DELETION = $x("//msg-button[@data-tsid='confirm-primary']");
    public void deleteMessage() {
        MY_MESSAGE_LINE.hover();
        MESSAGE_MENU.should(exist).hover();
        DELETE_BUTTON.should(exist).click();
        CONFIRM_DELETION.should(exist).click();
    }
}
