package com.tc.meta.vo;

import java.io.Serializable;

/**
  *                    _ooOoo_
  *                   o8888888o
  *                   88" . "88
  *                   (| -_- |)
  *                   O\  =  /O
  *                ____/`---'\____
  *              .'  \\|     |//  `.
  *             /  \\|||  :  |||//  \
  *            /  _||||| -:- |||||-  \
  *            |   | \\\  -  /// |   |
  *            | \_|  ''\---/''  |   |
  *            \  .-\__  `-`  ___/-. /
  *          ___`. .'  /--.--\  `. . __
  *       ."" '<  `.___\_<|>_/___.'  >'"".
  *      | | :  `- \`.;`\ _ /`;.`/ - ` : | |
  *      \  \ `-.   \_ __\ /__ _/   .-` /  /
  * ======`-.____`-.___\_____/___.-`____.-'======
  *                    `=---='
  * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  *          佛祖保佑       永无BUG
  *  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  *   author: tangcheng_cd
  *   create by: 2020/1/19
  *   descr: 
 */
public class MetaDBFunction implements Serializable {
    private String functionCat;
    private String functionSchem;
    private String functionName;
    private String remarks;
    private String functionType;
    private String specificName;

    public MetaDBFunction() {
    }

    public MetaDBFunction(String functionCat, String functionSchem, String functionName, String remarks, String functionType, String specificName) {
        this.functionCat = functionCat;
        this.functionSchem = functionSchem;
        this.functionName = functionName;
        this.remarks = remarks;
        this.functionType = functionType;
        this.specificName = specificName;
    }

    public String getFunctionCat() {
        return functionCat;
    }

    public void setFunctionCat(String functionCat) {
        this.functionCat = functionCat;
    }

    public String getFunctionSchem() {
        return functionSchem;
    }

    public void setFunctionSchem(String functionSchem) {
        this.functionSchem = functionSchem;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    public String getSpecificName() {
        return specificName;
    }

    public void setSpecificName(String specificName) {
        this.specificName = specificName;
    }

    @Override
    public String toString() {
        return "MetaDBFunction{" +
                "functionCat='" + functionCat + '\'' +
                ", functionSchem='" + functionSchem + '\'' +
                ", functionName='" + functionName + '\'' +
                ", remarks='" + remarks + '\'' +
                ", functionType='" + functionType + '\'' +
                ", specificName='" + specificName + '\'' +
                '}';
    }
}
