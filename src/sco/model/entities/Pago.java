package sco.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pagos database table.
 * 
 */
@Entity
@Table(name="pagos")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAGOS_IDPAGOS_GENERATOR", sequenceName="SEQ_PAGOS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAGOS_IDPAGOS_GENERATOR")
	@Column(name="id_pagos", unique=true, nullable=false)
	private Integer idPagos;

	@Column(name="estado_pagos")
	private Boolean estadoPagos;

	//bi-directional many-to-one association to Historiacab
	@ManyToOne
	@JoinColumn(name="id_historiacab")
	private Historiacab historiacab;

	public Pago() {
	}

	public Integer getIdPagos() {
		return this.idPagos;
	}

	public void setIdPagos(Integer idPagos) {
		this.idPagos = idPagos;
	}

	public Boolean getEstadoPagos() {
		return this.estadoPagos;
	}

	public void setEstadoPagos(Boolean estadoPagos) {
		this.estadoPagos = estadoPagos;
	}

	public Historiacab getHistoriacab() {
		return this.historiacab;
	}

	public void setHistoriacab(Historiacab historiacab) {
		this.historiacab = historiacab;
	}

}