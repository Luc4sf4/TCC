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

import backend_tcc.br.com.model.Curso;
import backend_tcc.br.com.repository.CursoRepository;




@RequestMapping("curso")
@RestController
public class CursoController {

	@Autowired
	private CursoRepository cursoRespository;
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Curso> saveCurso(@RequestBody Curso curso){
		
		Curso curso2 = cursoRespository.save(curso);
		
		return new ResponseEntity<Curso>(curso2, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Curso>>geteveryCurso(){
		
		
		List<Curso> curso1 = cursoRespository.findAll();
		
	
		return new ResponseEntity<List<Curso>>(curso1, HttpStatus.OK);
		
	}
	
	
	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<Curso>getCursoID(@RequestParam(name = "id")Long idCurso){
		
		
		Curso curso1 = cursoRespository.findById(idCurso).get();
		
		return new ResponseEntity<Curso>(curso1,HttpStatus.OK);
		
	}
	
	@DeleteMapping
	@ResponseBody 
	ResponseEntity<String> deleteCurso(@RequestParam Long idCurso){
		
		cursoRespository.deleteById(idCurso);
		return new ResponseEntity<String>("Curso deletado com sucesso", HttpStatus.OK);
		
	}
	
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?>updateCurso(@RequestBody Curso curso1){
	
		if(curso1.getIdCurso()== null) {
			
			return new ResponseEntity<String>("id não infromado para atualização", HttpStatus.OK);
			
		}
		
	Curso cursinho = cursoRespository.saveAndFlush(curso1);
		
	return new ResponseEntity<Curso>(cursinho,HttpStatus.OK);
		
	}
	
	
}
