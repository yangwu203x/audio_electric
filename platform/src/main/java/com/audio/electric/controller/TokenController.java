package com.audio.electric.controller;

import com.audio.electric.util.upload.IoUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 口令controller
 * @author albert
 */
@Controller
public class TokenController extends BaseController{
	/**
	 * 为文件上传生成token
	 * @throws Exception
	 */
	@RequestMapping("/obtainToken")
	public void obtainToken(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String name = req.getParameter("name");
		String size = req.getParameter("size");
		//根据上传的文件名生成口令
		String token = generateToken(name, size);
		PrintWriter writer = resp.getWriter();
		JSONObject json = new JSONObject();
		try {
			json.put("token", token);
			json.put("success", true);
			json.put("message", "");
		} catch (JSONException localJSONException) {
		}
		writer.write(json.toString());
		IoUtil.close(writer);
	}
	/**
	 * 根据名字hashcode来生成token
	 * @param name
	 * @param size
	 * @throws Exception
	 */
	private String generateToken(String name, String size) throws Exception {
		if ((name == null) || (size == null))
			return "";
		int code = name.hashCode();
		String token = (code > 0 ? "A" : "B") + Math.abs(code) + "_" + size.trim();
		return token;
	}
}