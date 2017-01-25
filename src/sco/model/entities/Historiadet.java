package sco.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the historiadet database table.
 * 
 */
@Entity
@Table(name="historiadet")
@NamedQuery(name="Historiadet.findAll", query="SELECT h FROM Historiadet h")
public class Historiadet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HISTORIADET_IDHISTORIADET_GENERATOR", sequenceName="SEQ_HISTORIADET", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HISTORIADET_IDHISTORIADET_GENERATOR")
	@Column(name="id_historiadet", unique=true, nullable=false)
	private Integer idHistoriadet;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_historiadet")
	private Date fechaHistoriadet;

	@Column(name="pagounitario_historiadet", precision=131089)
	private BigDecimal pagounitarioHistoriadet;

	@Column(name="sintomas_historiadet", length=200)
	private String sintomasHistoriadet;

	//bi-directional many-to-one association to Historiacab
	@ManyToOne
	@JoinColumn(name="id_historiacab")
	private Historiacab historiacab;

	public Historiadet() {
	}

	public Integer getIdHistoriadet() {
		return this.idHistoriadet;
	}

	public void setIdHistoriadet(Integer idHistoriadet) {
		this.idHistoriadet = idHistoriadet;
	}

	public Date getFechaHistoriadet() {
		return this.fechaHistoriadet;
	}

	public void setFechaHistoriadet(Date fechaHistoriadet) {
		this.fechaHistoriadet = fechaHistoriadet;
	}

	public BigDecimal getPagounitarioHistoriadet() {
		return this.pagounitarioHistoriadet;
	}

	public void setPagounitarioHistoriadet(BigDecimal pagounitarioHistoriadet) {
		this.pagounitarioHistoriadet = pagounitarioHistoriadet;
	}

	public String getSintomasHistoriadet() {
		return this.sintomasHistoriadet;
	}

	public void setSintomasHistoriadet(String sintomasHistoriadet) {
		this.sintomasHistoriadet = sintomasHistoriadet;
	}

	public Historiacab getHistoriacab() {
		return this.historiacab;
	}

	public void setHistoriacab(Historiacab historiacab) {
		this.historiacab = historiacab;
	}

}