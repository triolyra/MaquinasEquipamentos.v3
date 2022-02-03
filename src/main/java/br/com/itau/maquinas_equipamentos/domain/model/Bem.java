package br.com.itau.maquinas_equipamentos.domain.model;

import java.time.LocalDate;
import java.util.UUID;

import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Bem {

	public Bem(String idBem, int idTipoBem, String idUsuarioResponsavel, LocalDate dataDoCadastro,
			LocalDate dataDaAlteracao, char indicadorValorizacaoManual, double valorAtualDoBem, String descricaoCompl,
			String idTipoMaquEqui, String numeroDeSerie, double numeroNotaFiscal, int numeroSequencial, String cep,
			String logradouro, String complemento, LocalDate dataFimApolice, LocalDate dataInicioApolice,
			LocalDate dataRenovacaoApolice, char indicadorBeneficiarioSeguradora, String nomeSeguradora,
			double numeroApoliceSeguro, double numeroCpfOuCnpjSeguradora) {
		if (!this.validaUUIDs(idBem))
			throw new NegocioException("Id bem inválido");
		this.idBem = idBem;
		this.idTipoBem = idTipoBem;
		this.idUsuarioResponsavel = idUsuarioResponsavel;
		this.dataDaAlteracao = dataDaAlteracao;
		this.dataDoCadastro = dataDoCadastro;
		this.indicadorValorizacaoManual = indicadorValorizacaoManual;
		this.valorAtualDoBem = valorAtualDoBem;
		this.descricaoCompl = descricaoCompl;
		this.idTipoMaquEqui = idTipoMaquEqui;
		this.numeroDeSerie = numeroDeSerie;
		this.numeroNotaFiscal = numeroNotaFiscal;
		this.numeroSequencial = numeroSequencial;
		this.cep = cep;
		this.logradouro = logradouro;
		this.dataFimApolice = dataFimApolice;
		this.dataInicioApolice = dataInicioApolice;
		this.dataRenovacaoApolice = dataRenovacaoApolice;
		this.indicadorBeneficiarioSeguradora = indicadorBeneficiarioSeguradora;
		this.nomeSeguradora = nomeSeguradora;
		this.numeroApoliceSeguro = numeroApoliceSeguro;
		this.numeroCpfOuCnpjSeguradora = numeroCpfOuCnpjSeguradora;
	}
	
	private int idTipoBem;
	private String idBem;
	private String idTipoMaquEqui;

	private LocalDate dataDoCadastro;
	private LocalDate dataDaAlteracao;
	private String idUsuarioResponsavel;
	private char indicadorValorizacaoManual;
	private double valorAtualDoBem;

	private int numeroSequencial;
	private String numeroDeSerie;
	private double numeroNotaFiscal;
	private String descricaoCompl;
	
	private String cep;
	private String logradouro;
	private String complemento;
	
	private String nomeSeguradora;
	private double numeroCpfOuCnpjSeguradora;
	private double numeroApoliceSeguro;
	private char indicadorBeneficiarioSeguradora;
	private LocalDate dataInicioApolice;
	private LocalDate dataFimApolice;
	private LocalDate dataRenovacaoApolice;

	private boolean validaUUIDs(String uuid) {
		try {
			UUID.fromString(uuid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}