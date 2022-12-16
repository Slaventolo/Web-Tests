package Tests;

import Pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGroups extends BaseTest {

    private final String URL = "https://ok.ru/";
    private final String LOGIN = "technoPol24";
    private final String PASSWORD = "technoPolis2022";

    private final String nameToSet = "политех питер";
    private final String realGroupName = "Санкт-Петербургский политехнический университет";

    @Test
    public void testGroupSubscription() {

         LoginPage bot = new LoginPage();
            bot.openSite(URL);
            bot.insertData(LOGIN, PASSWORD);

         new OkMenu().goToGroups();

         GroupsPage groupsPage = new GroupsPage();
            groupsPage.insertGroupName(nameToSet);
            groupsPage.goToGroup(realGroupName);

         PolytechPage polytechPage = new PolytechPage();
            String groupName = polytechPage.getGroupName();
            assertEquals(realGroupName, groupName, "Names of group must be the same");

            polytechPage.subscribe();
            polytechPage.notifyOfPosts();
            polytechPage.allowGroupMessages();
    }

    @AfterEach
    public void unsubscribe() {
        PolytechPage polytechPage = new PolytechPage();
            polytechPage.unsubscribe();
    }
}
