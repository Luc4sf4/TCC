package backend_tcc.br.com.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
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

import backend_tcc.br.com.model.HistoricoCompras;
import backend_tcc.br.com.repository.HistoricoCompraRepository;

@RequestMapping("cadastro/historicoCompras")
@RestController
public class HistoricoComprasController {

	
	@Autowired
	private HistoricoCompraRepository historicoRepository;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<HistoricoCompras> saveHistorico(@RequestBody HistoricoCompras historico){
		
		
		HistoricoCompras hist = historicoRepository.save(historico);
		
		return new ResponseEntity<HistoricoCompras>(hist, HttpStatus.CREATED);
		
	}	
	
	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<HistoricoCompras> getHistoricoId(@RequestParam(name ="id")Long id){
		
		HistoricoCompras idH = historicoRepository.findById(id).get();
		
		return new ResponseEntity<HistoricoCompras>(idH, HttpStatus.OK);
		
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<HistoricoCompras>> getEveryHistorico(){
		
		List<HistoricoCompras> hist = historicoRepository.findAll();
		
		return new ResponseEntity<List<HistoricoCompras>>(hist, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping
	@ResponseBody
	public ResponseEntity<String>deleteHistorico(@RequestParam Long id){
		
		historicoRepository.deleteById(id);
		
		return new ResponseEntity<String>("Deletado com sucesso",HttpStatus.OK);
		
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?>updateHistorico(@RequestBody HistoricoCompras hist){
		
		if(hist.getId() == null){
			
			return new ResponseEntity<String>("id não informado para atualização",HttpStatus.OK);
		}
		
		HistoricoCompras histo = historicoRepository.saveAndFlush(hist);
		
		return new ResponseEntity<HistoricoCompras>(histo, HttpStatus.OK);
		
	}
	
	
	
	
}
