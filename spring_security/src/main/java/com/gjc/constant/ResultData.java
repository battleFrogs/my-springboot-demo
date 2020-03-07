package com.gjc.constant;

import java.util.HashMap;
import java.util.Map;

public class ResultData {


    /**
     * 默认生成的序列号
     */
    private static final long serialVersionUID = 1L;

    private int code = RetCode.FAIL.getCode();

    private String msg = "";

    private Map<String, Object> data = new HashMap<>(32);

    public ResultData() {
    }

    public ResultData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultData(int code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void addData(String key, Object value) {
        this.data.put(key, value);
    }


}
