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

import backend_tcc.br.com.model.Matricula;
import backend_tcc.br.com.repository.MatriculaRepository;

@RequestMapping("matricula")
@RestController
public class MatriculaController {
	
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Matricula> saveMatricula(@RequestBody Matricula matri){
		
		
		Matricula mat = matriculaRepository.save(matri);
		
	return new ResponseEntity<Matricula> (mat, HttpStatus.CREATED);
		
	}
	
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Matricula>>getEveryMatricula(){
		
		List<Matricula> matri = matriculaRepository.findAll();
		
		return new ResponseEntity<List<Matricula>>(matri, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<Matricula>getMatriculaId(@RequestParam(name = "id") Long idMatricula){
		
		Matricula matri = matriculaRepository.findById(idMatricula).get();
		
		return new ResponseEntity<Matricula>(matri,HttpStatus.OK);
		
		
	}
	
	
	
	@DeleteMapping
	@ResponseBody
	ResponseEntity<String> deleteMatricula(@RequestParam Long idMatricula){
		
		
		matriculaRepository.deleteById(idMatricula);
		
		return new ResponseEntity<String>("Matricula deletado com sucesso", HttpStatus.OK);
		
	}
	
	
	@PutMapping()
	@ResponseBody
	public ResponseEntity<?>updateMatricula(@RequestBody Matricula matrii){
		
		if(matrii.getIdMatricula() == null){
			
			return new ResponseEntity<String>("Id não informado para atualização", HttpStatus.OK);
			
		}
		
		Matricula mat = matriculaRepository.saveAndFlush(matrii);
		return new ResponseEntity<Matricula>(mat, HttpStatus.OK);
		
	}

}
