<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
			<form:form method="post" modelAttribute="todoa">
			<fieldset class="form-group">
				<form:label path="course">Course</form:label>
				<form:input path="course" type="text" class="form-control" required="required" />
				<form:errors path= "course" cssClass="text-warning"/>
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="date">Target Date</form:label>
				<form:input path="date" type="text" class="form-control" required="required" />
				<form:errors path= "date" cssClass="text-warning"/>
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>
		<%@ include file="common/footer.jspf" %>
	