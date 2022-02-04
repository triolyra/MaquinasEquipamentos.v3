package br.com.itau.maquinas_equipamentos.port;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.MaquEquiEntity;
import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.MaquEquiEntityPK;
import br.com.itau.maquinas_equipamentos.domain.model.MaquEqui;
import br.com.itau.maquinas_equipamentos.port.dto.MaquEquiDto;

public class MockFactory {

	public static final String ID_BEM = UUID.fromString("31246570-a314-44a0-b986-22024da29569").toString()
			.toUpperCase();
	public static final int ID_TIPO_BEM = 7;

	public static final LocalDate DATA_DO_CADASTRO = LocalDate.of(2022, Month.FEBRUARY, 03);
	public static final LocalDate DATA_DA_ALTERACAO = LocalDate.of(2022, Month.FEBRUARY, 04);
	public static final String ID_USUARIO_RESPONSAVEL = "9ad41e05-9022-4ce4-ac3d-c5494145aa1d";
	public static final char INDICADOR_VALORIZACAO_MANUAL = 's';
	public static final double VALOR_ATUAL_DO_BEM = 200.000;

	public static final String ID_TIPO_MAQU_EQUI = "3";
	public static final int NUMERO_SEQUENCIAL = 123456789;
	public static final String NUMERO_DE_SERIE = "1t2a3y4l05r";
	public static final double NUMERO_NOTA_FISCAL = 14314.31234213 - 123;
	public static final String DESCRICAO_COMPL = "Exemplo";

	public static final String CEP = "12345-124";
	public static final String LOGRADOURO = "Exemplo";
	public static final String COMPLEMENTO = "Exemplo";

	public static final String NOME_SEGURADORA = "Exemplo";
	public static final double NUMERO_CPF_OU_CNPJ_SEGURADORA = 260.7435600;
	public static final double NUMERO_APOLICE_SEGURO = 14314.31234213 - 123;
	public static final char INDICADOR_BENEFICIARIO_SEGURADORA = 's';;
	public static final LocalDate DATA_INICIO_APOLICE = LocalDate.of(2022, Month.FEBRUARY, 03);
	public static final LocalDate DATA_FIM_APOLICE = LocalDate.of(2022, Month.FEBRUARY, 04);
	public static final LocalDate DATA_RENOVACAO_APOLICE = LocalDate.of(2022, Month.FEBRUARY, 05);

	public static MaquEqui criarMaquEqui() {
		return new MaquEqui(ID_TIPO_BEM, ID_BEM, DATA_DO_CADASTRO, DATA_DA_ALTERACAO, ID_USUARIO_RESPONSAVEL,
				INDICADOR_VALORIZACAO_MANUAL, VALOR_ATUAL_DO_BEM, ID_TIPO_MAQU_EQUI, NUMERO_SEQUENCIAL, NUMERO_DE_SERIE,
				NUMERO_NOTA_FISCAL, DESCRICAO_COMPL, CEP, LOGRADOURO, COMPLEMENTO, NOME_SEGURADORA,
				NUMERO_CPF_OU_CNPJ_SEGURADORA, NUMERO_APOLICE_SEGURO, INDICADOR_BENEFICIARIO_SEGURADORA,
				DATA_INICIO_APOLICE, DATA_FIM_APOLICE, DATA_RENOVACAO_APOLICE);
	}

	public static MaquEquiEntityPK criarMaquEquiEntityPk() {
		return MaquEquiEntityPK.builder().idBem(ID_BEM).build();
	}

	public static MaquEquiEntity criarMaquEquiEntity() {
		return new MaquEquiEntity(criarMaquEquiEntityPk(),DATA_DO_CADASTRO, DATA_DA_ALTERACAO,
				ID_USUARIO_RESPONSAVEL, INDICADOR_VALORIZACAO_MANUAL, VALOR_ATUAL_DO_BEM, ID_TIPO_MAQU_EQUI,
				NUMERO_SEQUENCIAL, NUMERO_DE_SERIE, NUMERO_NOTA_FISCAL, DESCRICAO_COMPL, CEP, LOGRADOURO, COMPLEMENTO,
				NOME_SEGURADORA, NUMERO_CPF_OU_CNPJ_SEGURADORA, NUMERO_APOLICE_SEGURO,
				INDICADOR_BENEFICIARIO_SEGURADORA, DATA_INICIO_APOLICE, DATA_FIM_APOLICE, DATA_RENOVACAO_APOLICE);
	}
	
	public static MaquEquiDto criarMaquEquiDto() {
		return new MaquEquiDto(ID_TIPO_BEM, ID_BEM, DATA_DO_CADASTRO, DATA_DA_ALTERACAO, ID_USUARIO_RESPONSAVEL,
				INDICADOR_VALORIZACAO_MANUAL, VALOR_ATUAL_DO_BEM, ID_TIPO_MAQU_EQUI, NUMERO_SEQUENCIAL, NUMERO_DE_SERIE,
				NUMERO_NOTA_FISCAL, DESCRICAO_COMPL, CEP, LOGRADOURO, COMPLEMENTO, NOME_SEGURADORA,
				NUMERO_CPF_OU_CNPJ_SEGURADORA, NUMERO_APOLICE_SEGURO, INDICADOR_BENEFICIARIO_SEGURADORA,
				DATA_INICIO_APOLICE, DATA_FIM_APOLICE, DATA_RENOVACAO_APOLICE);
	}
	
	public static MaquEquiDto criarMaquEquiComDadosQuePodemSerNulos() {
		return new MaquEquiDto(ID_TIPO_BEM, ID_BEM, DATA_DO_CADASTRO, DATA_DA_ALTERACAO, ID_USUARIO_RESPONSAVEL,
				INDICADOR_VALORIZACAO_MANUAL, VALOR_ATUAL_DO_BEM, null, NUMERO_SEQUENCIAL, NUMERO_DE_SERIE,
				NUMERO_NOTA_FISCAL, DESCRICAO_COMPL, null, LOGRADOURO, null, null,
				NUMERO_CPF_OU_CNPJ_SEGURADORA, NUMERO_APOLICE_SEGURO, INDICADOR_BENEFICIARIO_SEGURADORA,
				DATA_INICIO_APOLICE, null, null);
	}
}
