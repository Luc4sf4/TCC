package backend_tcc.br.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import backend_tcc.br.com.model.Estilo_Body;
import backend_tcc.br.com.repository.Estilo_BodyRepository;


@RequestMapping("body")
@RestController
public class Estilo_BodyController {

	@Autowired
	private Estilo_BodyRepository bodyRepository;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Estilo_Body> saveEstiloBody(@RequestBody Estilo_Body body){
		
		bodyRepository.save(body);
		
		return new ResponseEntity<Estilo_Body>(body,HttpStatus.CREATED); 
		
		
	}
	
	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<Estilo_Body> getBodyId(@RequestParam(name="id") Long id){
		
		Estilo_Body id1 = bodyRepository.findById(id).get();		
		
		return new ResponseEntity<Estilo_Body>(id1,HttpStatus.OK);
		
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Estilo_Body>> getEveryBody(){
		
		List<Estilo_Body> body = bodyRepository.findAll();
		
		return new ResponseEntity<List<Estilo_Body>> (body,HttpStatus.OK);
		
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?> updateBody (@RequestBody Estilo_Body propiedade) {
		
		if (propiedade.getId() == null) {
			return new ResponseEntity<String> ("Id não informado para a atualização", HttpStatus.OK);
		}
		
		Estilo_Body est = bodyRepository.saveAndFlush(propiedade);
		
		return new ResponseEntity<Estilo_Body>(est,HttpStatus.OK);
		
	} 
	
	
	
	
}
