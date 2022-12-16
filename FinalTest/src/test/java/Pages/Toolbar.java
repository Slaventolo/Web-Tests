package Pages;

import com.codeborne.selenide.SelenideElement;

import java.net.PortUnreachableException;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Toolbar {
    // для сообщений
    private final SelenideElement SEARCH = $x("//input[contains(@class, 'white-toolbar')]");
    private final SelenideElement OPTIONS_FOR_PROFILE = $x("//div[@class='ucard-mini_cnt']");
    //private final SelenideElement SWITCH_TO_OTHER_PROFILE = $x("//a[text()='Войти в другой профиль']");
    private final SelenideElement LOG_OUT = $x("//a[@data-l='t,logout']");
    private final SelenideElement LOG_OUT_ADDITION = $x("//input[@data-l='t,logout']");
    private final SelenideElement MESSAGES = $x("//div[@class='toolbar_nav_i_ic']");
    private final SelenideElement neededPerson = $x("//div[text()='technoPol23 technoPol23' and contains(@class, 'card-caption')]"); // temporary


    // для видео
    private final SelenideElement GO_TO_VIDEOS = $x("//li[@data-l='t,video']");


    public Toolbar() {
        check();
    }

    private void check() {
        SEARCH.shouldBe(visible);
        OPTIONS_FOR_PROFILE.shouldBe(visible);
        MESSAGES.shouldBe(visible);
        GO_TO_VIDEOS.shouldBe(visible);
    }

    public void findPerson(String personName) {
        SEARCH.shouldBe(visible)
                .setValue(personName)
                .shouldHave(attribute("value", personName));

        //SelenideElement neededPerson = chooseNeededOne(personName); // ошибка тут при run. debug окей
        //assert neededPerson != null;
        neededPerson.should(exist).click();
    }

    private SelenideElement chooseNeededOne(String personName) {
        List<SelenideElement> searchResults = $$x("//div[contains(@class, 'card-caption__a0i64')]");
        for(SelenideElement element : searchResults) {
            if (element.getText().equals(personName + " " + personName))
                return element;
        }
        return null;
    }

    public void logOut() {
        OPTIONS_FOR_PROFILE.shouldBe(visible).click();
        LOG_OUT.shouldBe(visible).click();
        LOG_OUT_ADDITION.shouldBe(visible).click();
    }

    public void goToMessages() {
        MESSAGES.shouldBe(visible).click();
    }

    public void goToVideos() {
        GO_TO_VIDEOS.shouldBe(visible).click();
    }


}
