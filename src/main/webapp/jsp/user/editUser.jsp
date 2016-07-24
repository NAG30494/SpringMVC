<%@page import="java.util.Map"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	function validateAndSubmit(option) {
		document.userForm.option.value = option;
		var isError = false;
		var userName = document.userForm.userName.value;
		var firstName = document.userForm.firstName.value;
		if (option.toString() == 'save') {
			if (userName == '' || firstName == '') {
				isError = true;
				alert('<spring:message code="look.lookupType"/>' + ' & '
						+ '<spring:message code="look.lookupValue"/>'
						+ ' are mandatory ');
			}
		}
		if (!isError) {
			document.getElementById('userForm').submit();
		}
	}
</script>

<div class="col-md-12">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">
				<spring:message code="user.userForm" />
			</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" id="userForm" name="userForm"
				role="form"
				action='${pageContext.request.contextPath}/user/updateUser.htm'
				method="post" commandName="User" autocomplete="false">
				<input type="hidden" name='option' id='option' value=''/>
				<input type="hidden" name='id' id='id' value='${User.id}'>
				<div class="form-group">
					<div class="col-sm-2">
						<label for="firstName" class="control-label"><spring:message
								code="user.first.name" /> </label>
					</div>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="firstName"
							name="firstName"
							placeholder='<spring:message code="user.first.name"/>'
							value='${User.firstName}'>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2">
						<label for="lastName" class="control-label"> <spring:message
								code="user.last.name" />
						</label>
					</div>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="lastName"
							name="lastName"
							placeholder='<spring:message code="user.last.name"/>'
							value='${User.lastName}'>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-2">
						<label for="userName" class="control-label"><spring:message
								code="user.Name" /></label>
					</div>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="userName"
							name="userName" placeholder='<spring:message code="user.Name"/>'
							value='${User.userName}'>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2">
						<label for="user.gender" class="control-label"><spring:message code="user.gender" /></label>
					</div>
					<div class="col-sm-10">
						<select class="form-control" name="gender" id="gender">
						<c:forEach items='${genders}' var='entry' >
						   <option  value=${entry.key}  ${entry.key == User.gender ? 'selected' : ''} >
						   ${entry.value}
						</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-2">
						<label for="generic.role" class="control-label">
						<spring:message code="generic.role" /></label>
					</div>
					<div class="col-sm-10">
					<select class="form-control" name="userRole" id="userRole">
					<c:forEach items='${userRoles}' var='entry' >
						   <option  value=${entry.key}  ${entry.key == User.userRole ? 'selected' : ''} >
						   ${entry.value}
						</c:forEach>
						</select>
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-2">
						<label for="user.gender" class="control-label"><spring:message
								code="generic.description" /></label>
					</div>
					<div class="col-sm-10">
						<textarea id="userDescription" name="userDescription" cols="70"
							rows="5"
							placeholder='<spring:message code="generic.description"/>'
							> ${User.userDescription} </textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label> <input type='checkbox' id='isActive'
								name='isActive' checked='${User.isActive}'>
							<spring:message code="generic.isActive" /></label>
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button class="btn btn-default" onClick="validateAndSubmit('save')">
							<spring:message code="generic.Save" />
						</button>
						<c:choose>
							<c:when test="${User.id>0}">
                  <button class="btn btn-default" onClick="validateAndSubmit('delete')" ><spring:message code="generic.Delete"/></button>
                  <input type="hidden" name='createdOn' id='createdOn' value='${User.createdOn}'/>
					<input type="hidden" name='createdBy' id='createdBy' value='${User.createdBy}'/>
					<input type="hidden" name='lastModOn' id='lastModOn' value='${User.lastModOn}'/>
					<input type="hidden" name='lastModBy' id='lastModBy' value='${User.lastModBy}'/>
					<input type="hidden" name='lockTs' id='lockTs' value='${User.lockTs}'/>
                  </c:when>
				</c:choose>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>