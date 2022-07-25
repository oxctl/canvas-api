package edu.ksu.canvas.model;

import edu.ksu.canvas.annotation.CanvasField;
import edu.ksu.canvas.annotation.CanvasObject;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class to represent Canvas profiles.
 * See the <a href="https://canvas.instructure.com/doc/api/users.html#Profile">Profile</a> documentation.
 */
public class Profile extends BaseCanvasModel implements Serializable {
    private static final long serialVersionUID = 2L;

    private long id;
    private String name;
    private String sortableName;
    private String shortName;
    private String sisUserId;
    private String loginId;
    private String integrationId;
    private String avatarUrl;
    private String primaryEmail;
    private String locale;
    private String effectiveLocale;
    private String lastLogin;
    private String timeZone;
    private String bio;
    private Object calendar;
    private String ltiUserId;
    private boolean k5User;

    public Profile() {
    }

    public Profile(Profile other) {
        this.id = other.id;
        this.name = other.name;
        this.sortableName = other.sortableName;
        this.shortName = other.shortName;
        this.sisUserId = other.sisUserId;
        this.loginId = other.loginId;
        this.integrationId = other.integrationId;
        this.avatarUrl = other.avatarUrl;
        this.primaryEmail = other.primaryEmail;
        this.locale = other.locale;
        this.effectiveLocale = other.effectiveLocale;
        this.lastLogin = other.lastLogin;
        this.timeZone = other.timeZone;
        this.bio = other.bio;
        this.calendar = other.calendar;
        this.ltiUserId = other.ltiUserId;
        this.k5User = other.k5User;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortableName() {
        return sortableName;
    }

    public void setSortableName(String sortableName) {
        this.sortableName = sortableName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSisUserId() {
        return sisUserId;
    }

    public void setSisUserId(String sisUserId) {
        this.sisUserId = sisUserId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(String integrationId) {
        this.integrationId = integrationId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getEffectiveLocale() {
        return effectiveLocale;
    }

    public void setEffectiveLocale(String effectiveLocale) {
        this.effectiveLocale = effectiveLocale;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Object getCalendar() {
        return calendar;
    }

    public void setCalendar(Object calendar) {
        this.calendar = calendar;
    }

    public String getLtiUserId() {
        return ltiUserId;
    }

    public void setLtiUserId(String ltiUserId) {
        this.ltiUserId = ltiUserId;
    }

    public boolean getK5User() {
        return k5User;
    }

    public void setK5User(boolean k5User) {
        this.k5User = k5User;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return id == profile.id && Objects.equals(name, profile.name) && Objects.equals(sortableName, profile.sortableName) && Objects.equals(shortName, profile.shortName) && Objects.equals(loginId, profile.loginId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sortableName, shortName, loginId);
    }
}
