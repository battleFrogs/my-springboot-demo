package com.gjc.constant;

public enum RetCode {

    // 成功
    SUCCESS(200),

    // 失败
    FAIL(500);

    private int code;

    RetCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
