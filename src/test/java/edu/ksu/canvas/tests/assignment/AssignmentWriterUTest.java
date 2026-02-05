package edu.ksu.canvas.tests.assignment;

import edu.ksu.canvas.CanvasTestBase;
import edu.ksu.canvas.impl.AssignmentImpl;
import edu.ksu.canvas.interfaces.AssignmentWriter;
import edu.ksu.canvas.model.assignment.Assignment;
import edu.ksu.canvas.net.FakeRestClient;
import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Optional;

public class AssignmentWriterUTest extends CanvasTestBase {

    @Autowired
    private FakeRestClient fakeRestClient;
    private AssignmentWriter assignmentWriter;

    @Before
    public void setupData() {
        assignmentWriter = new AssignmentImpl(baseUrl, apiVersion, SOME_OAUTH_TOKEN, fakeRestClient, SOME_CONNECT_TIMEOUT, SOME_READ_TIMEOUT, DEFAULT_PAGINATION_PAGE_SIZE, false);
    }

    @Test
    public void testDeleteAssignmentWithIntegerId() throws IOException {
        String someCourseId = "1234";
        Integer someAssignmentId = 123;
        String url = baseUrl + "/api/v1/courses/" + someCourseId + "/assignments/" + someAssignmentId;
        fakeRestClient.addSuccessResponse(url, "SampleJson/assignment/DeletedAssignment.json");
        Optional<Assignment> deletedAssignmentOpt = assignmentWriter.deleteAssignment(someCourseId, someAssignmentId);
        Assignment deletedAssignment = deletedAssignmentOpt.orElseThrow(AssertionFailedError::new);
        Assert.assertEquals("Assignment1", deletedAssignment.getName());
        Assert.assertEquals(Integer.valueOf(1), deletedAssignment.getId());
    }

    @Test
    public void testDeleteAssignmentWithStringId() throws IOException {
        String someCourseId = "1234";
        String someAssignmentId = "lti_context_id:ab84f579-4442-4d4a-acd8-85c5ec6fd2b6";
        String url = baseUrl + "/api/v1/courses/" + someCourseId + "/assignments/" + someAssignmentId;
        fakeRestClient.addSuccessResponse(url, "SampleJson/assignment/DeletedAssignment.json");
        Optional<Assignment> deletedAssignmentOpt = assignmentWriter.deleteAssignment(someCourseId, someAssignmentId);
        Assignment deletedAssignment = deletedAssignmentOpt.orElseThrow(AssertionFailedError::new);
        Assert.assertEquals("Assignment1", deletedAssignment.getName());
        Assert.assertEquals(Integer.valueOf(1), deletedAssignment.getId());
    }

    @Test
    public void testDeleteAssignmentWithNumericStringId() throws IOException {
        String someCourseId = "1234";
        String someAssignmentId = "456";
        String url = baseUrl + "/api/v1/courses/" + someCourseId + "/assignments/" + someAssignmentId;
        fakeRestClient.addSuccessResponse(url, "SampleJson/assignment/DeletedAssignment.json");
        Optional<Assignment> deletedAssignmentOpt = assignmentWriter.deleteAssignment(someCourseId, someAssignmentId);
        Assignment deletedAssignment = deletedAssignmentOpt.orElseThrow(AssertionFailedError::new);
        Assert.assertEquals("Assignment1", deletedAssignment.getName());
        Assert.assertEquals(Integer.valueOf(1), deletedAssignment.getId());
    }
}
