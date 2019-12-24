<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">

	<table class="table table-striped">
		<H1>Name : ${name}</H1>

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
			<c:forEach items="${todo}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.course}</td>
					<td><fmt:formatDate value="${item.date}" pattern="MM/dd/yyyy" /></td>
					<td>${item.isdone?'Yes':'No'}</td>
					<td><a type="button" class="btn btn-success"
						href="/update-Todo?id=${item.id}">Update</a></td>
					<td><a type="button" class="btn btn-warning"
						href="/delete-Todo?id=${item.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div>
		<a type="button" href="/add-Todo" class="btn btn-success">Add a
			Todo</a>
	</div>
</div>

<%@ include file="common/footer.jspf"%>