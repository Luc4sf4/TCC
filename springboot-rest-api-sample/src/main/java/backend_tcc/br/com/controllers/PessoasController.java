package backend_tcc.br.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import backend_tcc.br.com.model.Pessoas;
import backend_tcc.br.com.repository.PessoaRepository;


@RequestMapping("pessoa")
@RestController
public class PessoasController {

	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping()
	@ResponseBody
	public ResponseEntity<List<Pessoas>>getListEveryPessoa(@RequestParam (name = "pessoa") String pessoa){
		
		List<Pessoas> pessoas = pessoaRepository.findAll();
		
		return new ResponseEntity<List<Pessoas>>(pessoas, HttpStatus.OK);	
	}
	
	
	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<Pessoas> getListPessoaID (@RequestParam(name = "id") Long idPessoa) {
		
		Pessoas people = pessoaRepository.findById(idPessoa).get();
		
		return new ResponseEntity<Pessoas>(people, HttpStatus.OK);
		
	}
	
	
	
	@DeleteMapping()
	@ResponseBody
	ResponseEntity<String> deletePessoa(@RequestParam Long idPessoa){
		
		pessoaRepository.deleteById(idPessoa);
		
		return new ResponseEntity<String>("User deletado com sucesso", HttpStatus.OK);
		
	}
	
	
	
	@PutMapping()
	@ResponseBody
	public ResponseEntity<?> updatePessoa(@RequestParam Pessoas pessoa){
		
		if(pessoa.getIdPessoa() == null) {
			
			
			return new ResponseEntity<String> ("Id não informado para atualização", HttpStatus.OK);
			
		}
		
		Pessoas pessoa1 = pessoaRepository.saveAndFlush(pessoa);
		
		return new ResponseEntity<Pessoas>(pessoa1, HttpStatus.OK);
		
	}
	
	
	
}
