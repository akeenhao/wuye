package com.serve.pojo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "通用返回结果")
public class Result<T> {
    public static final String SUCCESS_CODE = "0";
    public static final String FAILURE_CODE = "-1";

    public static final String SUCCESS_MSG = "操作成功！";
    public static final String FAILURE_MSG = "操作失败！";

    @ApiModelProperty(value = "成功失败标识")
    private String code;
    @ApiModelProperty(value = "提示信息")
    private String msg;
    @ApiModelProperty(value = "返回数据")
    private T data;

    /**
     * 若没有数据返回，默认状态码为0，提示信息为：操作成功！
     */
    public Result() {
        this.code = this.SUCCESS_CODE;
        this.msg = this.SUCCESS_MSG;
    }
    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     * @param code
     * @param msg
     */
    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    /**
     * 有数据返回时，状态码为0，默认提示信息为：操作成功！
     * @param data
     */
    public Result(T data) {
        this.data = data;
        this.code = this.SUCCESS_CODE;
        this.msg = this.SUCCESS_MSG;
    }
    /**
     * 有数据返回，状态码为0，人为指定提示信息
     * @param data
     * @param msg
     */
    public Result(T data, String msg) {
        this.data = data;
        this.code = this.SUCCESS_CODE;
        this.msg = msg;
    }

    /**
     * 判断是否成功
     * @return
     */
    public boolean success(){
        return this.code.equals(SUCCESS_CODE);
    }
    /**
     * 判断是否失败
     * @return
     */
    public boolean fail(){
        return !this.code.equals(SUCCESS_CODE);
    }

    public static Result ok (){
        return new Result();
    }
}
