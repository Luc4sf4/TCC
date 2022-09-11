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

import backend_tcc.br.com.model.Parametros;
import backend_tcc.br.com.repository.ParametroRepository;


@RequestMapping("cadastro/parametros")
@RestController
public class ParametroController {

	@Autowired
	private ParametroRepository paramRepository;

	@PostMapping()
	@ResponseBody
	public ResponseEntity<Parametros> salvarParametro(@RequestBody Parametros param) {

		Parametros sitetile = paramRepository.save(param);

		return new ResponseEntity<Parametros>(sitetile, HttpStatus.CREATED);

	}

	@GetMapping()
	@ResponseBody
	public ResponseEntity<List<Parametros>> getEveryParametro() {

		List<Parametros> sitetitle = paramRepository.findAll();

		return new ResponseEntity<List<Parametros>>(sitetitle, HttpStatus.OK);

	}

	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<Parametros> buscarParametroid(@RequestParam(name = "id") Long id) {

		Parametros parametro = paramRepository.findById(id).get();

		return new ResponseEntity<Parametros>(parametro, HttpStatus.OK);

	}

	@DeleteMapping
	@ResponseBody
	ResponseEntity<String> deleteParametro(@RequestParam Long id) {

		paramRepository.deleteById(id);

		return new ResponseEntity<String>("Parametro deletado com sucesso", HttpStatus.OK);

	}

	@PutMapping()
	@ResponseBody
	public ResponseEntity<?> autalizarParam(@RequestBody Parametros param) {

		if (param.getId() == null) {
			return new ResponseEntity<String>("Id não foi informado para atualização ", HttpStatus.OK);
		}

		Parametros siteTitle = paramRepository.saveAndFlush(param);
		return new ResponseEntity<Parametros>(siteTitle, HttpStatus.OK);

	}

}
