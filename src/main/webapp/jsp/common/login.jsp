<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script>
	function validateAndSubmit() {
		var isError = false;
		var userName = document.loginForm.j_username.value;
		var userPassword = document.loginForm.j_password.value;
		if (userName == '' || userPassword == '') {
			isError = true;
			alert('Password should not be empty');
		}
		if (!isError) {
			document.getElementById('loginForm').action = '${pageContext.request.contextPath}/loginAction.htm';
			document.getElementById('loginForm').method = "post";
			document.getElementById('loginForm').submit();
		}
	}
</script>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<p>
					Enter your Login User Name and Password to explore features of Spring MVC
				</p>
			</div>
			<div class="col-md-8">
				<form class="form-horizontal" role="form" id="loginForm" name="loginForm" >
					<div class="form-group">
						<div class="col-sm-2">
							<label for="j_username" class="control-label" ><spring:message code="user.Name"/></label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="j_username" name="j_username"  placeholder='<spring:message code="user.Name"/>' value='springmvc'">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="inputPassword3" class="control-label"><spring:message code="user.password"/></label>
						</div>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="j_password" name="j_password" placeholder='<spring:message code="user.password"/>' value='springmvc'>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label> <input type="checkbox">Remember me
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default" onClick="validateAndSubmit();">Sign in</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>