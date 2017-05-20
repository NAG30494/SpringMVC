<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
function validateAndSubmit(option) {
	document.lookupForm.option.value=option;
	var isError = false;
	var lookupType = document.lookupForm.lookupType.value;
	var lookupValue = document.lookupForm.lookupValue.value;
	if(option.toString()=='save'){
		if (lookupType == '' || lookupValue == '') {
			isError = true;
			alert('<spring:message code="look.lookupType"/>'+' & '+'<spring:message code="look.lookupValue"/>'+' are mandatory ');
		}
	}
	if (!isError) {
		alert("submitting the form"+option);
		document.getElementById('lookupForm').submit();
	}
	}
	</script>
<div class="col-md-12">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title"><spring:message code="lookup.lookup"/></h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" id="lookupForm" name="lookupForm"  role="form" action='${pageContext.request.contextPath}/lookup/saveLookup.htm' method='post' commandName='Lookup' autocomplete='false'>
			<input type="hidden" name='id' id='id' value='${Lookup.id}'>
			<input type="hidden" name='option' id='option' value=''/>
				<div class="form-group">
					<div class="col-sm-2">
							<label for="lookupType" class="control-label"><spring:message code="look.lookupType"/></label>
					</div>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="lookupType" name="lookupType" placeholder='<spring:message code="look.lookupType"/>' value='${Lookup.lookupType}'>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2">
						<label for="lookupType" class="control-label"><spring:message code="look.lookupValue"/></label>
					</div>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="lookupValue" name="lookupValue"
							placeholder='<spring:message code="look.lookupValue"/>' value='${Lookup.lookupValue}'>
					</div>
				</div>
				
				<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label> <input type='checkbox' id='isActive' name='isActive' checked='${Lookup.isActive}' ><spring:message code="generic.isActive"/></label>
							</div>
						</div>
					</div>
				
		 <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button class="btn btn-default" onClick="validateAndSubmit('save')" > <spring:message code="generic.Save"/> </button>
                   <c:choose>
				<c:when test="${Lookup.id>0}">
                  <button class="btn btn-default" onClick="validateAndSubmit('delete')" ><spring:message code="generic.Delete"/></button>
                  <input type="hidden" name='createdOn' id='createdOn' value='${Lookup.createdOn}'/>
					<input type="hidden" name='createdBy' id='createdBy' value='${Lookup.createdBy}'/>
					<input type="hidden" name='lastModOn' id='lastModOn' value='${Lookup.lastModOn}'/>
					<input type="hidden" name='lastModBy' id='lastModBy' value='${Lookup.lastModBy}'/>
					<input type="hidden" name='lockTs' id='lockTs' value='${Lookup.lockTs}'/>
                  </c:when>
				</c:choose>
                </div>
              </div>
				</form>
		</div>
	</div>

