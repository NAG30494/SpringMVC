<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>BlankSpace</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="static/script/cufon-yui.js"></script>
<script type="text/javascript" src="static/script/arial.js"></script>
<script type="text/javascript" src="static/script/cuf_run.js"></script>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="index.html"><span>My</span>Spring Journey<small>learning spring</small></a></h1>
      </div>
      <div class="search">
        <form id="form1" name="form1" method="post" action="#">
          <span>
          <input name="q" type="text" class="keywords" id="textfield" maxlength="50" value="Search..." />
          </span>
        </form>
      </div>
      <div class="clr"></div>
      <div class="menu">
        <ul>
          <li><a href="index.html" class="active"><span>Home</span></a></li>
          <li><a href="#"><span>Services</span></a></li>
          <li><a href="#"><span>About Us </span></a></li>
          <li><a href="#"><span>Contact Us</span></a></li>
        </ul>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
    </div>
    
  <div class="body">
    <div class="body_resize">
    <tiles:insertAttribute name="body" />
</div>
  
  </div>
  <div class="footer">
    <div class="footer_resize">
      <p class="lf">&copy; Copyright <a href="#">boddu.nageswar@hotmail.com</a>.</p>
      <p class="rf">Layout by Hot <a href="http://www.hotwebsitetemplates.net/">Website Templates</a></p>
      <div class="clr"></div>
    </div>
    <div class="clr"></div>
  </div>
</div>
</html>
