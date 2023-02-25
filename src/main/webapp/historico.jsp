<%@ page import="java.util.List" %>
<%@ page import="br.ada.americanas.helloworldservlet.operacao.Operacao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<Operacao> operacoes = (List<Operacao>) session.getAttribute("historico_operacoes"); %>

<html>
<head>
    <title>Historico de operações</title>
</head>
<body>
    <c:forEach items="${operacoes}" var="operacao">
        <h1><c:out value="${operacao}" /></h1>
    </c:forEach>
</body>
</html>
