package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GroupsPage {

    private final SelenideElement INPUT = $x("//input[@placeholder='Поиск по группам']");


    public GroupsPage() {
        check();
    }
    private void check() {
        INPUT.shouldBe(visible);
    }


    public GroupsPage insertGroupName(String groupName) {
        int len = groupName.length();
        for(int i = 0; i < len; i++) {
            INPUT.shouldBe(visible).append(String.valueOf(groupName.charAt(i)));
            sleep(50);
        }
        INPUT.shouldBe(visible).sendKeys(Keys.ENTER);
        return this;
    }

    private SelenideElement findGroup(String groupName) {
        sleep(5000);
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
        neededGroup.scrollIntoView("{block: \"center\"}");
        neededGroup.click();
    }
}
