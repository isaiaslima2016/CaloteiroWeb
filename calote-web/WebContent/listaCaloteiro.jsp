<%@ include file="/includes.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Lista Caloteiro</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	</br> Lista de Caloteiros:
	</br>

	<table border="2">
		<tr>
			<td>ID</td>
			<td>NOME</td>
			<td>EMAIL</td>
			<td>DEVENDO</td>
			<td>DATA DIVIDA</td>
			<td>AÇÕES</td>
		</tr>
		<c:forEach var="caloteiro" items="${lista}" varStatus="id">

			<tr bgcolor="#${id.count % 2 == 0 ? 'ff0000' : 'ffffff' }">
				<td>${id.count}</td>

				<c:choose>
					<c:when test="${not empty caloteiro.nome }">
						<td>${caloteiro.nome }</td>
					</c:when>
					<c:otherwise>
						<td>Nome não preenchido</td>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${not empty caloteiro.email }">
						<td><a href="mailto:${caloteiro.email }">${caloteiro.email }</a></td>
					</c:when>
					<c:otherwise>
						<td>Email não preenchido</td>
					</c:otherwise>
				</c:choose>


				<c:choose>
					<c:when test="${not empty caloteiro.devendo }">
						<td>${caloteiro.devendo }</td>
					</c:when>
					<c:otherwise>
						<td>Devendo não preenchido</td>
					</c:otherwise>
				</c:choose>


				<c:choose>
					<c:when test="${not empty caloteiro.dataDivida }">
						<td><fmt:formatDate value="${caloteiro.dataDivida.time}"
								pattern="dd/MM/yyyy" /></td>


					</c:when>
					<c:otherwise>
						<td>Data não preenchido</td>
					</c:otherwise>
				</c:choose>

				<td><a
					href="sistema?logica=DeletarCaloteiro&id=${caloteiro.id}">[X]</a></td>

			</tr>
		</c:forEach>

	</table>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>
