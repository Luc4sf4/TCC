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

import backend_tcc.br.com.model.Tamanho;
import backend_tcc.br.com.repository.TamanhoRepository;





@RequestMapping("tamanho")
@RestController
public class TamanhoController {

	
	
	@Autowired
	private TamanhoRepository tamanhoRepository;
	
	
	@PostMapping(value = "salvarTamanho")
	@ResponseBody  
	public ResponseEntity<Tamanho> salvarTamanho(@RequestBody Tamanho tam) /* Recebe os dados para salvar */ {

		Tamanho est = tamanhoRepository.save(tam);

		return new ResponseEntity<Tamanho>(est, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping(value = "deleteTamanho")
	@ResponseBody  
	ResponseEntity<String> deleteTamanho(@RequestParam Long id) /* Recebe os dados para salvar */ {

		tamanhoRepository.deleteById(id);

		return new ResponseEntity<String>("User deletado com sucesso ", HttpStatus.OK);
	}
	
	
	@PutMapping(value = "atualizarTamanho")
	@ResponseBody  
	public ResponseEntity<?> atualizarTamanho(@RequestBody Tamanho tam) /* Recebe os dados para salvar */ {

		if (tam.getId() == null) {
			return new ResponseEntity<String>(" Id não foi informado para a atualização ", HttpStatus.OK);
		}

		Tamanho	est = tamanhoRepository.saveAndFlush(tam);

		return new ResponseEntity<Tamanho>(est, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "getTamanhoid")
	@ResponseBody  
	public ResponseEntity<Tamanho> getTamanhoid (@RequestParam(name = "id") Long id) /* Recebe os dados para consultar */ {

		Tamanho id1 = tamanhoRepository.findById(id).get();

		return new ResponseEntity<Tamanho>(id1, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "getTamanho")
	@ResponseBody  
	public ResponseEntity<List<Tamanho>> getTamanho (@RequestParam(name = "tam") String tam) /* Recebe os dados para consultar */ {

		List<Tamanho> est1 = tamanhoRepository.getEstado(tam.trim().toUpperCase());

		return new ResponseEntity<List<Tamanho>>(est1, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "getEveryTamanho")
	@ResponseBody
	public ResponseEntity<List<Tamanho>> getEveryTamanho() {

		List<Tamanho> est1 = tamanhoRepository.findAll();/* executa a consulta do banco de dados */

		return new ResponseEntity<List<Tamanho>>(est1, HttpStatus.OK);

	}

	
	
}
