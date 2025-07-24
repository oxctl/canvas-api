package edu.ksu.canvas.impl;

import com.google.gson.reflect.TypeToken;
import edu.ksu.canvas.interfaces.LtiResourceLinkReader;
import edu.ksu.canvas.interfaces.LtiResourceLinkWriter;
import edu.ksu.canvas.model.LtiResourceLink;
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

public class LtiResourceLinkImpl extends BaseImpl<LtiResourceLink, LtiResourceLinkReader, LtiResourceLinkWriter> implements LtiResourceLinkReader, LtiResourceLinkWriter {
    private static final Logger LOG = LoggerFactory.getLogger(LtiResourceLinkImpl.class);

    public LtiResourceLinkImpl(String canvasBaseUrl, Integer apiVersion, OauthToken oauthToken, RestClient restClient,
                               int connectTimeout, int readTimeout, Integer paginationPageSize, Boolean serializeNulls) {
        super(canvasBaseUrl, apiVersion, oauthToken, restClient, connectTimeout, readTimeout,
                paginationPageSize, serializeNulls);
    }

    @Override
    protected Type listType() {
        return new TypeToken<List<LtiResourceLink>>(){}.getType();
    }

    @Override
    protected Class<LtiResourceLink> objectType() {
        return LtiResourceLink.class;
    }

    @Override
    public Optional<LtiResourceLink> getLtiResourceLink(String courseId, String resourceLinkId) throws IOException {
        LOG.debug("Fetching LtiResourceLink for resourceLinkId {} in courseId {}", resourceLinkId, courseId);
        String url = buildCanvasUrl("courses/" + courseId + "/lti_resource_links/" + resourceLinkId, Collections.emptyMap());
        return fetchLtiResourceLink(url);
    }

    @Override
    public Optional<LtiResourceLink> getLtiResourceLinkByUuid(String courseId, String resourceLinkUuid) throws IOException {
        LOG.debug("Fetching LtiResourceLink for resourceLinkUuid {} in courseId {}", resourceLinkUuid, courseId);
        String url = buildCanvasUrl("courses/" + courseId + "/lti_resource_links/resource_link_uuid:" + resourceLinkUuid, Collections.emptyMap());
        return fetchLtiResourceLink(url);
    }

    private Optional<LtiResourceLink> fetchLtiResourceLink(String url) throws IOException {
        Response response = canvasMessenger.getSingleResponseFromCanvas(oauthToken, url);
        if (response.getErrorHappened() || response.getResponseCode() != 200) {
            return Optional.empty();
        }
        return responseParser.parseToObject(LtiResourceLink.class, response);
    }
}
