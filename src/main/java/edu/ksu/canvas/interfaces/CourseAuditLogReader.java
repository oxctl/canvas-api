package edu.ksu.canvas.interfaces;

import edu.ksu.canvas.model.CourseAuditLog;

import java.io.IOException;
import java.util.List;

public interface CourseAuditLogReader extends CanvasReader<CourseAuditLog, CourseAuditLogReader> {

    /**
     * Returns the audit log of a course from Canvas
     * <p>
     * See <a href="https://canvas.instructure.com/doc/api/course_audit_log.html#method.course_audit_api.for_course">The course audit log for a given course.</a>
     * in the Canvas docs for details.
     * @param courseId The Canvas ID of the course or sis_course_id:SISID
     * @return The course audit log objects as list for a given course.
     * @throws IOException When there is an error communicating with Canvas
     */
     List<CourseAuditLog> getCourseAuditLog(String courseId) throws IOException;

}
