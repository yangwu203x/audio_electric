package com.audio.electric.util;

//import java.net.URLDecoder;

/**
 * Created by yangwu on 2017/3/28 0028.
 */
public final class AppUtils {
    public static String AppPath = "";
    public static boolean isUTF8 = false;
    static{
        try {
            isUTF8 = "中国".getBytes().length == 6;
            AppPath = AppUtils.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            //中文编码环境下，空格会变成“%20”从而使得路径错误，解决办法如下：
           // AppPath= URLDecoder.decode(AppPath,"utf-8");
            AppPath = AppPath.replace('\\', '/');
            if(AppPath.indexOf(":") > 0 && AppPath.startsWith("/")) {
                AppPath = AppPath.substring(1, AppPath.length());
            }

            if(AppPath.endsWith("/")) {
                AppPath = AppPath.substring(0, AppPath.lastIndexOf("/"));
            }

//            if(AppPath.endsWith("/classes")) {
//                AppPath = AppPath.substring(0, AppPath.lastIndexOf("/"));
//            }

            if(AppPath.endsWith("/lib")) {
                AppPath = AppPath.substring(0, AppPath.lastIndexOf("/"));
            }

            if(AppPath.endsWith("/classes/jvc/util/AppUtils.class")) {
                AppPath = AppPath.substring(0, AppPath.lastIndexOf("/classes/jvc/util/AppUtils.class"));
            }

        } catch (Exception var1) {
            AppPath = null;
        }

    }
    public static void main(String[] args){
        System.out.println(AppUtils.AppPath);
    }
}
