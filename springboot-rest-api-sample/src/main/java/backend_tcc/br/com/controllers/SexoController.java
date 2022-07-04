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

import backend_tcc.br.com.model.Sexo;
import backend_tcc.br.com.repository.SexoRepository;



@RequestMapping("sexo")
@RestController
public class SexoController {


	@Autowired
	
	private SexoRepository sexoRepository;



	@GetMapping()
	@ResponseBody  
	public ResponseEntity<List<Sexo>> getListSexo(
			@RequestParam(name = "sexo") String sexo)  {

		List<Sexo> list = sexoRepository.buscarPorNome(sexo.trim().toUpperCase());

		return new ResponseEntity<List<Sexo>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/id")
	@ResponseBody  
	public ResponseEntity<Sexo> getSexobyId(
			@RequestParam(name = "id") Long id) /* Recebe os dados para consultar */ {

		Sexo item = sexoRepository.findById(id).get();

		return new ResponseEntity<Sexo>(item, HttpStatus.OK);
	}

	@DeleteMapping()
	@ResponseBody  
	ResponseEntity<String> deleteS(@RequestParam Long idS) /* Recebe os dados para salvar */ {

		sexoRepository.deleteById(idS);

		return new ResponseEntity<String>("User deletado com sucesso ", HttpStatus.OK);
	}

	@PostMapping()
	@ResponseBody  
	public ResponseEntity<Sexo> salvarSexo(@RequestBody Sexo description) /* Recebe os dados para salvar */ {

	 sexoRepository.save(description);

		return new ResponseEntity<Sexo>(description, HttpStatus.CREATED);
	}

	@PutMapping()
	@ResponseBody  
	public ResponseEntity<?> atualizarS(@RequestBody Sexo status) /* Recebe os dados para salvar */ {

		Sexo stts = sexoRepository.saveAndFlush(status);

		return new ResponseEntity<Sexo>(stts, HttpStatus.OK);
	}

	
	
	
	
	
}
