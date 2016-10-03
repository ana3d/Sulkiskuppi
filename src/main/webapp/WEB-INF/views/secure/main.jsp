<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pääsivu</title>
<link rel="stylesheet" type="text/css"
	href="../resources/main.css">
</head>
<body>
<p><a href="../j_spring_security_logout" style="float: right;"> Kirjaudu ulos</a></p>
<h3>Sisäänkirjautuneena: <sec:authentication property="principal.username"/></h3>


<sec:authorize access="hasRole('ROLE_ADMIN')">
<p><a href="admin/tools">Admin tools</a></p>
</sec:authorize>

<div class="wrap">

	<div class="container2">

	<div class="tableDiv">
		<table class="printTable">
				<tr>
				<th>Pelaajalistaus</th>
				</tr>
			<c:forEach var="data" items="${pelaajat}">
				<tr>
					<td><span>${data.name}</span></td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<div class="tableDiv">
		
		<fieldset>
		<legend>Lisää tietoja</legend>
		<p><a href="lisaaUusiPelaaja"><button class="button">Lisää pelaaja</button></a></p>
		<p><a href="lisaa"><button class="button">Lisää uusi ottelu</button></a></p>
		</fieldset>
	</div>		
		
		
		

	
		<div class="tableDiv">
		
			<table class="printTable">
				<tr>
					<th colspan="2"> Pistelistaus</th>
				</tr>
				<c:forEach var="data" items="${pisteet}">
				<tr>
					<td><span>${data.pisteet}</span></td>
					<td><span>${data.name}</span></td>
				</tr>
				</c:forEach>			
			</table>
		</div>
	
	</div>
		
		<div class="container1">	
			<c:forEach var="o_data" items="${ottelut}" varStatus="status">
				<div class="div"><b>
					Ottelunro ${o_data.match_id}<br> ${o_data.pelaaja_1.name} VS ${o_data.pelaaja_2.name}<br>
					<font color="green">Voittaja ${o_data.voittaja.name}</font><br>
					Tulos: ${o_data.result} <b>Päiväys: ${o_data.match_date}</b>
				</div>	
			</c:forEach>
		</div>		
	</div>



</body>
</html>