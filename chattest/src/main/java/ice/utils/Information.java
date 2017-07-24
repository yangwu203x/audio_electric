package ice.utils;

/**
 * 消息枚举类
 * @Author leo_Yang【音特】
 * @Date 2017/4/11 0011 10:03
 */
public enum Information {
    OFFICIAL("0","官方消息"),
    COMMENTS("1","评论"),
    GOODS("2","点赞"),
    ATTENTION("3","关注");
    private String srcUserId;
    private String msg;

    Information(String srcUserId, String msg) {
        this.srcUserId = srcUserId;
        this.msg = msg;
    }

    public String getSrcUserId() {
        return srcUserId;
    }

    public String getMsg() {
        return msg;
    }
}
