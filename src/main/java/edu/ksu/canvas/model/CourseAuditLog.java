package edu.ksu.canvas.model;

import java.io.Serializable;
import java.util.List;

/**
 * Class to represent Canvas course audit log objects
 * See <a href="https://canvas.instructure.com/doc/api/course_audit_log.html">Canvas course audit log</a> documentation.
 */

public class CourseAuditLog extends BaseCanvasModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<CourseEvent> events;

    public List<CourseEvent> getEvents() {
        return events;
    }

    public void setEvents(List<CourseEvent> events) {
        this.events = events;
    }

}
