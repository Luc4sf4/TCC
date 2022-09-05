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

import backend_tcc.br.com.model.Usuario;
import backend_tcc.br.com.repository.UsuarioRepository;

@RequestMapping("tcc/user")
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository userRepository;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Usuario> SaveUse(@RequestBody Usuario userContructor){
		
		
		Usuario user = userRepository.save(userContructor);
		
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
		
	}
	
	@GetMapping
	@ResponseBody
		public ResponseEntity<List<Usuario>> getEveryUser(){
		List<Usuario> user = userRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(user, HttpStatus.OK);
		
	}
	
	
	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<Usuario> GetUserId(@RequestParam(name = "id")Long id){
		
		Usuario user = userRepository.findById(id).get();
		
		return new ResponseEntity<Usuario>(user,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping
	@ResponseBody
	public ResponseEntity<String>DeleteUser (@RequestParam Long id) {
		
		userRepository.deleteById(id);
		
		return new ResponseEntity<String>("Usuario deletado com sucesso",HttpStatus.OK);
		
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?>UpdateUser(@RequestBody Usuario userContructor){
		
		if(userContructor.getId() == null) {
			
			return new ResponseEntity<String> ("Id não informado para update", HttpStatus.OK);
			
		}
		
		Usuario user = userRepository.saveAndFlush(userContructor);
		
		return new ResponseEntity<Usuario>(user,HttpStatus.OK);
	}
	
	
}	
	

