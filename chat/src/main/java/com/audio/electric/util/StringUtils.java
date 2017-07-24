package com.audio.electric.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yangwu on 2017/3/28 0028.
 */
public class StringUtils {
    public StringUtils() {
    }

    public static String toGBK(String _str) {
        return _str == null?"":toGBK(_str.trim(), "GBK");
    }

    public static boolean isBlank(String str) {
        return str == null?true:str.equals("");
    }


    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String toGBK(String _str, String Encoding) {
        if(_str == null) {
            return "";
        } else if(Encoding == null) {
            return _str;
        } else {
            String gbkStr = "";

            try {
                gbkStr = new String(_str.getBytes("ISO8859_1"), Encoding);
            } catch (UnsupportedEncodingException var4) {
                var4.printStackTrace();
            }

            return gbkStr;
        }
    }


    public static String toISO(String _str, String Encoding) {
        if(Encoding == null) {
            return _str;
        } else if(Encoding.equals("")) {
            return _str;
        } else {
            String isoStr = "";

            try {
                isoStr = new String(_str.getBytes(Encoding), "ISO8859_1");
            } catch (UnsupportedEncodingException var4) {
                var4.printStackTrace();
            }

            return isoStr;
        }
    }

    public static String nulltoBlank(Object _str) {
        return _str == null?"":String.valueOf(_str);
    }

    public static int len(String _str) {
        return _str == null?0:_str.length();
    }

    public static String right(String _str, int length) {
        return _str == null?_str:(_str.length() <= length?_str:_str.substring(_str.length() - length, _str.length()));
    }

    public static String left(String _str, int length) {
        return _str == null?_str:(_str.length() <= length?_str:_str.substring(0, length));
    }

    public static String getEncoding(String _str, String Encoding) {
        String gbStr = null;
        if(_str == null) {
            return "";
        } else {
            try {
                if(Encoding == null) {
                    return _str;
                } else if(Encoding.equals("")) {
                    return _str;
                } else if(Encoding.equals("2utf-8")) {
                    return URLDecoder.decode(_str, "UTF-8");
                } else {
                    gbStr = new String(_str.getBytes("ISO8859_1"), Encoding);
                    return gbStr;
                }
            } catch (UnsupportedEncodingException var4) {
                var4.printStackTrace();
                throw new RuntimeException(var4.getMessage());
            }
        }
    }

