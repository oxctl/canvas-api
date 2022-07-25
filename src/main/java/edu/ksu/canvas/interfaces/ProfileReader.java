package edu.ksu.canvas.interfaces;

import edu.ksu.canvas.model.Profile;

import java.io.IOException;
import java.util.Optional;

public interface ProfileReader extends CanvasReader<Profile, ProfileReader> {

    /**
     * Retrieve a specific user profile from Canvas by user identifier
     * @param userIdentifier The object holding a user identifier value, for example:
     *    Numeric Canvas user ID
     *    A string like "sis_integration_id:123" to query by SIS integration ID
     *    A string like "sis_user_id:ABC" to query by SIS ID
     *    The special string "self" that the Canvas API interprets as "the currently logged in user"
     * @return The Profile returned by Canvas or an empty Optional
     * @throws IOException When there is an error communicating with Canvas
     */
     Optional<Profile> getUserProfile(String userIdentifier) throws IOException;

}
