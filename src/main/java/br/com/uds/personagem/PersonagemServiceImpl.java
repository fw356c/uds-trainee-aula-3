package br.com.uds.personagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class PersonagemServiceImpl implements PersonagemSevice{

    @Autowired
    private PersonagemRepository repositoty;

    @Override
    public Personagem criar(Ryu ryu) {
        return this.repositoty.save(ryu);

    }

    @Override
    public Set<Personagem> listar() {
        return this.repositoty.findAll();
    }

    @Override
    public Personagem obter(UUID id) {
        return this.repositoty.findOne(id);
    }

    @Override
    public void remover(UUID id) {
        this.repositoty.delete(id);

    }

    @Override
    public void editar(UUID id, Personagem personagem) {
        Personagem personagemrecuperado= this.obter(id);
        personagemrecuperado.setNivelDePoder(personagem.getNivelDePoder());
        personagemrecuperado.setPontosDeVida(personagem.getPontosDeVida());
        personagemrecuperado.setNome(personagem.getNome());
        this.repositoty.save(personagemrecuperado);

    }
}
