<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<font color="red">${message}</font>
		<form:form method="post" action="/login">
			<fieldset class="form-group">
				Name : <input type="text" name="name" class="form-control" />
				Password: <input type="password" name="password"
					class="form-control" />
			</fieldset>
			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>
<%@ include file="common/footer.jspf" %>