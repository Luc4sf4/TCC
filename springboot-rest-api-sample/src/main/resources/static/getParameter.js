		jQuery(document).ready(function() {

			$.ajax({
				method :"GET",
				url : "http://localhost:8081/api/parametros/id",
				data : "id=" + 3,
				success : function(response) {
				console.log(response);
					$("#id").val(response.id)                             ;
					$('#siteTitle').text(response.sitetitle)              ;
					$('#subTitle').text(response.subtitle1)               ;
					$('#Txt').text(response.txt1)                         ;
					$('#album_title').text(response.title_album)          ;
					$('#video_title').text(response.title_video)          ;
					$('#parametro_145').text(response.parametro145)       ;
					$('#parametro_152').text(response.parametro152)       ;
					$('#parametro_190').text(response.parametro190)       ;
					$('#parametro_547').text(response.parametro547)       ;
					$('#parametro_567').text(response.parametro567)       ;
					$('#parametro_786').text(response.parametro786)       ;
					$('#parametro_899').text(response.parametro899)       ;
					
					
				    $('#parametro_789').attr('src', response.parametro789);
				    $('#parametro_988').attr('src', response.parametro988);
				    $('#parametro_765').attr('src', response.parametro765);				
			
				}
				
				
			}).fail(function(xhr, status, errorThrown) {
				alert("Erro ao Buscar Usuario por id: " + xhr.reponseText);

			});
			
			
			//appends an "active" class to .popup and .popup-content when the "Open" button is clicked
$(".open").on("click", function() {

  $(".popup-overlay, .popup-content").addClass("active");
});

//removes the "active" class to .popup and .popup-content when the "Close" button is clicked 
$(".close, .popup-overlay").on("click", function() {
  $(".popup-overlay, .popup-content").removeClass("active");
});
			
			
			
			$('#myFunction').click(function(e) {
			alert(51);
				var popup = document.getElementById("myPopup");
				popup.classList.toggle("show");
			});
			
			
				});	
			
		
			

	