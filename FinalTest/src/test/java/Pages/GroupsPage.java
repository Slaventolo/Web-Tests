package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GroupsPage {

    private final SelenideElement INPUT = $x("//input[@placeholder='Поиск по группам']");


    private final SelenideElement PolytechGroup = $x("//*[text()='Санкт-Петербургский политехнический университет']");

    public GroupsPage() {
        check();
    }
    private void check() {
        INPUT.shouldBe(visible);
    }

     private SelenideElement findGroup(String groupName) {
        return PolytechGroup;
     }


    public void insertGroupName(String groupName) {
        INPUT.shouldBe(visible).setValue(groupName);
        INPUT.shouldHave(attribute("value", groupName));
        INPUT.shouldBe(visible).sendKeys(Keys.ENTER);
    }


/*    private SelenideElement findGroup(String groupName) {
        List<SelenideElement> searchResults = $$x("//a[@class='bold n-t']");
        for(SelenideElement element : searchResults) {
            if (element.should(exist).getText().equals(groupName))
                return element;
        }
        return null;
    }
*/

    public void goToGroup(String groupName) {
        SelenideElement neededGroup = findGroup(groupName);
        assert neededGroup != null;
        //neededGroup.scrollTo();
        neededGroup.shouldBe(visible).click();
    }
}
