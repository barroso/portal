<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${locale}"/>
<c:set var="ctx">${pageContext.request.contextPath}</c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Portal</title>
		<link href="${ctx}/css/admin.css" rel="stylesheet" type="text/css" media="screen" />
	    <script src='<c:url value="/js/jquery/jquery-1.4.2.min.js"/>'></script>
	</head>
	<body>
		<c:if test="false">
			<div id="headerWrap">
		    	<div id="headerContent">
		        </div>
		    </div>
	    </c:if>
	    <c:if test="${usuarioAdmin.logado}">
		    <div id="userInfo">
		    	<p>${usuarioWeb.login} - <a href="${ctx}/logout">Logout</a></p>
		    </div>
		    <div id="menuWrap">
		    	<ul id="menuElementsEn">
		        	<li><a href="${ctx}"><span>Home</span></a></li>
		        	<li>
		        		<c:url var="logs_url" value="/logs"/>
		        		<a href="${logs_url}"><span>Logs</span></a>
		        	</li>
		        </ul><!-- menuElements-->
		    </div><!-- menuWrap-->
	    </c:if>
		<c:if test="${not empty errors}">
			<div id="errors">
				<ul>
					<c:forEach items="${errors }" var="error">
						<li>${error.message }</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		<c:if test="${not empty notice}">
			<div id="notice">
				<p>${notice }</p>
			</div>
		</c:if>
		<div id="contentWrap">