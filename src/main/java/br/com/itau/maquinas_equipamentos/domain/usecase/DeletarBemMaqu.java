package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.BemNaoEncontradoException;
import br.com.itau.maquinas_equipamentos.port.repository.MaquEquiRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
public class DeletarBemMaqu {

	private MaquEquiRepository maquEquiRepository;

	@Inject
	public DeletarBemMaqu(MaquEquiRepository maquEquiRepository) {
		this.maquEquiRepository = maquEquiRepository;
	}

	public void execute(String idBem) {
		verificarSeExiste(idBem);
		log.info("Apagando_Maquina_Equipamento=idBem={}", idBem);
		maquEquiRepository.deletar(idBem);
	}

	private void verificarSeExiste(String idBem) {
		var bemOptional = maquEquiRepository.consultarPorId(idBem);
		if (bemOptional.isEmpty()) {
			log.info("Maquina_Equipamento_Nao_Encontrado=idBem{}", idBem);
			throw new BemNaoEncontradoException(idBem);
		}
	}
}
