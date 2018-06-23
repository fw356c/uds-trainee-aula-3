package br.com.uds.personagem;

import java.util.Set;
import java.util.UUID;

public interface PersonagemSevice {

    Personagem criar(Ryu ryu);

    Set<Personagem> listar();

    Personagem obter(UUID id);

    void remover(UUID id);

    void editar(UUID id, Personagem personagem);
}
