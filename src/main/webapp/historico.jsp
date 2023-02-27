<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Historico de operações</title>
</head>
<body>
    <h1 align="center">Operações realizadas foram:</h1>
    <c:forEach items="${historico_operacoes}" var="operacao">
        <h3 align="center"><c:out value="${operacao}" /></h3>
    </c:forEach>
</body>
</html>
