package edu.ksu.canvas.tests.courseauditlog;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;

import edu.ksu.canvas.CanvasTestBase;
import edu.ksu.canvas.impl.CourseAuditLogImpl;
import edu.ksu.canvas.interfaces.CourseAuditLogReader;
import edu.ksu.canvas.model.CourseAuditLog;
import edu.ksu.canvas.model.CourseEvent;
import edu.ksu.canvas.net.FakeRestClient;

public class CourseAuditLogGetUTest extends CanvasTestBase {

    @Autowired
    private FakeRestClient fakeRestClient;
    private CourseAuditLogReader courseAuditLogReader;

    @Before
    public void setupData() {
        courseAuditLogReader = new CourseAuditLogImpl(baseUrl,apiVersion,SOME_OAUTH_TOKEN, fakeRestClient, SOME_CONNECT_TIMEOUT, SOME_READ_TIMEOUT, DEFAULT_PAGINATION_PAGE_SIZE, false);
    }

    @Test
    public void testGettingCourses() throws IOException {
        String fakeCourseId = "1234";
        String url =  String.format("%s/api/v1/audit/course/courses/%s", baseUrl, fakeCourseId);
        fakeRestClient.addSuccessResponse(url, "SampleJson/courseAuditLog/GetCourseAuditLog.json");
        List<CourseAuditLog> courseAuditLogList = courseAuditLogReader.getCourseAuditLog(fakeCourseId);
        assertFalse(courseAuditLogList.isEmpty());
        CourseAuditLog courseAuditLog = courseAuditLogList.get(0);
        assertNotNull(courseAuditLog.getEvents());
        CourseEvent firstEvent = courseAuditLog.getEvents().get(0);
        assertEquals(firstEvent.getId(), new Integer(4985));
        ZonedDateTime zdt = ZonedDateTime.parse("2020-10-23T10:11:30Z");
        assertEquals(firstEvent.getCreatedAt(), zdt.toInstant());
        assertNotNull(firstEvent.getCourseEventData());
        assertNotNull(firstEvent.getCourseEventLinks());
        assertNotNull(firstEvent.getCourseEventLinks().getUser());
        assertEquals(firstEvent.getCourseEventLinks().getUser(), Integer.valueOf(72));
    }

}
