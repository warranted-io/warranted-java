package io.warranted;

/**
 * <p>Error class.</p>
 *
 * @author warranted.io
 * @version $Id: $Id
 */
public class Error {
    private String errorCode;
    private String message;
  
    /**
     * <p>Getter for the field <code>errorCode</code>.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String getErrorCode() {
      return errorCode;
    }
  
    /**
     * <p>Setter for the field <code>errorCode</code>.</p>
     *
     * @param errorCode a {@link java.lang.String} object
     */
    public void setErrorCode(String errorCode) {
      this.errorCode = errorCode;
    }
  
    /**
     * <p>Getter for the field <code>message</code>.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String getMessage() {
      return message;
    }
  
    /**
     * <p>Setter for the field <code>message</code>.</p>
     *
     * @param message a {@link java.lang.String} object
     */
    public void setMessage(String message) {
      this.message = message;
    }
  
    /** {@inheritDoc} */
    @Override
    public String toString() {
      return "Error{" +
          "errorCode='" + errorCode + '\'' +
          ", message='" + message + '\'' +
          '}';
    }
  }
