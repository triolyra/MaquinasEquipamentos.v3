package br.com.itau.maquinas_equipamentos.adapter.datastore.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TBGG070_BEM")
@SecondaryTable(name = "TBGG076_BEM_MAQU")
@SecondaryTable(name = "TBGG082_ENDE_BEM")
@SecondaryTable(name = "TBGG087_SEGU_BEM")
public class MaquEquiEntity {

	@EmbeddedId
	private MaquEquiEntityPK pk;

	// TABELA DE BEM

	@Column(name = "DAT_HOR_CADT_RGTO", nullable = false)
	private LocalDate dataDoCadastro;

	@Column(name = "DAT_HOR_ALTE_RGTO", nullable = false)
	private LocalDate dataDaAlteracao;

	@Column(name = "COD_USUA_RSPL_ALTE", nullable = false)
	private String idUsuarioResponsavel;

	@Column(name = "IND_VLRZ_MANU", nullable = false)
	private char indicadorValorizacaoManual;

	@Column(name = "VLR_ATUL_BEM", nullable = false)
	private double valorAtualDoBem;

	// TABELA MÁQUINAS E EQUIPAMENTOS

	@Column(table = "TBGG076_BEM_MAQU", name = "COD_TIPO_MAQU_EQUI", nullable = false)
	private String idTipoMaquEqui;

	@Column(table = "TBGG076_BEM_MAQU", name = "NUM_IDEF_MAQU_EQUI", nullable = false)
	private int numeroSequencial;

	@Column(table = "TBGG076_BEM_MAQU", name = "COD_NUM_SRIE_MAQU_EQUI", nullable = false)
	private String numeroDeSerie;

	@Column(table = "TBGG076_BEM_MAQU", name = "NUM_NOTA_FISC_MAQU_EQUI", nullable = false)
	private double numeroNotaFiscal;

	@Column(table = "TBGG076_BEM_MAQU", name = "DESC_CMPL_MAQU_EQUI", nullable = false)
	private String descricaoCompl;

	// TABELA DE ENDEREÇO

	@Column(table = "TBGG082_ENDE_BEM", name = "ID_CEP_LOGR_BEM")
	private String cep;

	@Column(table = "TBGG082_ENDE_BEM", name = "COD_NUM_LOGR_BEM", nullable = false)
	private String logradouro;

	@Column(table = "TBGG082_ENDE_BEM", name = "DESC_CMPL_BEM")
	private String complemento;

	// TABELA DE SEGURO

	@Column(table = "TBGG087_SEGU_BEM", name = "NOM_SEGA")
	private String nomeSeguradora;

	@Column(table = "TBGG087_SEGU_BEM", name = "NUM_CPF_CNPJ_SEGA", nullable = false)
	private double numeroCpfOuCnpjSeguradora;

	@Column(table = "TBGG087_SEGU_BEM", name = "NUM_APOL_SEGU_BEM")
	private double numeroApoliceSeguro;

	@Column(table = "TBGG087_SEGU_BEM", name = "IND_BENF_SEGU_BEM_BANC", nullable = false)
	private char indicadorBeneficiarioSeguradora;

	@Column(table = "TBGG087_SEGU_BEM", name = "DAT_INIO_VIGE_APOL_SEGU_BEM", nullable = false)
	private LocalDate dataInicioApolice;

	@Column(table = "TBGG087_SEGU_BEM", name = "DAT_FIM_VIGE_APOL_SEGU_BEM")
	private LocalDate dataFimApolice;

	@Column(table = "TBGG087_SEGU_BEM", name = "DAT_RENO_APOL_SEGU_BEM")
	private LocalDate dataRenovacaoApolice;
}
