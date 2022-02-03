package br.com.itau.maquinas_equipamentos.adapter.http.controller;

import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.maquinas_equipamentos.domain.exception.MaquEquiNaoEncontradoException;
import br.com.itau.maquinas_equipamentos.domain.exception.NegocioException;
import br.com.itau.maquinas_equipamentos.domain.usecase.AtualizarMaquEqui;
import br.com.itau.maquinas_equipamentos.domain.usecase.BuscarMaquEqui;
import br.com.itau.maquinas_equipamentos.domain.usecase.DeletarBemMaqu;
import br.com.itau.maquinas_equipamentos.domain.usecase.IncluirMaquEqui;
import br.com.itau.maquinas_equipamentos.port.dto.MaquEquiDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/garantias")
@RequiredArgsConstructor
public class MaquEquiController {

	private final IncluirMaquEqui incluirMaquEqui;
	private final BuscarMaquEqui buscarMaquEqui;
	private final AtualizarMaquEqui atualizarMaquEqui;
	private final DeletarBemMaqu deletarBemMaqu;
	public static final String PATH_MAQUEQUI = "bens/{id_bem}/maquinas-equipamentos";
	public static final String ID_BEM = "id_bem";
	public static final String ID_TIPO_BEM = "id_tipo_bem";

	@PostMapping(PATH_MAQUEQUI)
	@Transactional
	public ResponseEntity<MaquEquiDto> incluir(@PathVariable(name = ID_BEM) UUID idBem,
			@Valid @RequestBody MaquEquiDto maquEquiDto) {
		maquEquiDto.setIdBem(idBem.toString());
		var maquEqui = incluirMaquEqui.realizar(maquEquiDto);
		log.info("MaquEqu_Salvo={}", maquEqui.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(incluirMaquEqui.realizar(maquEqui));
	}

	@GetMapping(PATH_MAQUEQUI)
	public ResponseEntity<MaquEquiDto> buscarPorId(@PathVariable(name = ID_BEM) UUID idBem) throws NegocioException {
		MaquEquiDto maquEquiDto;
		try {
			maquEquiDto = buscarMaquEqui.realizar(idBem.toString());
			log.info("MaquEqui_Retornado={}", maquEquiDto.toString());
		} catch (MaquEquiNaoEncontradoException ex) {
			throw new NegocioException("Não foi encontrado");
		}
		return ResponseEntity.ok(maquEquiDto);
	}

	@PatchMapping(PATH_MAQUEQUI)
	@Transactional
	public ResponseEntity<MaquEquiDto> atualizar(@PathVariable(name = ID_BEM) UUID idBem,
			@Valid @RequestBody MaquEquiDto maquEquiDto) throws NegocioException {
		maquEquiDto.setIdBem(idBem.toString());
		MaquEquiDto maquEquiAtualizado;
		try {
			maquEquiAtualizado = atualizarMaquEqui.realizar(maquEquiDto);
		} catch (MaquEquiNaoEncontradoException ex) {
			throw new NegocioException("Não foi encontrado");
		}
		log.info("Maquina_Equipamento_Atualizado={}", maquEquiAtualizado.toString());
		return ResponseEntity.ok(atualizarMaquEqui.realizar(maquEquiDto));
	}

	@DeleteMapping(PATH_MAQUEQUI)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarBem(@PathVariable(name = ID_BEM) UUID idBem) throws NegocioException {
		try {
			deletarBemMaqu.execute(idBem.toString());
		} catch (MaquEquiNaoEncontradoException ex) {
			throw new NegocioException("Não foi encontrado");
		}
	}
}
