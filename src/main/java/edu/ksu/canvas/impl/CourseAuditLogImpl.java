package edu.ksu.canvas.impl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.reflect.TypeToken;

import edu.ksu.canvas.interfaces.CanvasWriter;
import edu.ksu.canvas.interfaces.CourseAuditLogReader;
import edu.ksu.canvas.model.CourseAuditLog;
import edu.ksu.canvas.net.RestClient;
import edu.ksu.canvas.oauth.OauthToken;

public class CourseAuditLogImpl extends BaseImpl<CourseAuditLog, CourseAuditLogReader, CanvasWriter> implements CourseAuditLogReader {
    private static final Logger LOG = LoggerFactory.getLogger(CourseAuditLogImpl.class);

    public CourseAuditLogImpl(String canvasBaseUrl, Integer apiVersion, OauthToken oauthToken, RestClient restClient,
            int connectTimeout, int readTimeout, Integer paginationPageSize, Boolean serializeNulls) {
                super(canvasBaseUrl, apiVersion, oauthToken, restClient, connectTimeout, readTimeout, paginationPageSize, serializeNulls);
    }

    @Override
    public List<CourseAuditLog> getCourseAuditLog(String courseId) throws IOException {
        LOG.debug(String.format("Listing course events for course %s", courseId));
        final String url = buildCanvasUrl(String.format("audit/course/courses/%s", courseId), Collections.emptyMap());
        return getObjectListFromCanvas(url);
    }

    @Override
    protected Type listType() {
        return new TypeToken<List<CourseAuditLog>>(){}.getType();
    }

    @Override
    protected Class<CourseAuditLog> objectType() {
        return CourseAuditLog.class;
    }

}
