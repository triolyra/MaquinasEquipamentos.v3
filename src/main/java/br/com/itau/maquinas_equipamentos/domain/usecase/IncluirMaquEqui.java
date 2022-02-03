package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.port.dto.MaquEquiDto;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.mapper.MaquEquiMapper;
import br.com.itau.maquinas_equipamentos.port.repository.MaquEquiRepository;

@Named
public class IncluirMaquEqui {

	private final MaquEquiRepository maquEquiRepository;
	private final MaquEquiMapper maquEquiMapper = MapperFactory.newInstance(MaquEquiMapper.class);

	@Inject
	public IncluirMaquEqui(MaquEquiRepository maquEquiRepository) {
		this.maquEquiRepository = maquEquiRepository;
	}

	public MaquEquiDto execute(MaquEquiDto maquEquiDto) {
		if (maquEquiDto == null)
			throw new NegocioException("A DTO de bem máquina/equipamento não pode ser nulo");

		var maquEqui = maquEquiMapper.fromMaquEquiDto(maquEquiDto);
		var maquEquiSalvo = maquEquiRepository.incluir(maquEqui);
		var maquEquiSalvoDto = maquEquiMapper.toMaquEquiDto(maquEquiSalvo);
		return maquEquiSalvoDto;
	}
}
