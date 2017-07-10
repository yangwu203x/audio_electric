package com.audio.electric.util.tool;

import com.audio.electric.util.constant.Constant;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

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
	 * 属性文件解析,根据属性名在属性文件中获取属性值
	 * @param propertyName
	 * proLocation .properties所在的文件位置
	 * @return
	 * @throws Exception
	 */
	public static String propertiesFileResolve(String propertyName) throws Exception{
		//实例化属性文件对象
		Properties properties=new Properties();
		//获取流
		InputStream stream=Tools.class.getResourceAsStream(Constant.PROPERTIESFILENAME);
		//加载流
		properties.load(stream);
		//根据所给的属性名获取值
		return properties.getProperty(propertyName);
	}

	/**
	 * 计算文件夹下文件数量不超过10000的文件夹的名字
	 */
	public static String obtainDirectoryName(String rootPath){
		File rootDir=new File(rootPath);
		//获取指定根文件夹下的所有文件夹
		File[] dirs=rootDir.listFiles();
		File destDir=null;
		File tempDir=null;
		String savePath=null;
		for (int i = 0;dirs != null && i < dirs.length; i++) {
			tempDir=dirs[i];
			//获取这些文件夹下拥有10000个文件的文件夹对象
			if(tempDir.isDirectory()&&tempDir.listFiles().length<10000){
				destDir=tempDir;
			}
			tempDir=null;
		}
		if(destDir==null){
			savePath=System.currentTimeMillis()+"";
			destDir=new File(rootPath + File.separator + savePath);
			if(!destDir.exists()){
				destDir.mkdirs();
			}
		}else{
			savePath=destDir.getName();
		}
		dirs=null;
		rootDir=null;
		//返回该文件夹的名字
		return savePath;
	}

	/**
	 * 产生一个新的文件名
	 * @return
	 * @throws Exception
	 */
	public static String fileRename(String fileName) throws Exception{
		UUID uuid=UUID.randomUUID();
		//获取uuid
		String uuidString=uuid.toString();
		//去掉所有的-
		uuidString=uuidString.replaceAll("-","");
		//去一半长度
		uuidString=	uuidString.substring(uuidString.length()/2, uuidString.length());

		return uuidString+"."+obtainFileSuffix(fileName);
	}

	/**
	 * 根据所给的文件名获取文件的名称不包含后缀
	 * @param fileName
	 * @return xx.* 返回xx
	 * @throws Exception
	 */
	public static String obtainFileName(String fileName) throws Exception{
		//找寻最后一个.所在的位置
		int startIndex=fileName.lastIndexOf(".");
		return fileName.substring(0,startIndex);
	}

	/**
	 * 根据所给的文件名获取文件的后缀
	 * @param fileName
	 * @return .* 如.png
	 * @throws Exception
	 */
	public static String obtainFileSuffix(String fileName) throws Exception{
		//找寻最后一个.所在的位置
		int startIndex=fileName.lastIndexOf(".");
		String fileSuffix=fileName.substring(startIndex+1,fileName.length());
		return fileSuffix;
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
