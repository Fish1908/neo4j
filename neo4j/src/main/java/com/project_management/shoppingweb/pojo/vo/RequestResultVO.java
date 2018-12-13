package com.project_management.shoppingweb.pojo.vo;

public class RequestResultVO implements java.io.Serializable {
    /**
     * code:TODO
     * @since JDK 1.7
     */
    private int code = 0;//表示成功
    /**
     * message:TODO
     * @since JDK 1.7
     */
    private String message = "";
    /**
     * obj:TODO
     * @since JDK 1.7
     */
    private Object data = null;
    /**
     * Create a new instance of RequestResult
     */
    public RequestResultVO() {
        // TODO Auto-generated constructor stub
    }
    public RequestResultVO(int code, String message, Object data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }
    /**
     * code.
     * @return  the code
     * @since   JDK 1.7
     */
    public int getCode() {
        return code;
    }
    /**
     * code.
     *
     * @param   code    the code to set
     * @since   JDK 1.7
     */
    public void setCode(int code) {
        this.code = code;
    }
    /**
     * message.
     *
     * @return  the message
     * @since   JDK 1.7
     */
    public String getMessage() {
        return message;
    }
    /**
     * message.
     * @param   message    the message to set
     * @since   JDK 1.7
     */
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * data.
     * @return  the data
     * @since   JDK 1.7
     */
    public Object getData() {
        return data;
    }
    /**
     * data.
     * @param   data    the data to set
     * @since   JDK 1.7
     */
    public void setData(Object data) {
        this.data = data;
    }
}
