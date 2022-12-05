package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GroupsPage {

    private final SelenideElement input = $x("//input[@placeholder='Поиск по группам']");
    private final String subscribeButton = "//a[@class='button-pro group-join_btn __small']";// любая кнопка вступить
    //private final String groupName = "//div[@class='ucard-v_h ellip']/a";// любое название группы
    private final String GALOCHKA = ".//*[@href='/polytechpetra']/span/*";

    private final SelenideElement PolytechGroup = $x("//*[text()='Санкт-Петербургский политехнический университет']");

     private SelenideElement findGroup(String groupName) {
        return PolytechGroup;
     }

    public void insertGroupName(String groupName) {
        input.shouldBe(visible).setValue(groupName);
        input.shouldHave(attribute("value", groupName));
        input.shouldBe(visible).sendKeys(Keys.ENTER);
    }


    /*private SelenideElement findGroup(String groupName) {
        List<SelenideElement> searchResults = $$x("//a[@class='bold n-t']");
        for(SelenideElement element : searchResults) {
            if (element.innerText().equals(groupName)) // тут выбираем подэлемент. Будет ли так работать?
                return element;
        }
        return null;
    }
    */

    public void goToGroup(String groupName) {
        SelenideElement neededGroup = findGroup(groupName);
        neededGroup.should(exist).click();
    }
}
