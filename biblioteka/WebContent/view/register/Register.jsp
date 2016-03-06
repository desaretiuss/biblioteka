<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<title>Biblioteka</title>
<style>
body {
	overflow-x: hidden;
}

.register-div {
	margin-left: 370px;
}

.field-error {
	margin-left: 155px;
	color: rgb(178, 68, 66);
}

.action-error{
    color: red;
}
</style>
</head>
<body>

	<div class="register-div">

		<div class="page-header">
			<h1>Formulari i regjistrimit</h1>
		</div>

			<s:actionerror escape="false" cssClass="action-error" />
		
		<form class="form-horizontal" role="form" method="post"
			action="register" novalidate>
			<div class="form-group">
				<s:fielderror fieldName="memberBean.firstname"
					cssClass="field-error" />
				<label for="emri" class="col-sm-2 control-label">Emri</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="firstname"
						name="memberBean.firstname" placeholder="Emri" />
				</div>
			</div>
			<div class="form-group">
				<s:fielderror fieldName="memberBean.lastname" cssClass="field-error" />
				<label for="lastname" class="col-sm-2 control-label">Mbiemri</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="lastname"
						name="memberBean.lastname" placeholder="Mbiemri" />
				</div>
			</div>
			<div class="form-group">
				<s:fielderror fieldName="memberBean.email" cssClass="field-error" />
				<label for="email" class="col-sm-2 control-label">Adresa
					e-mail</label>
				<div class="col-sm-4">
					<input type="email" class="form-control" id="email"
						name="memberBean.email" placeholder="Adresa e-mail" />
				</div>
			</div>
			<div class="form-group">
				<s:fielderror fieldName="memberBean.password" cssClass="field-error" />
				<label for="password" class="col-sm-2 control-label">Fjalëkalimi</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="password"
						name="memberBean.password" placeholder="Fjalëkalimi" />
				</div>
			</div>
			<div class="form-group">
		    	<s:fielderror fieldName="memberBean.confirmPassword" cssClass="field-error" />
				<label for="confirmPassword" class="col-sm-2 control-label">Fjalëkalimi</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" name="memberBean.confirmPassword"
						id="confirmPassword" placeholder="Rishkruaj Fjalëkalimin" />
				</div>
			</div>
			<div class="form-group">
				<s:fielderror fieldName="memberBean.mobile" cssClass="field-error" />
				<label for="mobile" class="col-sm-2 control-label">Nr. cel</label>
				<div class="col-sm-4">
					<input type="tel" class="form-control" id="mobile"
						name="memberBean.mobile" placeholder="Nr. cel" />
				</div>
			</div>
			<div class="form-group">
				<s:fielderror fieldName="memberBean.birthdate"
					cssClass="field-error" />
				<label for="birthdate" class="col-sm-2 control-label">Datëlindja</label>
				<div class="col-sm-4">
					<input type="date" class="form-control" id="birthdate"
						name="memberBean.birthdate" placeholder="vvvv-mm-dd" />
				</div>
			</div>
			<div class="form-group">
				<s:fielderror fieldName="memberBean.address" cssClass="field-error" />
				<label for="address" class="col-sm-2 control-label">Adresa e
					vendbanimit</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="address"
						name="memberBean.address" placeholder="Adresa e vendbanimit" />
				</div>
			</div>
			<div class="form-group">
				<label for="category" class="col-sm-2 control-label">Kategoria</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="category"
						name="memberBean.category" placeholder="Kategoria" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Dërgo</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>