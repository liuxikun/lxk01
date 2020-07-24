package com.example.lxk.enums;

/**
 * 返回提示信息
 *
 * @author zpz
 * @date 2019/01/02
 */
public enum ResultEnum {
    /**
     * 操作失败
     */
    OPERATE_FAIL(1, "操作失败"),
    /**
     * 系统异常
     */
    EXCEPTION_ERROR(2, "系统异常"),
    /**
     * token失效
     */
    TOKEN_ERROR(3, "token失效"),
    /**
     * 操作成功
     */
    OPERATE_SUCCESS(4, "操作成功"),

    IMG_FORMAT(10, "文件名格式有误！"),


    GROUP_DELET(310, "请删除该管理处下的部门！"),

    STAFF_BORDER(320, "离职时间不能不能小于入职时间！"),
    TOWER_LINE(330, "楼栋数已达到上线"),
    LOADING_SUCCESS(200, "加载成功！"),

    LOGIN_SUCCESS(200, "登陆成功！"),
    LOGIN_ALREADY_SUCCESS(200, "已经登陆成功！"),
    LOGIN_ALREADY_SUCCESS_ACCEPT(1002, "用户名应包含数字和字母！"),
    LOGIN_ERR_NOT_USER(201, "帐号不存在,请先注册"),
    LOGIN_ERR_PASSWORD(202, "账户或密码错误！"),
    LOGIN_ERR_MULTIPLE_LOG(203, "帐号多次登录"),
    LOGIN_ERR_ACCOUNT_LOCKOUT(204, "帐号锁定"),
    LOGIN_ERR_ACCOUNT_BAN(205, "帐号锁定"),
    LOGIN_ERR_OVERDUE_ACCOUNT(206, "帐号过期"),
    LOGIN_ERR_LACK_OF_COMPETENCE(207, "您没有得到相应的授权！"),

    LOGIN_FIX_SUCCESS(200, "修改成功！"),
    LOGIN_FIX_ERROR(100, "修改失败！"),
    LOGIN_FIX_ERROR_IS_NULL(300, "账户或密码为空"),
    LOGOUT_SUCCESS(200, "退出成功！"),

	LOGIN_IS_ACCOUNT_ERR_SUCCESS(100,"账户不存在"),
    LOGIN_IS_ACCOUNT_ERR_INVALID(101,"账户已注销"),
	LOGIN_IS_ACCOUNT_ERR_PASSWORD(100,"密码错误"),
	LOGIN_IS_ACCOUNT_ERR_EXIST(201,"账户存在"),
	LOGIN_IS_ACCOUNT_NOT_CONFORM_RULES(202,"用户名不符合规则"),
	LOGIN_IS_PWD_NOT_CONFORM_RULES(203,"密码不符合规则"),
    LOGIN_IS_PWD_ACCOUNT_NOT_CONFORM_RULES(204,"用户名或密码不符合规则"),

    USER_CONFIG_IS_NONE(100,"用户配置不存在"),
    SEND_VERIFICATION_STATUS_ONE(100, "验证码发送失败"),
    SEND_VERIFICATION_STATUS_TWO(200, "验证码发送成功"),
    SEND_ACCOUNT_ISEMPT(300, "账号为空"),

    CHECK_VERIFICATION_SUCCESS(200, "验证码正确"),
    CHECK_VERIFICATION_ERRR(100, "验证码错误"),

    REPORT_DOWNLOAD_ERROR(202, "检测报表导出异常"),
    REPORT_DOWNLOAD_NULL(201, "导出数据为空，不能导出"),

    FIX_SUCCESS(200, "修改成功！"),
    FIX_FAILURE(100, "修改失败"),
    ADD_SUCCESS(200, "添加成功"),
    ADD_FAILURE(100, "添加失败"),
    FIND_SUCCESS(200, "查询成功"),
    FIND_FAILURE(100, "查询失败"),
    FIND_FAILURE_ISEMPTY(300, "查询无结果"),
    DELETE_SUCCESS(200, "删除成功"),
    DELETE_FAILURE(100, "删除失败"),
    PARAMETER_ISEMPTY(400, "id 参数为空"),
    THERE_ARE_THE_SAME(1, "已存在"),

    THAN_AREA_BUILD(300, "建筑面积大于楼层总面积"),
    THAN_AREA_BILL(400, "计费面积大于楼层总面积"),
    STRING_TO_DATE_FAIL(200, "字符转换日期异常"),

    REGISTER_USER_ERROR(201, "用户注册异常！");
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}

