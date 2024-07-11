package com.min.edu.ctrl;

import java.io.IOException;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WeatherXMLServlet extends HttpServlet {

	
	private static final long serialVersionUID = 7745002611691526321L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("WeatherXMLServlet 서버에서 jsoup을 통한 요청 처리");
		
		String url = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000";
		
		Document doc = Jsoup.connect(url).get();
		System.out.println(doc);
		
		Elements ele1 = doc.select("body>data");
//		System.out.println(ele1);
		for(Element elem : ele1) {
			System.out.printf("시간 : %s , 날씨 : %s \n", elem.select("hour").text(), elem.select("wfKor").text());
		}
	}
	
	
	
}
