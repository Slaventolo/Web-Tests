package Tests;
import Pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        LoginPage bot1 = new LoginPage(URL);
            bot1.login(LOGIN_1, PASSWORD_1);

        Toolbar toolbarBot1 = new Toolbar();
            toolbarBot1.findPerson(LOGIN_2);

        SmbPage smbPage = new SmbPage();
            String userName2 = smbPage.getUserName();
            assertEquals(userName2, LOGIN_2 + " " + LOGIN_2);
            smbPage.writeMessage();

        MessagesPage messagesPageBot1 = new MessagesPage();
            messagesPageBot1.writeMessage(MESSAGE);
            String message = messagesPageBot1.checkMyLastMessage();
            assertEquals(message, MESSAGE);
            messagesPageBot1.closeMessageWindow();

        toolbarBot1.logOut();


        LoginPage bot2 = new LoginPage(URL);
            bot2.login(LOGIN_2, PASSWORD_2);

        Toolbar toolbarBot2 = new Toolbar();
            toolbarBot2.goToMessages();

        MessagesPage messagesPageBot2 = new MessagesPage();
            String userName1 = messagesPageBot2.findDialog(LOGIN_1 + " " + LOGIN_1);
            assertEquals(userName1, LOGIN_1 + " " + LOGIN_1);

            messagesPageBot2.clickOnDialog();
            messagesPageBot2.writeMessage(REPLY_TO_MESSAGE);
            String reply = messagesPageBot2.checkMyLastMessage();
            assertEquals(reply, REPLY_TO_MESSAGE);

            messagesPageBot2.closeMessageWindow();
    }

    @AfterEach
    //@Test
    public void cleanMessages() {

        Toolbar toolbarBot2 = new Toolbar();
            toolbarBot2.goToMessages();

        MessagesPage messagesPageBot2 = new MessagesPage();
            String bot1Name = messagesPageBot2.findDialog(LOGIN_1 + " " + LOGIN_1);
            assertEquals(bot1Name, LOGIN_1 + " " + LOGIN_1);

            messagesPageBot2.clickOnDialog();
            messagesPageBot2.deleteMessage();

        toolbarBot2.logOut();

        LoginPage bot1 = new LoginPage(URL);
            bot1.login(LOGIN_1, PASSWORD_1);

        Toolbar toolbarBot1 = new Toolbar();
            toolbarBot1.goToMessages();

        MessagesPage messagesPageBot1 = new MessagesPage();
            String bot2Name = messagesPageBot1.findDialog(LOGIN_2 + " " + LOGIN_2);
            assertEquals(bot2Name, LOGIN_2 + " " + LOGIN_2);

            messagesPageBot1.clickOnDialog();
            messagesPageBot1.deleteMessage();
    }
}
