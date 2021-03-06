package com.outdd.base;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/*
 * TODO: ResponseBase
 * @author VAIE
 * @date: 2018/12/18-10:52
 * @version v1.0
 */
@Getter
@Setter
@Slf4j
public class ResponseBase {
    // 响应code
    private Integer code;
    // 消息内容
    private String msg;
    // 返回data
    private Object data;

    public ResponseBase(Integer rtnCode, String msg, Object data) {
        super();
        this.code = rtnCode;
        this.msg = msg;
        this.data = data;
    }
    public ResponseBase() {

    }
    @Override
    public String toString() {
        return "ResponseBase [Code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }

}

