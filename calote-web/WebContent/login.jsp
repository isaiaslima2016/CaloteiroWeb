<%@ include file="/includes.jsp"%>
<html>
<head>
<title>Acessar sistema caloteiro</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />

	<form action="sistema?logica=AutenticaUsuario&nome=Parametro" method="post" id="formLogar">

		Login: <input type="text" name="login" value="" /> </br> 
		Senha: <input type="password" name="senha" value="" /></br> 
			   <input type="Submit"	value="Logar" /></br>
			
	</form>
	<p>${msgUsuario}</p>
	<c:import url="rodape.jsp" />
</body>
</html>