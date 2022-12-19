package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GroupsPage {

    private final SelenideElement INPUT = $x("//input[@placeholder='Поиск по группам']");

    //private final SelenideElement PolytechGroup = $x("//*[text()='Санкт-Петербургский политехнический университет']");

    //private final SelenideElement RECOMMENDED = $x("//div[text()='Рекомендуем']");
    //private final SelenideElement RECOMMENDED = $x("//a[@class='group-detailed-card_name']");


    public GroupsPage() {
        check();
    }
    private void check() {
        INPUT.shouldBe(visible);
    }

/*
     private SelenideElement findGroup(String groupName) {
        return PolytechGroup;
     }
*/


    public GroupsPage insertGroupName(String groupName) {
        int len = groupName.length();
        for(int i = 0; i < len; i++) {
            INPUT.shouldBe(visible).append(String.valueOf(groupName.charAt(i)));
            sleep(100);
        }
        INPUT.shouldBe(visible).sendKeys(Keys.ENTER);
        return this;
    }

    private SelenideElement findGroup(String groupName) {
        //sleep(5000);
        //RECOMMENDED.shouldBe(visible);
        List<SelenideElement> searchResults = $$x("//a[@class='bold n-t']");
        for(SelenideElement element : searchResults) {
            if (element.should(exist).getText().equals(groupName))
                return element;
        }
        return null;
    }


    public void goToGroup(String groupName) {
        SelenideElement neededGroup = findGroup(groupName);
        assert neededGroup != null;
        //neededGroup.scrollIntoView("{behavior: \"smooth\", block: \"center\", inline: \"nearest\"}");
        neededGroup.scrollIntoView("{block: \"center\"}");
        neededGroup.click();
    }
}
