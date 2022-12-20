package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class PersonalPage {

    // для репоста видео
    private final SelenideElement NOTES = $x("//a[@data-l='t,userStatuses']");

    public void goToNotes() {
        NOTES.click();
    }



}
