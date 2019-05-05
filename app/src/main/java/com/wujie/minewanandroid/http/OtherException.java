package com.wujie.minewanandroid.http;

public class OtherException extends RuntimeException {

    private int mErrorCode;

    public OtherException() {
    }

    public OtherException(int errorCode, String message) {
        super(message);
        mErrorCode = errorCode;
    }

    public int getErrorCode() {
        return mErrorCode;
    }
}
