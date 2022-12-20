package Tests;

import Pages.*;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestVideo extends BaseTest {

    private final String URL = "https://ok.ru/";
    private final String LOGIN = "technoPol24";
    private final String PASSWORD = "technoPolis2022";

    private final String VIDEO_NAME = "Luciano Pavarotti - Caruso";
    private final String NAME_TO_INSERT = "Pavarotti Caruso";

    @Test
    public void testRepostVideo() {
        LoginPage loginPage = new LoginPage(URL);
            loginPage.login(LOGIN, PASSWORD);

        new Toolbar().goToVideos();

        VideoCardsPage videoCardsPage = new VideoCardsPage();
            videoCardsPage.insertVideoName(NAME_TO_INSERT);
            videoCardsPage.chooseNeededVideo(VIDEO_NAME);
            String videoHref = videoCardsPage.getVideoHref();
            videoCardsPage.clickOnNeededVideo();

        VideoPage videoPage = new VideoPage();
            videoPage.likeVideo();
            boolean isLiked = videoPage.checkIfLiked();
            assertTrue(isLiked);

            videoPage.repostVideoToTheWall();
            videoPage.closeVideoWindow();

        new OkMenu().goToProfile();

        PersonalPage personalPage = new PersonalPage();
            personalPage.goToNotes();

        NotesPage notesPage = new NotesPage();
            String postVideoHref = notesPage.getPostVideoHref();
            assertEquals(videoHref, postVideoHref, "hrefs of found video and video in post must be the same");
    }

    @AfterEach
    //@Test
    public void deleteVideo() {
/*       LoginPage loginPage = new LoginPage(URL);
            loginPage.login(LOGIN, PASSWORD);

        new OkMenu().goToProfile();

        PersonalPage personalPage = new PersonalPage();
            personalPage.goToNotes();*/

        NotesPage notesPage = new NotesPage();
            notesPage.clickOnVideo();

        VideoPage videoPage = new VideoPage();
            videoPage.unlikeVideo();
            boolean isUnliked = videoPage.checkIfUnliked();
            assertTrue(isUnliked);

            videoPage.closeVideoWindow();

            notesPage.deleteVideo(VIDEO_NAME);
    }
}
