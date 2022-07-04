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

import backend_tcc.br.com.model.Cor;
import backend_tcc.br.com.repository.CorRepository;



@RequestMapping("cor")
@RestController
public class CorController {

	
	@Autowired
	private CorRepository corRepository;

	
	
	@PostMapping()
	@ResponseBody
	public ResponseEntity<Cor> salvarCor(@RequestBody Cor cor) /* Recebe os dados para salvar */ {

		Cor cor2 = corRepository.save(cor);

		return new ResponseEntity<Cor>(cor2, HttpStatus.CREATED);
	}

	@DeleteMapping()
	@ResponseBody
	ResponseEntity<String> deleteCor(@RequestParam Long id) /* Recebe os dados para salvar */ {

		corRepository.deleteById(id);

		return new ResponseEntity<String>("User deletado com sucesso ", HttpStatus.OK);
	}

	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<Cor> getCorid(@RequestParam(name = "id") Long id) /* Recebe os dados para consultar */ {

		Cor id1 = corRepository.findById(id).get();

		return new ResponseEntity<Cor>(id1, HttpStatus.OK);
	}



	@GetMapping()
	@ResponseBody
	public ResponseEntity<List<Cor>> getEveryCor() {

		List<Cor> cor1 = corRepository.findAll();/* executa a consulta do banco de dados */

		return new ResponseEntity<List<Cor>>(cor1, HttpStatus.OK);

	}

	@PutMapping()
	@ResponseBody
	public ResponseEntity<?> atualizarCor(@RequestBody Cor cor) /* Recebe os dados para salvar */ {

		if (cor.getId() == null) {
			return new ResponseEntity<String>(" Id não foi informado para a atualização ", HttpStatus.OK);
		}

		Cor cor1 = corRepository.saveAndFlush(cor);

		return new ResponseEntity<Cor>(cor1, HttpStatus.OK);
	}

}
