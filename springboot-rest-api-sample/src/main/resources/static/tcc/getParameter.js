jQuery(document).ready(function() {

	$.ajax({
		method: "GET",
		url: "http://localhost:8081/api/cadastro/parametros/id",
		data: "id=" + 6,
		success: function(response) {
			console.log(response);

			$('#tituloHome').text(response.tituloHome);
			$("#colecoes").text(response.colecoes);


		}


	}).fail(function(xhr, status, errorThrown) {
		alert("Erro ao Buscar Usuario por id: " + xhr.reponseText);

	});




});




