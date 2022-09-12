jQuery(document).ready(function() {

	$.ajax({
		method: "GET",
		url: "http://localhost:8081/api/cadastro/parametros/id",
		data: "id=" + 3,
		success: function(response) {
			console.log(response);

			$('#parametro_145').text(response.parametro145);



		}


	}).fail(function(xhr, status, errorThrown) {
		alert("Erro ao Buscar Usuario por id: " + xhr.reponseText);

	});




});




