jQuery(document).ready(function() {

	$.ajax({
		method: "GET",
		url: "http://localhost:8081/api/cadastro/parametros/id",
		data: "id=" + 6,
		success: function(response) {
			console.log(response);

			$('#tituloHome').text(response.tituloHome);
			$("#colecoes").text(response.colecoes);
			$("#footer").text(response.footer);

		}


	}).fail(function(xhr, status, errorThrown) {
		alert("Erro ao Buscar Usuario por id: " + xhr.reponseText);

	});

	if (localStorage.getItem("user")) {
		document.getElementById("cadastroTop").style.display = "none";
		document.getElementById("loginTop").style.display = "none";
		$("#nameUser").text("Olá, " + localStorage.getItem("user"));
	} else {
		document.getElementById("cadastroTop").style.display = "block";
		document.getElementById("loginTop").style.display = "block";
		$("#nameUser").text(" ") ;
	}

});




