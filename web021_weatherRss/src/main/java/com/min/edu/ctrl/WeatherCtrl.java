package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WeatherCtrl extends HttpServlet {

	private static final long serialVersionUID = -5982128587639515540L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String zone = req.getParameter("zone");
		System.out.println("전달받은 요청값 : " + zone);
		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("test", "테스트");
//		JSONObject json = new JSONObject(map);
//		System.out.println("json text : " + json.toJSONString());
//		resp.getWriter().print(json.toJSONString());
		
		req.setAttribute("zone", zone);
		req.getRequestDispatcher("/weatherjson.jsp").forward(req, resp);
	}
	
}
