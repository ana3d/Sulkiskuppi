<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lisää uusi ottelu</title>
<link rel="stylesheet" type="text/css" href="../resources/main.css">
<link rel="stylesheet" type="text/css" href="../resources/jquery-ui.css" />
</head>
    <script src="../resources/js/jquery.min.js"></script>
    <script src="../resources/js/jquery-ui.min.js"></script>
    <script src="../resources/js/jquery.ui.timepicker.js"></script>
    <script src="../resources/js/ui.datepicker-fi.js"> </script>
    <script src="../resources/js/bootstrap.min.js"></script>
    <script src="../resources/js/generic.js"></script>
<body>
<p><a href="../j_spring_security_logout" style="float: right;"><button class="button">Kirjaudu ulos</button></a></p>
<h3>Sisäänkirjautuneena: <sec:authentication property="principal.username"/></h3>
		
				<form:form modelAttribute="ottelu" method="post">
		  	<fieldset>		
				<legend><spring:message code="ottelu.create.legend" /></legend>
				
				<spring:hasBindErrors name="ottelu">
					<p class="Virheotsikko"><spring:message code="ottelu.create.errors" />:</p>
					<div class="Virheblokki"><form:errors path="*"/></div>
				</spring:hasBindErrors>
				
				<p>
					<form:label	path="player_1_id"><spring:message code="ottelu.create.player_1" /></form:label><br/>
					<select name="player_1_id">
						<c:forEach var="data" items="${pelaajat}">
							<option value=${data.id}>${data.name}</option>
						</c:forEach>
					</select>
					<form:errors path="player_1_id" cssClass="Virheteksti"/>		
				</p>
				
				<p>
					<form:label	path="player_1_score"><spring:message code="ottelu.create.player_1_score" /></form:label><br/>
					<form:input path="player_1_score" cssErrorClass="VirheellinenKentta"/> <br>
					<form:errors path="player_1_score" cssClass="Virheteksti"/>		
				</p>
				
				<p>
					<form:label	path="player_2_id"><spring:message code="ottelu.create.player_2" /></form:label><br/>
					<select name="player_2_id">
						<c:forEach var="data" items="${pelaajat}">
							<option value=${data.id}>${data.name}</option>
						</c:forEach>
					</select>
					<form:errors path="player_2_id" cssClass="Virheteksti"/>		
				</p>
				
				<p>
					<form:label	path="player_2_score"><spring:message code="ottelu.create.player_2_score" /></form:label><br/>
					<form:input path="player_2_score" cssErrorClass="VirheellinenKentta"/> <br>
					<form:errors path="player_2_score" cssClass="Virheteksti"/>		
				</p>
				
				<p>
					<form:label	path="match_date"><spring:message code="ottelu.create.match_date" /></form:label><br/>
					<form:input path="match_date" cssErrorClass="VirheellinenKentta"/> <br>
					<form:errors path="match_date" cssClass="Virheteksti"/>		
				</p>
				

				
				
				
<%-- 				
				<p>
					<form:label	path="result"><spring:message code="ottelu.create.result" /></form:label><br/>
					<form:input path="result" cssErrorClass="VirheellinenKentta"/> <br>
					<form:errors path="result" cssClass="Virheteksti"/>		
				</p>
				
				<p>
					<form:label	path="winner_id"><spring:message code="ottelu.create.winner" /></form:label><br/>
					<select name="winner_id">
						<c:forEach var="data" items="${pelaajat}">
							<option value=${data.id} >${data.name}</option>
						</c:forEach>
					</select>
					<form:errors path="winner_id" cssClass="Virheteksti"/>		
				</p>
--%>				
				


				<p>	
					<button type="submit" class="button"><spring:message code="ottelu.create.add" /></button>
				</p>
				<p>
				
				</p>
			</fieldset>
		</form:form>
		<a href="main"><button class="button">Peruuta</button></a>
		
		

</body>
</html>