package io.warranted;

import java.util.List;

/**
 * <p>LawEnforcementRequest class.</p>
 *
 * @author warranted.io
 * @version $Id: $Id
 */
public class LawEnforcementRequest {

    private String id;
    private long createdAt;
    private String owner;
    private String name;
    private String type;
    private String decisionId;
    private List<Status> statuses;
    private long updatedAt;
  
    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String getId() {
        return id;
    }
  
    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a {@link java.lang.String} object
     */
    public void setId(String id) {
        this.id = id;
    }
  
    /**
     * <p>Getter for the field <code>createdAt</code>.</p>
     *
     * @return a long
     */
    public long getCreatedAt() {
        return createdAt;
    }
  
    /**
     * <p>Setter for the field <code>createdAt</code>.</p>
     *
     * @param createdAt a long
     */
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
  
    /**
     * <p>Getter for the field <code>owner</code>.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String getOwner() {
        return owner;
    }
  
    /**
     * <p>Setter for the field <code>owner</code>.</p>
     *
     * @param owner a {@link java.lang.String} object
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
  
    /**
     * <p>Getter for the field <code>name</code>.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String getName() {
        return name;
    }
  
    /**
     * <p>Setter for the field <code>name</code>.</p>
     *
     * @param name a {@link java.lang.String} object
     */
    public void setName(String name) {
        this.name = name;
    }
  
    /**
     * <p>Getter for the field <code>type</code>.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String getType() {
        return type;
    }
  
    /**
     * <p>Setter for the field <code>type</code>.</p>
     *
     * @param type a {@link java.lang.String} object
     */
    public void setType(String type) {
        this.type = type;
    }
  
    /**
     * <p>Getter for the field <code>decisionId</code>.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String getDecisionId() {
        return decisionId;
    }
  
    /**
     * <p>Setter for the field <code>decisionId</code>.</p>
     *
     * @param decisionId a {@link java.lang.String} object
     */
    public void setDecisionId(String decisionId) {
        this.decisionId = decisionId;
    }
  
    /**
     * <p>Getter for the field <code>statuses</code>.</p>
     *
     * @return a {@link java.util.List} object
     */
    public List<Status> getStatuses() {
        return statuses;
    }
  
    /**
     * <p>Setter for the field <code>statuses</code>.</p>
     *
     * @param statuses a {@link java.util.List} object
     */
    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }
  
    /**
     * <p>Getter for the field <code>updatedAt</code>.</p>
     *
     * @return a long
     */
    public long getUpdatedAt() {
        return updatedAt;
    }
  
    /**
     * <p>Setter for the field <code>updatedAt</code>.</p>
     *
     * @param updatedAt a long
     */
    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
  
    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "LawEnforcementRequest{" +
            "id='" + id + '\'' +
            ", createdAt=" + createdAt +
            ", owner='" + owner + '\'' +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", decisionId='" + decisionId + '\'' +
            ", statuses=" + statuses +
            ", updatedAt=" + updatedAt +
            '}';
    }
  
    public static class Status {
        private String status;
        private String reason;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        @Override
        public String toString() {
            return "Status{" +
                "status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                '}';
        }
    }

    public static class DeleteResponse {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    
        @Override
        public String toString() {
            return "DeleteResponse{" +
                "message='" + message + '\'' +
                '}';
        }
    }
}
  
