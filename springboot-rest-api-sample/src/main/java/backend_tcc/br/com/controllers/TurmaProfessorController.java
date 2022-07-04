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

import backend_tcc.br.com.model.TurmaProfessor;
import backend_tcc.br.com.repository.TurmaProfRespository;

@RequestMapping("turmaprofessor")
@RestController
public class TurmaProfessorController {

	@Autowired
	private TurmaProfRespository profRepository;
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<TurmaProfessor> saveTurmaPRof(@RequestBody TurmaProfessor profe){
		
		
		TurmaProfessor turma = profRepository.save(profe);
		
		return new ResponseEntity<TurmaProfessor>(turma, HttpStatus.CREATED);
		
		
	}
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<TurmaProfessor>> getEveryTurmaProfessor(){
		
		
		List<TurmaProfessor> turma = profRepository.findAll();
		
		return new ResponseEntity<List<TurmaProfessor>>(turma, HttpStatus.OK);
		
	}
	
	
	
	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<TurmaProfessor>getTurmaProfessorId(@RequestParam(name = "id")Long idTurmaProf){
		
		
		TurmaProfessor turma = profRepository.findById(idTurmaProf).get();
		
		return new ResponseEntity<TurmaProfessor>(turma,HttpStatus.OK);
		
	}
	
	
	
	
	@DeleteMapping
	@ResponseBody
	ResponseEntity<String> deleteTurmaProfessor(@RequestParam Long idTurmaProf){
		
		profRepository.deleteById(idTurmaProf);
		
		return new ResponseEntity<String>("Turma do professor deletada com sucesso", HttpStatus.OK);
		
	}
	
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?>updateTurmaProfessor(@RequestBody TurmaProfessor prof){
		
		if(prof.getIdTurmaProf() == null) {
			
			return new ResponseEntity<String>("Id não foi informado para atualização", HttpStatus.OK);
			
		}
		
		
		TurmaProfessor turma = profRepository.saveAndFlush(prof);
		return new ResponseEntity<TurmaProfessor>(turma, HttpStatus.OK);
		
	}
	
	
	
	
}
