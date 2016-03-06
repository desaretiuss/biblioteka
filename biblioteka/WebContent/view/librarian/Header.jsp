<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!-- URLs 
====================================================================-->
<s:url var="librarian" namespace="/" action="librarian" />
<s:url var="showAddBook" namespace="/" action="showAddBook" />
<s:url var="showRemoveBook" namespace="/" action="showRemoveBook" />
<s:url var="showUpdateBook" namespace="/" action="select" />


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="assets/bootstrap/themes/cerulan.css" rel="stylesheet"
	type="text/css">
<title>Biblioteka</title>

<style>
body {
	overflow-x: hidden;
}
</style>

</head>
<body>


	<!-- Navbar
      ================================================== -->
	<div class="bs-docs-section clearfix">
		<div class="row">
			<div class="col-lg-12">

				<div class="bs-component">
					<nav class="navbar navbar-default">
						<div class="container-fluid">
							<div class="navbar-header">
								<a class="navbar-brand" href="<s:property value="#librarian" />">Kreu</a>
							</div>

						</div>
					</nav>
				</div>


			</div>
		</div>
	</div>


	<s:if test="hasActionMessages()">
		<div class="alert alert-success">
			<strong> <s:actionmessage escape="false" />
			</strong>
		</div>
	</s:if>

	<s:if test="hasActionErrors()">
		<div class="alert alert-danger">
			<strong> <s:actionerror escape="false" />
			</strong>
		</div>
	</s:if>


	<div style="width: 200px;" class="page-header">
		<h3>Profili i Librarianit</h3>
	</div>


	<div style="width: 150px;">
		<ul class="nav nav-pills nav-stacked">
			<li role="presentation" class="active"><a href="<s:property value="#showAddBook" />">Shto Libër</a></li>
			<li role="presentation"><a href="<s:property value="#showUpdateBook"/>">Përditëso Libër</a></li>
			<li role="presentation"><a href="<s:property value="#showRemoveBook"/>">Fshi Libër</a></li>
		</ul>
	</div>