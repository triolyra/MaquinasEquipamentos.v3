package br.com.itau.maquinas_equipamentos.port.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
public class MaquEquiDto {

	// BEM DTO

	private int idTipoBem = 7;
	private String idBem;

	@NotNull(message = "Não pode ser nulo")
	private LocalDate dataDoCadastro;

	@NotNull(message = "Não pode ser nulo")
	private LocalDate dataDaAlteracao;

	@NotNull(message = "Não pode ser nulo")
	private String idUsuarioResponsavel;

	@NotNull(message = "Não pode ser nulo")
	private char indicadorValorizacaoManual;

	@NotNull(message = "Não pode ser nulo")
	private double valorAtualDoBem;

	// MÁQUINAS E EQUIPAMENTOS DTO

	private String idTipoMaquEqui;

	private int numeroSequencial;

	@NotNull(message = "Não pode ser nulo")
	private String numeroDeSerie;

	@NotNull(message = "Não pode ser nulo")
	private double numeroNotaFiscal;

	@NotNull(message = "Não pode ser nulo")
	private String descricaoCompl;

	// ENDEREÇO DTO

	private String cep;

	@NotNull(message = "Não pode ser nulo")
	private String logradouro;

	private String complemento;

	// SEGURO DTO

	private String nomeSeguradora;

	@NotNull(message = "Não pode ser nulo")
	private double numeroCpfOuCnpjSeguradora;

	private double numeroApoliceSeguro;

	@NotNull(message = "Não pode ser nulo")
	private char indicadorBeneficiarioSeguradora;

	@NotNull(message = "Não pode ser nulo")
	private LocalDate dataInicioApolice;

	private LocalDate dataFimApolice;

	private LocalDate dataRenovacaoApolice;
}
