package edu.ksu.canvas.model;

import edu.ksu.canvas.annotation.CanvasField;
import edu.ksu.canvas.annotation.CanvasObject;

import java.io.Serializable;

@CanvasObject(postKey = "lti_resource_link")
public class LtiResourceLink extends BaseCanvasModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer contextId;
    private Integer contextExternalToolId;
    private Integer associatedContentId;
    private String contextType;
    private String resourceType;
    private String canvasLaunchUrl;
    private String resourceLinkUuid;
    private String lookupUuid;
    private String title;
    private String url;
    private String lti11Id;
    private String workflowState;
    private String associatedContentType;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @CanvasField(postKey = "context_id")
    public Integer getContextId() { return contextId; }
    public void setContextId(Integer contextId) { this.contextId = contextId; }

    @CanvasField(postKey = "context_type")
    public String getContextType() { return contextType; }
    public void setContextType(String contextType) { this.contextType = contextType; }

    @CanvasField(postKey = "context_external_tool_id")
    public Integer getContextExternalToolId() { return contextExternalToolId; }
    public void setContextExternalToolId(Integer contextExternalToolId) { this.contextExternalToolId = contextExternalToolId; }

    @CanvasField(postKey = "resource_type")
    public String getResourceType() { return resourceType; }
    public void setResourceType(String resourceType) { this.resourceType = resourceType; }

    @CanvasField(postKey = "canvas_launch_url")
    public String getCanvasLaunchUrl() { return canvasLaunchUrl; }
    public void setCanvasLaunchUrl(String canvasLaunchUrl) { this.canvasLaunchUrl = canvasLaunchUrl; }

    @CanvasField(postKey = "resource_link_uuid")
    public String getResourceLinkUuid() { return resourceLinkUuid; }
    public void setResourceLinkUuid(String resourceLinkUuid) { this.resourceLinkUuid = resourceLinkUuid; }

    @CanvasField(postKey = "lookup_uuid")
    public String getLookupUuid() { return lookupUuid; }
    public void setLookupUuid(String lookupUuid) { this.lookupUuid = lookupUuid; }

    @CanvasField(postKey = "title")
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @CanvasField(postKey = "url")
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    @CanvasField(postKey = "lti_1_1_id")
    public String getLti11Id() { return lti11Id; }
    public void setLti11Id(String lti11Id) { this.lti11Id = lti11Id; }

    @CanvasField(postKey = "workflow_state")
    public String getWorkflowState() { return workflowState; }
    public void setWorkflowState(String workflowState) { this.workflowState = workflowState; }

    @CanvasField(postKey = "associated_content_type")
    public String getAssociatedContentType() { return associatedContentType; }
    public void setAssociatedContentType(String associatedContentType) { this.associatedContentType = associatedContentType; }

    @CanvasField(postKey = "associated_content_id")
    public Integer getAssociatedContentId() { return associatedContentId; }
    public void setAssociatedContentId(Integer associatedContentId) { this.associatedContentId = associatedContentId; }
}