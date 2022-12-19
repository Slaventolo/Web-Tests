package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class VideoPage {


    //private final SelenideElement LIKE_BUTTON = $x("//span[@data-like-icon='like']");
    private final SelenideElement LIKE_BUTTON = $x("//span[@data-type='GROUP_MOVIE']");
    private final SelenideElement SHARE_BUTTON = $x("//button[@data-type='RESHARE']");
    private final SelenideElement SHARE_NOW = $x("//*[text()='Поделиться сейчас']");
    private final SelenideElement CLOSE_VIDEO_WINDOW = $x("//div[@id='vpl_close']/div");
    private final SelenideElement VIDEO_IS_LIKED = $x("//*[@data-react-icon='like']");


    private final String VIDEO_HREF = "/video/349007972891";
    private final String VIDEO_NAME = "Luciano Pavarotti - Caruso";




    public void likeVideo() {
        LIKE_BUTTON.shouldBe(visible).click();
    }

    public void unlikeVideo() {
        LIKE_BUTTON.shouldBe(visible).click();
    }

    public void repostVideoToTheWall() {
        SHARE_BUTTON.shouldBe(visible).click();
        SHARE_NOW.shouldBe(visible).click();
        sleep(500);
    }

    public boolean checkIfLiked() {
        return VIDEO_IS_LIKED.exists();
    }

    public boolean checkIfUnliked() {
        return !VIDEO_IS_LIKED.exists();
    }

    public void closeVideoWindow() {
        CLOSE_VIDEO_WINDOW.shouldBe(visible).click();
    }
}
