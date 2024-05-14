package io.warranted;

import java.util.List;

public class Schema {

    private String id;
    private long createdAt;
    private List<Field> fields;
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
  
    public List<Field> getFields() {
        return fields;
    }
  
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
  
    public long getUpdatedAt() {
        return updatedAt;
    }
  
    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
  
    @Override
    public String toString() {
        return "Schema{" +
            "id='" + id + '\'' +
            ", createdAt=" + createdAt +
            ", fields=" + fields +
            ", updatedAt=" + updatedAt +
            '}';
    }
  
    // Nested class for Field object
    public static class Field {
        private String key;
        private String description;
  
        public String getKey() {
            return key;
        }
  
        public void setKey(String key) {
            this.key = key;
        }
  
        public String getDescription() {
            return description;
        }
  
        public void setDescription(String description) {
            this.description = description;
        }
  
        @Override
        public String toString() {
            return "Field{" +
                "key='" + key + '\'' +
                ", description='" + description + '\'' +
                '}';
        }
    }
}
  