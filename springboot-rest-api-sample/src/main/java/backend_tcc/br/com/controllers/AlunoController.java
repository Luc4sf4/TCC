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

import backend_tcc.br.com.model.Aluno;
import backend_tcc.br.com.repository.AlunoRespository;



@RequestMapping("aluno")
@RestController
public class AlunoController {
	
	@Autowired
	private AlunoRespository alunoRepository;
	
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Aluno>saveAluno(@RequestBody Aluno aluninho){
		
		Aluno aluno1 = alunoRepository.save(aluninho);
		
		return new ResponseEntity<Aluno>(aluno1,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Aluno>> getEveryAluno(){
		
		List<Aluno> aluno1 = alunoRepository.findAll();
		
		return new ResponseEntity<List<Aluno>>(aluno1,HttpStatus.OK);
		
		
	}
	
	@GetMapping(value ="/id")
	@ResponseBody
	public ResponseEntity<Aluno>getAlunoId(@RequestParam(name= "id")Long idAluno){
		
		Aluno aluno1 = alunoRepository.findById(idAluno).get();
		
		
		return new ResponseEntity<Aluno>(aluno1,HttpStatus.OK);
		
	}
	
	@DeleteMapping
	@ResponseBody
	ResponseEntity<String>deleteAluno(@RequestParam Long idAluno){
		
		alunoRepository.deleteById(idAluno);
		
		return new ResponseEntity<String>("Aluno deletado com sucesso ", HttpStatus.OK);
		
		
		
		
		
	}

	@PutMapping
	@ResponseBody
	public ResponseEntity<?>updateAluno(@RequestBody Aluno aluninho){
		
		if(aluninho.getIdAluno() == null) {
			
			return new ResponseEntity<String>("id não informado para atualização", HttpStatus.OK);
			
		}
		
		
		Aluno aluno1 = alunoRepository.saveAndFlush(aluninho);
		
		return new ResponseEntity<Aluno>(aluno1, HttpStatus.OK);
		
	}




}



