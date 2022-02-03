package br.com.itau.maquinas_equipamentos.domain.model;

import java.time.LocalDate;
import java.util.UUID;

import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MaquEqui {

	public MaquEqui(int idTipoBem, String idBem, LocalDate dataDoCadastro, LocalDate dataDaAlteracao,
			String idUsuarioResponsavel, char indicadorValorizacaoManual, double valorAtualDoBem, String idTipoMaquEqui,
			int numeroSequencial, String numeroDeSerie, double numeroNotaFiscal, String descricaoCompl, String cep,
			String logradouro, String complemento, String nomeSeguradora, double numeroCpfOuCnpjSeguradora,
			double numeroApoliceSeguro, char indicadorBeneficiarioSeguradora, LocalDate dataInicioApolice,
			LocalDate dataFimApolice, LocalDate dataRenovacaoApolice) {
		if (!this.validaUUIDs(idBem))
			throw new NegocioException("Id bem inválido");
		this.idTipoBem = idTipoBem;
		this.idBem = idBem;
		this.dataDoCadastro = dataDoCadastro;
		this.dataDaAlteracao = dataDaAlteracao;
		this.idUsuarioResponsavel = idUsuarioResponsavel;
		this.indicadorValorizacaoManual = indicadorValorizacaoManual;
		this.valorAtualDoBem = valorAtualDoBem;
		this.idTipoMaquEqui = idTipoMaquEqui;
		this.numeroSequencial = numeroSequencial;
		this.numeroDeSerie = numeroDeSerie;
		this.numeroNotaFiscal = numeroNotaFiscal;
		this.descricaoCompl = descricaoCompl;
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.nomeSeguradora = nomeSeguradora;
		this.numeroCpfOuCnpjSeguradora = numeroCpfOuCnpjSeguradora;
		this.numeroApoliceSeguro = numeroApoliceSeguro;
		this.indicadorBeneficiarioSeguradora = indicadorBeneficiarioSeguradora;
		this.dataInicioApolice = dataInicioApolice;
		this.dataFimApolice = dataFimApolice;
		this.dataRenovacaoApolice = dataRenovacaoApolice;
	}

	private int idTipoBem;
	private String idBem;

	private LocalDate dataDoCadastro;
	private LocalDate dataDaAlteracao;
	private String idUsuarioResponsavel;
	private char indicadorValorizacaoManual;
	private double valorAtualDoBem;

	private String idTipoMaquEqui;
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