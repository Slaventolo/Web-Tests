package Tests;

import Pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGroups extends BaseTest {

    private final String URL = "https://ok.ru/";
    private final String LOGIN = "technoPol24";
    private final String PASSWORD = "technoPolis2022";
    private final String nameToSet = "политех питер";
    private final String realGroupName = "Санкт-Петербургский политехнический университет";

    @Test
    public void testGroupSubscription() {

         LoginPage bot = new LoginPage(URL);
            bot.login(LOGIN, PASSWORD);

         new OkMenu().goToGroups();

         GroupsPage groupsPage = new GroupsPage();
            groupsPage.insertGroupName(nameToSet);
            groupsPage.goToGroup(realGroupName);

         AnyGroupPage anyGroupPage = new AnyGroupPage();
            String groupName = anyGroupPage.getGroupName();
            assertEquals(realGroupName, groupName, "Names of group must be the same");

            anyGroupPage.subscribe();
            boolean isSubscribed = anyGroupPage.checkIfSubscribed();
            assertTrue(isSubscribed);

            /*anyGroupPage.notifyOfPosts();
            boolean allowedNotifications = anyGroupPage.checkIfAllowedNotifications();
            assertTrue(allowedNotifications);

            anyGroupPage.allowGroupMessages();
            boolean allowedMessages = anyGroupPage.checkIfAllowedMessages();
            assertTrue(allowedMessages);*/
    }

    @AfterEach
    public void unsubscribe() {
        AnyGroupPage anyGroupPage = new AnyGroupPage();
            /*anyGroupPage.restrictGroupMessages();
            boolean restrictedMessages = anyGroupPage.checkIfRestrictedMessages();
            assertTrue(restrictedMessages);*/

            anyGroupPage.unsubscribe();
            boolean isUnsubscribed = anyGroupPage.checkIfUnsubscribed();
            assertTrue(isUnsubscribed);
    }
}
