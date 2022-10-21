var listProdutos;
jQuery(document).ready(function() {

if (Number(localStorage.getItem("idUser"))==0){
	alert("Login necessário");
}


	$.ajax({
		method: "GET",
		url: "http://localhost:8081/api/cadastro/produto",
		
		success: function(response) {
			listProdutos = response;
		}

	}).fail(function(xhr, status, errorThrown) {
		alert("Erro ao Buscar Produto por id: " + xhr.reponseText);
	});


	$.ajax({
		method: "GET",
		url: "http://localhost:8081/api/cadastro/historicoCompras",
		success: function(response2) {

			var tabela = '<table style="border: 1px solid black; width: 100%"><tr><th>Produto</th><th>Descrição</th><th>Data Compra</th><th>Preço</th></tr>';
// percorro toda a lista de produtos 
for (let i = 0; i < listProdutos.length; i++) {
							// e toda a lista de historico
							for (let k = 0; k < response2.length; k++) {
								// se for mesmo produto e mesmo idusuario, mostro na tela
								if (listProdutos[i].idProduto === response2[k].idProduto && response2[k].idUsuario == Number(localStorage.getItem("idUser"))  ){
										tabela = tabela + ' <tr> <td> <img id="imageProduto" src="' + 'imagens/' + listProdutos[i].nomeFoto + '" style="width: 100px"></td>' 
											+ '<td>' + listProdutos[i].descricao + '</td>' 
											+ '<td style="width:150px">' + response2[k].dataPagamento + '</td>' 
											+ '<td style="width:150px">' + response2[k].valor + '</td></tr>';
								}
							}
}

			$("#historico_list").append(tabela + '</table>');
		}

	}).fail(function(xhr, status, errorThrown) {
		alert("Erro ao Buscar Produto por id: " + xhr.reponseText);
	});


});






