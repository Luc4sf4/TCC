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

import backend_tcc.br.com.model.Categoria;
import backend_tcc.br.com.repository.CategoriaRepository;


@RequestMapping ("categoria") 
@RestController
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	
	
	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<Categoria> getcategoriaid(
			@RequestParam(name = "id") Long id) /* Recebe os dados para consultar */ {

		Categoria id1 = categoriaRepository.findById(id).get();

		return new ResponseEntity<Categoria>(id1, HttpStatus.OK);
	}

	@GetMapping()
	@ResponseBody
	public ResponseEntity<List<Categoria>> getEveryCategoria() {

		List<Categoria> cat = categoriaRepository.findAll();/* executa a consulta do banco de dados */

		return new ResponseEntity<List<Categoria>>(cat, HttpStatus.OK);

	}

	@PostMapping()
	@ResponseBody
	public ResponseEntity<Categoria> salvarCategoria(
			@RequestBody Categoria categoria) /* Recebe os dados para salvar */ {

		Categoria cat = categoriaRepository.save(categoria);

		return new ResponseEntity<Categoria>(cat, HttpStatus.CREATED);
	}

	@DeleteMapping()
	@ResponseBody
	ResponseEntity<String> deleteCategoria(@RequestParam Long id) /* Recebe os dados para salvar */ {

		categoriaRepository.deleteById(id);

		return new ResponseEntity<String>("User deletado com sucesso ", HttpStatus.OK);
	}

	@PutMapping()
	@ResponseBody
	public ResponseEntity<?> atualizarCategoria(@RequestBody Categoria categoria) /* Recebe os dados para salvar */ {

		if (categoria.getId() == null) {
			return new ResponseEntity<String>(" Id não foi informado para a atualização ", HttpStatus.OK);
		}

		Categoria cat = categoriaRepository.saveAndFlush(categoria);

		return new ResponseEntity<Categoria>(cat, HttpStatus.OK);
	}

}
