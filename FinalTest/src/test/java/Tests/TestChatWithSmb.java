package Tests;
import Pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class TestChatWithSmb extends BaseTest {

    private final String URL = "https://ok.ru/";

    private final String LOGIN_1 = "technoPol24";
    private final String PASSWORD_1 = "technoPolis2022";

    private final String LOGIN_2 = "technoPol23";
    private final String PASSWORD_2 = "technoPolis2022";

    private final String MESSAGE = "Привет)";
    private final String REPLY_TO_MESSAGE = "Привет:)";

    @Test
    public void testChatWithSmb() {
        LoginPage bot1 = new LoginPage();
            bot1.openSite(URL);
            bot1.insertData(LOGIN_1, PASSWORD_1);

        Toolbar toolbarBot1 = new Toolbar();
            toolbarBot1.findPerson(LOGIN_2);

        new SmbPage().writeMessage();

        MessagesPage messagesPageBot1 = new MessagesPage();
            messagesPageBot1.writeMessage(MESSAGE);
            messagesPageBot1.closeMessageWindow();

        toolbarBot1.logOut();


        LoginPage bot2 = new LoginPage();
            bot2.insertData(LOGIN_2, PASSWORD_2);

        Toolbar toolbarBot2 = new Toolbar();
            toolbarBot2.goToMessages();

        MessagesPage messagesPageBot2 = new MessagesPage();
            messagesPageBot2.reply(REPLY_TO_MESSAGE);
            messagesPageBot2.closeMessageWindow();
    }

    @AfterEach
    public void cleanMessages() {

        Toolbar toolbarBot2 = new Toolbar();
            toolbarBot2.goToMessages();

        MessagesPage messagesPageBot2 = new MessagesPage();
            messagesPageBot2.chooseTheDialog("technoPol24 technoPol24");
            messagesPageBot2.deleteMessage();

        toolbarBot2.logOut();

        LoginPage bot1 = new LoginPage();
        bot1.insertData(LOGIN_1, PASSWORD_1);

        Toolbar toolbarBot1 = new Toolbar();
            toolbarBot1.goToMessages();

        MessagesPage messagesPageBot1 = new MessagesPage();
            messagesPageBot1.chooseTheDialog("technoPol23 technoPol23");
            messagesPageBot1.deleteMessage();
    }
}
