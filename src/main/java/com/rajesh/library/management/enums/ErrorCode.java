package com.rajesh.library.management.enums;

public enum ErrorCode {
    BAD_REQUEST(400),
    NOT_FOUND(404),
    CREATION_ERROR(400),
    UPDATION_ERROR(400);
    int responseCode;
    private ErrorCode(int code){
        this.responseCode = code;
    }
    public int getResponseCode(){
        return responseCode;
    }
}
