package br.com.itau.maquinas_equipamentos.adapter.datastore.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.MaquEquiEntity;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.MaquEquiEntityPK;
import br.com.itau.maquinas_equipamentos.adapter.datastore.repository.MaquEquiJpaRepository;
import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.port.MockFactory;

@ExtendWith(MockitoExtension.class)
public class MaquEquiRepositoryImplTest {

	@Mock
	private MaquEquiJpaRepository maquEquiJpaRepository;
	@InjectMocks
	private MaquEquiRepositoryImpl maquEquiRepositoryImpl;

	@Test
	@DisplayName("Incluir bem máquina/equipamento")
	void salvar() {
		var maquEqui = MockFactory.criarMaquEqui();
		var maquEquiEntitySalvo = MockFactory.criarMaquEquiEntity();
		var maquEquiConvertido = MockFactory.criarMaquEqui();

		when(maquEquiJpaRepository.save(any(MaquEquiEntity.class))).thenReturn(maquEquiEntitySalvo);
		var maquEquiRetorno = maquEquiRepositoryImpl.incluir(maquEqui);

		assertNotNull(maquEquiRetorno);
		assertEquals(maquEquiRetorno.getIdTipoBem(), maquEquiConvertido.getIdBem());
		assertEquals(maquEquiRetorno.getIdBem(), maquEquiConvertido.getIdBem());
		assertEquals(maquEquiRetorno.getDataDoCadastro(), maquEquiConvertido.getDataDoCadastro());
		assertEquals(maquEquiRetorno.getDataDaAlteracao(), maquEquiConvertido.getDataDaAlteracao());
		assertEquals(maquEquiRetorno.getIdUsuarioResponsavel(), maquEquiConvertido.getIdUsuarioResponsavel());
		assertEquals(maquEquiRetorno.getIndicadorValorizacaoManual(),
				maquEquiConvertido.getIndicadorValorizacaoManual());
		assertEquals(maquEquiRetorno.getValorAtualDoBem(), maquEquiConvertido.getValorAtualDoBem());
		assertEquals(maquEquiRetorno.getIdTipoMaquEqui(), maquEquiConvertido.getIdTipoMaquEqui());
		assertEquals(maquEquiRetorno.getNumeroSequencial(), maquEquiConvertido.getNumeroSequencial());
		assertEquals(maquEquiRetorno.getNumeroDeSerie(), maquEquiConvertido.getNumeroDeSerie());
		assertEquals(maquEquiRetorno.getNumeroNotaFiscal(), maquEquiConvertido.getNumeroNotaFiscal());
		assertEquals(maquEquiRetorno.getDescricaoCompl(), maquEquiConvertido.getDescricaoCompl());
		assertEquals(maquEquiRetorno.getCep(), maquEquiConvertido.getCep());
		assertEquals(maquEquiRetorno.getLogradouro(), maquEquiConvertido.getLogradouro());
		assertEquals(maquEquiRetorno.getComplemento(), maquEquiConvertido.getComplemento());
		assertEquals(maquEquiRetorno.getNomeSeguradora(), maquEquiConvertido.getNomeSeguradora());
		assertEquals(maquEquiRetorno.getNumeroCpfOuCnpjSeguradora(), maquEquiConvertido.getNumeroCpfOuCnpjSeguradora());
		assertEquals(maquEquiRetorno.getNumeroApoliceSeguro(), maquEquiConvertido.getNumeroApoliceSeguro());
		assertEquals(maquEquiRetorno.getIndicadorBeneficiarioSeguradora(),
				maquEquiConvertido.getIndicadorBeneficiarioSeguradora());
		assertEquals(maquEquiRetorno.getDataInicioApolice(), maquEquiConvertido.getDataInicioApolice());
		assertEquals(maquEquiRetorno.getDataFimApolice(), maquEquiConvertido.getDataFimApolice());
		assertEquals(maquEquiRetorno.getDataRenovacaoApolice(), maquEquiConvertido.getDataRenovacaoApolice());
	}

