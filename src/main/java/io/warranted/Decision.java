package io.warranted;

import java.util.Map;

/**
 * <p>Decision class.</p>
 *
 * @author warranted.io
 * @version $Id: $Id
 */
public class Decision {

    private String id;
    private long createdAt;
    private String lawEnforcementRequestId;
    private String owner;
    private Result result;
    private long updatedAt;
  
    // Getters and Setters
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
     * <p>Getter for the field <code>lawEnforcementRequestId</code>.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String getLawEnforcementRequestId() {
        return lawEnforcementRequestId;
    }
  
    /**
     * <p>Setter for the field <code>lawEnforcementRequestId</code>.</p>
     *
     * @param lawEnforcementRequestId a {@link java.lang.String} object
     */
    public void setLawEnforcementRequestId(String lawEnforcementRequestId) {
        this.lawEnforcementRequestId = lawEnforcementRequestId;
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
     * <p>Getter for the field <code>result</code>.</p>
     *
     * @return a {@link io.warranted.Decision.Result} object
     */
    public Result getResult() {
        return result;
    }
  
    /**
     * <p>Setter for the field <code>result</code>.</p>
     *
     * @param result a {@link io.warranted.Decision.Result} object
     */
    public void setResult(Result result) {
        this.result = result;
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
  
