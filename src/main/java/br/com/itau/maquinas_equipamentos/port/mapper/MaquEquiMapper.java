package br.com.itau.maquinas_equipamentos.port.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.MaquEquiEntity;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.MaquEquiEntityPK;
import br.com.itau.maquinas_equipamentos.domain.model.MaquEqui;
import br.com.itau.maquinas_equipamentos.port.dto.MaquEquiDto;

@Mapper
public interface MaquEquiMapper {

	@Mapping(target = "idTipoBem", ignore = true)
	MaquEquiEntityPK toEntityPk(String idBem);

	MaquEquiDto toMaquEquiDto(MaquEqui maquEqui);

	@Mapping(target = "pk.idBem", source = "idBem")
	@Mapping(target = "pk.idTipoBem", source = "idTipoBem")
	MaquEquiEntity toMaquEquiEntity(MaquEqui maquEqui);

	default MaquEqui fromMaquEquiDto(MaquEquiDto maquEquiDto) {
		return new MaquEqui(maquEquiDto.getIdTipoBem(), maquEquiDto.getIdBem(), maquEquiDto.getDataDoCadastro(),
				maquEquiDto.getDataDaAlteracao(), maquEquiDto.getIdUsuarioResponsavel(),
				maquEquiDto.getIndicadorValorizacaoManual(), maquEquiDto.getValorAtualDoBem(),
				maquEquiDto.getIdTipoMaquEqui(), maquEquiDto.getNumeroSequencial(), maquEquiDto.getNumeroDeSerie(),
				maquEquiDto.getNumeroNotaFiscal(), maquEquiDto.getDescricaoCompl(), maquEquiDto.getCep(),
				maquEquiDto.getLogradouro(), maquEquiDto.getComplemento(), maquEquiDto.getNomeSeguradora(),
				maquEquiDto.getNumeroCpfOuCnpjSeguradora(), maquEquiDto.getNumeroApoliceSeguro(),
				maquEquiDto.getIndicadorBeneficiarioSeguradora(), maquEquiDto.getDataInicioApolice(),
				maquEquiDto.getDataFimApolice(), maquEquiDto.getDataRenovacaoApolice());
	}

	default MaquEqui fromMaquEquiEntity(MaquEquiEntity maquEquiEntity) {
		return new MaquEqui(maquEquiEntity.getPk().getIdTipoBem(), maquEquiEntity.getPk().getIdBem(),
				maquEquiEntity.getDataDoCadastro(), maquEquiEntity.getDataDaAlteracao(),
				maquEquiEntity.getIdUsuarioResponsavel(), maquEquiEntity.getIndicadorValorizacaoManual(),
				maquEquiEntity.getValorAtualDoBem(), maquEquiEntity.getIdTipoMaquEqui(),
				maquEquiEntity.getNumeroSequencial(), maquEquiEntity.getNumeroDeSerie(),
				maquEquiEntity.getNumeroNotaFiscal(), maquEquiEntity.getDescricaoCompl(), maquEquiEntity.getCep(),
				maquEquiEntity.getLogradouro(), maquEquiEntity.getComplemento(), maquEquiEntity.getNomeSeguradora(),
				maquEquiEntity.getNumeroCpfOuCnpjSeguradora(), maquEquiEntity.getNumeroApoliceSeguro(),
				maquEquiEntity.getIndicadorBeneficiarioSeguradora(), maquEquiEntity.getDataInicioApolice(),
				maquEquiEntity.getDataFimApolice(), maquEquiEntity.getDataRenovacaoApolice());
	}
}
