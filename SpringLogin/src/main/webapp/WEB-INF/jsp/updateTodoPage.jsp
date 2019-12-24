<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="container">
	<form:form method="post" modelAttribute="todo">
		<fieldset class="form-group">
			<table class="table table-striped">

				<thead>
					<tr>
						<th>Id</th>
						<th>Course</th>
						<th>End Date</th>
						<th>Is it Done</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${todo.id}</td>
						<td><form:input path="course" type="text"
								class="form-control" required="required" /></td>
						<td><form:input path="date" type="text" class="form-control"
								required="required" /></td>
						<%-- <td>${todo.isdone}</td> --%>
						<td><c:choose>
								<c:when test="${todo.isdone==true}">
									<input type="checkbox" name="isdone" checked />
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="isdone" />
								</c:otherwise>
							</c:choose></td>
						<td><form:button type="submit" class="btn btn-success">Submit</form:button>
					</tr>
					<tr>
						<td></td>
						<td><form:errors path="course" cssClass="text-warning"></form:errors></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>
