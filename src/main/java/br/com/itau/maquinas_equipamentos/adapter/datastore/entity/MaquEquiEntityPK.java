package br.com.itau.maquinas_equipamentos.adapter.datastore.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MaquEquiEntityPK implements Serializable {

	private static final long serialVersionUID = -303025669985788188L;

	@Column(name = "COD_BEM", nullable = false, updatable = false)
	private String idBem;

	@Column(name = "COD_TIPO_BEM", nullable = false, updatable = false)
	private final int idTipoBem = 7;

	@Override
	public String toString() {
		return "BemEntityPK(" + "id_tipo_bem= " + idTipoBem + ",id_bem" + idBem + ')';
	}
}
