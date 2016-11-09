package com.tn.web.Exceptions;

/**
 * Created by Show on 2016/10/24.
 */
public class PositionException extends Exception {
    private int messageCode;
    private String message;

    public PositionException( int messageCode,String message){
        this.messageCode=messageCode;
        this.message=message;
    }
    public int getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(int messageCode) {
        this.messageCode = messageCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
