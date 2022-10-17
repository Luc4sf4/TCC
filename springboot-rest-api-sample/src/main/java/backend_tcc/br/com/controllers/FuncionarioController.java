package backend_tcc.br.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import backend_tcc.br.com.model.Funcionario;
import backend_tcc.br.com.repository.FuncionarioRepository;

@RequestMapping("tcc/funcionario")
@Controller
public class FuncionarioController {
	
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<Funcionario> getFuncionarioId(@RequestParam(name = "idFunc") Long idFunc){
		
	
		Funcionario id1 = funcionarioRepository.findById(idFunc).get();
		
				
		return new ResponseEntity<Funcionario> (id1, HttpStatus.OK);
		
	}
	
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Funcionario>> getFuncionario(){
	
		
		List<Funcionario> func = funcionarioRepository.findAll();
		
		return new ResponseEntity<List<Funcionario>>(func, HttpStatus.OK);
		
	
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Funcionario> saveFuncionario(@RequestBody Funcionario funcionario){
		
		Funcionario func = funcionarioRepository.save(funcionario);
		
		return new ResponseEntity<Funcionario>(func, HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping
	@ResponseBody
	ResponseEntity<String> deleFuncionario (@RequestParam Long idFunc){
		
		funcionarioRepository.deleteById(idFunc);
		
		return new ResponseEntity<String>("User deletado com sucesso", HttpStatus.OK);
		
	}
	
	
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?> updateFuncionario(@RequestBody Funcionario funcionario){
		
		
		if(funcionario.getIdFunc() == null){
			
			return new ResponseEntity<String>("id não informado para a atualização", HttpStatus.OK);
			
		}
	
		Funcionario func = funcionarioRepository.saveAndFlush(funcionario);
		
		return new ResponseEntity<Funcionario>(func, HttpStatus.OK);
		
		
		
	}
	
	

}
