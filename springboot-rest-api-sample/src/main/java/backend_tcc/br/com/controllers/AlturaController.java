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



@RequestMapping("cadastro/altura")
@RestController
public class AlturaController {

	@Autowired
	private AlturaRepository alturaRepository;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Altura> saveHeight (@RequestBody Altura isHeight/*isHeight é a variável de construção */ ) {
		
		Altura height = alturaRepository.save(isHeight)                 ;
		return new ResponseEntity<Altura>(height,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Altura>> getEveryHeight () {
		
		
		List<Altura> height = alturaRepository.findAll()              ;	
		return new ResponseEntity<List<Altura>> (height,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<Altura> getHeightId (@RequestParam(name = "id")Long id){
		
		Altura alt = alturaRepository.findById(id).get()     ;	
		return new ResponseEntity<Altura>(alt, HttpStatus.OK);
		
		
	}  
	
	
	
	@DeleteMapping
	@ResponseBody
	public ResponseEntity<String> delteHeight (@RequestParam Long id) {
		
		
		alturaRepository.deleteById(id)													  ;
		return new ResponseEntity<String> ("Cadastro deletado com sucesso", HttpStatus.OK);
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?> updateHeight(@RequestBody Altura height) {
		
		if(height.getId() == null) {
			
			return new ResponseEntity<String> (" ID não foi informado para atualização ", HttpStatus.OK);
			
		}
		
		Altura heighT = alturaRepository.saveAndFlush(height)     ;
		return new ResponseEntity<Altura>(heighT, HttpStatus.OK);
		
		
		
	} 
	
}
