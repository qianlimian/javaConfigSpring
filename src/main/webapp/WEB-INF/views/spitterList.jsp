<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpitterList</title>
<style type="text/css">
a:link,a:visited {
	text-decoration:none;
}
a:hover {
	text-decoration:underline;
}
</style>
<!-- 如果需要引用本地的jquery文件，需要加入对静态资源的处理 -->
<!-- 如何在javaConfig中加入对静态资源的处理 -->
<script type="text/javascript"
	src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var saveDataArray = [];
		var one = {"firstName":"wang","lastName":"haidong"};
		var two = {"firstName":"yu","lastName":"jiaojiao"};
		saveDataArray.push(one);
		saveDataArray.push(two);
		
		$("button").click(function(){
			$.ajax({
				type:"POST",
				url:"testResponseBody",
				dataType:"json",
				contentType:"application/json",
				data:JSON.stringify(saveDataArray),
				success:function(data){
					for(var i = 0 ;i<data.length;i++){
						console.log(data[i].firstName+" "+data[i].lastName);
						$("#one").append("<h1>"+data[i].firstName+" "+data[i].lastName+"</h1>");
					}
				}
			});
		});
		
		
		$("a").click(function(){
			console.log($("a").attr("href"));
			$("a").attr("href","spitterList");
		});
	});
</script>
</head>
<body>
	This is SpitterList.
	<br />
	<button>Ajax</button>
	<div id="one"></div>
	<br />
	<a href="#">Clear</a>
	
</body>
</html>