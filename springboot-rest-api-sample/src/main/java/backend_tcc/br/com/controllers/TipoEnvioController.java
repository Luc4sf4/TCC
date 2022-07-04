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

import backend_tcc.br.com.model.TipoEnvio;
import backend_tcc.br.com.repository.EnvioRepository;


@RequestMapping("envio")
@RestController
public class TipoEnvioController {

	
	
	@Autowired
	private EnvioRepository envioRepository;

	@PostMapping()
	@ResponseBody
	public ResponseEntity<TipoEnvio> saveEnvio(@RequestBody TipoEnvio envio) {

		TipoEnvio envio1 = envioRepository.save(envio);

		return new ResponseEntity<TipoEnvio>(envio1, HttpStatus.CREATED);

	}

	@GetMapping()
	@ResponseBody
	public ResponseEntity<List<TipoEnvio>> getEveryEnvio() {

		List<TipoEnvio> id1 = envioRepository.findAll();

		return new ResponseEntity<List<TipoEnvio>>(id1, HttpStatus.OK);

	}

	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<TipoEnvio> getEnvioId(@RequestParam(name = "id") Long id) {

		TipoEnvio id1 = envioRepository.findById(id).get();

		return new ResponseEntity<TipoEnvio>(id1, HttpStatus.OK);

	}

	@PutMapping()
	@ResponseBody
	public ResponseEntity<?> updateEnvio(@RequestBody TipoEnvio envio) {

		if (envio.getId() == null) {
			return new ResponseEntity<String>("ID não informado para a atualização", HttpStatus.OK);

		}

		TipoEnvio env = envioRepository.saveAndFlush(envio);

		return new ResponseEntity<TipoEnvio>(env,HttpStatus.OK);

	}

	
	@DeleteMapping ()
	@ResponseBody
	public ResponseEntity<String> deleteEnvio (@RequestParam Long id){
		
		
		envioRepository.deleteById(id);
		
		return new ResponseEntity<String> ("Envio deletado com sucesso ", HttpStatus.OK);
		
	}
	
	
	
	
	
}
