jQuery(document).ready(function() {

	$.ajax({
		method: "GET",
		url: "http://localhost:8081/api/cadastro/categoria",
		success: function(response) {
			console.log(response);
			for (let i = 0; i < response.length; i++) {

    			$("#categoria_list").append('<div class="w3-third w3-margin-bottom"> <a href="produtos.html?idCategoria='+response[i].idCategoria+'&amp;"><img src="imagens/categoria_'+response[i].idCategoria+'.png" alt="New York2" style="width:100%" class="w3-hover-opacity"></a><div class="w3-container w3-white"> <p><b>'
    			+response[i].description+'</b></p> </div></div>');
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