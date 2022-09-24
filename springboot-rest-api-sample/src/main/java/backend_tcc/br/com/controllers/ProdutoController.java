package backend_tcc.br.com.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import backend_tcc.br.com.model.Produto;
import backend_tcc.br.com.repository.ProdutoRepository;

@RequestMapping("cadastro/produto")
@RestController
public class ProdutoController {

	
	@Autowired
	private ProdutoRepository prodRepository;
	
	
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Produto> saveProd(@ModelAttribute Produto produu, @RequestParam(value = "file", required = false) MultipartFile file) {
		
		try {
			if(file.getBytes().length> 0){
				
			 produu.setImagemProd(file.getBytes());
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Produto produto = prodRepository.save(produu);
		
		
		
		return new ResponseEntity<Produto> (produto, HttpStatus.CREATED);
		
		
	}
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Produto>> getProd(){
		
		
		List<Produto> prod = prodRepository.findAll();
		
		return new ResponseEntity<List<Produto>>(prod, HttpStatus.OK);
		
	}
	
	
	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<Produto> getProdId(@RequestParam(name = "id") Long id){
		
		
		Produto prod = prodRepository.findById(id).get();
		
		
		return new ResponseEntity<Produto> (prod, HttpStatus.OK);
	}
	
	@DeleteMapping
	@ResponseBody
	public ResponseEntity<String> deleteprod(@RequestParam Long id){
		
		
		prodRepository.deleteById(id);
		
		return new ResponseEntity<String>("Id delete successfully",HttpStatus.OK);
		
	}
	
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?>updateProd(@RequestBody Produto prod){
		
		if(prod.getIdProduto() == null ) {
			
			return new ResponseEntity<String>("id not defined to update", HttpStatus.OK);
			
		}
		
		Produto produto = prodRepository.saveAndFlush(prod);
		return new ResponseEntity<Produto>(produto,HttpStatus.OK);
		
	}
	
	
}
