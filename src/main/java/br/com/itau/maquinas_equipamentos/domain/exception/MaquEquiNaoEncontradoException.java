package br.com.itau.maquinas_equipamentos.domain.exception;

import br.com.itau.maquinas_equipamentos.adapter.datastore.entity.MaquEquiEntityPK;

public class MaquEquiNaoEncontradoException extends NegocioException {

	private static final long serialVersionUID = 3029128520249095094L;

	public MaquEquiNaoEncontradoException(String idBem) {
		super(new MaquEquiEntityPK().toString());
	}
}
