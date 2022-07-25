package edu.ksu.canvas.tests.user;

import edu.ksu.canvas.CanvasTestBase;
import edu.ksu.canvas.impl.ProfileImpl;
import edu.ksu.canvas.interfaces.ProfileReader;
import edu.ksu.canvas.model.Profile;
import edu.ksu.canvas.net.FakeRestClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProfileRetrieverUTest extends CanvasTestBase {

    @Autowired
    private FakeRestClient fakeRestClient;
    private ProfileReader profileReader;

    @Before
    public void setupData() {
        profileReader = new ProfileImpl(baseUrl, apiVersion, SOME_OAUTH_TOKEN, fakeRestClient, SOME_CONNECT_TIMEOUT,
                SOME_READ_TIMEOUT, DEFAULT_PAGINATION_PAGE_SIZE, false);
    }

    @Test
    public void testShowUserProfile() throws Exception {
        int userId = 1111;
        String url = baseUrl + "/api/v1/users/" + String.valueOf(userId) + "/profile";
        fakeRestClient.addSuccessResponse(url, "SampleJson/profile/Profile.json");
        Optional<Profile> result = profileReader.getUserProfile(String.valueOf(userId));
        Profile profile = result.get();
        Assert.assertEquals(userId, profile.getId());
        Assert.assertEquals("Europe/Madrid", profile.getTimeZone());
        Assert.assertEquals("Fake bio", profile.getBio());
    }

}
