package com.audio.electric.util.upload;


import com.audio.electric.domain.Range;
import com.audio.electric.util.constant.Constant;
import com.audio.electric.util.tool.Tools;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IoUtil {
	/**
	 * 确保最终生成的文件目录是存在的并根据文件名构建文件句柄
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public static File getFile(String filename) throws Exception {
		if ((filename == null) || (filename.isEmpty()))
			return null;
		String name = filename.replaceAll("/", Matcher.quoteReplacement(File.separator));
		File f = new File(Tools.propertiesFileResolve(Constant.SONGFILELOCATION) + Constant.FILE_SEPLATOR + name);
		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();
		if (!f.exists()) {
			f.createNewFile();
		}
		return f;
	}

	/**
	 * 通过口令生成上传片段文件并逐步将上传的文件片段追加
	 * @param token
	 * @return
	 * @throws IOException
	 */
	public static File getTokenedFile(String serverPath, String token) throws Exception {
		if ((token == null) || (token.isEmpty())) {
			return null;
		}
		//创建文件对象
		File f = new File(serverPath+Constant.FILE_SEPLATOR+ token);
		/*File f = new File(serverPath+File.separator+Tools.propertiesFileResolve(Const.SONGFILELOCATION) + File.separator + token);*/
		//检查存放文件的目录是否存在
		if (!f.getParentFile().exists())
			f.getParentFile().mkdirs();
		//如果不存在通过口令生成的上传片段文件则该文件是第一次上传，则创建一个新文件
		if (!f.exists()) {
			f.createNewFile();
		}
		return f;
	}

	/**
	 * 关闭流
	 * @param stream
	 */
	public static void close(Closeable stream){
		try {
			if (stream != null)
				stream.close();
		} catch (IOException localIOException) {
		}
		stream=null;
	}

	public static Range parseRange(HttpServletRequest req) throws Exception {
		//获取头信息中的上传内容的文件上传大小信息
		String rangeStr = req.getHeader("content-range");
		Pattern rangePattern = Pattern.compile("bytes \\d+-\\d+/\\d+");
		long from=0L;
		long to=0L;
		long size=0L;
		if(rangeStr!=null){
			Matcher m = rangePattern.matcher(rangeStr);
			if (m.find()) {
				rangeStr = m.group().replace("bytes ", "");
				String[] rangeSize = rangeStr.split("/");
				String[] fromTo = rangeSize[0].split("-");
				//处理请求头中的文件信息
				from = Long.parseLong(fromTo[0]);
				to = Long.parseLong(fromTo[1]);
				size = Long.parseLong(rangeSize[1]);
				return new Range(from, to, size);
			}
		}
		return new Range(from, to, size);
	}

	public static long streaming(InputStream in, String key, String fileName) throws Exception {
		OutputStream out = null;
		File f = getTokenedFile("",key);
		try {
			out = new FileOutputStream(f);

			int read = 0;
			byte[] bytes = new byte[10485760];
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
		} finally {
			close(out);
		}

		File dst = getFile(fileName);
		dst.delete();
		f.renameTo(dst);

		long length = getFile(fileName).length();

		return length;
	}
}