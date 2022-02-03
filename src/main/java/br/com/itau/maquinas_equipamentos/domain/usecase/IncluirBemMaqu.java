package br.com.itau.maquinas_equipamentos.domain.usecase;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.port.dto.MaquEquiDto;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.mapper.MaquEquiMapper;
import br.com.itau.maquinas_equipamentos.port.repository.MaquEquiRepository;

@Named
public class IncluirBemMaqu {

	private final MaquEquiRepository maquEquiRepository;
	private final MaquEquiMapper maquEquiMapper = MapperFactory.newInstance(MaquEquiMapper.class);

	@Inject
	public IncluirBemMaqu(MaquEquiRepository maquEquiRepository) {
		this.maquEquiRepository = maquEquiRepository;
	}

	public MaquEquiDto execute(MaquEquiDto maquEquiDto) {
		if (maquEquiDto == null)
			throw new NegocioException("O bem DTO não pode ser nulo");

		var bem = maquEquiMapper.fromMaquEquiDto(maquEquiDto);
		var bemSalvo = maquEquiRepository.incluir(bem);
		var bemSalvoDto = maquEquiMapper.toMaquEquiDto(bemSalvo);
		return bemSalvoDto;
	}
}