    public static Date toDate(Object obj) {
        try {
            String str = String.valueOf(obj);
            if(str.equals("")) {
                return null;
            } else {
                if(str.length() < 10 && str.indexOf(":") < 0) {
                    String[] arr = str.split("-");
                    str = arr[0] + "-" + formatLen(arr[1], 2, "0") + "-" + formatLen(arr[2], 2, "0");
                }

                if(str.length() > 10) {
                    str = str.substring(0, 10);
                }

                return Date.valueOf(str);
            }
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Timestamp toTimestamp2(String str) {
        try {
            if(str.equals("")) {
                return null;
            } else {
                if(str.length() < 10 && str.indexOf(":") < 0) {
                    String[] arr = str.split("-");
                    str = arr[0] + "-" + formatLen(arr[1], 2, "0") + "-" + formatLen(arr[2], 2, "0");
                }

                if(str.indexOf(":") <= 0) {
                    str = str + " 23:59:59";
                }

                return Timestamp.valueOf(str);
            }
        } catch (Exception var2) {
            var2.printStackTrace();
            System.out.println("StringUtils-toTimestamp2 format Error :" + str);
            return null;
        }
    }

    public static Timestamp toTimestamp(Object obj) {
        try {
            String str = String.valueOf(obj);
            if(str.equals("")) {
                return null;
            } else {
                if(str.length() < 10 && str.indexOf(":") < 0) {
                    String[] arr = str.split("-");
                    str = arr[0] + "-" + formatLen(arr[1], 2, "0") + "-" + formatLen(arr[2], 2, "0");
                }

                if(str.indexOf(":") <= 0) {
                    str = str + " 00:00:00";
                }

                return Timestamp.valueOf(str);
            }
        } catch (Exception var3) {
            return null;
        }
    }

    public static Time toTime(String str) {
        try {
            return str.equals("")?null:Time.valueOf(str);
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }


    public static String urlEncode(String data) {
        try {
            return URLEncoder.encode(data, "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            var2.printStackTrace();
            return null;
        }
    }



    public static boolean toBoolean(String Str) {
        try {
            return Str == null?false:Str.equalsIgnoreCase("true");
        } catch (Exception var2) {
            return false;
        }
    }

    public static double toDouble(Object obj, double DefaultValue) {
        try {
            if(obj == null) {
                return DefaultValue;
            } else {
                String sValue = String.valueOf(obj);
                if(sValue.equals("null")) {
                    return DefaultValue;
                } else {
                    sValue = sValue.replaceAll(",", "");
                    return Double.parseDouble(sValue);
                }
            }
        } catch (Exception var4) {
            return DefaultValue;
        }
    }

    public static double toDouble(Object sValue) {
        return toDouble(sValue, 0.0D);
    }

    public static long toLong(Object Str) {
        return toLong(Str, 0L);
    }

    public static long toLong(Object obj, long DefaultValue) {
        try {
            String Str = String.valueOf(obj);
            if(Str == null) {
                return DefaultValue;
            } else if(Str.trim().length() == 0) {
                return DefaultValue;
            } else {
                String sValue = Str.replaceAll(",", "");
                int dot = sValue.indexOf(".");
                if(dot > 0) {
                    sValue = sValue.substring(0, dot);
                }

                return Long.parseLong(sValue);
            }
        } catch (Exception var6) {
            return DefaultValue;
        }
    }

    public static int toInt(String Str, int DefaultValue) {
        try {
            if(Str == null) {
                return DefaultValue;
            } else if(String.valueOf(Str).trim().length() == 0) {
                return DefaultValue;
            } else {
                String sValue = String.valueOf(Str).replaceAll(",", "");
                sValue = sValue.trim();
                int dot = sValue.indexOf(".");
                if(dot > 0) {
                    sValue = sValue.substring(0, dot);
                }

                return Integer.parseInt(sValue);
            }
        } catch (Exception var4) {
            return DefaultValue;
        }
    }

    public static int toInt(Object Str, int DefaultValue) {
        try {
            if(Str == null) {
                return DefaultValue;
            } else if(String.valueOf(Str).trim().length() == 0) {
                return DefaultValue;
            } else {
                String sValue = String.valueOf(Str).replaceAll(",", "");
                sValue = sValue.trim();
                int dot = sValue.indexOf(".");
                if(dot > 0) {
                    sValue = sValue.substring(0, dot);
                }

                return Integer.parseInt(sValue);
            }
        } catch (Exception var4) {
            return DefaultValue;
        }
    }


    public static int toInt(Object Str) {
        return toInt((Object)Str, 0);
    }

    public static int toInt(String Str) {
        return toInt((String)Str, 0);
    }

    public static String toSBC(String str) {
        String tmp = "";
        if(str == null) {
            return "";
        } else {
            for(int i = 0; i < str.length(); ++i) {
                if(str.charAt(i) > 0 && str.charAt(i) < 255) {
                    tmp = tmp + (char)(str.charAt(i) + 'ﻠ');
                } else {
                    tmp = tmp + str.charAt(i);
                }
            }

            return tmp;
        }
    }


    public static String formatLen(String str, int len) {
        return formatLen(str, len, " ");
    }

    public static String formatLenRight(String str, int len, String code) {
        if(str.length() > len) {
            return str.substring(str.length() - len);
        } else {
            while(str.length() < len) {
                str = str + code;
            }

            return str;
        }
    }

    public static String formatLen(String str, int len, String code) {
        if(str == null) {
            return null;
        } else if(str.length() > len) {
            return str.substring(0, len);
        } else {
            while(str.length() < len) {
                str = code + str;
            }

            return str;
        }
    }

    public static String formatLen(int iStr, int len) {
        return formatLen(iStr, len, " ");
    }

    public static String formatLen(int iStr, int len, String code) {
        return formatLen(String.valueOf(iStr), len, code);
    }


    public static String passwordLeft(String str, int len) {
        return str == null?null:(str.length() < len?formatLen("", str.length(), "*"):formatLen("", len, "*") + str.substring(len));
    }

    public static String ignoreCaseReplace(String source, String oldstring, String newstring) {
        Pattern p = Pattern.compile(oldstring, 2);
        Matcher m = p.matcher(source);
        String ret = m.replaceAll(newstring);
        return ret;
    }

    public static String replaceOld(String aInput, String aOldPattern, String aNewPattern) {
        StringBuffer result = new StringBuffer();
        int startIdx = 0;

        int idxOld;
        for(boolean var5 = false; (idxOld = aInput.indexOf(aOldPattern, startIdx)) >= 0; startIdx = idxOld + aOldPattern.length()) {
            result.append(aInput.substring(startIdx, idxOld));
            result.append(aNewPattern);
        }

        result.append(aInput.substring(startIdx));
        return result.toString();
    }

    public static Object[] Str2ArrayB(String str, int len) {
        List<String> list = new ArrayList();
        int counter = 0;
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if(c < 255) {
                counter += 2;
            } else {
                counter += 2;
            }

            if(counter <= len) {
                sb.append(c);
            } else {
                list.add(sb.toString());
                sb = new StringBuffer();
                sb.append(c);
                counter = c < 255?2:2;
            }

            if(counter > 0 && i == str.length() - 1) {
                list.add(sb.toString());
                sb = new StringBuffer();
                counter -= len;
            }
        }

        return list.toArray();
    }


    public static String tripScript(String str) {
        if(str == null) {
            return null;
        } else {
            str = str.replaceAll("<", "");
            str = str.replaceAll(">", "");
            str = str.replaceAll("'", "");
            str = str.replaceAll("\"", "");
            return str;
        }
    }


    public static byte[] utf2GBK(byte[] srcByte) {
        StringBuffer str = new StringBuffer();
        int len = srcByte.length;
        int count = 0;

        while(count < len) {
            int char1 = srcByte[count] & 255;
            byte char2;
            switch(char1 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    ++count;
                    str.append((char)char1);
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return null;
                case 12:
                case 13:
                    count += 2;
                    if(count > len) {
                        return null;
                    }

                    char2 = srcByte[count - 1];
                    if((char2 & 192) != 128) {
                        return null;
                    }

                    str.append((char)((char1 & 31) << 6 | char2 & 63));
                    break;
                case 14:
                    count += 3;
                    if(count > len) {
                        return null;
                    }

                    char2 = srcByte[count - 2];
                    int char3 = srcByte[count - 1];
                    if((char2 & 192) != 128 || (char3 & 192) != 128) {
                        return null;
                    }

                    str.append((char)((char1 & 15) << 12 | (char2 & 63) << 6 | (char3 & 63) << 0));
            }
        }

        String temp = new String(str);

        try {
            return temp.getBytes("GBK");
        } catch (Exception var9) {
            return null;
        }
    }

    public static String gbk2UTF(String gbkStr) {
        int n = gbkStr.length();
        byte[] utfBytes = new byte[3 * n];
        int k = 0;

        for(int i = 0; i < n; ++i) {
            int m = gbkStr.charAt(i);
            if(m < 128 && m >= 0) {
                utfBytes[k++] = (byte)m;
            } else {
                utfBytes[k++] = (byte)(224 | m >> 12);
                utfBytes[k++] = (byte)(128 | m >> 6 & 63);
                utfBytes[k++] = (byte)(128 | m & 63);
            }
        }

        if(k < utfBytes.length) {
            byte[] tmp = new byte[k];
            System.arraycopy(utfBytes, 0, tmp, 0, k);

            try {
                return new String(tmp, "utf-8");
            } catch (UnsupportedEncodingException var6) {
                var6.printStackTrace();
                return null;
            }
        } else {
            try {
                return new String(utfBytes, "utf-8");
            } catch (UnsupportedEncodingException var7) {
                var7.printStackTrace();
                return null;
            }
        }
    }




    public static final String toHex(byte b) {
        return "" + "0123456789ABCDEF".charAt(15 & b >> 4) + "0123456789ABCDEF".charAt(b & 15);
    }

    public static String toHex(byte[] data) {
        return toHex(data, 0, data.length);
    }

    public static byte[] hexToBytes(String data) {
        try {
            byte[] b = new byte[data.length() / 2];

            for(int i = 0; i < data.length() / 2; ++i) {
                b[i] = (byte)Integer.parseInt(data.substring(i * 2, (i + 1) * 2), 16);
            }

            return b;
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static String toHex(byte[] data, int start, int len) {
        StringBuffer sb = new StringBuffer("");

        for(int i = 0; i < len; ++i) {
            sb.append(toHex(data[start + i]));
        }

        return sb.toString();
    }

    public static String toHex(String data) {
        return toHex(data.getBytes(), 0, data.getBytes().length);
    }

    public static String toStringFromBytes(byte[] data, int start, int len) {
        return toStringFromBytes(data, start, len, "utf-8");
    }

    public static String toStringFromBytes(byte[] data, int start, int len, String encode) {
        byte[] b = new byte[len];

        for(int i = 0; i < len; ++i) {
            b[i] = data[start + i];
        }

        try {
            return new String(b, encode);
        } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public static String invoke(String classname, String strMethod, String paramvalue) {
        try {
            Object callobj = Class.forName(classname).newInstance();
            Class[] classes = new Class[]{String.class};
            Method method = callobj.getClass().getDeclaredMethod(strMethod, classes);
            return (String)method.invoke(callobj, new Object[]{paramvalue});
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public static String invoke(String classname, String strMethod) {
        try {
            Object callobj = Class.forName(classname).newInstance();
            Method method = callobj.getClass().getDeclaredMethod(strMethod, new Class[0]);
            return (String)method.invoke(callobj, new Object[0]);
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static String invoke(String classname, String strMethod, int paramvalue) {
        try {
            Object callobj = Class.forName(classname).newInstance();
            Class[] classes = new Class[]{Integer.class};
            Method method = callobj.getClass().getDeclaredMethod(strMethod, classes);
            return (String)method.invoke(callobj, new Object[]{Integer.valueOf(paramvalue)});
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public static String getJsonData(String strJson, String key) {
        int iStart = strJson.indexOf("\"" + key + "\":");
        if(iStart == -1) {
            return "";
        } else {
            iStart += key.length() + 4;
            int iEnd = strJson.indexOf("\"", iStart);
            return iEnd == -1?"":strJson.substring(iStart, iEnd);
        }
    }
}
