package edu.ksu.canvas.requestOptions;

/**
 * Submission options to submit an assignment
 * <p>
 * See <a href="https://canvas.instructure.com/doc/api/submissions.html#method.submissions.create">Submit an Assignment</a>
 * for more details.
 */
public final class SubmissionOptions extends BaseOptions {
    private final String courseId;
    private final String assignmentId;

    public SubmissionOptions(String courseId, String assignmentId) {
        this.courseId = courseId;
        this.assignmentId = assignmentId;
    }

    public SubmissionOptions userId(String parameter) {
        addSingleItem("submission[user_id]", parameter);
        return this;
    }

    public SubmissionOptions url(String parameter) {
        addSingleItem("submission[url]", parameter);
        return this;
    }

    public SubmissionOptions textComment(String parameter) {
        addSingleItem("comment[text_comment]", parameter);
        return this;
    }

    public SubmissionOptions submissionType(String parameter) {
        addSingleItem("submission[submission_type]", parameter);
        return this;
    }

    public String getCourseId() { return courseId; }
    public String getAssignmentId() { return assignmentId; }
}