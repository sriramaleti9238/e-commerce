<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="0; URL=${pageContext.request.contextPath}/e-commerce-0.0.1-SNAPSHOT/">
    <title>Redirecting...</title>
</head>
<body>
<p>Redirecting to the application...</p>
<script type="text/javascript">
    window.location.href = "${pageContext.request.contextPath}/e-commerce-0.0.1-SNAPSHOT/";
</script>
</body>
</html>