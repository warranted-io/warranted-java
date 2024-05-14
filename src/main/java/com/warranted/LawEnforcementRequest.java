package com.warranted;

import java.util.List;

public class LawEnforcementRequest {

    private String id;
    private long createdAt;
    private String owner;
    private String name;
    private String type;
    private String decisionId;
    private List<Status> statuses;
    private long updatedAt;
  
    public String getId() {
        return id;
    }
  
    public void setId(String id) {
        this.id = id;
    }
  
    public long getCreatedAt() {
        return createdAt;
    }
  
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
  
    public String getOwner() {
        return owner;
    }
  
    public void setOwner(String owner) {
        this.owner = owner;
    }
  
    public String getName() {
        return name;
    }
  
    public void setName(String name) {
        this.name = name;
    }
  
    public String getType() {
        return type;
    }
  
    public void setType(String type) {
        this.type = type;
    }
  
    public String getDecisionId() {
        return decisionId;
    }
  
    public void setDecisionId(String decisionId) {
        this.decisionId = decisionId;
    }
  
    public List<Status> getStatuses() {
        return statuses;
    }
  
    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }
  
    public long getUpdatedAt() {
        return updatedAt;
    }
  
    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
  
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
  