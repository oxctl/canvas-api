package edu.ksu.canvas.interfaces;
import edu.ksu.canvas.model.LtiResourceLink;

import java.io.IOException;
import java.util.Optional;

public interface LtiResourceLinkReader extends CanvasReader<LtiResourceLink, LtiResourceLinkReader> {
    /**
     * Get an LTI Resource Link by ID
     * @param courseId The course ID
     * @param resourceLinkId The LTI Resource Link ID
     * @return Optional containing the LTI Resource Link if found
     * @throws IOException When there is an error communicating with Canvas
     */
    Optional<LtiResourceLink> getLtiResourceLink(String courseId, String resourceLinkId) throws IOException;

    /**
     * Get an LTI Resource Link by UUID
     * @param courseId The course ID
     * @param resourceLinkUuid The LTI Resource Link UUID
     * @return Optional containing the LTI Resource Link if found
     * @throws IOException When there is an error communicating with Canvas
     */
    Optional<LtiResourceLink> getLtiResourceLinkByUuid(String courseId, String resourceLinkUuid) throws IOException;
}
