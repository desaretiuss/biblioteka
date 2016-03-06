<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<s:include value="Header.jsp" />


<body style="overflow-y: hidden">

	<div class="container" style="margin-left: 300px; margin-top: -150px;">

		<form role="form" class="form-horizontal" method="post"
			action="removeBook">

			<div class="form-group">
				<div class="col-sm-3">
					<label>ISBN e Librit</label><input class="form-control"
						name="book.isbn" type="text">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-danger pull-left">Fshi</button>
				</div>
			</div>
		</form>
		<hr>
	</div>
</body>
</html>