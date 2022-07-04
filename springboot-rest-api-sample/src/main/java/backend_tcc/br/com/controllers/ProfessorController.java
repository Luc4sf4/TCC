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

import backend_tcc.br.com.model.Professor;
import backend_tcc.br.com.repository.ProfessorRespository;


@RequestMapping("prof")
@RestController
public class ProfessorController {

	
	@Autowired
	private ProfessorRespository professorRespository;
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Professor>saveProfessor(@RequestBody Professor profSave){
		
		Professor profe1 = professorRespository.save(profSave);
		
		return new ResponseEntity<Professor>(profe1, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Professor>> getEveryProfessor(){
		
		List<Professor> aluno1 = professorRespository.findAll();
		
		return new ResponseEntity<List<Professor>>(aluno1,HttpStatus.OK);
		
		
	}
	
	@GetMapping(value ="/id")
	@ResponseBody
	public ResponseEntity<Professor>getProfessorId(@RequestParam(name= "id")Long idProfessor){
		
		Professor aluno1 = professorRespository.findById(idProfessor).get();
		
		
		return new ResponseEntity<Professor>(aluno1,HttpStatus.OK);
		
	}
	
	@DeleteMapping
	@ResponseBody
	ResponseEntity<String>deleteProfessor(@RequestParam Long idProfessor){
		
		professorRespository.deleteById(idProfessor);
		
		return new ResponseEntity<String>("Cadastro deletado com sucesso",HttpStatus.OK);
		
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?>updateProfessor(@RequestBody Professor profe){
		
		if(profe.getIdProf() == null) {
			
			return new ResponseEntity<String>("id não informado para atualização",HttpStatus.OK);
			
		}
		
		Professor profe1 = professorRespository.saveAndFlush(profe);
		
		return new ResponseEntity<Professor>(profe1,HttpStatus.OK);
		
	}
	
	
	
	
	
	
}


