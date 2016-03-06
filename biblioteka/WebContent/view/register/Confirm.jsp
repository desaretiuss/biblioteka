<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Biblioteka</title>
</head>
<body>
	<s:if test="hasActionErrors()">
		<s:actionerror escape="false" />
	</s:if>

	<s:if test="hasActionMessages()">
		<s:actionmessage escape="false" />
	</s:if>

	<hr />
</body>
</html>