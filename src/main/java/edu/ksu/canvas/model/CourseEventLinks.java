package edu.ksu.canvas.model;

import java.io.Serializable;

/**
 * Class to represent Canvas course event link.
 * See <a href="https://canvas.instructure.com/doc/api/course_audit_log.html#CourseEventLink">Canvas course event link</a> documentation.
 */

public class CourseEventLinks extends BaseCanvasModel implements Serializable {

    public static final long serialVersionUID = 1L;

    // ID of the course for the event.
    private Integer course;

    // ID of the user for the event (who made the change).
    private Integer user;

    // ID of the page view during the event if it exists.
    private String pageView;

    // ID of the course that this course was copied from. This is only included if
    // the event_type is copied_from.
    private Integer copiedFrom;

    // ID of the course that this course was copied to. This is only included if the
    // event_type is copied_to.
    private Integer copiedTo;

    // ID of the SIS batch that triggered the event.
    private Integer sisBatch;

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getCourse() {
        return this.course;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getUser() {
        return this.user;
    }

    public String getPageView() {
        return this.pageView;
    }

    public void setPageView(String pageView) {
        this.pageView = pageView;
    }

    public void setCopiedFrom(Integer copiedFrom) {
        this.copiedFrom = copiedFrom;
    }

    public Integer getCopiedFrom() {
        return this.copiedFrom;
    }

    public void setCopiedTo(Integer copiedTo) {
        this.copiedTo = copiedTo;
    }

    public Integer getCopiedTo() {
        return this.copiedTo;
    }

    public void setSisBatch(Integer sisBatch) {
        this.sisBatch = sisBatch;
    }

    public Integer getSisBatch() {
        return this.sisBatch;
    }

}
