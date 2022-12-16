package Tests;

import Pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVideo extends BaseTest {

    private final String URL = "https://ok.ru/";

    private final String LOGIN = "technoPol24";
    private final String PASSWORD = "technoPolis2022";

    private final String VIDEO_NAME = "Luciano Pavarotti - Caruso";
    private final String NAME_TO_INSERT = "Pavarotti Caruso";

    @Test
    public void testRepostVideo() {
        LoginPage loginPage = new LoginPage();
            loginPage.openSite(URL);
            loginPage.insertData(LOGIN, PASSWORD);

        new Toolbar().goToVideos();

        VideoPage videoPage = new VideoPage();
            videoPage.insertVideoName(NAME_TO_INSERT);
            videoPage.findVideo();
            String videoHref = videoPage.getVideoHref();
            videoPage.likeVideo();
            videoPage.repostVideoToTheWall();
            videoPage.closeVideoWindow();


        new OkMenu().goToProfile();

        PersonalPage personalPage = new PersonalPage();
        personalPage.goToNotes();
        String postVideoHref = personalPage.getPostVideoHref();

        assertEquals(videoHref, postVideoHref, "hrefs of found video and video in post must be the same");

    }

    //@AfterEach
    @Test
    public void deleteVideo() {
       LoginPage loginPage = new LoginPage();
            loginPage.openSite(URL);
            loginPage.insertData(LOGIN, PASSWORD);

        new OkMenu().goToProfile();

        PersonalPage personalPage = new PersonalPage();
            personalPage.goToNotes();
            personalPage.clickOnVideo();

        VideoPage videoPage = new VideoPage();
            videoPage.unlikeVideo();
            videoPage.closeVideoWindow();

            personalPage.deleteVideo();
    }
}
