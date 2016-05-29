<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="org.springmvc.web.utils.AppUtils"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <script type="text/javascript" src="static/js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
        <link href="static/font/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="static/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<!--  Page Header -->
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="jumbotron">
						<h1>Learning Spring MVC</h1>						
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12"></div>
							<%if( !AppUtils.getInstance().isEmpty(AppUtils.getInstance().getRequestAttribute(request,"ErrorMsg"))){ %>
		<div class="alert alert-danger">
		 <strong>Error !</strong>
  				<!--  ${requestScope.ErrorMsg} -->
  				<spring:message code='${requestScope.ErrorMsg}'/>
</div>
<%}%>
				 <tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
<footer class="footer">
      <div class="container">
        <p class="text-muted">&copy; Copyright <a href="#">boddu.nageswar@hotmail.com</a></p>
      </div>
    </footer>
</html>
