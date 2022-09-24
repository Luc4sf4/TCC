jQuery(document).ready(function() {
	const urlParams = new URLSearchParams(window.location.search);
	const id = urlParams.get('idProduto');

	$.ajax({
		method: "GET",
		url: "http://localhost:8081/api/cadastro/produto/id",
		data: "id=" + id,
		success: function(response) {
			console.log(response);
			$('#titulo').text(response.titulo);
			$("#desc").text(response.descricao);
			$("#preco").text('R$ ' + response.preco);
			$('#imageProduto').attr('src', 'imagens/terno_' + id + '.jpg');
		}
		
	}).fail(function(xhr, status, errorThrown) {
		alert("Erro ao Buscar Usuario por id: " + xhr.reponseText);

	});




});




