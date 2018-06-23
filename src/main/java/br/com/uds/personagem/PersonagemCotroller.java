package br.com.uds.personagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/personagens")
public class PersonagemCotroller {
    @Autowired
    private PersonagemSevice personagemservice;

    @PostMapping
    public ResponseEntity criar(@RequestBody Ryu ryu){
        personagemservice.criar(ryu);
        return new ResponseEntity(ryu.toString(),HttpStatus.CREATED);

//
    }
        @GetMapping
        public Set<Personagem> listar(){
        return this.personagemservice.listar();
        }

        @GetMapping("/findBy")
        public Personagem obter(@RequestParam("id")UUID id){
        return  this.personagemservice.obter(id);

        }
    @DeleteMapping
    public ResponseEntity remover(@RequestParam("id")UUID id){
        this.personagemservice.remover(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

     @PutMapping
    public ResponseEntity editar(
            @RequestParam("id")UUID id,
            @RequestBody Personagem personagem){
        this.personagemservice.editar(id,personagem);
        return new ResponseEntity("editado com sucesso",HttpStatus.OK);

     }


}

