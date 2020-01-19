package com.tc.meta.vo;

import java.io.Serializable;
import java.util.Map;

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
  *   descr:  元数据库信息
 */
public class MetaDBInfo implements Serializable {
    // 数据库连接url
    private String url;
    // 数据库类型
    private String dbType;
    // 用户名
    private String userName;
    // 密码
    private String password;
    // 驱动class
    private String dirverClass;
    // 扩展参数
    private Map<String, Object> extraParams;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDirverClass() {
        return dirverClass;
    }

    public void setDirverClass(String dirverClass) {
        this.dirverClass = dirverClass;
    }

    public Map<String, Object> getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(Map<String, Object> extraParams) {
        this.extraParams = extraParams;
    }

    @Override
    public String toString() {
        return "MetaDBInfo{" +
                "url='" + url + '\'' +
                ", dbType='" + dbType + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dirverClass='" + dirverClass + '\'' +
                ", extraParams=" + extraParams +
                '}';
    }
}
