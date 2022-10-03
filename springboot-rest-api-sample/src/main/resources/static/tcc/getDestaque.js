jQuery(document).ready(function() {
	var categoriaRandomica = 3;
	var conteudo = '';
	$.ajax({
		method: "GET",
		url: "http://localhost:8081/api/cadastro/produto",
		success: function(response) {
			console.log(response);
			for (let i = 0; i < response.length; i++) {

				if (response[i].idCategoria != Math.floor(Math.random() * categoriaRandomica) + 1) {



					conteudo = conteudo + '<div class="w3-col s4 "><div class="w3-container"> <img src="imagens/terno_'
						+ response[i].idProduto +
						'.jpg" style="width:100%"><p>'
						+ response[i].titulo +
						'<br><b>'
						+ response[i].preco +
						'</b></p></div></div>';



				}
			}
			$("#destaque_list").append("<div class='w3-row'>" + conteudo + '</div>');
		}
	}).fail(function(xhr, status, errorThrown) {
		alert("Erro ao Buscar Usuario por id: " + xhr.reponseText);
	});

});




	