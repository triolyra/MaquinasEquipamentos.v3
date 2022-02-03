package br.com.itau.maquinas_equipamentos.port.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.itau.maquinas_equipamentos.domain.model.Bem;

@Component
public interface MaquEquiRepository {
	
	Bem incluir(Bem bem);
	
	Bem atualizar(Bem bem);

	void deletar(String idBem);

	Optional<Bem> consultarPorId(String idBem);

	Long verificarSeExiste(String idBem);
}
