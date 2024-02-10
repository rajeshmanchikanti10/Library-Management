package com.rajesh.library.management.Exception;

import com.rajesh.library.management.enums.ErrorCode;
public class LibraryException extends  RuntimeException{
    private final  int httpStatusCode;
    private final ErrorCode errorCode;
    private final String Message;
    public LibraryException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode ;
        this.httpStatusCode = errorCode.getResponseCode();
        Message = message;
    }
    public int getHttpStatusCode(){
        return httpStatusCode;
    }
    public String getMessage(){
        return Message;
    }
}
