package br.com.itau.maquinas_equipamentos.adapter.datastore.http.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.itau.maquinas_equipamentos.adapter.http.controller.MaquEquiController;
import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.domain.usecase.AtualizarMaquEqui;
import br.com.itau.maquinas_equipamentos.domain.usecase.BuscarMaquEqui;
import br.com.itau.maquinas_equipamentos.domain.usecase.DeletarBemMaqu;
import br.com.itau.maquinas_equipamentos.domain.usecase.IncluirMaquEqui;
import br.com.itau.maquinas_equipamentos.port.MockFactory;
import br.com.itau.maquinas_equipamentos.port.dto.MaquEquiDto;

@ExtendWith(MockitoExtension.class)
public class MaquEquiControllerTest {

	@Mock
	private IncluirMaquEqui incluirMaquEqui;
	@Mock
	private BuscarMaquEqui buscarMaquEqui;
	@Mock
	private AtualizarMaquEqui atualizarMaquEqui;
	@Mock
	private DeletarBemMaqu deletarBemMaqu;

	@Captor
	ArgumentCaptor<MaquEquiDto> maquEquiDtoArgumentCaptor;

	private MaquEquiController maquEquiController;

	@BeforeEach
	void setup() {
		maquEquiController = new MaquEquiController(incluirMaquEqui, buscarMaquEqui, atualizarMaquEqui, deletarBemMaqu);
	}

	@Test
	@DisplayName("Deve incluir o bem máquina/equipamento")
	void deveIncluirMaquEqui() {
		var maquEquiDto = MockFactory.criarMaquEquiDto();
		var idBem = getUUID();

		when(incluirMaquEqui.realizar(maquEquiDto)).thenReturn(maquEquiDto);
		var retorno = maquEquiController.incluir(idBem, maquEquiDto);

		assertEquals(201, retorno.getStatusCodeValue());
		var maquEquiSalvo = retorno.getBody().getDataDoCadastro();
		assertEquals(maquEquiDto, maquEquiSalvo);
	}

	@Test
	@DisplayName("Deve setar o idBem no corpo da requisição ao fazer a inclusão")
	void deveSetarIdBemNaInclusao() {
		var maquEquiDto = MockFactory.criarMaquEquiDto();
		maquEquiDto.setIdBem("13131313");
		var idBem = getUUID();

		when(incluirMaquEqui.realizar(maquEquiDto)).thenReturn(maquEquiDto);
		var retorno = maquEquiController.incluir(idBem, maquEquiDto);
		verify(incluirMaquEqui).realizar(maquEquiDtoArgumentCaptor.capture());
		var maquEquiCapturado = maquEquiDtoArgumentCaptor.getValue();

		assertEquals(idBem.toString(), maquEquiCapturado.getIdBem());
		assertEquals(201, retorno.getStatusCodeValue());
		var maquEquiSalvo = retorno.getBody().getDataDoCadastro();
		assertEquals(maquEquiDto, maquEquiSalvo);
	}

	@Test
	@DisplayName("Deve buscar o bem máquina/equipamento pelo id")
	void deveBuscarPeloId() throws NegocioException {
		var maquEquiDto = MockFactory.criarMaquEquiDto();
		var idBem = toUUID(maquEquiDto.getIdBem().toUpperCase());
		
		when(buscarMaquEqui.realizar(idBem.toString())).thenReturn(MockFactory.criarMaquEquiDto());
		var retorno = maquEquiController.buscarPorId(idBem);
		assertEquals(201, retorno.getStatusCodeValue());
		var maquEquiDtoRetorno = (MaquEquiDto) retorno.getBody();
		
	}

	private UUID getUUID() {
		return UUID.randomUUID();
	}

	private UUID toUUID(String id) {
		return UUID.fromString(id);
	}
}
