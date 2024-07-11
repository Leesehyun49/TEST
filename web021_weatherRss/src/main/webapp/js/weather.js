window.onload = function(){
	document.getElementById("cors").onclick=function(){
		console.log("jQuery Ajax를 실행하여 직접 공공데이터를 호출 CORS 문제")
		$.ajax({
			url:"https://www.kma.go.kr/wid/queryDFSRSS.jsp",
			type:"post",
			data:{zone:1154551000},
			dataType:"xml",
			success:function(){
				console.log(typeof data, data);
			},
			error:function(){
				alert("잘못된 요청 입니다")
			}
		});
	}
	
	document.getElementById("xmlView").onclick=function(){
		location.href="./weatherXML.do";
	}
	
	$("#weatherView").click(function(){
		var code = $("#address option:selected").val();
		console.log("선택된 지역코드",code);
		
		$.ajax({
			url:"./weatherOpen.do",
			type:"get",
			data:{zone:code},
			dataType:"text",
			success:function(data){
				//let obj = JSON.parse(data);
				//console.log(typeof obj, obj, obj.test);
				let obj = JSON.parse(data);
				console.log(obj , obj.pubDate);
				$("#pop").val(obj.pop);
				$("#pubDate").val(obj.pubDate);
				$("#reh").val(obj.reh);
				$("#wfKor").val(obj.wfKor);
				$("#temp").val(obj.temp);
				
				var weather_icon = obj.wfKor;
				switch(weather_icon){
					case "맑음": $("#weatherImg").attr("src","./image/Clear.png"); break;
					case "구름 조금": $("#weatherImg").attr("src","./image/Partly_Cloudy.png"); break;
					case "구름 많음": $("#weatherImg").attr("src","./image/Mostly_Cloudy.png"); break;
					case "흐림":$("#weatherImg").attr("src","./image/Cloudy.png"); break;
					case "비": $("#weatherImg").attr("src","./image/Rain.png"); break;
					case "눈/비": $("#weatherImg").attr("src","./image/Snow_Rain.png"); break;
					case "눈": $("#weatherImg").attr("src","./image/Snow.png"); break;
				}
				
			},
			error:function(){
				alert("잘못된 요청 처리");
			}
			
		});
		
		
	});
	
}