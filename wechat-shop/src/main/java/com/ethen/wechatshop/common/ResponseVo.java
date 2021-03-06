package com.ethen.wechatshop.common;

public class ResponseVo<T> {

    private int code;
    private String msg;
    private T data;

    public ResponseVo() {
    }

    public ResponseVo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static ResponseVo fail(ResponseEnum resEnum) {
        return success(resEnum);
    }

    public static ResponseVo success(ResponseEnum resEnum) {
        return success(resEnum,null);
    }

    public static <T>ResponseVo<T> success(ResponseEnum resEnum, T data) {
        ResponseVo<T> res = new ResponseVo<>();
        res.setCode(Integer.parseInt(resEnum.getCode()));
        res.setMsg(resEnum.getMessage());
        if (data != null) {
            res.setData(data);
        }
        return res;
    }

    public ResponseVo(int code, String msg, T data) {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
