	const urlParams = new URLSearchParams(window.location.search);
	const id = urlParams.get('idProduto');
	

	
		
jQuery(document).ready(function() {
	const qtde = 1;
	if(Number(urlParams.get('qtde'))>0){
		qtde = Number(urlParams.get('qtde'))
	}
	
	;
	$.ajax({
		method: "GET",
		url: "http://localhost:8081/api/cadastro/produto/id",
		data: "id=" + id,
		success: function(response) {
			console.log(response);
			$('#imageProduto').attr('src', 'imagens/' + response.nomeFoto);
			$('#titulo').text(response.titulo);
			$("#desc").text(response.descricao);
			$("#preco").text('R$ ' + response.preco);
			$("#qtde").val(qtde);
					$("#precoTotal").text('R$ ' + ( Number($("#qtde").val())*
									    Number($("#preco").text().replace("R$ ","").replace(",","."))
									   ) + Number($("#frete").val()));
			
		}

	}).fail(function(xhr, status, errorThrown) {
		alert("Erro ao Buscar Produto por id: " + xhr.reponseText);
	});
	

	
	    $("#qtde").on('blur', function() {

		$("#precoTotal").text('R$ ' + ( Number($("#qtde").val())*
									    Number($("#preco").text().replace("R$ ","").replace(",","."))
									   ) + Number($("#frete").val()));
	  	
        });
	
	
});

function saveHistoricoProduto() {
//{"id":1,"idUsuario":7,"idProduto":2,"dataPagamento":"2022-10-20","valor":33.0}
			var idUsuario = Number(localStorage.getItem("idUser"));
			var idProduto = Number(id);
			var valor = Number($("#precoTotal").text().replace("R$ ","").replace(".","" ).replace(",","."));
			

			$.ajax({
				method : "POST",
				url : "http://localhost:8081/api/cadastro/historicoCompras",
				data : 
					JSON.stringify({
						idUsuario : idUsuario,
						idProduto : idProduto,
						valor : valor,
						id: null,
						dataPagamento : new Date()
					}),
				contentType : "application/json; charset= utf-8",
				success : function(response) {

					$("#id").val(response.id);

					window.location.href = "http://localhost:8081/api/tcc/sucesso.html";
				}

			}).fail(function(xhr, status, errorThrown) {
				console.log("Erro ao salvar" + xhr.reponseText);
					window.location.href = "http://localhost:8081/api/tcc/sucesso.html";
			})
		}






