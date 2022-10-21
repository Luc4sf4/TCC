jQuery(document).ready(function() {
	const urlParams = new URLSearchParams(window.location.search);

	$.ajax({
		method: "GET",
		url: "http://localhost:8081/api/cadastro/user",
		success: function(response) {

			if (response.id != 0) {
				document.getElementById("cadastroTop").style.display = "none";
				document.getElementById("loginTop").style.display = "none";
			}

		}
	}).fail(function(xhr, status, errorThrown) {
		alert("Erro ao Buscar Produto por id: " + xhr.reponseText);
	});

	//	pegar o nome no LocalStorage e aplicar na div userDiv
	document.getElementById("nameUser").innerHTML = "Olá, " + localStorage.getItem("user");

});






