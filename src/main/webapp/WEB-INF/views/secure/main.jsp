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

<a href="lisaaUusiPelaaja"><button class="button">Lisää pelaaja</button></a>
<a href="lisaa"><button class="button">Lisää uusi ottelu</button></a>
<a href="../j_spring_security_logout" style="float: right;"><button class="button">Kirjaudu ulos</button></a><br>
<span style="float: right;">Sisäänkirjautuneena: <sec:authentication property="principal.username"/></span>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<%-- Tähän voi implementtaa vaikka adminhässäkät --%>
</sec:authorize>
<div class="wrap">
	<div class="container1">
				<div class="card">
					<div class="cardHeader">Pelaajalistaus</div>
						<c:forEach var="data" items="${pelaajat}">
							<div class="cardData">${data.name}</div>
						</c:forEach>
				</div>
				
				<div class="card">
					<div class="cardHeader">Pistelistaus</div>
						<c:forEach var="data" items="${pisteet}">
							<div class="cardData">${data.pisteet} ${data.name}</div>
						</c:forEach>
					</div>			
	

			<c:forEach var="o_data" items="${ottelut}" varStatus="status">
					<div class="card">
						<div class="cardHeader">Ottelu #${o_data.match_id} / ${o_data.match_date}</div>
						<div class="cardData"> ${o_data.pelaaja_1.name} vs ${o_data.pelaaja_2.name} </div>
						<div class="cardData"> Tulos: ${o_data.result} </div>
						<div class="cardData">Voittaja <span class="winner">${o_data.voittaja.name}</span></div>
					</div>	
			</c:forEach>
		</div>
</div>
	

</body>
</html>