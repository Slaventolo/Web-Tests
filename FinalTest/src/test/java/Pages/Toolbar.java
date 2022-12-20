package Pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Toolbar {
    // для сообщений
    private final SelenideElement SEARCH = $x("//input[contains(@class, 'white-toolbar')]");
    private final SelenideElement OPTIONS_FOR_PROFILE = $x("//div[@class='ucard-mini_cnt']");
    private final SelenideElement LOG_OUT = $x("//a[@data-l='t,logout']");
    private final SelenideElement LOG_OUT_ADDITION = $x("//input[@data-l='t,logout']");
    private final SelenideElement MESSAGES = $x("//div[@class='toolbar_nav_i_ic']");


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

        SelenideElement neededPerson = chooseNeededOne(personName);
        assert neededPerson != null;
        neededPerson.click();
    }

    private SelenideElement chooseNeededOne(String personName) {
        sleep(5000);
        List<SelenideElement> searchResults = $$x("//div[contains(@class, 'card-caption__a0i64')]");
        for(SelenideElement element : searchResults) {
            if (element.getText().equals(personName + " " + personName))
                return element;
        }
        return null;
    }


    public void logOut() {
        OPTIONS_FOR_PROFILE.click();
        LOG_OUT.click();
        LOG_OUT_ADDITION.click();
    }

    public void goToMessages() {
        MESSAGES.click();
    }

    public void goToVideos() {
        GO_TO_VIDEOS.click();
    }


}
