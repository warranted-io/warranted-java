package io.warranted;

import java.util.List;

/**
 * <p>Schema class.</p>
 *
 * @author warranted.io
 * @version $Id: $Id
 */
public class Schema {

    private String id;
    private long createdAt;
    private List<Field> fields;
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
     * <p>Getter for the field <code>fields</code>.</p>
     *
     * @return a {@link java.util.List} object
     */
    public List<Field> getFields() {
        return fields;
    }
  
    /**
     * <p>Setter for the field <code>fields</code>.</p>
     *
     * @param fields a {@link java.util.List} object
     */
    public void setFields(List<Field> fields) {
        this.fields = fields;
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
  
