package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.MaquEquiNaoEncontradoException;
import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.port.dto.MaquEquiDto;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.mapper.MaquEquiMapper;
import br.com.itau.maquinas_equipamentos.port.repository.MaquEquiRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
public class AtualizarMaquEqui {

	private final MaquEquiRepository maquEquiRepository;
	private final MaquEquiMapper maquEquiMapper = MapperFactory.newInstance(MaquEquiMapper.class);

	@Inject
	public AtualizarMaquEqui(MaquEquiRepository maquEquiRepository) {
		this.maquEquiRepository = maquEquiRepository;
	}

	public MaquEquiDto realizar(MaquEquiDto maquEquiDto) {
		if (maquEquiDto == null)
			throw new NegocioException("A DTO de bem máquina/equipamento não pode ser nulo");
		Long maquEquiExiste = maquEquiRepository.verificarSeExiste(maquEquiDto.getIdBem());
		if (maquEquiExiste <= 0L) {
			log.info("Maquina_Equipamento_Nao_Encontrado={}", maquEquiDto.toString());
			throw new MaquEquiNaoEncontradoException(maquEquiDto.getIdBem());
		}
		log.info("Atualizando_Maquina_Equipamento={}", maquEquiDto.toString());
		var maquEqui = maquEquiMapper.fromMaquEquiDto(maquEquiDto);
		var maquEquiAtualizado = maquEquiRepository.atualizar(maquEqui);
		var maquEquiAtualizadoDto = maquEquiMapper.toMaquEquiDto(maquEquiAtualizado);
		return maquEquiAtualizadoDto;
	}
}
