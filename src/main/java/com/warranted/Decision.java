package com.warranted;

import java.util.Map;

public class Decision {

    private String id;
    private long createdAt;
    private String lawEnforcementRequestId;
    private String owner;
    private Result result;
    private long updatedAt;
  
    // Getters and Setters
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
  
    public String getLawEnforcementRequestId() {
        return lawEnforcementRequestId;
    }
  
    public void setLawEnforcementRequestId(String lawEnforcementRequestId) {
        this.lawEnforcementRequestId = lawEnforcementRequestId;
    }
  
    public String getOwner() {
        return owner;
    }
  
    public void setOwner(String owner) {
        this.owner = owner;
    }
  
    public Result getResult() {
        return result;
    }
  
    public void setResult(Result result) {
        this.result = result;
    }
  
    public long getUpdatedAt() {
        return updatedAt;
    }
  
    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
  
    @Override
    public String toString() {
      return "Decision{" +
          "id='" + id + '\'' +
          ", createdAt=" + createdAt +
          ", lawEnforcementRequestId='" + lawEnforcementRequestId + '\'' +
          ", owner='" + owner + '\'' +
          ", result=" + result +
          ", updatedAt=" + updatedAt +
          '}';
    }
  
    // Nested class for Result object
    public static class Result {
        private String subject;
        private String requester;
        private String startTime;
        private String endTime;
        private Map<String, SchemaEntry> schema;
  
        public String getSubject() {
            return subject;
        }

        public String getRequester() {
            return requester;
        }

        public String getStartTime() {
            return startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public Map<String, SchemaEntry> getSchema() {
            return schema;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public void setRequester(String requester) {
            this.requester = requester;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public void setSchema(Map<String, SchemaEntry> schema) {
            this.schema = schema;
        }
  
        @Override
        public String toString() {
            return "Result{" +
                "subject='" + subject + '\'' +
                ", requester='" + requester + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", schema=" + schema +
                '}';
        }
    }
  
    // Nested class for SchemaEntry object (assuming simple structure)
    public static class SchemaEntry {
        private boolean isRequested;
        private boolean isError;
        private String reason;

        public boolean getIsRequested() {
            return isRequested;
        }
        
        public boolean getIsError() {
            return isError;
        }
        
        public String getReason() {
            return reason;
        }
        
        public void setIsRequested(boolean requested) {
            isRequested = requested;
        }
        
        public void setIsError(boolean error) {
            isError = error;
        }
        
        public void setReason(String reason) {
            this.reason = reason;
        }
  
        @Override
        public String toString() {
            return "SchemaEntry{" +
                "isRequested=" + isRequested +
                ", isError=" + isError +
                ", reason='" + reason + '\'' +
                '}';
        }
    }
}
  