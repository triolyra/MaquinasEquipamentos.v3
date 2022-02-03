package br.com.itau.maquinas_equipamentos.port.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.itau.maquinas_equipamentos.domain.model.MaquEqui;

@Component
public interface MaquEquiRepository {

	MaquEqui incluir(MaquEqui maquEqui);

	MaquEqui atualizar(MaquEqui maquEqui);

	void deletar(String idBem);

	Optional<MaquEqui> consultarPorId(String idBem);

	Long verificarSeExiste(String idBem);
}
