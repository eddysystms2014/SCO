package sco.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pacientes database table.
 * 
 */
@Entity
@Table(name="pacientes")
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PACIENTES_IDPACIENTES_GENERATOR", sequenceName="SEQ_PACIENTES", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PACIENTES_IDPACIENTES_GENERATOR")
	@Column(name="id_pacientes", unique=true, nullable=false)
	private Integer idPacientes;

	@Column(name="apellidos_pacientes", length=100)
	private String apellidosPacientes;

	@Column(name="cedula_pacientes", length=15)
	private String cedulaPacientes;

	@Column(name="celular_pacientes", length=15)
	private String celularPacientes;

	@Column(name="domicilio_pacientes", length=200)
	private String domicilioPacientes;

	@Column(name="estado_pacientes")
	private Boolean estadoPacientes;

	@Column(name="imagen_pacientes", length=254)
	private String imagenPacientes;

	@Column(name="nombres_pacientes", length=200)
	private String nombresPacientes;

	@Column(name="telefono_pacientes", length=20)
	private String telefonoPacientes;

	//bi-directional many-to-one association to Historiacab
	@OneToMany(mappedBy="paciente")
	private List<Historiacab> historiacabs;

	public Paciente() {
	}

	public Integer getIdPacientes() {
		return this.idPacientes;
	}

	public void setIdPacientes(Integer idPacientes) {
		this.idPacientes = idPacientes;
	}

	public String getApellidosPacientes() {
		return this.apellidosPacientes;
	}

	public void setApellidosPacientes(String apellidosPacientes) {
		this.apellidosPacientes = apellidosPacientes;
	}

	public String getCedulaPacientes() {
		return this.cedulaPacientes;
	}

	public void setCedulaPacientes(String cedulaPacientes) {
		this.cedulaPacientes = cedulaPacientes;
	}

	public String getCelularPacientes() {
		return this.celularPacientes;
	}

	public void setCelularPacientes(String celularPacientes) {
		this.celularPacientes = celularPacientes;
	}

	public String getDomicilioPacientes() {
		return this.domicilioPacientes;
	}

	public void setDomicilioPacientes(String domicilioPacientes) {
		this.domicilioPacientes = domicilioPacientes;
	}

	public Boolean getEstadoPacientes() {
		return this.estadoPacientes;
	}

	public void setEstadoPacientes(Boolean estadoPacientes) {
		this.estadoPacientes = estadoPacientes;
	}

	public String getImagenPacientes() {
		return this.imagenPacientes;
	}

	public void setImagenPacientes(String imagenPacientes) {
		this.imagenPacientes = imagenPacientes;
	}

	public String getNombresPacientes() {
		return this.nombresPacientes;
	}

	public void setNombresPacientes(String nombresPacientes) {
		this.nombresPacientes = nombresPacientes;
	}

	public String getTelefonoPacientes() {
		return this.telefonoPacientes;
	}

	public void setTelefonoPacientes(String telefonoPacientes) {
		this.telefonoPacientes = telefonoPacientes;
	}

	public List<Historiacab> getHistoriacabs() {
		return this.historiacabs;
	}

	public void setHistoriacabs(List<Historiacab> historiacabs) {
		this.historiacabs = historiacabs;
	}

	public Historiacab addHistoriacab(Historiacab historiacab) {
		getHistoriacabs().add(historiacab);
		historiacab.setPaciente(this);

		return historiacab;
	}

	public Historiacab removeHistoriacab(Historiacab historiacab) {
		getHistoriacabs().remove(historiacab);
		historiacab.setPaciente(null);

		return historiacab;
	}

}