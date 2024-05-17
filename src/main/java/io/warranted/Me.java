package io.warranted;

/**
 * <p>Me class.</p>
 *
 * @author warranted.io
 * @version $Id: $Id
 */
public class Me {
    private String id;
    private String role;
  
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
     * <p>Getter for the field <code>role</code>.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String getRole() {
      return role;
    }
  
    /**
     * <p>Setter for the field <code>role</code>.</p>
     *
     * @param role a {@link java.lang.String} object
     */
    public void setRole(String role) {
      this.role = role;
    }
  
    /** {@inheritDoc} */
    @Override
    public String toString() {
      return "Me{" +
          "id='" + id + '\'' +
          ", role='" + role + '\'' +
          '}';
    }
  }
