<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.Arrays"%>
<%@page import="org.springmvc.web.utils.AppUtils"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<link
	href="${pageContext.request.contextPath}/static/font/font-awesome.min.css"
	rel="stylesheet" type="text/css">
	<link
		href="${pageContext.request.contextPath}/static/css/bootstrap.css"
		rel="stylesheet" type="text/css">
		<link
			href="${pageContext.request.contextPath}/static/css/simple-sidebar.css"
			rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String[] val = null;
	%>
	<%-- <tiles:insertAttribute name="menu" /> --%>

	<div class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-ex-collapse">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>Spring MVC</span></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a
						href="${pageContext.request.contextPath}/home">Home</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/displayAllUser.htm">User</a></li>
					<li><a
						href="${pageContext.request.contextPath}/lookup/lookup.htm">Lookup</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- navigation bar -->
	<%-- 
	<div class="section">
		<div class="container">
			<div class="row">

				<%if( !AppUtils.getInstance().isEmpty(AppUtils.getInstance().getRequestAttribute(request,"ErrorMsg"))){ 
				 val= AppUtils.getInstance().getRequestAttribute(request, "ErrorMsg").split("~");	
				 %>
				<div class="alert alert-danger" role="alert">
					<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>Error
						!</strong>
					<% if(val != null && val.length>1){ %>
					<spring:message code='<%=val[0]%>' arguments="<%=val[1] %>"
						htmlEscape="false" />
					<%}else{ %>
					<spring:message code='<%=val[0]%>' htmlEscape="false" />
					<%} %>
				</div>
				<%}else if( !AppUtils.getInstance().isEmpty(AppUtils.getInstance().getRequestAttribute(request,"SuccessMsg"))){ %>
				<%  val= AppUtils.getInstance().getRequestAttribute(request, "SuccessMsg").split("~"); 
				%>
				<div class="alert alert-success fade in" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>Success !</strong>
					<% if(val != null && val.length>1){ %>
					<spring:message code='<%=val[0]%>' arguments="<%=val[1] %>"
						htmlEscape="false" />
					<%}else{ %>
					<spring:message code='<%=val[0]%>' htmlEscape="false" />
					<%} %>
				</div>
				<%}%> --%>
	<div id="wrapper">
		<tiles:insertAttribute name="content-menu" />
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="col-lg-12">
					<tiles:insertAttribute name="body" />
					<footer class="footer">
					<div class="container">
						<p class="text-muted">
							&copy; Copyright <a href="#">boddu.nageswar@hotmail.com</a>
						</p>
					</div>
					</footer>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	</div>

	</div>
</html>