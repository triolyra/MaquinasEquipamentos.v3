package br.com.itau.maquinas_equipamentos.port.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.MaquEquiEntity;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.MaquEquiEntityPK;
import br.com.itau.maquinas_equipamentos.domain.model.Bem;
import br.com.itau.maquinas_equipamentos.port.dto.MaquEquiDto;

@Mapper
public interface MaquEquiMapper {

	@Mapping(target = "idTipoBem", ignore = true)
	MaquEquiEntityPK toEntityPk(String idBem);

	MaquEquiDto toMaquEquiDto(Bem bem);

	@Mapping(target = "pk.idBem", source = "idBem")
	@Mapping(target = "pk.idTipoBem", source = "idTipoBem")
	MaquEquiEntity toMaquEquiEntity(Bem bem);

	default Bem fromMaquEquiDto(MaquEquiDto maquEquiDto) {
		return new Bem(maquEquiDto.getIdBem(), maquEquiDto.getIdTipoBem(), maquEquiDto.getIdUsuarioResponsavel(),
				maquEquiDto.getDataDoCadastro(), maquEquiDto.getDataDaAlteracao(),
				maquEquiDto.getIndicadorValorizacaoManual(), maquEquiDto.getValorAtualDoBem(),
				maquEquiDto.getDescricaoCompl(), maquEquiDto.getIdTipoMaquEqui(), maquEquiDto.getNumeroDeSerie(),
				maquEquiDto.getNumeroNotaFiscal(), maquEquiDto.getNumeroSequencial(), maquEquiDto.getCep(),
				maquEquiDto.getLogradouro(), maquEquiDto.getComplemento(), maquEquiDto.getDataFimApolice(),
				maquEquiDto.getDataInicioApolice(), maquEquiDto.getDataRenovacaoApolice(),
				maquEquiDto.getIndicadorBeneficiarioSeguradora(), maquEquiDto.getNomeSeguradora(),
				maquEquiDto.getNumeroApoliceSeguro(), maquEquiDto.getNumeroCpfOuCnpjSeguradora());
	}

	default Bem fromMaquEquiEntity(MaquEquiEntity maquEquiEntity) {
		return new Bem(maquEquiEntity.getPk().getIdBem(), maquEquiEntity.getPk().getIdTipoBem(),
				maquEquiEntity.getIdUsuarioResponsavel(), maquEquiEntity.getDataDoCadastro(),
				maquEquiEntity.getDataDaAlteracao(), maquEquiEntity.getIndicadorValorizacaoManual(),
				maquEquiEntity.getValorAtualDoBem(), maquEquiEntity.getDescricaoCompl(),
				maquEquiEntity.getIdTipoMaquEqui(), maquEquiEntity.getNumeroDeSerie(),
				maquEquiEntity.getNumeroNotaFiscal(), maquEquiEntity.getNumeroSequencial(), maquEquiEntity.getCep(),
				maquEquiEntity.getLogradouro(), maquEquiEntity.getComplemento(), maquEquiEntity.getDataFimApolice(),
				maquEquiEntity.getDataInicioApolice(), maquEquiEntity.getDataRenovacaoApolice(),
				maquEquiEntity.getIndicadorBeneficiarioSeguradora(), maquEquiEntity.getNomeSeguradora(),
				maquEquiEntity.getNumeroApoliceSeguro(), maquEquiEntity.getNumeroCpfOuCnpjSeguradora());
	}
}
