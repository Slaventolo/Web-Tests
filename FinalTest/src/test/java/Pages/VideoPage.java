package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class VideoPage {

    private final SelenideElement SEARCH = $x("//input[@placeholder='Поиск видео']");
    private final SelenideElement SEARCH_BUTTON = $x("//div[@class='button-pro js-search-submit']");
    //private final SelenideElement LIKE_BUTTON = $x("//span[@data-like-icon='like']");
    private final SelenideElement LIKE_BUTTON = $x("//span[@data-type='GROUP_MOVIE']");
    private final SelenideElement SHARE_BUTTON = $x("//button[@data-type='RESHARE']");
    private final SelenideElement SHARE_NOW = $x("//*[text()='Поделиться сейчас']");
    private final SelenideElement CLOSE_VIDEO_WINDOW = $x("//div[@class='media-layer_close']/div");
    private final SelenideElement neededVideo = $x("//div[@data-id='349007972891']"); // temporary

    private final String VIDEO_HREF = "/video/349007972891";
    private final String VIDEO_NAME = "Luciano Pavarotti - Caruso";


    public VideoPage() {
        //check();
    }

    private void check() {
        SEARCH.shouldBe(visible);
        //SEARCH_BUTTON.shouldBe(visible);
    }

    public void insertVideoName(String videoName) {
        SEARCH
                .shouldBe(visible).setValue(videoName);
                //.shouldHave(exactText(videoName))
                //.sendKeys(Keys.ENTER);
                SEARCH_BUTTON.shouldBe(visible).click();
    }

    public void findVideo() {
        //SelenideElement neededVideo = chooseNeededVideo();
        neededVideo.shouldBe(visible).click();
    }

    private SelenideElement chooseNeededVideo() {
        List<SelenideElement> videos = $$x("//div[contains(@class, 'item-movie')]");
        for (SelenideElement video : videos) {
            if (video.has(exactText(VIDEO_NAME)) && (Objects.equals(video.getAttribute("href"), VIDEO_HREF)))
                return video;
        }
        return null;
    }

    public String getVideoHref () {
        return neededVideo.should(exist).getAttribute("href");
    }

    public void likeVideo() {
        LIKE_BUTTON.shouldBe(visible).click();
    }

    public void unlikeVideo() {
        LIKE_BUTTON.shouldBe(visible).click();
    }

    public void repostVideoToTheWall() {
        SHARE_BUTTON.shouldBe(visible).click();
        SHARE_NOW.shouldBe(visible).click();
    }

    public void closeVideoWindow() {
        CLOSE_VIDEO_WINDOW.shouldBe(visible).click();
    }
}
