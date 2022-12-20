package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class OkMenu {

    // для групп
    private final SelenideElement GROUPS = $x("//a[@aria-label='Группы']");

    // для видео
    private final SelenideElement GO_TO_PROFILE = $x("//a[@data-l='t,userPage']");


    public OkMenu() {
        check();
    }

    private void check() {
        GROUPS.shouldBe(visible);
        GO_TO_PROFILE.shouldBe(visible);
    }

    public void goToGroups() {
        GROUPS.click();
    }

    public void goToProfile() {
        GO_TO_PROFILE.scrollIntoView("{block: \"end\"}");
        GO_TO_PROFILE.click();
    }
}
