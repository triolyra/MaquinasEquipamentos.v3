package br.com.itau.maquinas_equipamentos.adapter.datastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.MaquEquiEntity;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.MaquEquiEntityPK;

public interface MaquEquiJpaRepository
		extends JpaRepository<MaquEquiEntity, MaquEquiEntityPK>, JpaSpecificationExecutor<MaquEquiEntity> {

	Long countByPk(MaquEquiEntityPK pk);
}
