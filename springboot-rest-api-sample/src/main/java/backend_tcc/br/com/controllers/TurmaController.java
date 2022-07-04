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

import backend_tcc.br.com.model.Turma;
import backend_tcc.br.com.repository.TurmaRepository;

@RequestMapping("turma")
@RestController
public class TurmaController {

	
	@Autowired
	private TurmaRepository turmaRepository;
	
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Turma> saveTurma(@RequestBody Turma aluno){
		
		Turma tur = turmaRepository.save(aluno);
		
		return new ResponseEntity<Turma>(tur,HttpStatus.CREATED);
		
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Turma>>getEveryTurma(){
		
		List<Turma> tur = turmaRepository.findAll(); 
		
		
		return new ResponseEntity<List<Turma>>(tur,HttpStatus.OK);
		
	}
	
	
	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<Turma>getTurmaId(@RequestParam(name = "id")Long idTurma){
		
		
		Turma tur = turmaRepository.findById(idTurma).get();
		
		return new ResponseEntity<Turma> (tur, HttpStatus.OK);
		
	}
	
	@DeleteMapping
	@ResponseBody
	ResponseEntity<String> deleteTurma(@RequestParam Long idTurma) {
		
		
		turmaRepository.deleteById(idTurma);
		return new ResponseEntity<String>("Turma deletada com sucesso",HttpStatus.OK);
		
	}
	
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?> updateTurma(@RequestBody Turma turminha){
		
		if(turminha.getIdTurma() == null){
			
			return new ResponseEntity<String>("id não foi informado para a atualização", HttpStatus.OK);
			
			
		}
		
	Turma tur =	turmaRepository.saveAndFlush(turminha);
		
	return new ResponseEntity<Turma>(tur,HttpStatus.OK);	
	
	
	}
	
	
	
	
	
	
	
}
