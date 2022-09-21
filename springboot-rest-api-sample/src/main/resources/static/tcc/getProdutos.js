jQuery(document).ready(function() {

	$.ajax({
		method: "GET",
		url: "http://localhost:8081/api/cadastro/produto",
		success: function(response) {
			console.log(response);
			for (let i = 0; i < response.length; i++) {

    			$("#produtos_list").append('<div class="w3-container"><a href="produto.html?idProduto=1&"> <img src="imagens/terno_'+response[i].idProduto+'.jpg" style="width:100%"></a><p><span class="tituloProduto" id="titulo_1">'+
    			response[i].titulo
    			+
    			'</span> <br><b><span class="precoProduto" id="preco_1">'+
    			response[i].preco
    			+'</span> </b></p></div>');
				}
	

		}


	}).fail(function(xhr, status, errorThrown) {
		alert("Erro ao Buscar Usuario por id: " + xhr.reponseText);

	});




});


/*
<div class="w3-third w3-margin-bottom">
        <a href="produtos.html?idProduto=1&amp;"><img src="imagens/camisascategorias.png" alt="New York" style="width:100%" class="w3-hover-opacity"></a>
        <div class="w3-container w3-white">
          <p><b>Camisas</b></p>
          <button class="w3-button w3-black w3-margin-bottom" onclick="document.getElementById('ticketModal').style.display='block'">Confira Já!</button>
        </div>
      </div>
*/