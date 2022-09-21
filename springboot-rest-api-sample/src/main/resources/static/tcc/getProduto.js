jQuery(document).ready(function() {

	$.ajax({
		method: "GET",
		url: "http://localhost:8081/api/cadastro/produto/id",
		data: "id=" + 2,
		success: function(response) {
			console.log(response);

			$  ('#titulo').text(response.titulo) ;
			$  ("#desc").text(response.descricao);
			$  ("#preco").text(response.preco)   ;



		}


	}).fail(function(xhr, status, errorThrown) {
		alert("Erro ao Buscar Usuario por id: " + xhr.reponseText);

	});




});




