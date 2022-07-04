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

import backend_tcc.br.com.model.Altura;
import backend_tcc.br.com.repository.AlturaRepository;



@RequestMapping("altura")
@RestController
public class AlturaController {

	@Autowired
	private AlturaRepository alturaRepository;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Altura> saveAltura (@RequestBody Altura altu) {
		
		Altura alt = alturaRepository.save(altu);
		
		return new ResponseEntity<Altura>(alt,HttpStatus.CREATED);
		
		
	}
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Altura>> getEveryAltura () {
		
		
		List<Altura> alt = alturaRepository.findAll();
		
		return new ResponseEntity<List<Altura>> (alt,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<Altura> getAlturaId (@RequestParam(name = "id")Long id){
		
		Altura alt = alturaRepository.findById(id).get();
		
		return new ResponseEntity<Altura>(alt, HttpStatus.OK);
		
		
	}  
	
	
	
	@DeleteMapping
	@ResponseBody
	public ResponseEntity<String> delteAltura (@RequestParam Long id) {
		
		
		alturaRepository.deleteById(id);
		
		return new ResponseEntity<String> ("Cadastro deletado com sucesso", HttpStatus.OK);
		
		
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?> updateAltura(@RequestBody Altura altu) {
		
		if(altu.getId() == null) {
			
			return new ResponseEntity<String> (" ID não foi informado para atualização ", HttpStatus.OK);
			
		}
		
		Altura alt = alturaRepository.saveAndFlush(altu);
		
		return new ResponseEntity<Altura>(alt, HttpStatus.OK);
		
		
		
	} 
	
	
	
	
}
