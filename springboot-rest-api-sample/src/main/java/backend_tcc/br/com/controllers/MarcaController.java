package backend_tcc.br.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import backend_tcc.br.com.model.Marca;
import backend_tcc.br.com.repository.MarcaRepository;





@RequestMapping("marca")
@RestController
public class MarcaController {

	@Autowired
	private MarcaRepository marcaRepository;
	

	

/*================================================================================================================================*/
	
/*=================================================MARCA===================================================================*/
	
	
	
	@PostMapping()
	@ResponseBody  
	public ResponseEntity<Marca> salvarMarca(@RequestBody Marca marca) /* Recebe os dados para salvar */ {

		Marca mar = marcaRepository.save(marca);

		return new ResponseEntity<Marca>(mar, HttpStatus.CREATED);
	}
		
	
	
	@GetMapping(value = "/id")
	@ResponseBody  
	public ResponseEntity<Marca> getMarcaid (@RequestParam(name = "id") Long id) /* Recebe os dados para consultar */ {

		Marca id1 = marcaRepository.findById(id).get();

		return new ResponseEntity<Marca>(id1, HttpStatus.OK);
	}
	
		
	
	@GetMapping()
	@ResponseBody
	public ResponseEntity<List<Marca>> getEveryMarca() {

		List<Marca> mar = marcaRepository.findAll();/* executa a consulta do banco de dados */

		return new ResponseEntity<List<Marca>>(mar, HttpStatus.OK);

	}
	
	
	
	@DeleteMapping()
	@ResponseBody  
	ResponseEntity<String> deleteMarca(@RequestParam Long id) /* Recebe os dados para salvar */ {

		marcaRepository.deleteById(id);

		return new ResponseEntity<String>("User deletado com sucesso ", HttpStatus.OK);
	}
	
	
	
	@PutMapping()
	@ResponseBody  
	public ResponseEntity<?> atualizarMarca(@RequestBody Marca marca) /* Recebe os dados para salvar */ {

		if (marca.getId() == null) {
			return new ResponseEntity<String>(" Id não foi informado para a atualização ", HttpStatus.OK);
		}

		Marca mar = marcaRepository.saveAndFlush(marca);

		return new ResponseEntity<Marca>(mar, HttpStatus.OK);
	}
	


	
}
