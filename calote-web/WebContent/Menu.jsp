<%@ include file="/includes.jsp"%>
<html>
<head>
<title>Menu Sistema Caloteiro</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<p>Seja bem vindo, ${usuarioLogado.nome} ao sistema caloteiros:</p>
	<p>Menu</p>
	<p>
	<ol>
		<a href='<c:url value="/adiciona-caloteiro.jsp" />'> Adiciona
			caloteiros </a>
		</br>


		<a href='<c:url value="/sistema?logica=ListarCaloteiro" />'>
			Listar caloteiros </a>
	</ol>
	</p>

	<hr/>
	Variaveis EL:

	<p> 
	1- Param: ${param.nome }</br>
	2- RequestScope: ${requestScope.nome }</br>
	3- SessionScope: ${sessionScope.nome }</br>
	4- Sem especificar: ${nome }
	
	</p>
	<hr/>


	<c:import url="rodape.jsp"></c:import>
</body>
</html>