	@Test
	@DisplayName("Atualizar bem máquina/equipamento")
	void atualizar() {
		var maquEqui = MockFactory.criarMaquEqui();
		var maquEquiEntitySalvo = MockFactory.criarMaquEquiEntity();
		var maquEquiConvertido = MockFactory.criarMaquEqui();
		
		when(maquEquiJpaRepository.save(any(MaquEquiEntity.class))).thenReturn(maquEquiEntitySalvo);
		var maquEquiRetorno = maquEquiRepositoryImpl.atualizar(maquEqui);
		
		assertNotNull(maquEquiRetorno);
		assertEquals(maquEquiRetorno.getIdTipoBem(), maquEquiConvertido.getIdBem());
		assertEquals(maquEquiRetorno.getIdBem(), maquEquiConvertido.getIdBem());
		assertEquals(maquEquiRetorno.getDataDoCadastro(), maquEquiConvertido.getDataDoCadastro());
		assertEquals(maquEquiRetorno.getDataDaAlteracao(), maquEquiConvertido.getDataDaAlteracao());
		assertEquals(maquEquiRetorno.getIdUsuarioResponsavel(), maquEquiConvertido.getIdUsuarioResponsavel());
		assertEquals(maquEquiRetorno.getIndicadorValorizacaoManual(),
				maquEquiConvertido.getIndicadorValorizacaoManual());
		assertEquals(maquEquiRetorno.getValorAtualDoBem(), maquEquiConvertido.getValorAtualDoBem());
		assertEquals(maquEquiRetorno.getIdTipoMaquEqui(), maquEquiConvertido.getIdTipoMaquEqui());
		assertEquals(maquEquiRetorno.getNumeroSequencial(), maquEquiConvertido.getNumeroSequencial());
		assertEquals(maquEquiRetorno.getNumeroDeSerie(), maquEquiConvertido.getNumeroDeSerie());
		assertEquals(maquEquiRetorno.getNumeroNotaFiscal(), maquEquiConvertido.getNumeroNotaFiscal());
		assertEquals(maquEquiRetorno.getDescricaoCompl(), maquEquiConvertido.getDescricaoCompl());
		assertEquals(maquEquiRetorno.getCep(), maquEquiConvertido.getCep());
		assertEquals(maquEquiRetorno.getLogradouro(), maquEquiConvertido.getLogradouro());
		assertEquals(maquEquiRetorno.getComplemento(), maquEquiConvertido.getComplemento());
		assertEquals(maquEquiRetorno.getNomeSeguradora(), maquEquiConvertido.getNomeSeguradora());
		assertEquals(maquEquiRetorno.getNumeroCpfOuCnpjSeguradora(), maquEquiConvertido.getNumeroCpfOuCnpjSeguradora());
		assertEquals(maquEquiRetorno.getNumeroApoliceSeguro(), maquEquiConvertido.getNumeroApoliceSeguro());
		assertEquals(maquEquiRetorno.getIndicadorBeneficiarioSeguradora(),
				maquEquiConvertido.getIndicadorBeneficiarioSeguradora());
		assertEquals(maquEquiRetorno.getDataInicioApolice(), maquEquiConvertido.getDataInicioApolice());
		assertEquals(maquEquiRetorno.getDataFimApolice(), maquEquiConvertido.getDataFimApolice());
		assertEquals(maquEquiRetorno.getDataRenovacaoApolice(), maquEquiConvertido.getDataRenovacaoApolice());
	}

	@Test
	@DisplayName("Verificar se o bem máquina/equipamento existe")
	void verificarSeExiste() {
		var maquEqui = MockFactory.criarMaquEqui();
		
		when(maquEquiJpaRepository.countByPk(any(MaquEquiEntityPK.class))).thenReturn(1L);
		
		Long maquEquiExiste = maquEquiRepositoryImpl.verificarSeExiste(maquEqui.getIdBem());
		assertNotNull(maquEquiExiste);
		assertEquals(1L, maquEquiExiste);
	}
	
	@Test
	@DisplayName("Incluir bem máquina/equipamento")
	void incluirMaquEquiNulo() {
		assertThrows(NegocioException.class, () -> {
			maquEquiRepositoryImpl.incluir(null);
		});
	}
	
	@Test
	@DisplayName("Atualizar bem máquina/equipamento")
	void atualizarMaquEquiNulo() {
		assertThrows(NegocioException.class, () -> {
			maquEquiRepositoryImpl.incluir(null);
		});
	}
	
	@Test
	@DisplayName("Verificar se a busca de MaquEquiDto não é nulo")
	void verificarSeMaquEquiDtoNaoNulo() {
		assertThrows(NegocioException.class, () -> {
			maquEquiRepositoryImpl.consultarPorId(null);
		});
	}
}
