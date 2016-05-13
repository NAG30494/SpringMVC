<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
 function submitForm(id){
	 var form = document.createElement("form");
	 document.body.appendChild(form);
	 form.method = "POST";
	 form.action = '${pageContext.request.contextPath}/lookup/editLookup.htm';
	 var element = document.createElement("INPUT");         
	    element.name='id';
	    element.value = id;
	    element.type = 'hidden';
	    form.appendChild(element);
	 form.submit(); 
}
</script>

<div class="panel panel-primary">
	<div class="panel-heading">
		<div class="panel-heading">
                <div class="btn-group pull-right">
                  <a href="${pageContext.request.contextPath}/lookup/editLookup.htm" class="btn btn-default btn-xs" ><span class="glyphicon glyphicon-plus-sign"></span></a>
                </div>
                <h4 class="panel-title"> <spring:message code="look.showLookup"/></h4>
              </div>
	</div>
	<div class="panel-body">
		<table class="table">
			<thead>
				<tr>
					<th> <spring:message code="look.lookupType"/></th>
					<th> <spring:message code="look.lookupValue"/> </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${allLookups}' var='element'>
					<tr>
						<td>${element.lookupType}</td>
						<td><a href="#" onclick="submitForm(<c:out value='${element.id}'/>)" >${element.lookupValue}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
