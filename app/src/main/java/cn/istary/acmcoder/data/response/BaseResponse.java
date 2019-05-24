package cn.istary.acmcoder.data.response;

import java.util.List;

/**
 * DESCRIPTION:
 *
 * @author Sinry
 * @version 2019/5/9 11:04
 */

public class BaseResponse {

    private int code;
    private String msg;

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
}
