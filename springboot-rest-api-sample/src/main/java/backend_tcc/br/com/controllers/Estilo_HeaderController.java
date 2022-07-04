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

import backend_tcc.br.com.model.EstiloHeader;
import backend_tcc.br.com.repository.Estilo_HeaderRepository;


@RequestMapping("header")
@RestController
public class Estilo_HeaderController {

	@Autowired
	private Estilo_HeaderRepository estiloHeaderRepository;
	
	
	
	@PostMapping()
	@ResponseBody  
	public ResponseEntity<EstiloHeader> salvarEstilo(@RequestBody EstiloHeader est) /* Recebe os dados para salvar */ {

		EstiloHeader estilo = estiloHeaderRepository.save(est);

		return new ResponseEntity<EstiloHeader>(estilo, HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "/id")
	@ResponseBody
	ResponseEntity<EstiloHeader> getEstiloHeaderId(@RequestParam(name = "id") Long id) {
		
		EstiloHeader id1= estiloHeaderRepository.findById(id).get();
		
		return new ResponseEntity<EstiloHeader>(id1,HttpStatus.OK);
		
		
		
	} 
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<EstiloHeader>>getEstiloHeader(){
		
		List<EstiloHeader> propriedade= estiloHeaderRepository.findAll();
		
		return new ResponseEntity<List<EstiloHeader>>(propriedade,HttpStatus.OK); 
		
	}
	
	@DeleteMapping
	@ResponseBody
	ResponseEntity<String> delteEstiloHeader(@RequestParam Long id){
		
		estiloHeaderRepository.deleteById(id);
		
		return new ResponseEntity<String>("User deletado com sucesso", HttpStatus.OK);
		
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?> updateEstilo(@RequestBody EstiloHeader propriedade){
		
		
		if(propriedade.getId() == null) {
			
			return new ResponseEntity<String> ("id não informado para a autalização",HttpStatus.OK);
		}
		
		EstiloHeader est = estiloHeaderRepository.saveAndFlush(propriedade);
		
		return new ResponseEntity<EstiloHeader>(est,HttpStatus.OK);		
	}
	
	
}
