package Pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class VideoCardsPage {

    private final SelenideElement SEARCH = $x("//input[@placeholder='Поиск видео']");
    private final SelenideElement SEARCH_BUTTON = $x("//div[@class='button-pro js-search-submit']");

    //private final SelenideElement neededVideo = $x("//div[@data-id='349007972891']"); // temporary
    private final SelenideElement neededVideo = $x("//div[@data-id='349007972891']/div/a"); // temporary
    //private SelenideElement neededVideo; // temporary

    public VideoCardsPage() {
        check();
    }

    private void check() {
        SEARCH.shouldBe(visible);
        SEARCH_BUTTON.shouldBe(visible);
    }

    public void insertVideoName(String videoName) {
        int len = videoName.length();
        for(int i = 0; i < len; i++) {
            SEARCH.shouldBe(visible).append(String.valueOf(videoName.charAt(i)));
            sleep(100);
        }
        SEARCH_BUTTON.click();
    }

    public void clickOnNeededVideo(String videoName) {
        /*SelenideElement neededVideo = chooseNeededVideo(videoName);
        assert neededVideo != null;*/
        neededVideo.click();
    }

    private SelenideElement chooseNeededVideo(String videoName) {
        //sleep(8000);
        //List<SelenideElement> videos = $$x("//div[contains(@class, 'item-movie')]");
        List<SelenideElement> videos = $$x("//a[@class='video-card_n ellip']");
        for (SelenideElement video : videos) {
            if (video.has(exactText(videoName)))
                return video;
        }
        return null;
    }

    public String getVideoHref () {
        return neededVideo.should(exist).getAttribute("href");
    }
}
