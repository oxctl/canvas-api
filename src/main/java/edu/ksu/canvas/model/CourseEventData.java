package edu.ksu.canvas.model;

import java.io.Serializable;
import java.time.Instant;

/**
 * Class to represent Canvas event data objects.
 * See <a href="https://canvas.instructure.com/doc/api/course_audit_log.html#CourseEventData">Canvas event data</a> documentation.
 */

public class CourseEventData extends BaseCanvasModel implements Serializable {

    public static final long serialVersionUID = 1L;

    // The created event data object returns all the fields that were set in the
    // format of the following example.  If a field does not exist it was not set.
    // The value of each field changed is in the format of [:old_value, :new_value].
    // The created event type also includes a created_source field to specify what
    // triggered the creation of the course.
    private String[] name;
    private Instant[] startAt;
    private Instant[] concludeAt;
    private boolean[] isPublic;
    private String createdSource;

    public String[] getName() {
        return this.name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public Instant[] getStartAt() {
        return this.startAt;
    }

    public void setStartAt(Instant[] startAt) {
        this.startAt = startAt;
    }

    public Instant[] getConcludeAt() {
        return this.concludeAt;
    }

    public void setConcludeAt(Instant[] concludeAt) {
        this.concludeAt = concludeAt;
    }

    public boolean[] getIsPublic() {
        return this.isPublic;
    }

    public void setIsPublic(boolean[] isPublic) {
        this.isPublic = isPublic;
    }

    public String getCreatedSource() {
        return this.createdSource;
    }

    public void setCreatedSource(String createdSource) {
        this.createdSource = createdSource;
    }

}
