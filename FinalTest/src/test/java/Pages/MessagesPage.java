package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MessagesPage {

    private final SelenideElement MESSAGE_FIELD = $x("//div[@data-tsid='write_msg_input-input']");
    private final SelenideElement SEND_MESSAGE_BUTTON = $x("//msg-button[@data-tsid='button_send']");
    private final SelenideElement CLOSE_MESSAGES_WINDOW = $x("//div[@data-l='t,closeLayer']");

    private SelenideElement botMessage;        //= $x("//div[@data-tsid='conversation_name']"); // temporary


   public String findDialog(String userName) {
        sleep(5000);
        List<SelenideElement> searchResults = $$x("//div[@data-tsid='conversation_name']");
        for(SelenideElement element : searchResults) {
            if (element.text().equals(userName)) {
                botMessage = element;
                return element.getText();
            }
        }
        return null;
    }

    public void clickOnDialog() {
        assert botMessage != null;
        botMessage.click();
        botMessage = null;
    }

    public void writeMessage(String message) {
        MESSAGE_FIELD.shouldBe(visible).setValue(message);
        MESSAGE_FIELD.shouldHave(exactText(message));
        SEND_MESSAGE_BUTTON.click();
    }

    public String checkMyLastMessage() {
        sleep(5000);
        ElementsCollection messages = $$x("//msg-message[@mine='']//span[@data-tsid='message_text']");
        SelenideElement myLastMessage = messages.last();
        assert myLastMessage != null;
        return myLastMessage.getText();
    }

    public void closeMessageWindow() {
        CLOSE_MESSAGES_WINDOW.click();
    }


    //@AfterEach
    private final SelenideElement MY_MESSAGE_LINE = $x("//msg-message[@mine='' and @class='']");
    private final SelenideElement MESSAGE_MENU = $x("//msg-icon[@icon='menu']");
    private final SelenideElement DELETE_BUTTON = $x("//msg-l10n[@key='message-action-remove']");
    private final SelenideElement CONFIRM_DELETION = $x("//msg-button[@data-tsid='confirm-primary']");

    public void deleteMessage() {
        MY_MESSAGE_LINE.hover();
        MESSAGE_MENU.hover();
        DELETE_BUTTON.click();
        CONFIRM_DELETION.click();
    }
}
