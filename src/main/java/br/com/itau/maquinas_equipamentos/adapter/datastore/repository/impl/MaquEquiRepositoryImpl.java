package br.com.itau.maquinas_equipamentos.adapter.datastore.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.itau.maquinas_equipamentos.adapter.datastore.repository.MaquEquiJpaRepository;
import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.domain.model.Bem;
import br.com.itau.maquinas_equipamentos.port.mapper.MapperFactory;
import br.com.itau.maquinas_equipamentos.port.mapper.MaquEquiMapper;
import br.com.itau.maquinas_equipamentos.port.repository.MaquEquiRepository;

@Repository
public class MaquEquiRepositoryImpl implements MaquEquiRepository {

	@Autowired
	private MaquEquiJpaRepository maquEquiJpaRepository;

	private final MaquEquiMapper maquEquiMapper = MapperFactory.newInstance(MaquEquiMapper.class);

	
	@Override
	public Bem incluir(Bem bem) {
		if (bem == null)
			throw new NegocioException("O bem não pode ser nulo");
		var maquEquiEntity = maquEquiJpaRepository.save(maquEquiMapper.toMaquEquiEntity(bem));
		return maquEquiMapper.fromMaquEquiEntity(maquEquiEntity);
	}

	@Override
	public void deletar(String idBem) {
		var maquEquiPk = maquEquiMapper.toEntityPk(idBem);
		{
			maquEquiJpaRepository.deleteById(maquEquiPk);
		}
	}

	@Override
	public Optional<Bem> consultarPorId(String idBem) {
		var bemPk = maquEquiMapper.toEntityPk(idBem);
		var bemEntityOptional = maquEquiJpaRepository.findById(bemPk);
		if (bemEntityOptional.isEmpty()) {
			return Optional.empty();
		}
		var bem = maquEquiMapper.fromMaquEquiEntity(bemEntityOptional.get());
		return Optional.of(bem);
	}

	@Override
	public Long verificarSeExiste(String idBem) {
		return maquEquiJpaRepository.countByPk(maquEquiMapper.toEntityPk(idBem));
	}

	@Override
	public Bem atualizar(Bem bem) {
		// TODO Auto-generated method stub
		return null;
	}
}
