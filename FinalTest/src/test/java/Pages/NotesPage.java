package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class NotesPage {
    // для репоста видео
    private final SelenideElement NOTE_VIDEO_NAME = $x("//a[@class='video-card_n ellip']");
    private final SelenideElement POST_MENU = $x("//div[@class='feed_menu_ic']/span");
    private final SelenideElement DELETE_NOTE = $x("//div[@id='hook_Block_ShortcutMenu']//*[contains(@hrefattrs, 'deleteButton')]");
    private final SelenideElement SONG_NAME = $x("//a[@class='video-card_n ellip']");


    public String getPostVideoHref() {
        return SONG_NAME.getAttribute("href");
    }

    public void clickOnVideo() {
        NOTE_VIDEO_NAME.should(exist).click();
    }

    public void deleteVideo(String videoName) {
        POST_MENU.hover();
        DELETE_NOTE.click();
    }

}
