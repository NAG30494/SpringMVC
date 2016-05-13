<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
 function submitForm(id){
	 var form = document.createElement("form");
	 document.body.appendChild(form);
	 form.method = "POST";
	 form.action = '${pageContext.request.contextPath}/user/editUser.htm';
	 var element = document.createElement("INPUT");         
	    element.name='userId';
	    element.value = id;
	    element.type = 'hidden';
	    form.appendChild(element);
	 form.submit(); 
}
</script>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title"><spring:message code="user.display.users"/></h3>
	</div>
	<div class="panel-body">
		<table class="table table-bordered table-condensed table-hover table-striped">
			<thead>
				<tr>
					<!--  <th>#</th> -->
					<th><spring:message code="user.Name"/></th>
					<th><spring:message code="user.first.name"/></th>
					<th><spring:message code="user.last.name"/></th>
					<th><spring:message code="generic.role"/></th>
					<th><spring:message code="user.gender"/></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${allUsers}' var='element'>
					<tr>
						<!-- <td>${element.id}</td> -->
						<td>${element.userName}</td>
						 <form class="form-horizontal" action='${pageContext.request.contextPath}/user/editUser.htm' method="post" commandName="User" autocomplete="false">
			<input type="hidden" name='id' id='id' value='${element.id}'>
						<td><a href ="#" onClick="submitForm('${element.id}')" >${element.firstName}</td></a>
						<td>${element.lastName}</td>
						<td>${userRoles[element.userRole]}</td>
						<td>${genders[element.gender]}</td>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
