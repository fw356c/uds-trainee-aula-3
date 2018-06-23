package br.com.uds.personagem;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PersonagemRepositoryImpl implements PersonagemRepository {

    private Set<Personagem> personagens= new HashSet();

    @Override
    public Personagem save(Personagem personagem) {
        personagens.add(personagem);
        return personagem;
    }

    @Override
    public Set<Personagem> findAll() {
        return personagens;
    }

    @Override
    public Personagem findOne(UUID id) {
        for (Personagem personagem:personagens ){
            if(personagem.getId().equals(id)){
                return personagem;

            }
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        Personagem personagem= this.findOne(id);
        this.personagens.remove(personagem);
    }
}
