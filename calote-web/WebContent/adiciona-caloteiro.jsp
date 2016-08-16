<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adiciona caloteiro</title>
</head>

<body>
	<c:import url="cabecalho.jsp"></c:import>
	</br>
	<hr>
	Usuario: ${usuarioLogado.nome}
	<hr>
	<form action="sistema" method="post">
		<input type="hidden" name="logica" value="AdicionaCaloteiro" /> Nome:
		<input type="text " name="nome" placeholder="NOME" /></br> E-mail: <input
			type="text " name="email" placeholder="EMAIL" /></br> Devendo: <input
			type="text " name="devendo" placeholder="VALOR EM INTEIRO" /></br> Data:
		<input type=" text " name="dataDivida" placeholder="DIA/MES/ANO" /></br> <input
			type="submit" value="Salvar" /></br>

		<c:import url="rodape.jsp"></c:import>
		</br>
	</form>
</body>
</html>