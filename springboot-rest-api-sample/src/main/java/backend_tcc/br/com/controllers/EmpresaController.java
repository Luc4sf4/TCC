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

import backend_tcc.br.com.model.Empresa;
import backend_tcc.br.com.repository.EmpresaRepository;

@RequestMapping("ini/")
@RestController
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepo;
 
    @PostMapping
    @ResponseBody
    public ResponseEntity<Empresa> saveEmpresa (@RequestBody Empresa emp){
        
        
        Empresa empresa = empresaRepo.save(emp);
        
        return new ResponseEntity<Empresa> (empresa, HttpStatus.CREATED);
        
    }
    
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Empresa>> getAllEmpresa(){
        
        List<Empresa> empresa = empresaRepo.findAll();
        
        return new ResponseEntity<List<Empresa>> (empresa ,HttpStatus.OK);
        
    }
    
    
    @GetMapping(value = "/id")
    @ResponseBody
    public ResponseEntity<Empresa> getEmpresaID(@RequestParam(name = "id")Long id){   
        Empresa empresa = empresaRepo.findById(id).get();
    
    return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
            
    }
    
    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> deleteEmpresa(@RequestParam Long id){
        
        empresaRepo.deleteById(id);
        
        return new ResponseEntity<String>("Empresa deletado com sucesso", HttpStatus.OK);
        
    }


    @PutMapping
    @ResponseBody
    public ResponseEntity<?>updateEmpresa (@RequestBody Empresa empresaConstructor){
        
        if(empresaConstructor.getId() == null) {
            
            
            return new ResponseEntity<String>("id não informado para atualização",HttpStatus.OK);
            
        }       
        
        Empresa empresa = empresaRepo.saveAndFlush(empresaConstructor);
        
        return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
        
    }
    
    
}
