<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>freeBoard</title>
</head>
<body>
	<table border="2">
		<form action="/updateBoard" method="POST">
			<tr>
				<td>제목</td>
				<td><input type="text" style="width: 400px;" name="title" placeholder="제목을 입력하세요" /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" style="width: 400px;" name="writer"/></td>
			</tr>
			<tr>	
				<td>일자</td>
				<td><input type="date" style="width: 400px;" name="writer" id="now_date"/></td>
			</tr>
			<tr>	
				<td>내용</td>
				<td><textarea name="contents" rows="10" cols="50" placeholder="내용을 입력하세요" ></textarea></td>
			</tr>
		</form>
	</table>
	<button type="submit" onclick="saveData()">제출하기</button>
</body>
<script type="text/javascript">
    function saveData(){
        location.href = "/freeBoard/saveData";
    }
    document.getElementById('now_date').valueAsDate = new Date();
</script>
</html>