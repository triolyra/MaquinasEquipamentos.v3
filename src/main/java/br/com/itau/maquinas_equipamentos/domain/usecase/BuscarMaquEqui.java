package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.MaquEquiNaoEncontradoException;
import br.com.itau.maquinas_equipamentos.port.dto.MaquEquiDto;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.mapper.MaquEquiMapper;
import br.com.itau.maquinas_equipamentos.port.repository.MaquEquiRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
public class BuscarMaquEqui {

	private final MaquEquiRepository maquEquiRepository;
	private final MaquEquiMapper maquEquiMapper = MapperFactory.newInstance(MaquEquiMapper.class);

	@Inject
	public BuscarMaquEqui(MaquEquiRepository maquEquiRepository) {
		this.maquEquiRepository = maquEquiRepository;
	}

	public MaquEquiDto realizar(String idBem) {
		log.info("Buscando_MaquEqui_Por_ID=idBem={}", idBem);
		var bemOptional = maquEquiRepository.consultarPorId(idBem);
		if (bemOptional.isEmpty()) {
			log.info("MaquEqui_Nao_Encontrada=idBem={}", idBem);
			throw new MaquEquiNaoEncontradoException(idBem);
		}
		return maquEquiMapper.toMaquEquiDto(bemOptional.get());
	}
}