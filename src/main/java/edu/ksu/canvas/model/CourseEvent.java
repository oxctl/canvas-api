package edu.ksu.canvas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.Instant;

/**
 * Class to represent Canvas course events.
 * See <a href="https://canvas.instructure.com/doc/api/course_audit_log.html#CourseEvent">Canvas course events</a> documentation.
 */

public class CourseEvent extends BaseCanvasModel implements Serializable {

    private static final long serialVersionUID = 1L;

    // ID of the event.
    private Integer id;

    // timestamp of the event
    private Instant createdAt;

    // Course event type The event type defines the type and schema of the
    // event_data object.
    private String eventType;

    // Course event data depending on the event type.  This will return an object
    // containing the relevant event data.  An updated event type will return an
    // UpdatedEventData object.
    @SerializedName("event_data")
    private CourseEventData courseEventData;

    // Course event source depending on the event type.  This will return a string
    // containing the source of the event.
    private String eventSource;

    // Jsonapi.org links
    @SerializedName("links")
    private CourseEventLinks courseEventLinks;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setCourseEventData(CourseEventData courseEventData) {
        this.courseEventData = courseEventData;
    }

    public CourseEventData getCourseEventData() {
        return this.courseEventData;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getEventSource() {
        return this.eventSource;
    }

    public void setCourseEventLinks(CourseEventLinks courseEventLinks) {
        this.courseEventLinks = courseEventLinks;
    }

    public CourseEventLinks getCourseEventLinks() {
        return this.courseEventLinks;
    }

}
