package com.audio.electric.util.enums;

/**
 * Created by yangwu on 2017/3/17 0017.
 */
public enum RetCode {

    SUCCESS(1,"success"),
    FAILED(-1,"失败"),
    UNKNOWN_ERROR(0,"未知错误"),
    UNLOGINED(2,"未登陆"),
    UNACTIVED(3,"账号未激活"),
    PARAMETER_ERROR(1001,"参数错误"),
    UTIL_ILLEGAL(4,"非法操作,当前登录用户操作了其他用户数据"),
    UTIL_AUTHCODE(5,"验证码错误"),
    ERROR_PASSWORD(6,"密码错误"),
    NEWVERSION_NO(7,"没有新版本"),
    SQLEXCEPTION(8,"数据库异常"),
    LOG_USERNAME_OR_PASSWOLD_ERROR(9,"用户名或密码错误"),
    REG_USER_PARAMETER_ERROR(101,"用户参数错误"),
    REG_EMPTY_EMAIL(102,"邮箱为空"),
    REG_FORMAT_ERROR_EMAIL(103,"邮箱格式不正确"),
    REG_EXIST_EMAIL(104,"邮箱已经注册"),
    REG_EMPTY_USER_NAME(105,"用户名为空"),
    REG_EXIST_USER_NAME(106,"用户名已存在"),
    REG_EMPTY_PASSWORD(107,"密码为空"),
    REG_EMPTY_PHONENUM(108,"手机号为空"),
    REG_FORMAT_ERROR_PHONENUM(109,"手机格式不正确"),
    REG_EXIST_PHONENUM(110,"手机号已存在"),
    REG_EMPTY_AUTHENTICATED_CODE(111,"验证码为空"),
    REG_AUTHENTICATED_CODE_ERROR(112,"验证码错误"),
    REG_MISTAKE_ACTIVATION(113,"邮箱激活码错误"),
    REG_EMAIL_ACTIVATED(114,"邮箱已激活"),
    REG_EMAIL_IS_NOT_REGISTER(115,"邮箱未注册(或者邮箱不存在)"),
    REG_EMAIL_IS_MISTAKE(116,"邮箱格式有误"),
    REG_EMAIL_MORETHANONE(117,"存在多个邮箱相同的账号"),
    STATUSEXCEPTION(118,"账号状态异常"),
    USERNOTEXIST(119,"用户不存在"),
    PORTFOLIIONOTEXIST(120,"作品不存在"),
    GIFTNOTEXIST(121,"礼物不存在"),
    GIFTNOTENOUGH(122,"礼物不足够"),
    GOODSALREADY(123,"已经点赞，不能重复点赞"),
    GOODSNOT(124,"还没点赞，不能取消点赞"),
    COLLECTIONALREADY(126,"已经收藏，不能重复收藏"),
    COLLECTIONNOT(127,"还没收藏，不能取消收藏"),
    ATTENDTIONALREADY(126,"已经关注，不能重复关注"),
    ATTENDTIONNOT(127,"还没关注，不能取消关注");


    RetCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
