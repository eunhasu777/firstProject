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
			<th>NO</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
		<c:forEach var="freeBoard" items="${result}">
		<tr>
			<td>${freeBoard.boardId}</td>
			<td>${freeBoard.writer}</td>
			<td><a href="selectOne?boardId=${freeBoard.boardId}">${freeBoard.title}</td>
			<td>${freeBoard.content}</td>
			<td>${freeBoard.update}</td>
		</tr>
		</c:forEach>
		<button type="button" onclick="updateBoard()">글쓰기</button> <br>
	</table>
</body>
<script type="text/javascript">
    function updateBoard(){
        location.href = "/freeBoard/updateBoard";
    }
</script>
</html>