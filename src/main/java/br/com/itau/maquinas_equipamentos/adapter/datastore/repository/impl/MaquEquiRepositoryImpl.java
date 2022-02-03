package br.com.itau.maquinas_equipamentos.adapter.datastore.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.itau.maquinas_equipamentos.adapter.datastore.repository.MaquEquiJpaRepository;
import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.domain.model.MaquEqui;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.mapper.MaquEquiMapper;
import br.com.itau.maquinas_equipamentos.port.repository.MaquEquiRepository;

@Repository
public class MaquEquiRepositoryImpl implements MaquEquiRepository {

	@Autowired
	private MaquEquiJpaRepository maquEquiJpaRepository;

	private final MaquEquiMapper maquEquiMapper = MapperFactory.newInstance(MaquEquiMapper.class);

	@Override
	public MaquEqui incluir(MaquEqui maquEqui) {
		if (maquEqui == null)
			throw new NegocioException("O bem máquina/equipamento não pode ser nulo");
		var maquEquiEntity = maquEquiJpaRepository.save(maquEquiMapper.toMaquEquiEntity(maquEqui));
		return maquEquiMapper.fromMaquEquiEntity(maquEquiEntity);
	}

	@Override
	public Optional<MaquEqui> consultarPorId(String idBem) {
		var maquEquiPk = maquEquiMapper.toEntityPk(idBem);
		var maquEquiEntityOptional = maquEquiJpaRepository.findById(maquEquiPk);
		if (maquEquiEntityOptional.isEmpty()) {
			return Optional.empty();
		}
		var maquEqui = maquEquiMapper.fromMaquEquiEntity(maquEquiEntityOptional.get());
		return Optional.of(maquEqui);
	}

	@Override
	public MaquEqui atualizar(MaquEqui maquEqui) {
		return this.atualizar(maquEqui);
	}

	@Override
	public void deletar(String idBem) {
		var maquEquiPk = maquEquiMapper.toEntityPk(idBem);
		{
			maquEquiJpaRepository.deleteById(maquEquiPk);
		}
	}

	@Override
	public Long verificarSeExiste(String idBem) {
		return maquEquiJpaRepository.countByPk(maquEquiMapper.toEntityPk(idBem));
	}
}
