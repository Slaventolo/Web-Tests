package Pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class VideoCardsPage {

    private final SelenideElement SEARCH = $x("//input[@placeholder='Поиск видео']");
    private final SelenideElement SEARCH_BUTTON = $x("//div[@class='button-pro js-search-submit']");

    //private final SelenideElement neededVideo = $x("//div[@data-id='349007972891']/div/a"); // temporary

    private SelenideElement neededVideo;

    public VideoCardsPage() {
        check();
    }

    private void check() {
        SEARCH.shouldBe(visible);
    }

    public void insertVideoName(String videoName) {
        int len = videoName.length();
        for(int i = 0; i < len; i++) {
            SEARCH.shouldBe(visible).append(String.valueOf(videoName.charAt(i)));
            sleep(100);
        }
        SEARCH_BUTTON.click();
    }


    public void chooseNeededVideo(String videoName) {
        sleep(5000);
        List<SelenideElement> videoNames = $$x("//a[@class='video-card_n ellip']");  //    //div[contains(@class, 'item-movie')]     //a[@class='video-card_n ellip']
        for (SelenideElement video : videoNames) {
            if (video.has(exactText(videoName)))
                neededVideo = video;
        }
    }

    public String getVideoHref () {
        assert neededVideo != null;
        return neededVideo.getAttribute("href");
    }

    public void clickOnNeededVideo() {
        assert neededVideo != null;
        neededVideo.click();
    }


}
