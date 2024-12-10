<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>index</title>

<style type="text/css">
	h2 {display: inline-block; }
	p {display: inline-block; margin-left: 40px; margin-top: -30px;}
	a {text-decoration: none; color: #000;}
	a:hover {color: red;}
	li	{list-style: none; display: inline-block;}
	li:nth-child(3) {display:block; width: 400px; height: 100px; border: 1px solid #000;}
</style>	
	
	
</head>
<body>
<div>
<h2>
	학점<br>관리
</h2>
<p>찾기 : 
  <input type="search" id="searchInput" placeholder="검색하세요.">
</p>
<ul id="searchResults"></ul>

</div>
	
	<a href="/member/login">로그인</a>
	<a href="/member/save">학생등록</a>
 	<ul>
 		<li>학번</li>
 		<li>이름</li>
 		<li></li>
 		<li></li>
 	</ul>
</body>

<script>
  document.getElementById('searchInput').addEventListener('input', function() {
    let query = this.value;
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'list.jsp?searchQuery=' + encodeURIComponent(query), true);
    xhr.onreadystatechange = function() {
      if (xhr.readyState === 4 && xhr.status === 200) {
        document.getElementById('searchResults').innerHTML = xhr.responseText;
      }
    };
    xhr.send();
  });
</script>
</html>
