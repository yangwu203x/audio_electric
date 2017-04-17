package com.audio.electric.util.tool;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 工具类
 *
 * @author albert
 * @time 2016年9月27日
 */
public class Tools {
	/**
	 * 加密响应数据
	 * 
	 * @param result
	 * @return
	 */
	public static String encode(String result) {
		try {
			result = Base64.encode(result.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param date
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date = sdf.parse(sdf.format(date));
		Date bdate = new Date(System.currentTimeMillis());
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 判断是否是int
	 */
	public static boolean isInteger(String num) {
		try {
			Integer.parseInt(num);
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}
		return true;
	}





	/**
	 * 判断字符串是否是英文
	 * 
	 * @param word
	 * @return
	 */
	public static boolean strIsEnglish(String word) {
		return word.matches("[a-zA-Z]+");
	}

	public static String getUTF8StringFromGBKString(String gbkStr) {
		try {
			return new String(getUTF8BytesFromGBKString(gbkStr), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new InternalError();
		}
	}

	public static byte[] getUTF8BytesFromGBKString(String gbkStr) {
		int n = gbkStr.length();
		byte[] utfBytes = new byte[3 * n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			int m = gbkStr.charAt(i);
			if (m < 128 && m >= 0) {
				utfBytes[k++] = (byte) m;
				continue;
			}
			utfBytes[k++] = (byte) (0xe0 | (m >> 12));
			utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
			utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
		}
		if (k < utfBytes.length) {
			byte[] tmp = new byte[k];
			System.arraycopy(utfBytes, 0, tmp, 0, k);
			return tmp;
		}
		return utfBytes;
	}

}
