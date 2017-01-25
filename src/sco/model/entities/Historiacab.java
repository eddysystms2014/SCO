package sco.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the historiacab database table.
 * 
 */
@Entity
@Table(name="historiacab")
@NamedQuery(name="Historiacab.findAll", query="SELECT h FROM Historiacab h")
public class Historiacab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HISTORIACAB_IDHISTORIACAB_GENERATOR", sequenceName="SEQ_HISTORIACAB", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HISTORIACAB_IDHISTORIACAB_GENERATOR")
	@Column(name="id_historiacab", unique=true, nullable=false)
	private Integer idHistoriacab;

	@Column(name="estado_historiacab")
	private Boolean estadoHistoriacab;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_historiacab")
	private Date fechaHistoriacab;

	@Column(name="total_historiacab", precision=131089)
	private BigDecimal totalHistoriacab;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(name="id_medicos")
	private Medico medico;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="id_pacientes")
	private Paciente paciente;

	//bi-directional many-to-one association to Historiadet
	@OneToMany(mappedBy="historiacab", cascade=CascadeType.ALL)
	private List<Historiadet> historiadets;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="historiacab")
	private List<Pago> pagos;

	public Historiacab() {
	}

	public Integer getIdHistoriacab() {
		return this.idHistoriacab;
	}

	public void setIdHistoriacab(Integer idHistoriacab) {
		this.idHistoriacab = idHistoriacab;
	}

	public Boolean getEstadoHistoriacab() {
		return this.estadoHistoriacab;
	}

	public void setEstadoHistoriacab(Boolean estadoHistoriacab) {
		this.estadoHistoriacab = estadoHistoriacab;
	}

	public Date getFechaHistoriacab() {
		return this.fechaHistoriacab;
	}

	public void setFechaHistoriacab(Date fechaHistoriacab) {
		this.fechaHistoriacab = fechaHistoriacab;
	}

	public BigDecimal getTotalHistoriacab() {
		return this.totalHistoriacab;
	}

	public void setTotalHistoriacab(BigDecimal totalHistoriacab) {
		this.totalHistoriacab = totalHistoriacab;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Historiadet> getHistoriadets() {
		return this.historiadets;
	}

	public void setHistoriadets(List<Historiadet> historiadets) {
		this.historiadets = historiadets;
	}

	public Historiadet addHistoriadet(Historiadet historiadet) {
		getHistoriadets().add(historiadet);
		historiadet.setHistoriacab(this);

		return historiadet;
	}

	public Historiadet removeHistoriadet(Historiadet historiadet) {
		getHistoriadets().remove(historiadet);
		historiadet.setHistoriacab(null);

		return historiadet;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setHistoriacab(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setHistoriacab(null);

		return pago;
	}

}