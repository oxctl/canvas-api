package edu.ksu.canvas.impl;

import com.google.gson.reflect.TypeToken;
import edu.ksu.canvas.interfaces.CanvasWriter;
import edu.ksu.canvas.interfaces.ProfileReader;
import edu.ksu.canvas.model.Profile;
import edu.ksu.canvas.net.Response;
import edu.ksu.canvas.net.RestClient;
import edu.ksu.canvas.oauth.OauthToken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProfileImpl extends BaseImpl<Profile, ProfileReader, CanvasWriter> implements ProfileReader {
    private static final Logger LOG = LoggerFactory.getLogger(ProfileImpl.class);

    public ProfileImpl(String canvasBaseUrl, Integer apiVersion, OauthToken oauthToken, RestClient restClient,
                    int connectTimeout, int readTimeout, Integer paginationPageSize, Boolean serializeNulls) {
        super(canvasBaseUrl, apiVersion, oauthToken, restClient, connectTimeout, readTimeout,
                paginationPageSize, serializeNulls);
    }

    @Override
    public Optional<Profile> getUserProfile(String userIdentifier) throws IOException {
        LOG.debug("Retrieving user profile");
        String url = buildCanvasUrl("users/" + userIdentifier + "/profile", Collections.emptyMap());
        Response response = canvasMessenger.getSingleResponseFromCanvas(oauthToken, url);
        return responseParser.parseToObject(Profile.class, response);
    }

    @Override
    protected Type listType() {
        return new TypeToken<List<Profile>>() {
        }.getType();
    }

    @Override
    protected Class<Profile> objectType() {
        return Profile.class;
    }
}
